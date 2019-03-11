package com.controller.lendingResult;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.controller.erp_icbc.base.BaseController;
import com.model1.icbc.erp.PageData;

import com.util.limitutil;

@Controller
@RequestMapping("/lendingResult1Controller")
public class lendingResult1Controller extends BaseController{
	private static Logger log = LogManager.getLogger(lendingResult1Controller.class.getName());
	@Autowired
	private com.service1.lendingResult.lendingResult1Service lendingResult1Service;
	
	/**
	 * 查询所有数据并分页   模糊查询
	 * @return
	 */
	@RequestMapping("/select")
	
	public String select(String qn,String cn,String type,String dn,
			int pagesize,
			int pagenow,
			String c_cardno,
			String periods,
			HttpServletRequest request
			) throws UnsupportedEncodingException{
			
		List<PageData> newpdList=new ArrayList<>();
		PageData pd=new PageData();
		pd.put("dn", dn);
		String param=request.getParameter("param");
		List<PageData> l1=lendingResult1Service.selectlendingResult1(param, pd);
		for(PageData pd1 : l1){
			//判断  根据身份证号查询时数据不为空
			if(pd1.get("c_cardno") != null && !pd1.get("c_cardno").equals("")){
				
				//获取当前欠款
				//本息合计=本金合计*（1+利率）
				//贷款金额
				if(null != pd1.get("dk_total_price")){
					BigDecimal aa=new BigDecimal(pd1.get("dk_total_price").toString());
					//利率
					double lv=(double)pd1.get("dk_lv")/100+1;
					BigDecimal bb=new BigDecimal(String.valueOf(lv));
					//本金*利率  得到本息合计
					BigDecimal ee=aa.multiply(bb);//乘法
					log.info("本息合计------"+ee);
					//贷款期限
					BigDecimal cc=new BigDecimal(pd1.get("aj_date").toString());
					//每月应还=本息合计/贷款期数
					if(cc.compareTo(BigDecimal.ZERO)!= 0){
						BigDecimal myyh=ee.divide(cc,2,RoundingMode.HALF_UP);
						//每月应还*已还期数=已还
						BigDecimal b3=new BigDecimal(pd1.get("jd_count").toString());
						//得到已还钱数
						BigDecimal yh=myyh.multiply(b3);
						//贷款总额-已还钱数
						BigDecimal dqqktotal=aa.subtract(yh);//得到当前欠款
						log.info(dqqktotal+"*********************");
						pd1.put("dqqktotal", dqqktotal);
						
						
					}
				}
				
			}
		}
		
		newpdList=limitutil.fy(l1, pagesize, pagenow);
		System.out.println("*************"+newpdList);
		int q=l1.size()%pagesize;
		int totalpage=0;//总页数
		if (q==0) {
			totalpage=l1.size()/pagesize;
		}else{
			totalpage=l1.size()/pagesize+1;
		}
		request.setAttribute("dn", dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("pagenow",pagenow);
		request.setAttribute("pagesize", pagesize);
		request.setAttribute("totalsize",l1.size());
		request.setAttribute("newpdList", newpdList);
//		System.out.println("结果"+l1);
		return "kjs_icbc/index";
		
	}
	/**
	 * 查询详情
	 * @param id_card  身份证号
	 * @param periods  第几期
	 * @return
	 */
	@RequestMapping("/selectdetail")
	public String selectdetail(
			String qn,
			String cn,
			String type,
			String dn,
			String c_cardno,
			String periods,  
			HttpServletRequest request
			){
		List<Map> detailList=lendingResult1Service.selectdetail(c_cardno, periods);
		//获取当前时间
		DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String localTime=df.format(LocalDateTime.now());
		System.out.println("当前时间："+localTime);
		for(Map map : detailList){
			System.out.println("detail:"+detailList);
			//判断  根据身份证号查询时数据不为空
			if(map.get("id_card") != null && !map.get("id_card").equals("")){
			//获取当前欠款
			//本息合计=本金合计*（1+利率）
			//贷款金额
		if(null != map.get("dk_total_price")){
			BigDecimal aa=new BigDecimal(map.get("dk_total_price").toString());
			//利率
			double lv=(double)map.get("dk_lv")/100+1;
			BigDecimal bb=new BigDecimal(String.valueOf(lv));
			//本金*利率  得到本息合计
			BigDecimal ee=aa.multiply(bb);//乘法
			log.info("本息合计------"+ee);
			//贷款期限
			log.info("------------"+map.get("aj_date").toString());
			BigDecimal cc=new BigDecimal(map.get("aj_date").toString());
			//每月应还=本息合计/贷款期数
			if(cc.compareTo(BigDecimal.ZERO)!= 0){
				BigDecimal myyh=ee.divide(cc,2,RoundingMode.HALF_UP);
				log.info(myyh+"*/*/*/*/*/*/*/*/*/*");
				map.put("myyh", myyh);
				
			}
		}
			}
		}
		
		request.setAttribute("dn", dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type); 
		request.setAttribute("detailList", detailList);
		return "kjs_icbc/index";
	}
	/**
	 * 添加数据到表中
	 * @param c_cardno
	 * @param periods
	 * @param qn
	 * @param cn
	 * @param dn
	 * @param type
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/addlendingResult")
	public String addlendingResult(
			String c_cardno,
			String periods,
			String qn,
			String cn,
			String dn,
			String type,
			HttpServletRequest request,
			HttpServletResponse response
			) throws IOException{
		
		//获取当前日期
		DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");	
		String localTime = df.format(LocalDateTime.now());
		System.out.println(localTime);
		
		//查询详情页
		List<Map> detailMap=lendingResult1Service.selectdetail(c_cardno, periods);
		BigDecimal myyh=null;
		for(Map map : detailMap){
			System.out.println("detail:"+detailMap);
			//判断  根据身份证号查询时数据不为空
			if(map.get("id_card") != null && !map.get("id_card").equals("")){
			//获取当前欠款
			//本息合计=本金合计*（1+利率）
			//贷款金额
		if(null != map.get("dk_total_price")){
			BigDecimal aa=new BigDecimal(map.get("dk_total_price").toString());
			//利率
			double lv=(double)map.get("dk_lv")/100+1;
			BigDecimal bb=new BigDecimal(String.valueOf(lv));
			//本金*利率  得到本息合计
			BigDecimal ee=aa.multiply(bb);//乘法
			log.info("本息合计------"+ee);
			//贷款期限
			log.info("------------"+map.get("aj_date").toString());
			BigDecimal cc=new BigDecimal(map.get("aj_date").toString());
			//每月应还=本息合计/贷款期数
			if(cc.compareTo(BigDecimal.ZERO)!= 0){
				myyh=ee.divide(cc,2,RoundingMode.HALF_UP);
				log.info(myyh+"*/*/*/*/*/*/*/*/*/*");
				map.put("myyh", myyh);
				String myyh1 = myyh.toString();
				//修改状态  已代偿日期
				int flag=lendingResult1Service.updateflag(c_cardno, periods,localTime,myyh1);
			}
		}
			}
			
		}
		
		
		//添加前查询的信息
		Map<String, Object> listMap=lendingResult1Service.selectCardno(c_cardno);
		//查询用户是否在表中重复
		Map<String, Object> confirmMap=lendingResult1Service.selectconfirm(c_cardno);
		if(confirmMap == null){
			//判断数据库是否已存在相同数据    添加列表页数据
			int i=lendingResult1Service.addlendingResult1(listMap);
		}
		//添加详情页数据
		lendingResult1Service.adddetail1(detailMap.get(0));
		//修改import_repayment表中状态，身份证号，期数,日期
		lendingResult1Service.updatestate(c_cardno, periods, localTime);
		//修改partner_details表中状态，已代偿日期
		lendingResult1Service.updatedetail1(c_cardno, periods, localTime);
		//修改partner_details表中状态，已代偿日期
		lendingResult1Service.updatedetail(c_cardno, periods, localTime);
		request.setAttribute("dn", dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		return "kjs_icbc/index";
		
	}


	private void requestParam(HttpServletRequest request) {
		// TODO Auto-generated method stub
		
	}
}
