package com.controller.dyapi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.http.duoying.syncjkrxxHttp;
import com.model1.archives;
import com.model1.mgcert;
import com.model1.zjf.zjfhistory;
import com.service1.duoying.archivesService;
import com.service1.duoying.mgcertService;
import com.service1.zjf.zjfhistoryService;
import com.util.creditutil;
import com.util.duoying.syncutil;

@Controller
public class adddydjController {

	@Autowired
	private mgcertService mgcertservice;
	@Autowired
	private archivesService archivesservice;
	@Autowired
	private zjfhistoryService zjfhistoryservice;
	/**
	 * 4.5	抵押登记完成接口
     *接口说明:通知多盈抵押登记完成
	 * @return
	 */
	@RequestMapping(value="kjs_dydj.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	private String kjs_dydj(String kjs_type,String id){
		String res=null;
		
		List<mgcert> mglist=new ArrayList<mgcert>();
            if(kjs_type.equals("8")){
            	mglist=mgcertservice.carlist(3);
            }
            if(kjs_type.equals("9")){
            	mglist=mgcertservice.certlist(3);
            }
            if(kjs_type.equals("10")){
            	mglist=mgcertservice.newcarlist(3);
            }
        	

        	if(mglist!=null&&mglist.size()>0){
        	for(int i=0;i<mglist.size();i++){
        		List<JSONObject> mortgageList=new ArrayList<JSONObject>();
        		mgcert mg=new mgcert();
        		mg=mglist.get(i);
        		JSONObject Mortgage=new JSONObject();
        		if(kjs_type.equals("8")){
        			if(mg.getSpcount()!=null&&!mg.getSpcount().equals("")){
        				Mortgage.put("loanBaseId",mg.getGems_code()+"|mgcar|"+mg.getSpcount());//借款信息外部唯一ID  , gems_code
                			
        			}else{
        				Mortgage.put("loanBaseId",mg.getGems_code()+"|mgcar|0");//借款信息外部唯一ID  , gems_code
                		
        			}
            		
        		}
                if(kjs_type.equals("9")){
        			if(mg.getSpcount()!=null&&!mg.getSpcount().equals("")){
        				Mortgage.put("loanBaseId",mg.getGems_code()+"|mgcert|"+mg.getSpcount());//借款信息外部唯一ID  , gems_code
                			
        			}else{
        				Mortgage.put("loanBaseId",mg.getGems_code()+"|mgcert|0");//借款信息外部唯一ID  , gems_code
                		
        			}	
        		}
                if(kjs_type.equals("10")){
        			if(mg.getSpcount()!=null&&!mg.getSpcount().equals("")){
        				Mortgage.put("loanBaseId",mg.getGems_code()+"|mgnewcar|"+mg.getSpcount());//借款信息外部唯一ID  , gems_code
                			
        			}else{
        				Mortgage.put("loanBaseId",mg.getGems_code()+"|mgnewcar|0");//借款信息外部唯一ID  , gems_code
                		
        			}
                }
        		archives a=archivesservice.Apiarchives(mg.getC_carno(),mg.getC_vin(),"0");
        		if(a!=null&&!a.equals("")){
        		Mortgage.put("collateralUniqueId",a.getR_item6());//车辆识别代号
        		Mortgage.put("mortgageSign",a.getR2_item5());//抵押标记
        		if(a.getR2_item6()!=null&&!a.getR2_item6().equals("")){
        		Mortgage.put("mortgageTime",creditutil.datatotime(a.getR2_item6()));//抵押时间
        		}
        		Mortgage.put("mortgageHolder",a.getR2_item7());//抵押权人
        		Mortgage.put("historyMortgage",a.getR2_item8());//历史抵押
        		}
        		mortgageList.add(Mortgage);   
                 JSONObject data=new JSONObject();
          	     data.put("mortgageList",mortgageList);
             	     // System.out.println("data:"+data);	    	    		 
          	     JSONObject obj=syncutil.createHead(data);
          	     obj.put("data", data);	
          	        zjfhistory zh=new zjfhistory();
          	        zh.setAddtime(creditutil.time());
          	        zh.setUptime(creditutil.time());
          	        zh.setSynpath("http://abs.51duoying.com:8082/ws/services/rest/loan/doApproval");
          	        zh.setSynrecording(obj.toString());
          	        zh.setCountnum(mortgageList.size());
          	        zh.setZjfname("多盈抵押登记");
          	        zh.setPath_type(6);
          	     try {
          		     String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/doMortgage", obj.toString());  	 		
          		     res=s+res;
          		     zh.setReturnmsg(s.toString());
          	         zh.setSuccessnum(1);  
          			 zjfhistoryservice.addsynhistory(zh);
          			JSONObject result=JSONObject.parseObject(s);
    		    	if(result.getString("code").equals("200")){	
    		    		JSONObject ret=JSONObject.parseObject(result.getString("ret"));
    		    		String[] successIds=ret.getString("successIds").replace(" ","").replace("[","").replace("]","").split(",");
    		    		if(successIds[0]!=null&&!successIds[0].equals("")){
    	          			 if(kjs_type.equals("8")){	 
    	                   		mgcert car=new mgcert();
    	                 		car.setId(mg.getId());
    	                 		car.setZjf_type("5");
    	                 		mgcertservice.upmgcar(car); 
    	           			 }
    	           			if(kjs_type.equals("9")){
    	           				mgcert car=new mgcert();
    	                 		car.setId(mg.getId());
    	                 		car.setZjf_type("5");
    	                 		mgcertservice.upmgcert(car);
    	           			}
    	           			if(kjs_type.equals("10")){
    	           				mgcert car=new mgcert();
    	                 		car.setId(mg.getId());
    	                 		car.setZjf_type("5");
    	                 		mgcertservice.upmgnewcar(car);
    	           			}    		    			
    		    		}
    		    	}
          			 

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
    	    }else{
   			 JSONObject result=new JSONObject();
   			 result.put("code","203");
   			 result.put("ret", "");
   			 result.put("msg", "未找到借款信息");
   			 return result.toString();	
    	    }               
		return res; 
	}
}
