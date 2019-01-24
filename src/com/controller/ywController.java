package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.yw;
import com.service.companyService;
import com.service.customerService;
import com.service.ywService;
import com.util.excelutil;

@Controller
public class ywController {
 
	 @Autowired
	 private ywService ywservice;
	 @Autowired
	 private companyService cps;
	 @Autowired
	 private customerService cs;
	 
	 
	 @RequestMapping(value="/toexcel.do",produces="text/html;charset=UTF-8")
	 @ResponseBody
	 public String toexcel(HttpServletRequest request,String ckey){
		 List<yw> ylist=new ArrayList();
		 int ckeynum= cps.ckynum(ckey);
	     int pkeynum=cs.keypeople(ckey);
	     if(ckeynum!=0||pkeynum!=0){
	    	 ylist=ywservice.fywlist();
			 excelutil.toexcel(ylist);
			 
	     }
		
		 return "³É¹¦";
		 
		 
		 
		 
	 }
}
