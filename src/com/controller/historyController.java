package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.history;
import com.service.creditService;
import com.service.financeService;
import com.service.historyService;
import com.service.pdfoverService;
import com.util.jsonutil;

@Controller
public class historyController {
	@Autowired
    private pdfoverService pfs;
	@Autowired
    private historyService hts;
	@Autowired
    private creditService cds;
	@Autowired
    private financeService fns;

	private jsonutil ju;

	@RequestMapping(value="/historylist.do",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
	@ResponseBody
	public String historylist(HttpServletRequest request,String uid){
		 List<history> hlist=new ArrayList();
		 hlist=hts.hlist(uid);		
		 request.setAttribute("hlist",hlist);			
		 return jsonutil.toJSONString(hlist);
		
		
	}

}
