package com.controller.duoying;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.http.duoying.syncjkrxxHttp;
import com.mashape.unirest.http.JsonNode;
import com.model1.mgcert;
import com.service1.duoying.mgcertService;
import com.util.duoying.syncutil;

@Controller
public class zsresult4_10Controller {

	  @Autowired
	  private mgcertService mgcertservice;
	/**
	 * 4.10提交终审结果
	 * @return
	 */
	 @RequestMapping(value="zsresult.do",produces = "text/html;charset=UTF-8")
	 @ResponseBody
	 public String zsresult(){
	    	List<mgcert> mgcertlist = new ArrayList<mgcert>(); 
	    	List<mgcert> mgcarlist = new ArrayList<mgcert>(); 
	    	List<mgcert> mgnewcarlist = new ArrayList<mgcert>(); 
	    	List<mgcert> mgalllist = new ArrayList<mgcert>();
		    mgcertlist =mgcertservice.csmgcert();
		    mgcarlist=mgcertservice.csmgcar();
		    mgnewcarlist=mgcertservice.csmgnewcar();
		    mgalllist.addAll(mgcertlist);
		    mgalllist.addAll(mgcarlist);
		    mgalllist.addAll(mgnewcarlist);
		    JSONObject data=new JSONObject();
		    List idList =new ArrayList<>();		
		String s = null;
		String res = null;
		if(mgalllist!=null&&mgalllist.size()>0){
			
			for(int i=0;i<mgcertlist.size();i++){
				mgcert m=mgcertlist.get(i);
//		    	if(i<mgcertlist.size()){
//		    		idList.add(m.getId()+"|"+"mgcert");
//		    	}
//		    	if(i>mgcertlist.size()){
//		    	if(i<mgcertlist.size()+mgcarlist.size()){
//		    		idList.add(m.getId()+"|"+"mgcar");
//		    	}	
//		    	}
//		    	if(i>mgcertlist.size()+mgcarlist.size()){
//		    		if(i<mgalllist.size()){
//		    		idList.add(m.getId()+"|"+"mgnewcar");	
//		    		}
//		    	}
				idList.add(m.getGems_code()+"|"+"mgcert");
			}			
			
	        if(null!=idList&&idList.size()>0){
		    	int pointsDataLimit =100;//限制条数
		    	Integer size = idList.size();
		    	//判断是否有必要分批
		    	if(pointsDataLimit<size){
		    	int part = size/pointsDataLimit;//分批数
		    	System.out.println("共有 ： "+size+"条，！"+" 分为 ："+part+"批");
		    	//
		    	for (int i = 0; i < part; i++) {
		    		
		    	//100条
		        List<Map<Object, Object>> listPage = idList.subList(0,pointsDataLimit);
//		    	System.out.println(listPage);								
				 data.put("idList",listPage);
				 JSONObject obj=syncutil.createHead(data);
				 obj.put("data", data);
				 s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/queryApprovalResult",obj.toString());  
				 res=res+s.toString();
		    	//	剔除
		       	//System.out.println("返回参数："+s);
				 idList.subList(0,pointsDataLimit).clear();  
		      // return data.toString();		
		      }
		     if(!idList.isEmpty()){	
				 data.put("idList", idList);
				 JSONObject obj=syncutil.createHead(data);
				 obj.put("data", data);
				 s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/queryApprovalResult",obj.toString());  
				 res=res+s.toString();
		      }
		   }else{
				 data.put("idList", idList);
				 JSONObject obj=syncutil.createHead(data);
				 obj.put("data", data);
				 s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/queryApprovalResult",obj.toString());  
				 res=s.toString();
		   }
		   }else{
		     System.out.println("没有数据!!!");
		   }	
}		 
		 return res;
	 }
	
	
}
