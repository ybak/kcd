package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.ykdbb;
import com.service.bbService;
import com.service.companyService;
import com.service.customerService;
import com.service.gskhService;
import com.service.gsrykhService;
import com.service.mdxxService;
import com.service.ykdbbService;
import com.util.Idcardutil;
import com.util.jsonutil;

@Controller
public class bbController {
	
	 @Autowired
	 private bbService bbs;
	 @Autowired
	 private companyService cps;
	 @Autowired
	 private customerService cs;
	 @Autowired
	 private mdxxService mdxxservice;
	 @Autowired
     private ykdbbService ykdbbservice;	 
	 @Autowired
	 private gskhService gskhservice;
	 @Autowired
     private gsrykhService gsrykhservice;	
	 
	 
	@RequestMapping(value="/fbbbbyorder.do",produces="text/html;charset=UTF-8")
	 @ResponseBody
	 public String fbbbbyorder(HttpServletRequest request,
			 String ckey,
			 String orderid,
			 String sign,
			 String time
			 ){
		 //String orderid=request.getParameter("orderid");
		 Map gm=gsrykhservice.fgsrykh(ckey);
		 System.out.println(orderid);
		// int mdsize= mdxxservice.mdxxsize(ckey);		 
		 Map bmlist=new HashMap<>();
		 Map result=new HashMap();
		List<Map> ml=new ArrayList<Map>();
		 if(gm!=null&&gm.size()>0){			 		 		
		 bmlist=bbs.findbb(orderid);
		 System.out.println(bmlist.size());		
		 if(bmlist!=null&&!bmlist.equals("")){		 			
				 Map result1=new HashMap();	
				 result1.put("bid",bmlist.get("bid"));
				 result1.put("khxm",bmlist.get("khxm"));
				 result1.put("sfzbh",Idcardutil.maskCertId(bmlist.get("sfzbh").toString()));			
				 result1.put("md",bmlist.get("md"));
				 result1.put("sqsbh",bmlist.get("sqsbh"));
				 result1.put("orderid",bmlist.get("orderid"));
				 result1.put("cxr",bmlist.get("cxr"));			 					 				 
   				
   				 if(bmlist.get("onecxtime")!=null&&!bmlist.get("onecxtime").equals("")){
   					 result1.put("onecxtime",bmlist.get("onecxtime").toString().replace(".0", ""));				
				 }else{
					 result1.put("onecxtime","");
				 }
				 if(bmlist.get("stime")!=null&&!bmlist.get("stime").equals("")){
					 result1.put("stime",bmlist.get("stime").toString().replace(".0", ""));				
				 }else{
					 result1.put("stime","");
				 }
				 if(bmlist.get("cxerror")!=null&&!bmlist.get("cxerror").equals("")){
					 result1.put("cxerror",bmlist.get("cxerror"));
				 }else{
					 result1.put("cxerror","");
				 }
				 if(bmlist.get("errortest")!=null&&!bmlist.get("errortest").equals("")){
					 result1.put("errortest",bmlist.get("errortest"));
				 }else{
					 result1.put("errortest","");
				 }
				 if(bmlist.get("bb")!=null&&!bmlist.get("bb").equals("")){
					 result1.put("bb",bmlist.get("bb"));
				 }else{
					 result1.put("bb","");
				 } 				 
			 result.put("errcode","01");
			 result.put("errmsg","查询成功");
			 result.put("result",result1);
		 }else{
			 result.put("errcode","013");
			 result.put("errmsg","无订单信息");			
		 }
	}else{
		 result.put("errcode","02");
		 result.put("errmsg","用户验证失败");		 
	 }
		 
		 
		 return jsonutil.toJSONString(result).replace("[","").replace("]","");
	
	 }
	 
	 @RequestMapping(value="/ykdbb.do",produces="text/html;charset=UTF-8")
	 @ResponseBody
	 public String ykdbb(String sdate,String edate,String ckey){
           List<ykdbb> ykdlist=new ArrayList<ykdbb>();
          Map<String, String> mdate=new HashMap<String, String>();
          mdate.put("sdate", sdate);
          mdate.put("edate", edate);
           Map result=new HashMap();
           if(ckey!=null&&!ckey.equals("")){
        	int m=mdxxservice.mdxxsize(ckey);
        	   if(m>0){
        		   ykdlist=ykdbbservice.findbydate(mdate);
        	   }else{
        		   result.put("errcode","02");
        		   result.put("errmsg","用户验证失败");
        		   
        	   }
               
           }else{
    		   result.put("errcode","03");
    		   result.put("errmsg","ckey不能为空"); 
    	   }
		 if(ykdlist!=null&&ykdlist.size()>0){
			  result.put("errcode","01");
   		      result.put("errmsg","查询成功"); 
			  result.put("result",ykdlist); 
			 
		 }
		 
		 
		 return jsonutil.toJSONString(result);
		 
		 
		 
		 
		 
		 
	 }
	
}
