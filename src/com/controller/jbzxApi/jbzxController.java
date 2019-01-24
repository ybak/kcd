package com.controller.jbzxApi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.http.niwodaihttp;
import com.http.jbzx.jbzxhttp;
import com.model.zxjb;
import com.model.jbapi.jbzx;
import com.model.jbapi.jbzxapihistory;
import com.model.jbapi.jbzxapiuser;
import com.model.jbapi.jbzxuser;
import com.service.pdfoverService;
import com.service.zx.jbzxService;
import com.service.zx.jbzxapiuserService;
import com.service.zx.jbzxhistoryService;
import com.service.zx.jbzxuserService;
import com.util.creditutil;
import com.util.jsonutil;

@Controller
public class jbzxController {
	
	@Autowired
	private jbzxService jbzxservice;
	@Autowired
	private jbzxhistoryService jbzxhistoryservice;
	@Autowired
	private jbzxuserService jbzxuserservice;
	@Autowired
	private jbzxapiuserService jbzxapiuserservice;
	//注册1步   认证
	@RequestMapping(value="/getauthentication.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	 public String getauthentication(
	    		@RequestParam("cardno") String cardno,
	    		@RequestParam("name") String name,
	    		@RequestParam("appKey") String appKey,   		
	    		HttpServletRequest request){
                //String result=niwodaihttp(cardno,name,appKey);
		        jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);
		        String s1 = null;
		      if(ja!=null){
    	
              try {            	
		       s1=jbzxhttp.jbzxzc1(cardno,name,"6602e77a-c286-a0b9-13a6-287f438b3336");
		       JSONObject jb=JSONObject.parseObject(s1);
		       //记录
		       jbzxapihistory jah=new jbzxapihistory();
		       jah.setAddtime(creditutil.time());
		       jah.setUptime(creditutil.time());
		       jah.setApimsg(s1);
		       jah.setCardno(cardno);
		       jah.setName(name);
		       jah.setApitype("1:个人身份证及姓名认证");
		       jah.setMsg(jb.getString("resultMsg"));
		       jbzxhistoryservice.addjbzxhistory(jah);
		    	  
              } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}             
	          }else{
	        	JSONObject reslult=new JSONObject();
	        	reslult.put("resultCode","1");
	        	reslult.put("resultMsg","用户令牌不存在");
	        	reslult.put("success",false);
	        	return reslult.toString();
	          }
		  return s1;
	}
	//注册2步
	@RequestMapping(value="/getcode.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getcode(
    		@RequestParam("name") String name,
    		@RequestParam("phoneNo") String phoneNo,
    		@RequestParam("cardno") String cardno,
    		@RequestParam("appKey") String appKey,   		
    		HttpServletRequest request){
         /* Map result=new HashMap<>();*/
  // String result=niwodaihttp(username,cardno,name,appKey);
		  jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);		 
          String s2 = null;
          if(ja!=null){
          try {            	
	      s2=jbzxhttp.jbzxzc2(name,phoneNo,cardno,"6602e77a-c286-a0b9-13a6-287f438b3336");
	      JSONObject jb=JSONObject.parseObject(s2);
	      jbzxapihistory jah=new jbzxapihistory();
	       jah.setAddtime(creditutil.time());
	       jah.setUptime(creditutil.time());
	       jah.setApimsg(s2);
	       jah.setCardno(cardno);
	       jah.setName(name);
	       jah.setTel(phoneNo);
	       jah.setApitype("2:获取注册账号短信验证码");
	       jah.setMsg(jb.getString("resultMsg"));
	       jbzxhistoryservice.addjbzxhistory(jah);
          } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
          }else{
	        	JSONObject reslult=new JSONObject();
	        	reslult.put("resultCode","1");
	        	reslult.put("resultMsg","用户令牌不存在");
	        	reslult.put("success",false);
	        	return reslult.toString();
	          }
	  return s2;
	}
	//注册3步
	@RequestMapping(value="/getuserreg.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getuserreg(   
			@RequestParam("name") String name,//身份证名字段
    		@RequestParam("cardno") String cardno,//身份证名字段
    		@RequestParam("phoneNo") String phoneNo,//手机号
    		@RequestParam("loginName") String loginName,//登录名
    		@RequestParam("passwd") String passwd,	//密码
    		@RequestParam("smsCode") String smsCode,//短信验证码
    		@RequestParam("appKey") String appKey,//用户令牌
    	HttpServletRequest request){
         /* Map result=new HashMap<>();*/
  // String result=niwodaihttp(username,cardno,phoneNo,loginName,passwd,smsCode,appKey);
		  jbzxapiuser ja= jbzxapiuserservice.findapiuserbyappkey(appKey);
          String s3 = null;
          if(ja!=null){

          try {      
	      s3=jbzxhttp.jbzxzc3(name,cardno,phoneNo,loginName,passwd,smsCode,"6602e77a-c286-a0b9-13a6-287f438b3336");
	      JSONObject jb=JSONObject.parseObject(s3);
	      if(jb.getString("resultCode").equals("9109")){
           jbzxuser ju=new jbzxuser();
           ju.setAddtime(creditutil.time());
           ju.setUptime(creditutil.time());
           ju.setLoginname(loginName);
           ju.setName(name);
           ju.setTel(phoneNo);
           ju.setCardno(cardno);
           jbzxuserservice.addjbzxuser(ju);
             // jb.put("ordercode",zj.getGems_code());              
   	       jbzxapihistory jah=new jbzxapihistory();
   	       jah.setMsg(jb.getString("resultMsg"));
   	       jah.setAddtime(creditutil.time());
   	       jah.setUptime(creditutil.time());
   	       jah.setApimsg(jb.toString());
   	       jah.setCardno(cardno);
   	       jah.setName(name);
   	       jah.setTel(phoneNo);
   	       jah.setLoginname(loginName);
   	       //jah.setJbzx_id(ju.getId());
   	       jah.setApitype("3:账号注册");
   	       jbzxhistoryservice.addjbzxhistory(jah);
           return jb.toString();
	       }else{
	   	       jbzxapihistory jah=new jbzxapihistory();
	   	       jah.setMsg(jb.getString("resultMsg"));
	   	       jah.setAddtime(creditutil.time());
	   	       jah.setUptime(creditutil.time());
	   	       jah.setApimsg(jb.toString());
	   	       jah.setCardno(cardno);
	   	       jah.setName(name);
	   	       jah.setTel(phoneNo);
	   	       jah.setLoginname(loginName);
	   	       //jah.setJbzx_id();
	   	       jah.setApitype("3:账号注册");
	   	       jbzxhistoryservice.addjbzxhistory(jah);	    	   
	       }
          
          } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}         	  
      }else{
      	JSONObject reslult=new JSONObject();
      	reslult.put("resultCode","1");
      	reslult.put("resultMsg","用户令牌不存在");
      	reslult.put("success",false);
      	return reslult.toString();
        }
       return s3;
	}
    //性能最高的方法
    public static String testStringBuilder(int sl) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<sl; i++) {
            sb.append(0);
        }
        return sb.toString();
        
    }
	
	public static void main(String[] args) {		
		System.out.println(Double.parseDouble("43.00")-10);
	}
}
