package com.controller.dyapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.http.duoying.syncjkrxxHttp;
import com.http.dyapi.dyapihttp;
import com.model1.mgcert;
import com.model1.zjf.zjferrmsg;
import com.model1.zjf.zjfhistory;
import com.service1.duoying.mgcertService;
import com.service1.zjf.zjferrmsgService;
import com.service1.zjf.zjfhistoryService;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.stringorintutil;
import com.util.duoying.MD5;
import com.util.duoying.syncutil;

@Controller
public class addzsController {

	
	@Autowired
	private mgcertService mgcertservice;
	
	
	@Autowired
	private zjfhistoryService zjfhistoryservice;
	
	@Autowired
	private zjferrmsgService zjferrmsgservice;
    /**
     * 
     * 查询终审信息
     * @return
     */ 
	@SuppressWarnings("unused")
	@RequestMapping(value="kjs_findzs.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String kjs_findzs(String kjs_type,
			String id
			){
		List<String> idList=new ArrayList<>();
		List<mgcert> mglist=new ArrayList<mgcert>();
        if(kjs_type.equals("8")){
        	mglist=mgcertservice.carlist(2);
        	if(mglist!=null&&mglist.size()>0){
        	for(int i=0;i<mglist.size();i++){
        		mgcert mg=new mgcert();
        		mg=mglist.get(i);
        		if(mg.getSpcount()!=null&&!mg.getSpcount().equals("")){
        			idList.add(mg.getGems_code()+"|mgcar|"+mg.getSpcount());	
        		}else{
        			idList.add(mg.getGems_code()+"|mgcar|0");
        		}
        	}    		
    	    }else{
   			 JSONObject result=new JSONObject();
   			 result.put("code","203");
   			 result.put("ret", "");
   			 result.put("msg", "未找到借款信息");
   			 return result.toString();	
    	    }
        }
        if(kjs_type.equals("9")){
        	mglist=mgcertservice.certlist(2);
        	if(mglist!=null&&mglist.size()>0){
        	for(int i=0;i<mglist.size();i++){
        		mgcert mg=new mgcert();
        		mg=mglist.get(i);
        		if(mg.getSpcount()!=null&&!mg.getSpcount().equals("")){
        			idList.add(mg.getGems_code()+"|mgcert|"+mg.getSpcount());	
        		}else{
        			idList.add(mg.getGems_code()+"|mgcert|0");
        		}
        	}    		
    	}else{
  			 JSONObject result=new JSONObject();
  			 result.put("code","203");
  			 result.put("ret", "");
  			 result.put("msg", "未找到借款信息");
  			 return result.toString();	
   	    }
        }
        if(kjs_type.equals("10")){
        	mglist=mgcertservice.newcarlist(2);
        	if(mglist!=null&&mglist.size()>0){
        	for(int i=0;i<mglist.size();i++){
        		mgcert mg=new mgcert();
        		mg=mglist.get(i);
        		if(mg.getSpcount()!=null&&!mg.getSpcount().equals("")){
        			idList.add(mg.getGems_code()+"|mgnewcar|"+mg.getSpcount());	
        		}else{
        			idList.add(mg.getGems_code()+"|mgnewcar|0");
        		}
        		
        	}
        	}else{
        		 JSONObject result=new JSONObject();
     			 result.put("code","203");
     			 result.put("ret", "");
     			 result.put("msg", "未找到借款信息");
     			 return result.toString();	
        	}
        }        
         JSONObject data=new JSONObject();
		 data.put("idList",idList);
		 JSONObject obj=syncutil.createHead(data);
		 obj.put("data", data);
	        zjfhistory zh=new zjfhistory();
	        zh.setAddtime(creditutil.time());
	        zh.setUptime(creditutil.time());
	        zh.setSynpath("http://abs.51duoying.com:8082/ws/services/rest/loan/doApproval");
	        zh.setSynrecording(obj.toString());
	        zh.setCountnum(idList.size());
	        zh.setZjfname("多盈终审结果");
	        zh.setPath_type(5);
		 try {
			 String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/queryApprovalResult",obj.toString());  			 		    			 
	         zh.setReturnmsg(s.toString());
	         zh.setSuccessnum(1);  
			 zjfhistoryservice.addsynhistory(zh);
			 JSONObject result=JSONObject.parseObject(s);
		    	if(result.getString("code").equals("200")){			    		
		    		JSONObject ret=JSONObject.parseObject(result.getString("ret"));
		            String[] successIds=ret.getString("successIds").replace(" ","").replace("[","").replace("]","").split(",");
		    	  if(successIds[0]!=null&&!successIds[0].equals("")){
		    		  System.out.println("多盈终审查询(成功订单)");
		    		 for(int i=0;i<successIds.length;i++){		    			 
		    			 if(kjs_type.equals("8")){
			    			 mgcert mc=mgcertservice.findcar(successIds[i].substring(1,successIds[i].indexOf("|")));		    			 
			    			 if(!mc.getZjf_type().equals("3")){
			    				 mgcert c=new mgcert();
			    				 c.setZjf_type("3");
			    				 //c.setSpcount(0);
			    				 c.setId(mc.getId());
			    				 mgcertservice.upmgcar(c);
			    			System.out.println("审核成功订单id:"+successIds[i].substring(1,successIds[i].indexOf("|")));
			    			 } 
		    			 }
		    			 if(kjs_type.equals("9")){
			    			 mgcert mc=mgcertservice.findcert(successIds[i].substring(1,successIds[i].indexOf("|")));		    			 
			    			 if(!mc.getZjf_type().equals("3")){
			    				 mgcert c=new mgcert();
			    				 c.setZjf_type("3");
			    				 //c.setSpcount(0);
			    				 c.setId(mc.getId());
			    				 mgcertservice.upmgcert(c);
			    			System.out.println("审核成功订单id:"+successIds[i].substring(1,successIds[i].indexOf("|")));		 
			    			 } 
		    			 }
		    			 if(kjs_type.equals("10")){
			    			 mgcert mc=mgcertservice.findnewcar(successIds[i].substring(1,successIds[i].indexOf("|")));		    			 
			    			 if(!mc.getZjf_type().equals("3")){
			    				 mgcert c=new mgcert();
			    				 c.setZjf_type("3");
			    				 //c.setSpcount(0);
			    				 c.setId(mc.getId());
			    				 mgcertservice.upmgnewcar(c);
			    		   System.out.println("审核成功订单id:"+successIds[i].substring(1,successIds[i].indexOf("|")));	 
			    			 }
		    			 }
		    			 System.out.println("成功订单:"+successIds[i]); 
		    		}
		    	  } 
		    	  String failIds=ret.getString("failIds").replace("{","").replace("}","");
		    	  if(failIds!=null&&!failIds.equals("")){
		    		  System.out.println("多盈终审查询(失败订单):"+failIds);
		    			Map m=JSONObject.parseObject(ret.getString("failIds"));
		    			Iterator<Entry<String, String>> iter =m.entrySet().iterator();
		    			Entry<String, String> entry;
		    			while(iter.hasNext()){
		    				 entry = iter.next();
		    				 String  key = entry.getKey();
		    				 //String  value = entry.getValue();
		    				 
		    			     //System.out.println(key.substring(0,key.indexOf("|")));		    			     
		    			     //System.out.println(value); 
			    			 if(kjs_type.equals("8")){
				    			 mgcert mc=mgcertservice.findcar(key.substring(0,key.indexOf("|")));		    			 
				    				 mgcert c=new mgcert();
				    				 c.setZjf_type("4");
				    				 if(mc.getSpcount()!=null&&!mc.getSpcount().equals("")){
				    					 int spcs=Integer.parseInt(mc.getSpcount());
				    					 c.setSpcount(String.valueOf(spcs+1)); 
				    				 }else{
				    					 c.setSpcount("1");  
				    				 }				    				 
				    				 c.setId(mc.getId());
				    				 mgcertservice.upmgcar(c);
				    			System.out.println("审核成功订单id:"+key.substring(0,key.indexOf("|")));
				    			  zjferrmsg errmsg=new zjferrmsg();
				    			  errmsg.setAddtime(creditutil.time());
				    			  errmsg.setUptime(creditutil.time());
				    			  errmsg.setFailIds(key+":"+m.get(key).toString());
				    			  errmsg.setGems_code(key.substring(0,key.indexOf("|")));
				    			  errmsg.setKjs_type(8);
				    			  errmsg.setMsg(m.get(key).toString());
				    			  zjferrmsgservice.savezjferrmsg(errmsg);
			    			 }
			    			 if(kjs_type.equals("9")){
				    			 mgcert mc=mgcertservice.findcert(key.substring(0,key.indexOf("|")));		    			 
				    				 mgcert c=new mgcert();
				    				 c.setZjf_type("4");
				    				 if(mc.getSpcount()!=null&&!mc.getSpcount().equals("")){
				    					 int spcs=Integer.parseInt(mc.getSpcount());
				    					 c.setSpcount(String.valueOf(spcs+1)); 
				    				 }else{
				    					 c.setSpcount("1");  
				    				 }	
				    				 c.setId(mc.getId());
				    				 mgcertservice.upmgcert(c);
				    			System.out.println("审核成功订单id:"+key.substring(0,key.indexOf("|")));		 
				    			  zjferrmsg errmsg=new zjferrmsg();
				    			  errmsg.setAddtime(creditutil.time());
				    			  errmsg.setUptime(creditutil.time());
				    			  errmsg.setFailIds(key+":"+m.get(key).toString());
				    			  errmsg.setGems_code(key.substring(0,key.indexOf("|")));
				    			  errmsg.setKjs_type(9);
				    			  errmsg.setMsg(m.get(key).toString());
				    			  zjferrmsgservice.savezjferrmsg(errmsg);
			    			 }
			    			 if(kjs_type.equals("10")){
				    			 mgcert mc=mgcertservice.findnewcar(key.substring(0,key.indexOf("|")));		    			 
				    				 mgcert c=new mgcert();
				    				 c.setZjf_type("4");
				    				 if(mc.getSpcount()!=null&&!mc.getSpcount().equals("")){
				    					 int spcs=Integer.parseInt(mc.getSpcount());
				    					 c.setSpcount(String.valueOf(spcs+1)); 
				    				 }else{
				    					 c.setSpcount("1");  
				    				 }	
				    				 c.setId(mc.getId());
				    				 mgcertservice.upmgnewcar(c);
				    		    System.out.println("审核成功订单id:"+key.substring(0,key.indexOf("|")));	 
				    			  zjferrmsg errmsg=new zjferrmsg();
				    			  errmsg.setAddtime(creditutil.time());
				    			  errmsg.setUptime(creditutil.time());
				    			  errmsg.setFailIds(key+":"+m.get(key).toString());
				    			  errmsg.setGems_code(key.substring(0,key.indexOf("|")));
				    			  errmsg.setKjs_type(10);
				    			  errmsg.setMsg(m.get(key).toString());
				    			  zjferrmsgservice.savezjferrmsg(errmsg);
			    			 }
		    			}
		    	  }
		    	}			 
			 return s.toString();		 
		 } catch (Exception e) {
				 JSONObject result=new JSONObject();
				 result.put("code","201");
				 result.put("ret", "");
				 result.put("msg", "同步失败-"+e);
			     zh.setReturnmsg(result.toString());
			     zjfhistoryservice.addsynhistory(zh); 
			     return result.toString();			
		}		 
	}		
	public static void main(String[] args) {				
//		String id ="222";
//		String kjs_type ="9";
//		String time =String.valueOf(new Date().getTime());
//		String sign;
//		sign=MD5.sign(id+time+"kcway","UTF-8");			
//		String s = null;
//		try {
//	    s =dyapihttp.kjsjkrxxhttp(id,kjs_type,"http://localhost:8080/kcd/kjs_findzs.do");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        System.out.println(s);
		
//		String s="[\"2017071320000196|mgcert|0\", \"2017072020000214|mgcert|0\"]";
//		String[] s1=s.replace(" ","").replace("[","").replace("]","").split(",");
//		if(s1[0]!=null&&!s1[0].equals("")){
//			for(int i=0;i<s1.length;i++){
//				System.out.println(s1[i].substring(1,s.indexOf("|")-1));	
//			}
//			System.out.println("s");
//		}else{
//			System.out.println("e");
//		}
		String s1="[\"2017071320000196|mgcert|0\", \"2017072020000214|mgcert|0\"]";		
		String s="{\"2017072520000222|mgcert|0\":{\"fund\":\"信息资质不足,不予通过\",\"customer\":\"\"},"
				+ "\"2017072020000216|mgcert|0\":{\"fund\":\"信息资质不足,不予通过\",\"customer\":\"\"}}";
		Map m=(Map)JSONObject.parseObject(s);  
		System.out.println(m);
		Iterator<Entry<String, String>> iter =m.entrySet().iterator();
		Entry<String, String> entry;
		while(iter.hasNext()){
			 entry = iter.next();
			  String  key=entry.getKey();
			  //String  value=entry.getValue();
		      System.out.println(key.substring(0,key.indexOf("|")));
		      System.out.println(m.get(key));
		      //System.out.println(value); 
		}

		
	}
}
