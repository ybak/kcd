package com.controller.matEndiwmentResult;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controller.businessPayApplication.BusinessPayApplicationController;
import com.model1.icbc.erp.PageData;
import com.service1.businessPayApplication.BusinessPayService;
import com.service1.matEndiwmentResult.MatEndiwmentResultService;
import com.util.limitutil;

@Controller
@RequestMapping("/matEndiwmentResultControoller")
public class MatEndiwmentResultControoller {
	
	private static Logger log = LogManager.getLogger(BusinessPayApplicationController.class.getName());
	@Autowired
	private MatEndiwmentResultService matEndiwmentResultService;
	
	@RequestMapping("/select")
	public String select(String qn,
			String param,
			String type,
			String dn,	
			Integer pagesize,
			Integer pagenow,
			String id_card,
			HttpServletRequest request) throws UnsupportedEncodingException{
//			List<PageData> newpdList=new ArrayList<>();
			
//			String param=request.getParameter("param");
//			if(StringUtils.isNotBlank(param)){
//			  param = new String(param.getBytes("ISO-8859-1"),"utf-8");
//			}
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
			List<PageData> buList=matEndiwmentResultService.selectMat(param,(pn-1)*ps,ps);
				
			for(PageData pd : buList){
			
			//判断根据身份证号查询时数据不为空
			if(pd.get("id_card") != null && !pd.get("id_card").equals("")){
				//根据身份证号查询import_repayment表的信息
				List<Map> imlist= matEndiwmentResultService.selectdetail(pd.getString("id_card"));
//				判断集合不为null
				if(imlist.size()>0){
					//逾期未还金额汇总	
					BigDecimal yqwhtotal = new BigDecimal("0");			
					//遍历集合中元素
					for(Map map:imlist){
					double overdue_amount = (double) map.get("overdue_amount");
					BigDecimal yqwhtotal1=new BigDecimal(String.valueOf(overdue_amount));
					if(null != yqwhtotal1){
						//得到逾期金额
						yqwhtotal=yqwhtotal.add(yqwhtotal1);//逾期金额相加
					}									
					}			
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
			int totalsize=matEndiwmentResultService.count();
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
	
	@RequestMapping("/selectDetail")
	public String selectDetail(String qn,
			String type,
			String dn,	
			String id_card,
			String periods,
			HttpServletRequest request){
		
		List<Map> matMap = matEndiwmentResultService.selectDetail(id_card,periods);
				
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);	
		request.setAttribute("matMap",matMap);
		return "kjs_icbc/index";
	}
	
	@RequestMapping("/addAgree")
	@Transactional
	public String addAgree(String c_cardno,
			String periods,
			String qn,
			String type,
			String dn,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException{
		
		//获取当前日期
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");	
		String localTime = df.format(LocalDateTime.now());
		System.out.println(localTime);	
		//修改状态，已代偿日期
		matEndiwmentResultService.updateflag(c_cardno, periods,localTime);		
		System.out.println("&&&&&&&&&&&&&"+c_cardno+"（（（（（（（（（（（（"+periods);
		//查询详情
		List<Map> agreeList = matEndiwmentResultService.selectDetail(c_cardno, periods);
		System.out.println("++++++++++++++++++++"+agreeList);
		//添加前的查询
		Map<String, Object> cardnoMap = matEndiwmentResultService.selectid_card(c_cardno);
		System.out.println("---------- -------"+cardnoMap);
		List<Map> afreeMap = matEndiwmentResultService.selectAfree(c_cardno);
		if(afreeMap.size() == 0){
			matEndiwmentResultService.addMat(cardnoMap);
		}
		//添加详情
		matEndiwmentResultService.addhk(agreeList.get(0));
		//修改垫款次数前查询条数
		String count = matEndiwmentResultService.selectcount(c_cardno);
		System.out.println("count____________:"+count);
		//修改条数
		matEndiwmentResultService.updatecount(c_cardno, count);
		matEndiwmentResultService.updatecount2(c_cardno, count);
		//修改import_repayment表中状态 身份证号，期数
		matEndiwmentResultService.updatestate(c_cardno, periods,localTime);
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		return "kjs_icbc/index";
	}
	
}
