package com.controller.CBSapi;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.chaboshi.util.CBS;
import com.model.CBS.CbsSuccessfulPurchaseQueryReport;
import com.model.jbapi.jbzxapiuser;
import com.service.CBS.CbsSuccessfulPurchaseQueryReportService;
import com.service.zx.jbzxapiuserService;
import com.util.DeductFeeAmountTool;
import com.util.Page;
import com.util.creditutil;
/**
 * 查博士报告
 * @author LiWang
 * 2018年2月2日
 * http://localhost:8080/kcd/purchaseReport.do?appKey=8918da17a51cca06cbed868dcaeb669a&vin=/WBAFG210XBL505722&enginno=1&licenseplate=1
 */
@Controller
public class CBSController{
	private static final String USER_ID="60206";
	private static final String  KEY_SECRET="b2082f585b0fcb96f19283bb74e5f235";
	//查博士的操作
	@Autowired
	private CbsSuccessfulPurchaseQueryReportService cspqr;
	@Autowired
	private jbzxapiuserService jbzxapiuserservice;
	//购买报告 
	@RequestMapping(value="/purchaseReport.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String  cbsPurchase(
			@RequestParam("appKey")String appKey,  //用户令牌
			@RequestParam("vin") String vin,	//汽车Vin码
	/*		@RequestParam(value="callbackurl",required=false)String callbackurl, */
			/*回掉地址 
		    1.required=false表示不传的话，会给参数赋值为null，required=true就是必须要有，否则报400 
			2.如果购买报告接口的时候没有传入回调的地址，说明不需要回调，则需要接口的用户调用查看订单状态的接口查看状态
			3.如果订单状态为已出报告的时候才可调用查看报告详情页和查看报告json的接口然后解析,如果失败，则会有失败原因
			*/
			@RequestParam(value="enginno",required=false) String enginno,//发动机号
			@RequestParam(value="licenseplate",required=false) String licenseplate //牌照
				) throws IOException{
		jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);
		String messages=null;
		JSONObject reslult=new JSONObject();//自定义返回消息 非接口返回
		if(ja!=null){//存在令牌 
			//账户余额
			BigDecimal balance=new  BigDecimal(ja.getApi_money());//账户余额
			BigDecimal zero=new  BigDecimal("0");//零
			BigDecimal remain=balance.subtract(new  BigDecimal(DeductFeeAmountTool.MAINTENANCE_ENQUIRY));//减去维修保养剩下的金额
			boolean apitype=true;//api类型不等于1的时候或者金额减去8>=0的时候为true
			boolean deductionlogo=true;//扣费标识
			if(ja.getApi_type()!=1){//判断用户的类型
				deductionlogo=false; //不扣费
			}else{ //扣费
				//判断余额
				if(remain.compareTo(zero)==-1){
					//金币不足够
					apitype=false; 
				}
			}
			if(apitype){
				CBS cbs=CBS.getInstance(USER_ID, KEY_SECRET);
				//接口状态  返回：成功 和其他失败返回消息
				messages=cbs.getBuyReport(vin, enginno, licenseplate, null);
				JSONObject jsonobject=null;
				jsonobject=JSONObject.parseObject(messages);//转换为json对象
				
				Object code=null;//code码
				code=jsonobject.get("Code");
				
				int cbstart=0; //订单状态 
				if(code.equals("0")){//订单购买成功 Code为0的时候才有orderid
					if(deductionlogo){
						//更新费用
						ja.setApi_money(remain.toString());
						jbzxapiuserservice.upmoney(ja);
					}
					CbsSuccessfulPurchaseQueryReport csfpq=new CbsSuccessfulPurchaseQueryReport();////查博士封装类
					csfpq.setCbsVin(vin); 
					csfpq.setCbsEnginno(enginno);
					csfpq.setCbsLicenseplate(licenseplate); 
					csfpq.setCbsApiuserId(ja.getId());
					
					String orderid=(String) jsonobject.get("orderId");//获取订单id 
					//订单状态
					String s=cbs.getReportStatus(orderid);//查询订单返回消息
					jsonobject=JSONObject.parseObject(s);
					code=jsonobject.get("Code");
					
					if(code.equals("1102")){//查询中
						cbstart=1;
					}else if(code.equals("1104")){//已出报告
						cbstart=2;
						//查询报告详情 json格式
						String reportdetails=cbs.getNewReportJson(orderid);
						csfpq.setCbsReportDetails(reportdetails);
					}
					csfpq.setCbsOrderid((String)orderid);//保存订单id
					csfpq.setCbsStart(cbstart);//设置订单状态
					csfpq.setCbsMessage(s);//保存返回的结果
					String time=creditutil.time(); 
					csfpq.setCbsAddtime(time);//添加订单信息
					csfpq.setCbsUptime(time); //最后更新时间
					//System.out.println(csfpq); 输出到控制台
					//保存在数据库
					cspqr.insertSelective(csfpq);
				}
				return messages;
			}else{
				reslult.put("resultCode","2");
		      	reslult.put("resultMsg","账户余额不足,请充值");
		      	reslult.put("success",false);
		      	return  reslult.toString();
			}
		}else{
	      	reslult.put("resultCode","1");
	      	reslult.put("resultMsg","用户令牌不存在");
	      	reslult.put("success",false);
	      	return  reslult.toString();
		}
	}
	//查看报告状态接口
	//http://localhost:8080/kcd/reportStatus.do?appKey=8918da17a51cca06cbed868dcaeb669a&orderId=fcc19c57aae3348e16d85ac79cb136be
	@RequestMapping(value="/reportStatus.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String reportStatus(
			@RequestParam("appKey")String appKey,  //用户令牌
			@RequestParam("orderId")String orderId //订单id
			){
			jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);
			if(ja!=null){
				return CBS.getInstance(USER_ID, KEY_SECRET).getReportStatus(orderId);
			}else{
				JSONObject reslult=new JSONObject();//自定义返回消息 非接口返回
			  	reslult.put("resultCode","1");
		      	reslult.put("resultMsg","用户令牌不存在");
		      	reslult.put("success",false);
		      	return reslult.toString();
			}
	}
	//检查品牌是否支持查询
	//http://localhost:8080/kcd/checkBrand.do?appKey=8918da17a51cca06cbed868dcaeb669a&vin=WBAFG210XBL505722
	@RequestMapping(value="/checkBrand.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String checkBrand(
			@RequestParam("appKey")String appKey,  //用户令牌
			@RequestParam("vin")String vin //vin码
			){
			jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);
			if(ja!=null){
				return CBS.getInstance(USER_ID, KEY_SECRET).getCheckBrand(vin);
			}else{
				JSONObject reslult=new JSONObject();//自定义返回消息 非接口返回
			  	reslult.put("resultCode","1");
		      	reslult.put("resultMsg","用户令牌不存在");
		      	reslult.put("success",false);
		      	return reslult.toString();
			}
	}
	//查询报告详情(url)
	//返回一个json对象：pcUrl可以查看PC报告详情页;mobileUrl:可以看到wap的报告详情页
	//http://localhost:8080/kcd/reportDetailsUrl.do?appKey=8918da17a51cca06cbed868dcaeb669a&orderId=3754b2334f23400ca7e7dff0d5d51331
	/*@RequestMapping(value="/reportDetailsUrl.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String reportDetailsUrl(
			@RequestParam("appKey")String appKey,  //用户令牌
			@RequestParam("orderId")String orderId //订单id
			){
			JSONObject reslult=new JSONObject();//自定义返回消息 非接口返回
			jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);
			if(ja!=null){
				Map map=CBS.getInstance(USER_ID, KEY_SECRET).getNewReportUrl(orderId);
				reslult.put("resultCode", "0");
		      	reslult.put("pcUrl",map.get("pcUrl"));
		      	reslult.put("mobileUrl",map.get("mobileUrl"));
		      	reslult.put("success", true);
		      	return reslult.toString();
			}else{
			
			  	reslult.put("resultCode","1");
		      	reslult.put("resultMsg","用户令牌不存在");
		      	reslult.put("success",false);
		      	return reslult.toString();
			}
	}*/
	//获取json报告
	@RequestMapping(value="/reportDetailsJson.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String reportDetailsJson(
			@RequestParam("appKey")String appKey,  //用户令牌
			@RequestParam("orderId")String orderId //订单id
			){
			JSONObject reslult=new JSONObject();//自定义返回消息 非接口返回
			jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);
			if(ja!=null){
				/*
				根据orderid查询
				CbsSuccessfulPurchaseQueryReportExample cspqre=new CbsSuccessfulPurchaseQueryReportExample();
				Criteria criteria=cspqre.createCriteria();
				criteria.andCbsOrderidEqualTo(orderId);
				List<CbsSuccessfulPurchaseQueryReport> selectByExample = cspqr.selectByExample(cspqre);*/
				String reportdetailsjson=CBS.getInstance(USER_ID, KEY_SECRET).getNewReportJson(orderId);
		      	return reportdetailsjson;
			}else{
			  	reslult.put("resultCode","1");
		      	reslult.put("resultMsg","用户令牌不存在");
		      	reslult.put("success",false);
		      	return reslult.toString();
			}
	}

	
}
