package com.controller.dyapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.http.duoying.syncjkrxxHttp;
import com.model1.mgcert;
import com.model1.zjf.zjfhistory;
import com.service1.duoying.mgcertService;
import com.service1.zjf.zjfhistoryService;
import com.util.creditutil;
import com.util.duoying.syncutil;

@Controller
public class addfindfkController {
	@Autowired
	private mgcertService mgcertservice;
	@Autowired
	private zjfhistoryService zjfhistoryservice;
	/**
	 * 3.11查询放款许可
     * 
	 * @return
	 */
	@RequestMapping(value="kjs_fkxk.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	private String kjs_fkxk(
			String kjs_type,
			String id
			){
		List<String> idList=new ArrayList<>();
		List<mgcert> mglist=new ArrayList<mgcert>();
        if(kjs_type.equals("8")){
        	mglist=mgcertservice.carlist(5);
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
        	mglist=mgcertservice.certlist(5);
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
        	mglist=mgcertservice.newcarlist(5);
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
		 data.put("idList", idList);
		 JSONObject obj=syncutil.createHead(data);
		 obj.put("data", data);
	        zjfhistory zh=new zjfhistory();
	        zh.setAddtime(creditutil.time());
	        zh.setUptime(creditutil.time());
	        zh.setSynpath("http://abs.51duoying.com:8082/ws/services/rest/loan/doApproval");
	        zh.setSynrecording(obj.toString());
	        zh.setCountnum(idList.size());
	        zh.setZjfname("多盈放款许可");
	        zh.setPath_type(7);
		 try {
			 String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/queryDisbursement", obj.toString());  	         			 
			 zh.setReturnmsg(s.toString());
	         zh.setSuccessnum(1);  
			 zjfhistoryservice.addsynhistory(zh);
			 JSONObject result=JSONObject.parseObject(s);
		    	if(result.getString("code").equals("200")){	
		    		JSONObject ret=JSONObject.parseObject(result.getString("ret"));
		    		String[] successIds=ret.getString("successIds").replace(" ","").replace("[","").replace("]","").split(",");
		    		if(successIds[0]!=null&&!successIds[0].equals("")){
		    			for(int i=0;i<successIds.length;i++){	
	                   		mgcert car=new mgcert();
		    			if(kjs_type.equals("8")){
		    				mgcert mc=mgcertservice.findcar(successIds[i].substring(1,successIds[i].indexOf("|")));		    			 		    						    			
	                 		car.setId(mc.getId());
	                 		car.setZjf_type("6");
	                 		mgcertservice.upmgcar(car); 
	           			 }
	           			if(kjs_type.equals("9")){
	           				mgcert mc=mgcertservice.findcert(successIds[i].substring(1,successIds[i].indexOf("|")));		    			 		    						    			
	                 		car.setId(mc.getId());
	                 		car.setZjf_type("6");
	                 		mgcertservice.upmgcert(car);
	           			}
	           			if(kjs_type.equals("10")){
	           				mgcert mc=mgcertservice.findnewcar(successIds[i].substring(1,successIds[i].indexOf("|")));		    			 		    						    			
	                 		car.setId(mc.getId());
	                 		car.setZjf_type("6");
	                 		mgcertservice.upmgnewcar(car);
	           			}    		   
		    			 }
		    		}
		    	}
			 return s;
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
		String i = "0";		
		if(i!=null&&!i.equals("")){
			System.out.println(i);
		}else{
			System.out.println("null");
		}
		
		
	}
}
