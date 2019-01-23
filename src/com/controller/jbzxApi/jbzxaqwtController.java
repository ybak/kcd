package com.controller.jbzxApi;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.http.jbzx.jbzxaqwthttp;
import com.model.zxjb;
import com.model.jbapi.jbzxapihistory;
import com.model.jbapi.jbzxapiuser;
import com.model.jbapi.jbzxuser;
import com.service.zx.jbzxService;
import com.service.zx.jbzxapiuserService;
import com.service.zx.jbzxhistoryService;
import com.service.zx.jbzxuserService;
import com.util.creditutil;
@Controller
public class jbzxaqwtController {
	
	   @Autowired
	   private jbzxhistoryService jbzxhistoryservice;
		@Autowired
		private jbzxService jbzxservice;
		@Autowired
		private jbzxuserService jbzxuserservice;
		@Autowired
		private jbzxapiuserService jbzxapiuserservice;

	    //性能最高的方法
	    public static String testStringBuilder(int sl) {
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i<sl; i++) {
	            sb.append(0);
	        }
	        return sb.toString();
	        
	    }
	
	//获取安全问题1
		@RequestMapping(value="/getquestions.do",produces = "text/html;charset=UTF-8")
		@ResponseBody
		public String getquestions(
				@RequestParam("loginName") String loginName,//登录名称
	    		@RequestParam("passwd") String passwd,//密码 
	    		@RequestParam("appKey") String appKey, //用户令牌	  		
	    		HttpServletRequest request){
	  // String result=niwodaihttp(loginName,passwd,appKey);
			jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);	
			BigDecimal b1 = new BigDecimal(ja.getApi_money());
			BigDecimal b2 = new BigDecimal("10");
			String c1=null;
			if(ja!=null){
				if(ja.getApi_type()!=0){
				       if(b1.subtract(b2).doubleValue()<=0){
				    	    JSONObject reslult=new JSONObject();
				        	reslult.put("resultCode","4");
				        	reslult.put("resultMsg","用户费用不足");
				        	reslult.put("success",false);
				        	return reslult.toString();
				       }
				}
                jbzxuser jz=jbzxuserservice.findjbzxuser(loginName);
                if(jz!=null){
	          try{
	        	  c1=jbzxaqwthttp.jbzxaq1(loginName,passwd,"6602e77a-c286-a0b9-13a6-287f438b3336");
	        	   jbzxapihistory jah=new jbzxapihistory();
	       	       jah.setAddtime(creditutil.time());
	       	       jah.setUptime(creditutil.time());
	       	       jah.setApimsg(c1);
	       	      //jah.setCardno(cardno);
	       	       //jah.setName(username);
	       	       //jah.setTel(phoneNo);
	       	       jah.setLoginname(loginName);	       	       
	       	       jah.setApitype("4:个人征信获取安全问题接口");
	       	       JSONObject jb=JSONObject.parseObject(c1);
	       	       jah.setMsg(jb.getString("resultMsg"));
		        if(jb.getString("resultCode").equals("0")){
		                   zxjb zj=new zxjb();
		                   zj.setBc_status("1");
		                   zj.setApi_result("");
		                   zj.setApi_resultcode("0");
		                   zj.setApi_resultmsg("");
			               zj.setC_cardno(jz.getCardno());
			               zj.setC_name(jz.getName());
			               zj.setC_tel(jz.getTel());   
		                   zj.setDt_add(creditutil.time());
		                   zj.setDt_edit(creditutil.time());
		                   zj.setGems_code("APIJBZX");
		                   zj.setGems_fs_id(ja.getId());
		                   zj.setGems_id(0);
		                   zj.setLoginname(loginName);
		                   zj.setMid_add(0);
		                   zj.setMid_edit(0);
		                   zj.setQuery_type(0);
		                   zj.setSmscode("");
		                   jbzxservice.addjbzx(zj); 
		                   jah.setJbzx_id(zj.getId());
		                   jbzxhistoryservice.addjbzxhistory(jah);
		                   zxjb zxjb=new zxjb();
		                   zxjb.setId(zj.getId());
		                   zxjb.setGems_code("APIJBZX"+testStringBuilder(7-String.valueOf(zj.getId()).length())+zj.getId());
		                   jbzxservice.upzxjb(zxjb);
		                   jb.put("ordercode",zxjb.getGems_code()); 
		           if(ja.getApi_type()!=0){
 	               //改变金额
 	               jbzxapiuser  jau=new jbzxapiuser();
   	               jau.setId(ja.getId());
   	               //int money=Integer.parseInt(ja.getApi_money())-10;
   	               jau.setApi_money(b1.subtract(b2).toString());
   	               jau.setApi_uptime(creditutil.time());
   	               jbzxapiuserservice.upmoney(jau);
		           }
                   return jb.toString();
 			        }else{
 			      jbzxhistoryservice.addjbzxhistory(jah);
 			        }	       	      
	          }catch (IOException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  		}      
              }else{
           	JSONObject reslult=new JSONObject();
  	        	reslult.put("resultCode","15");
  	        	reslult.put("resultMsg","账户不存在");
  	        	reslult.put("success",false);
  	        	return reslult.toString(); 
              }
			}else{
	        	JSONObject reslult=new JSONObject();
	        	reslult.put("resultCode","1");
	        	reslult.put("resultMsg","用户令牌不存在");
	        	reslult.put("success",false);
	        	return reslult.toString();
	          }
		  return c1;
		}
		//获取安全问题2
				@RequestMapping(value="/outquestions.do",produces = "text/html;charset=UTF-8")
				@ResponseBody
				public String outquestions(
						@RequestParam("loginName") String loginName,//登录名称
			    		@RequestParam("passwd") String passwd, 
			    		@RequestParam("qFirst") String qFirst,
			    		@RequestParam("qSecond")String qSecond,
			    		@RequestParam("qThird") String qThird,
			    		@RequestParam("qFouth") String qFouth,
			    		@RequestParam("qFivth") String qFivth,
			    		@RequestParam("appKey") String appKey, //用户令牌
			    		@RequestParam("ordercode") String ordercode, //用户令牌
			    		HttpServletRequest request){
			  // String result=niwodaihttp(loginName,passwd,appKey);
					jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);
					zxjb zj=jbzxservice.findzxjb(ordercode);
					if(zj==null||zj.equals("")){
						 JSONObject result=new JSONObject(); 
			        	 result.put("resultMsg","订单不存在");
			        	 result.put("resultCode","13");
			        	 result.put("success",false);
			        	 return result.toString();
					}
					String c2=null;
					if(ja!=null){
			          try{
					       c2=jbzxaqwthttp.jbzxaq2(loginName,passwd,qFirst,qSecond,qThird,qFouth,qFivth,"6602e77a-c286-a0b9-13a6-287f438b3336");					        	  
					       jbzxapihistory jah=new jbzxapihistory();
					       JSONObject jb=JSONObject.parseObject(c2);
					      	jah.setMsg(jb.getString("resultMsg"));
					       	jah.setAddtime(creditutil.time());
					       	jah.setUptime(creditutil.time());
					       	jah.setApimsg(c2);
					       	       //jah.setCardno(cardno);
					       	       //jah.setName(username);
					       	       //jah.setTel(phoneNo);
					       	jah.setLoginname(loginName);					       	       
					       	jah.setJbzx_id(zj.getId());					       	       
					       	jah.setApitype("5:个人征信提交问题答案接口");
					       	jbzxhistoryservice.addjbzxhistory(jah);
					        if(jb.getString("resultCode").equals("0")){
					                   zxjb zxjb=new zxjb();
					                   zxjb.setId(zj.getId());
					                   zxjb.setBc_status("2");		                   
					                   jbzxservice.upzxjb(zxjb);  
					        } 	       
			          }catch (IOException e) {
			  			e.printStackTrace();
			  		  }
					}else{
			        	JSONObject reslult=new JSONObject();
			        	reslult.put("resultCode","1");
			        	reslult.put("resultMsg","用户令牌不存在");
			        	reslult.put("success",false);
			        	return reslult.toString();
			          }
				  return c2;
				}
