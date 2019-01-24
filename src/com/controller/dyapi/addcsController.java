package com.controller.dyapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.chainsaw.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.http.duoying.syncjkrxxHttp;
import com.http.dyapi.dyapihttp;
import com.model1.mgcert;
import com.model1.zjf.zjfhistory;
import com.service1.duoying.mgcertService;
import com.service1.zjf.zjfhistoryService;
import com.util.creditutil;
import com.util.duoying.MD5;
import com.util.duoying.syncutil;

@Controller
public class addcsController {

	
	@Autowired
	private mgcertService mgcertservice;
	@Autowired
	private zjfhistoryService zjfhistoryservice;
    /**
     * 
     * 提交初审借款人信息
     * @return
     */ 
	@SuppressWarnings("unused")
	@RequestMapping(value="kjs_tjcs.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String kjs_tjcs(
			String id,
			String kjs_type
			){
        //空指针判断
      if(id==null||kjs_type==null||
		   id.equals("")||kjs_type.equals("")				   
				){
			JSONObject jb=new JSONObject();
			jb.put("code","202");
			jb.put("ret","");
			jb.put("msg","有字段为空");
		    return jb.toString();
		}
		mgcert mg=new mgcert();
        List<JSONObject>  loanInfoList=new ArrayList<JSONObject>();
        JSONObject  LoanBase =new JSONObject();
        if(kjs_type.equals("8")){
            mg=mgcertservice.mgcarAPI(Integer.parseInt(id));
            if(mg.getSpcount()!=null&&!mg.getSpcount().equals("")){
            	 LoanBase.put("loanBaseId",mg.getGems_code()+"|mgcar|"+mg.getSpcount());	
            }else{
            	 LoanBase.put("loanBaseId",mg.getGems_code()+"|mgcar|0");
            }
           
        }
        if(kjs_type.equals("9")){
        	mg=mgcertservice.mgcertAPI(Integer.parseInt(id)); 
        	
            if(mg.getSpcount()!=null&&!mg.getSpcount().equals("")){
           	 LoanBase.put("loanBaseId",mg.getGems_code()+"|mgcert|"+mg.getSpcount());	
           }else{
           	 LoanBase.put("loanBaseId",mg.getGems_code()+"|mgcert|0");
           }
            }
        if(kjs_type.equals("10")){
        	mg=mgcertservice.mgnewcarAPI(Integer.parseInt(id));
        	
            if(mg.getSpcount()!=null&&!mg.getSpcount().equals("")){
           	 LoanBase.put("loanBaseId",mg.getGems_code()+"|mgnewcar|"+mg.getSpcount());	
           }else{
           	 LoanBase.put("loanBaseId",mg.getGems_code()+"|mgnewcar|0");
           }
        } 
        if(kjs_type.equals("17")){
        	mg=mgcertservice.mgxcAPI(Integer.parseInt(id));
        	
        	LoanBase.put("loanBaseId",mg.getGems_code()+"|mgxc|"+mg.getSpcount());
        }        
    	LoanBase.put("approvalAmount",Double.parseDouble(mg.getC_mgprice_result())*10000);
    	int lv=mg.getC_mgtype();
    	if(lv==0){
    		LoanBase.put("approvalRate","0.01");//先息后本		
    	}
    	if(lv==1){
    		LoanBase.put("approvalRate","0.0068");//等额本息		
    	}	    	    		    		    	
    	LoanBase.put("result","1");    	
    	loanInfoList.add(LoanBase);
		JSONObject data = new JSONObject();
        data.put("loanInfoList",loanInfoList); 
        JSONObject obj=syncutil.createHead(data);
        obj.put("data", data);
        zjfhistory zh=new zjfhistory();
        zh.setAddtime(creditutil.time());
        zh.setUptime(creditutil.time());
        zh.setSynpath("http://abs.51duoying.com:8082/ws/services/rest/loan/doApproval");
        zh.setSynrecording(obj.toString());
        zh.setCountnum(loanInfoList.size());
        zh.setZjfname("多盈提交初审");
        zh.setPath_type(4);
        try {
        	mgcert mc=new mgcert();
        	mc.setId(Integer.parseInt(id));
        	mc.setZjf_type("2");
        	//mc.setSpcount(0);
            String s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/doApproval", obj.toString());				    	
            zh.setReturnmsg(s.toString());
            zh.setSuccessnum(1);        
            zjfhistoryservice.addsynhistory(zh);
			 JSONObject result=JSONObject.parseObject(s);
		    	if(result.getString("code").equals("200")){			    		
		    		JSONObject ret=JSONObject.parseObject(result.getString("ret"));
		            String[] successIds=ret.getString("successIds").replace(" ","").replace("[","").replace("]","").split(",");
		    	  if(successIds[0]!=null&&!successIds[0].equals("")){
		    		  if(kjs_type.equals("8")){
		                  mgcertservice.upmgcar(mc);	
		              }
		              if(kjs_type.equals("9")){
		              	mgcertservice.upmgcert(mc);
		              }
		              if(kjs_type.equals("10")){
		              	mgcertservice.upmgnewcar(mc);
		              }  
		    	  }
		    	  }          
            return s;
		 }catch (Exception e) {
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
		String id ="188";
		String kjs_type ="9";
		String time =String.valueOf(new Date().getTime());
		String sign;
		sign=MD5.sign(id+time+"kcway","UTF-8");			
		String s = null;
		try {
			s =dyapihttp.kjsjkrxxhttp(id,kjs_type,"http://localhost:8080/kcd/kjs_tjcs.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(s);
	}
}
