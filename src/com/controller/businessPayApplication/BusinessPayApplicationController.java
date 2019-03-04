package com.controller.businessPayApplication;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itextpdf.text.log.SysoCounter;
import com.model1.icbc.erp.PageData;
import com.service1.businessPayApplication.BusinessPayService;
import com.util.limitutil;

@Controller
@RequestMapping("/businessPayApplicationController")
public class BusinessPayApplicationController {
	
	private static Logger log = LogManager.getLogger(BusinessPayApplicationController.class.getName());
	@Autowired
	private BusinessPayService businessPayService;
	
	/**
	 * @throws ParseException 
	 * 查询并分页
	 * @throws 
	 */
	@RequestMapping("/select")
	public String select(
			String param,
			String qn,
			String type,
			String dn,	
			Integer pagesize,
			Integer pagenow,
			String c_cardno,
			String periods,
			HttpServletRequest request) throws UnsupportedEncodingException, ParseException{
		
//		List<PageData> newpdList=new ArrayList<>();
		
		int ps = 0;
		int pn = 0;
		if (pagesize != null && !pagesize.equals("")) {
			ps = pagesize;
		} else {
			ps = 10;
		}
		if (pagenow != null && !pagenow.equals("")) {
			pn = pagenow;
		} else {
			pn = 1;
		}
//		String param=request.getParameter("param");
//		if(StringUtils.isNotBlank(param)){
//			  param = new String(param.getBytes("ISO-8859-1"),"utf-8");
//			}
		List<PageData> buList=businessPayService.selectBusinessPay(param,(pn-1)*ps,ps);
		System.out.println("_--------------------------param:"+param);
		for(PageData pd : buList){
			
			//判断根据身份证号查询时数据不为空
			if(pd.get("c_cardno") != null && !pd.get("c_cardno").equals("")){
//				//根据身份证号查询import_repayment表的信息
				List<Map> imlist= businessPayService.selectdetail(pd.getString("c_cardno"),"");
				//判断集合不为null
				if(imlist.size()>0){
					//逾期未还金额汇总	
					BigDecimal yqwhtotal = new BigDecimal("0");
					//遍历集合中元素
					for(Map map:imlist){
					double overdue_amount = (double) map.get("overdue_amount");
					System.out.println("__________________"+overdue_amount);
					BigDecimal yqwhtotal1=new BigDecimal(String.valueOf(overdue_amount));
					System.out.println("+++++++++++++++++++++"+yqwhtotal1);
					if(null != yqwhtotal1){
						//得到逾期金额
						yqwhtotal=yqwhtotal.add(yqwhtotal1);//逾期金额相加						
					}									
					}	
					System.out.println("+++++++++++++++++++++"+yqwhtotal);
					pd.put("yqwhtotal", yqwhtotal);
					
					}
				
				//获取当前欠款
				//本息合计=本金合计*（1+利率）
				//贷款金额
				if(null != pd.get("dk_total_price")){
					BigDecimal aa = new BigDecimal(pd.get("dk_total_price").toString());
					//利率
					double lv = (double)pd.get("dk_lv")/100 + 1;
					BigDecimal bb = new BigDecimal(String.valueOf(lv));
					//本金*利率 得到本息合计
					BigDecimal ee = aa.multiply(bb);//乘法
					log.info("本息合计->"+ee);
					//贷款期限
					BigDecimal cc=new BigDecimal( pd.get("aj_date").toString());
					//每月应还=本息合计/贷款期数
					if(cc.compareTo(BigDecimal.ZERO) != 0){
						
						BigDecimal myyh = ee.divide(cc, 2, RoundingMode.HALF_UP);
						//每月应还*已还期数=已还
						BigDecimal b3=new BigDecimal(pd.get("jd_count").toString());
						//得到已还钱数
						BigDecimal yh = myyh.multiply(b3);
						//贷款总额-已还钱数
						BigDecimal dqqktotal = aa.subtract(yh);//得到当前欠款
						
						pd.put("dqqktotal", dqqktotal);
					}
				}	
			}	
		}
		System.out.println("***************count:"+businessPayService.count());
		int totalsize=businessPayService.count();
		System.out.println("***************count:"+totalsize);
		int q=totalsize%ps;
		int totalpage=0;//总页数
		if(q==0){
			totalpage=totalsize/ps;	    		
		}else{
			totalpage=totalsize/ps+1;
		} 
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);	
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("totalsize",totalsize);
		request.setAttribute("pagesize",ps);
		request.setAttribute("pagenow",pn);
		request.setAttribute("newpdList", buList);
		return "kjs_icbc/index";
	}
	
	/**
	 * 查询详情
	 * @throws ParseException 
	 */
	@RequestMapping("/selectdetail")
	public String selectdetail(
			String qn,
			String type,
			String dn,	
			String c_cardno,
			String periods,
			HttpServletRequest request) throws ParseException{
//		System.out.println("id_card------------------------"+c_cardno);
		List<Map> detailList=businessPayService.selectdetail(c_cardno,periods);
		System.out.println("*****************"+detailList);
		//得到当前时间
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");	
		String localTime = df.format(LocalDateTime.now());
		System.out.println(localTime);	
		if(detailList.size()>0){
			for(Map mm : detailList){
				String days = null;
//				System.out.println("----------------:"+mm.get("hk_time").toString());
				if(null != mm){
				if(null != mm.get("hk_time")){	
				String hkdate=mm.get("hk_time").toString().substring(0, 19);
				System.out.println("hkdate:"+hkdate);
				
					//比较当前时间是否晚于还款时间
				int dd = localTime.compareTo(hkdate);				
				if(dd > 0){
					System.out.println("当前时间晚于指定时间,已经过了指定时间");
					//计算逾期天数
					SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");					
					
						Date d1 = sdf.parse(localTime);
						Date d2 = sdf.parse(hkdate);
						System.out.println("当前时间："+d1.getTime()+"--还款时间："+d2.getTime());
						long dc=(d1.getTime() - d2.getTime())/1000;//除以1000转换成秒
						System.out.println("dc:"+dc);
						long daa=dc/(24*3600);
						System.out.println("时间："+daa);
						days = String.valueOf(daa);
					System.out.println("天数："+days);
								
				}else if(dd < 0){
					System.out.println("当前时间早于指定时间，还没过指定时间");
					days="无";
				}else{
					System.out.println("相等");
					days=localTime;
				}
				mm.put("days", days);
				}
				}
			}
		}
		
		request.setAttribute("detailList", detailList);
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		return "kjs_icbc/index";
	}
	

	//查询添加
	@RequestMapping("/addconfirm1")
	@Transactional
	public String Addconfirm1(
			String c_cardno,
			String periods,
			String qn,
			String type,
			String dn,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException, ParseException{
					
			//得到当前时间
			DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");	
			String localTime = df.format(LocalDateTime.now());
			System.out.println(localTime);	
			//查询详情
			List<Map> periodsMap = businessPayService.selectdetail(c_cardno,periods);
			String days = null;
			if(periodsMap.size()>0){
				for(Map mm : periodsMap){
					if(null != mm){
					if(null != mm.get("hk_time")){
					String hkdate=mm.get("hk_time").toString().substring(0, 19);

					int dd = localTime.compareTo(hkdate);
					if(dd > 0){
						System.out.println("当前时间晚于指定时间,已经过了指定时间");
						SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");					
						
						Date d1 = sdf.parse(localTime);
						Date d2 = sdf.parse(hkdate);
						System.out.println("当前时间："+d1.getTime()+"--还款时间："+d2.getTime());
						long dc=(d1.getTime() - d2.getTime())/1000;//除以1000转换成秒
						System.out.println("dc:"+dc);
						long daa=dc/(24*3600);
						System.out.println("时间："+daa);
						days = String.valueOf(daa);
					System.out.println("天数："+days);
					}else if(dd < 0){
						System.out.println("当前时间早于指定时间，还没过指定时间");
						days="无";
					}else{
						System.out.println("相等");
						days=localTime;
					}
					 }
					}
				}
			}
			
			int j = businessPayService.updateflag(c_cardno, periods,localTime,days);
			
			System.out.println("&&&&&&&&&&&&&"+c_cardno+"（（（（（（（（（（（（"+periods);
			
			Map<String, Object> CardnoMap = businessPayService.selectCardno(c_cardno);
			System.out.println("----+++++++++++++----:"+CardnoMap);
			List<Map> uuList = businessPayService.selectdetail(c_cardno, periods);
			List<Map> confirmMap = businessPayService.selectconfirm(c_cardno);
			System.out.println("-------------------++++:"+confirmMap.size());
			
			//当用户身份证号 不重复 表中的身份证号 时执行添加
			if(confirmMap.size() == 0){
				//判断数据库中是否已经存在一样的数据 
			 businessPayService.addBusin(CardnoMap);
			 //否则，有一样的身份证号
			}
			//添加详情
			businessPayService.addhk(uuList.get(0));	
		
			request.setAttribute("dn", dn);
			request.setAttribute("qn", qn);
			request.setAttribute("type", type);
			return "kjs_icbc/index";
		 
	}
	
	
	
}
