package com.Repayment.controller;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model1.icbc.erp.PageData;
import com.service1.Repayment.RepaymentService;
import com.util.limitutil;

@Controller
@RequestMapping("/repaymentController")
public class RepaymenttestController {
	
	private static Logger log = LogManager.getLogger(RepaymenttestController.class.getName());
	@Autowired
	private RepaymentService repaymentService;

	/**
	 * 查询并分页
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/select")
	public String select(
			String param,
			String qn,
			String type,
			String dn,	
			int pagesize,
			int pagenow,	
			HttpServletRequest request) throws UnsupportedEncodingException{
		requestParams(request);
		
		List<PageData> newpdList=new ArrayList<>();
		PageData pd=new PageData();
		pd.put("dn", dn);
//      
//		String param=request.getParameter("param");
//		if(StringUtils.isNotBlank(param)){
//		  param = new String(param.getBytes("ISO-8859-1"),"utf-8");
//		}
		List<PageData> pdList=repaymentService.selectRepayment(param, pd);
		newpdList = limitutil.fy(pdList, pagesize, pagenow);
		int q=pdList.size()%pagesize;
		int totalpage=0;//总页数
		if(q==0){
			totalpage=pdList.size()/pagesize;	    		
		}else{
			totalpage=pdList.size()/pagesize+1;
		} 
		
		for(int i = 0;i<pdList.size();i++){			
			Map map = pdList.get(i);
			log.info("map->"+map);
			double myyh=0;
			if(null != map){
				//总额
				BigDecimal aa = new BigDecimal(map.get("dk_total_price").toString());

				//贷款期限
				BigDecimal cc=new BigDecimal( map.get("aj_date").toString());
				
				//每月应还=总额/贷款期数
				BigDecimal dd2 = aa.divide(cc, 3,BigDecimal.ROUND_DOWN);
				String a1 = dd2.toString();//转成string
				System.out.println(a1);
				System.out.println(a1.length());//获取长度
				System.out.println(a1.substring(a1.indexOf(".")+3, a1.length()));
				String bb = a1.substring(a1.indexOf(".")+3, a1.length());//截取第三位小数
				System.out.println("----bb："+bb);
				int c1 = Integer.parseInt(bb);//转成int
				if(c1 > 0){//判断是否大于0  是就保留两位小数
					BigDecimal vv = dd2.setScale(2, BigDecimal.ROUND_DOWN);
					BigDecimal zero = new BigDecimal("0.01");
					myyh = vv.add(zero).doubleValue();
				}else{
					BigDecimal vv = dd2.setScale(2, BigDecimal.ROUND_DOWN);
					myyh=vv.doubleValue();
					System.out.println("----每月应还2："+myyh);
				}
						
				map.put("myyh", myyh);
				BigDecimal icbc_pricecs = new BigDecimal(map.get("icbc_pricecs").toString());
				String s=icbc_pricecs.toString();
				//去掉多余的 0
				if(s.indexOf(".")!=-1){
					 s = s.replaceAll("0+?$", "").replaceAll("[.]$", "");  
				}
				map.put("icbc_pricecs",s);
			}
			
			
		}		
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);	
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("totalsize",pdList.size());
		request.setAttribute("pagesize",pagesize);
		request.setAttribute("pagenow",pagenow);
		request.setAttribute("newpdList", newpdList);
		return "kjs_icbc/index";
	}
	//简单打印参数方便测试
	public static void requestParams(HttpServletRequest request){
		Enumeration enu=request.getParameterNames();  
		while(enu.hasMoreElements()){  
			String paraName=(String)enu.nextElement();  
			log.info("参数名:"+paraName+",参数值："+request.getParameter(paraName));
		}
	}

	//查询主贷人信息表
	@RequestMapping("/selectBorrow")
	public String selectBorrow(String qn
								,String type
								,String dn
								,HttpServletRequest request
								,String c_cardno
								,String icbc_id
								){
		
		Map<String, Object> lborrow = repaymentService.selectBorrow(icbc_id);
				
			log.info("map2->"+lborrow);
			double yy=0;
			if(null != lborrow){
				//总额
				BigDecimal mm = new BigDecimal(lborrow.get("dk_total_price").toString());
				System.out.println("-----mm:"+mm);
				//贷款期限
				BigDecimal cc2=new BigDecimal( lborrow.get("aj_date").toString());
				System.out.println("------cc2:"+cc2);
				//每月应还=本息合计/贷款期数
				BigDecimal dd2 = mm.divide(cc2, 3,BigDecimal.ROUND_DOWN);//保留三位小数
				System.out.println("------dd2:"+dd2);
				String aa = dd2.toString();//转成string
				System.out.println(aa);
				System.out.println(aa.length());//获取长度
				System.out.println(aa.substring(aa.indexOf(".")+3, aa.length()));
				String bb = aa.substring(aa.indexOf(".")+3, aa.length());//截取第三位小数
				int cc = Integer.parseInt(bb);//转成int
				if(cc > 0){//判断是否大于0  是就保留两位小数
					BigDecimal vv = dd2.setScale(2, BigDecimal.ROUND_DOWN);	
					BigDecimal zero = new BigDecimal("0.01");
					yy = vv.add(zero).doubleValue();
				}else{
					BigDecimal vv = dd2.setScale(2, BigDecimal.ROUND_DOWN);
					yy=vv.doubleValue();
				}
				lborrow.put("myyh", yy);
				System.out.println("-----yy:"+yy);
				BigDecimal icbc_pricecs2 = new BigDecimal(lborrow.get("icbc_pricecs").toString());
				String s=icbc_pricecs2.toString();
				//去掉多余的 0
				if(s.indexOf(".")!=-1){
					 s = s.replaceAll("0+?$", "").replaceAll("[.]$", ""); 
			}
				lborrow.put("icbc_pricecs",s);
			}
			
			
		//查询还款计划
			List<Map> mapschedule = repaymentService.selectschedule(icbc_id);
			
			log.info("map3->"+mapschedule);
		//查询import_repayment
			//查询贷后信息
			List<Map> mapafter = repaymentService.selectafter(icbc_id);
			log.info("map4->"+mapafter);
//			System.out.println("234577980---------------------"+mapafter.get(0).get("c_name_gj2 "));
			
			//查询主贷人信息
			Map<String, Object> mapzdr = repaymentService.selectzdr(icbc_id);
			log.info("map5->"+mapzdr);
		request.setAttribute("dn", dn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);
		request.setAttribute("lborrow", lborrow);
		request.setAttribute("mapschedule", mapschedule);
		request.setAttribute("mapafter", mapafter);
		request.setAttribute("mapzdr", mapzdr);
		return "kjs_icbc/index";
		
	}
	//查询修改还款记录
	public void selectImport(){
		List<Map> repayMap = repaymentService.selectimport();
		Map<String, Object> map=new HashMap<>();
		for(int i=0;i<repayMap.size();i++){
			map.put("practical_money", Math.round((double) repayMap.get(i).get("balance_card")*100)/100.00);
			map.put("overdue_money", Math.round((double) repayMap.get(i).get("overdue_amount")*100)/100.00);
			map.put("practical_date", repayMap.get(i).get("add_time"));
			map.put("cardno", repayMap.get(i).get("id_card"));
			if(Math.round((double) repayMap.get(i).get("overdue_amount")) != 0){
				map.put("overdue", 1);
			}else{
				map.put("overdue", 0);
			}
			repaymentService.updateschedule(map);
		}
		

	}
	
	
}
