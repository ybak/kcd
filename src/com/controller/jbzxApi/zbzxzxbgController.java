package com.controller.jbzxApi;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.http.jbzx.jbzxzxbghttp;
import com.model.zxjb;
import com.model.jbapi.jbzxapihistory;
import com.model.jbapi.jbzxapiuser;
import com.service.zx.jbzxService;
import com.service.zx.jbzxapiuserService;
import com.service.zx.jbzxhistoryService;
import com.util.creditutil;


@Controller
public class zbzxzxbgController{

	@Autowired
	private jbzxService  jbzxservice;
	@Autowired
	private jbzxhistoryService jbzxhistoryservice;
	@Autowired
	private jbzxapiuserService jbzxapiuserservice;
	
	//简版征信 征信报告
	@RequestMapping(value="/getjbzxreport.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String getjbzxreport(
			@RequestParam("loginName")String loginName,
			@RequestParam("passwd")String passwd,
			@RequestParam("code")String code,
			@RequestParam("ordercode")String ordercode,
			@RequestParam("appKey")String appKey,
			HttpServletRequest request) throws IOException{
		// String result=niwodaihttp(name,cardno,phoneNo,loginName,passwd,appKey);
		String z=null;
		jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);
		if(ja!=null){
		 try{
			 z=jbzxzxbghttp.jbzxzxbg1("6602e77a-c286-a0b9-13a6-287f438b3336",loginName,passwd,code);
			 JSONObject jb=JSONObject.parseObject(z);
			 if(jb!=null&&!jb.equals("")){
		      if(jb.getString("resultCode").equals("0")){
		    	 zxjb zx=jbzxservice.findzxjb(ordercode);
		         if(zx!=null){
		        	 zxjb zj=new zxjb();
		        	 zj.setId(zx.getId());
		        	 zj.setApi_result(jb.toString());
		        	 zj.setApi_resultmsg(jb.getString("resultMsg"));
		        	 zj.setApi_resultcode(jb.getString("resultCode"));
		             zj.setBc_status("3");
		             zj.setDt_edit(creditutil.time());
		             jbzxservice.upzxjb(zj);
		             jb.put("ordercode",ordercode);
		      	       jbzxapihistory jah=new jbzxapihistory();
		       	       jah.setAddtime(creditutil.time());
		       	       jah.setUptime(creditutil.time());
		       	       jah.setApimsg(jb.toString());
		       	      //jah.setCardno(cardno);
		       	       //jah.setName(username);
		       	       //jah.setTel(phoneNo);
		       	       jah.setMsg(jb.getString("resultMsg"));
		       	       jah.setLoginname(loginName);
		       	       jah.setJbzx_id(zx.getId());
		       	       jah.setApitype("6:简版个人征信采集接口");
		       	       jbzxhistoryservice.addjbzxhistory(jah);	
		               return jb.toString();
		         }else{
		        	 JSONObject result=new JSONObject(); 
		        	 result.put("resultMsg","订单不存在");
		        	 result.put("resultCode","13");
		        	 result.put("success",false);
		        	 return result.toString();
		         }		      
		      }else{
		    	  zxjb zx=jbzxservice.findzxjb(ordercode);
			      if(zx!=null){
			        	 zxjb zj=new zxjb();
			        	 zj.setId(zx.getId());
			        	 zj.setApi_result(jb.toString());
			        	 zj.setApi_resultmsg(jb.getString("resultMsg"));
			        	 zj.setApi_resultcode(jb.getString("resultCode"));
			             zj.setBc_status("4");
			             zj.setDt_edit(creditutil.time());
			             jbzxservice.upzxjb(zj);
			             jb.put("ordercode",ordercode);
			             jbzxapihistory jah=new jbzxapihistory();
			       	       jah.setAddtime(creditutil.time());
			       	       jah.setUptime(creditutil.time());
			       	       jah.setApimsg(jb.toString());
			       	      //jah.setCardno(cardno);
			       	       //jah.setName(username);
			       	       //jah.setTel(phoneNo);
			       	       jah.setLoginname(loginName);
			       	       jah.setJbzx_id(zx.getId());
			       	       jah.setApitype("6:简版个人征信采集接口");
			       	       jah.setMsg(jb.getString("resultMsg"));
			       	       jbzxhistoryservice.addjbzxhistory(jah);
			               return jb.toString();
			         }else{
			        	 JSONObject result=new JSONObject(); 
			        	 result.put("resultMsg","订单不存在");
			        	 result.put("resultCode","13");
			        	 result.put("success",false);
			        	 return result.toString();
			         }				       
		      }				 
			 }
		 }catch (IOException e) {
	  			// TODO Auto-generated catch block
	  			e.printStackTrace();
	  	 }
		 return z;
		}else{
        	JSONObject reslult=new JSONObject();
        	reslult.put("resultCode","1");
        	reslult.put("resultMsg","用户令牌不存在");
        	reslult.put("success",false);
        	return reslult.toString();
          } 
		           	  
	}
	
}
