package com.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.customer;
import com.service.customerService;
import com.service.creditService;
import com.service.historyService;
import com.util.errorutil;
import com.util.jsonutil;
import com.util.md5util;

@Controller
public class customerController {
	    @Autowired
	    private creditService creditService;
	    @Autowired
	    private historyService hts;
	    @Autowired
	    private customerService customerservice;
	    //json 工具类
	    jsonutil ju=new jsonutil();
	    
	    //添加员工
	    @RequestMapping(value="/addperson.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String addperson(HttpServletRequest request,
	    		@RequestParam("account")String account,
	    		@RequestParam("level")String level,
	    		@RequestParam("name")String name,
	    		@RequestParam("owencompany")String owencompany,
	    		@RequestParam("password")String password	    		
	    		){	    	
	    	  Map result=new HashMap();
	    	  UUID randomUUID = UUID.randomUUID();
	    	  String ckey=md5util.getMD5(name+randomUUID.toString(),"UTF-8");
	    	  customer ct=new customer();
	    	  ct.setAccount(account);
	    	  ct.setLevel(level);
	    	  ct.setName(name);
	    	  ct.setOwencompany(owencompany);
	    	  ct.setPassword(password);
	    	  ct.setCkey(ckey);
	    	  customerservice.addperson(ct);
	    	  result.put("errorcode","01");
	    	  result.put("errormsg","添加成功");
	    	  result.put("result",ct);
	    	  return jsonutil.toJSONString(result);		
	    }


	    //根据公司查询员工
	    @RequestMapping(value="/findperson.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String findperson(HttpServletRequest request,
	    		@RequestParam("company")String company	    		
	    		){	    	 
	    	  Map result=new HashMap();
	    	  List<customer> cm=new ArrayList();
	    	  cm=customerservice.findbycompany(company);
	    	  //cm.put("login_time",cm.get("login_time").toString());
	    	  if(cm.size()>0){
	    		  result.put("errorcode", "01");
		    	  result.put("errormsg", "查询成功");
		    	  result.put("result",cm); 
	    	  }else {
	    		  result.put("errorcode", "07");
		    	  result.put("errormsg", "查询失败");
		    	  result.put("result", errorutil.error07());
			  }
	    	  	    	  
	    	  return jsonutil.toJSONString(result);		
	    }
	   //根据公司查询员工
	    @RequestMapping(value="/findlevel.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	    @ResponseBody
	    public String findlevel(HttpServletRequest request,
	    		@RequestParam("level")String level,
	    		@RequestParam("company")String company
	    		){	    	 
	    	  Map result=new HashMap();
	    	  List<customer> clist=new ArrayList();
	    	  List<customer> clist1=new ArrayList();
	    	  List<customer> clist2=new ArrayList();
	    	  Map result1=new HashMap();
	    	  Map result2=new HashMap();
	    	  
	    	  clist1=customerservice.findbylevel(level, company);	    		 
	    		System.out.println(clist1.size()+"sssssssss");
	    	  if(clist1.size()>0){	    			    	   	    	    	    	      		 
	    		  result.put("errorcode", "01");
		    	  result.put("errormsg", "查询成功");
		    	  result.put("result",clist1); 
		    	  return jsonutil.toJSONString(result);		
	    	  }else{
	    		  result.put("errorcode", "07");
		    	  result.put("errormsg", "查询失败");
		    	  result.put("result", errorutil.error07());
		    	  return jsonutil.toJSONString(result);		
	    	  }
    	  
  
	    	 
	    }
}