//		//获取安全问题3
//		@RequestMapping(value="/jbzxaq3.do",produces = "text/html;charset=UTF-8")
//		@ResponseBody
//		public String jbzxaq3(
//				@RequestParam("loginName") String loginName,//登录名称
//	    		@RequestParam("passwd") String passwd, 
//	    		@RequestParam("code") String code,
//	    		@RequestParam("appKey") String appKey, //用户令牌	  		
//	    		HttpServletRequest request){
//	  // String result=niwodaihttp(loginName,passwd,appKey);
//	          String c3=null;
//	          try{
//	        	  c3 = jbzxaqwthttp.jbzxaq3(loginName,passwd,code,"6602e77a-c286-a0b9-13a6-287f438b3336");
//	      	       jbzxapihistory jah=new jbzxapihistory();
//	       	       jah.setAddtime(creditutil.time());
//	       	       jah.setUptime(creditutil.time());
//	       	       jah.setApimsg(c3);
//	       	      //jah.setCardno(cardno);
//	       	       //jah.setName(username);
//	       	       //jah.setTel(phoneNo);
//	       	       jah.setLoginname(loginName);
//	       	       //jah.setJbzx_id(jbzx.getId());
//	       	       jah.setApitype("6简版个人征信采集接口");
//	       	       jbzxhistoryservice.addjbzxhistory(jah);	          
//	          }catch (IOException e) {
//	  			// TODO Auto-generated catch block
//	  			e.printStackTrace();
//	  		}      
//		  return c3;
//		}
}
