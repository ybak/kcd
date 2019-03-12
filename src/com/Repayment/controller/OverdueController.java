package com.Repayment.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model1.icbc.erp.PageData;
import com.service1.Repayment.OverdueService;
import com.util.limitutil;

@Controller
@RequestMapping("/overdueController")
public class OverdueController {

	@Autowired
	private OverdueService overdueService;
	
	@RequestMapping("/select")
	public String select(
			String qn,
			String cn,
			String type,
			String dn,	
			int pagesize,
			int pagenow,
			String param,
			HttpServletRequest request){
		List<PageData> newpdList=new ArrayList<>();
		PageData pd=new PageData();
		pd.put("dn", dn);
		List<PageData> pdList=overdueService.selectoverdue(param, pd);
		newpdList = limitutil.fy(pdList, pagesize, pagenow);
		int q=pdList.size()%pagesize;
		int totalpage=0;//×ÜÒ³Êý
		if(q==0){
			totalpage=pdList.size()/pagesize;	    		
		}else{
			totalpage=pdList.size()/pagesize+1;
		} 
		
		
		request.setAttribute("dn", dn);
		request.setAttribute("cn", cn);
		request.setAttribute("qn", qn);
		request.setAttribute("type", type);	
		request.setAttribute("totalpage",totalpage);
		request.setAttribute("totalsize",pdList.size());
		request.setAttribute("pagesize",pagesize);
		request.setAttribute("pagenow",pagenow);
		request.setAttribute("newpdList", newpdList);
		return "kjs_icbc/index";
	}
}
