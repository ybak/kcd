package com.controller.assess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.ykdutil;
import com.model1.fs;
import com.model1.queryzx;
import com.service1.fsService;
import com.service1.gemsService;
import com.service1.queryzxService;
import com.util.jsonutil;

@Controller
public class queryzxController {
	
	 @Autowired
	 private queryzxService queryzxservice;
	 @Autowired
	 private fsService fsservice;
	 @Autowired
	 private gemsService gemsservice;
	 	 	 
	    //批量查询pdf	    
	    @RequestMapping(value="/batchqueryzx.do",produces="application/json;charset=UTF-8")
	    @ResponseBody
	    public Map  batchqueryzx(@RequestBody String jsonstring,@RequestHeader String ckey){
	    	queryzx q=new queryzx();   	     	
	    	Map cm=new HashMap<>();      
	     	Map result1=new HashMap();
	     	 List<Map<String,Object>> mapList = new ArrayList<Map<String,Object>>();
	     	 List<Map<String,String>> list=new ArrayList<Map<String,String>>();
	     	// System.out.println(ckey);
	     	 if(!ckey.equals("")&&ckey!=null){     		      	 
	     	List<fs> flist=fsservice.findfsbyckey(ckey);
	     	 //jsonstring="["+jsonstring+"]";
	     	 //jsonstring=jsonstring.replace("[", "").replace("]","");
	     	 System.out.println(jsonstring);
	     	 
	     	 List<ykdutil> l=jsonutil.toList(jsonstring,ykdutil.class);
	     	if(flist!=null&&!flist.equals("")&&flist.size()>0){
	    	for(int j=0;j<l.size();j++){	    		
	    		Map result=new HashMap<>();
	    		ykdutil y=l.get(j);
	    		cm=queryzxservice.findqueryzx(y.getC_name(),y.getC_card_no());
	    		if(cm!=null&&!cm.toString().equals("")&&cm.size()>0){	    			
	    			if(!cm.get("result_pdf").toString().equals("")&&cm.get("result_pdf")!=null){
	    				result.put("orderid",cm.get("gems_code"));
            			result.put("name",cm.get("c_name"));
            			result.put("IDcard_num",cm.get("c_card_no"));
            			result.put("ordertime",cm.get("dt_add").toString().replace(".0", ""));
            			result.put("eid",cm.get("id"));
            			result.put("pdfurl","http://a.kcway.net/"+cm.get("result_pdf"));
            			result.put("pdfuptime",cm.get("dt_edit").toString().replace(".0", ""));	
	    			}else{	            			
            			result.put("orderid",cm.get("gems_code"));
            			result.put("name",cm.get("c_name"));
            			result.put("IDcard_num",cm.get("c_card_no"));
            			result.put("ordertime",cm.get("dt_add").toString().replace(".0", ""));
            			result.put("eid",cm.get("id"));
            			result.put("msg","此订单未出报告");	            			
            		}	    		
	    		}else{	      	            			
        			result.put("name",y.getC_name());
        			result.put("IDcard_num",y.getC_card_no());
        			result.put("msg","无此订单信息");	            			
        		}
	    		
	    		mapList.add(result);
	    	} 	     			            		
	            	 result1.put("errcode", "00");
			         result1.put("errmsg", "查询成功");
			         result1.put("result",mapList);
	            
	     	 }else{
	     		 result1.put("errcode", "02");
	         	 result1.put("errmsg","用户验证失败"); 

	     	 }  
	     	
	     	 }else{
	     		 result1.put("errcode", "03");
	         	 result1.put("errmsg","ckey不能为null"); 

	     	 } 
	    	
	    	return result1;
	    	
	    
	    }
	    
	    
		 @RequestMapping(value="/queryykd.do",produces="application/json;charset=UTF-8")
		 @ResponseBody
		 public Map queryykd( @RequestBody String dataqj, @RequestHeader String ckey){
	           List<queryzx> querylist=new ArrayList<queryzx>();
	          Map<String, String> mdate=new HashMap<String, String>();
	          List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
	          //dataqj=dataqj.replace("[", "").replace("]","");
	          Map time= jsonutil.toHashMap(dataqj);
	          
	          if(!time.get("sdate").equals("")&&time.get("sdate")!=null){
	        	  mdate.put("sdate",time.get("sdate").toString());
	          }else{
	        	  mdate.put("sdate","");
	          }	         
               if(!time.get("edate").equals("")&&time.get("edate")!=null){
            	   mdate.put("edate",time.get("edate").toString());
	          }else{
	        	  mdate.put("edate","");
	          }	
	         
	           Map result=new HashMap();
	           if(ckey!=null&&!ckey.equals("")){
	        	List<fs> fl=fsservice.findfsbyckey(ckey);
	        	   if(fl.size()>0){
	        		   querylist=queryzxservice.querybydate(mdate);
	        		   if(querylist.size()>0){
	        			   
	        		  
	        		   for(queryzx qz : querylist){
	        			   Map<String,Object> m=new HashMap<String,Object>();
	        			   m.put("search_date",qz.getDt_add().toString().replace(".0", ""));
	        			   m.put("success_date",qz.getDt_edit().toString().replace(".0", ""));
	        			   m.put("orderid",qz.getGems_code());
	        			   m.put("name",qz.getC_name());
	        			   m.put("IDcard_num",qz.getC_card_no());
	        			   Map gm=gemsservice.selectname(qz.getGems_id());
	        			   m.put("sname",gm.get("name"));
	        			   m.put("saccount",gm.get("username"));
	        			   m.put("sIDcard",gm.get("idcard"));
	        			   m.put("yfreturn",qz.getBook_status());
	        			   m.put("yf_time",qz.getDt_edit().toString().replace(".0", ""));
	        			   m.put("sqsbm", qz.getC_book_no());
	        			   maplist.add(m);
	        		   }
	        		   result.put("errcode","01");
	        		   result.put("errmsg","查询成功");
	        		   result.put("result", maplist);
	        		   }else{
	        			   result.put("errcode","04");
		        		   result.put("errmsg","此区间暂无报表信息"); 
		        		 
	        		   }
	        	   }else{
	        		   result.put("errcode","02");
	        		   result.put("errmsg","用户验证失败");
	        		  
	        	   }
	               
	           }else{
	    		   result.put("errcode","03");
	    		   result.put("errmsg","ckey不能为空");
	    		   
	    	   }
		 			 
			 return result;			 			 						 			 			 
		 }
		 
		 
		 
	 
}
