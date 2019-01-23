package com.controller.kcdback;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.company;
import com.model.finance;
import com.service.companyService;
import com.service.financeService;
import com.util.errorutil;
import com.util.jsonutil;
import com.util.md5util;

@Controller
public class companyController {
    @Autowired
	private companyService companyservice;
    @Autowired
	private financeService fs;
  //json 工具类
    jsonutil ju=new jsonutil();
    
//    @RequestMapping(value="/download.do",method=RequestMethod.GET,produces = "text/html;charset=UTF-8")
//    @ResponseBody
//     private String download(HttpServletRequest request,HttpServletResponse response) {
//    	
//    	String fileName="20160812画册1.pdf";
//    	try {
//			Download.downloadFile(request, response, fileName);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	
//    	String s="成功";
//		return s;
//		// TODO Auto-generated method stub
//
//	}
    
    //充值 
    @RequestMapping(value="/upcompany.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String upcompany(HttpServletRequest request,
    		String beans,
    		String company,
    		String qygsm,
    		String je,
    		String bz,
    		String lx,
    		String rmk,
    		String zt,
    		String czr
    		){
    	company com=new company();
    	finance fn=new finance();
    	 Map result=new HashMap();
    	com.setCompany(company);
        Map  cm=companyservice.findcompany(company);    	
         if(cm!=null){        	
        	 if(cm.get("beans")!=null){
        		 int beans1=Integer.parseInt(beans)+Integer.parseInt(cm.get("beans").toString());       		 
        		 com.setBeans(String.valueOf(beans1));        		 
        	 }else{
        		 com.setBeans(beans);
        	 }
        	   	companyservice.upcompany(com);           
            	result.put("errorcode", "01");
            	result.put("errormsg", "充值成功");
            	result.put("result",com);
            	fn.setBz(bz);
            	fn.setCzr(czr);
            	fn.setJe(je);
            	fn.setLx(lx);
            	fn.setQygsm(qygsm);
            	fn.setRmk(rmk);
            	fn.setShgs(company);
            	fn.setZt(zt);
        	    fs.savefinance(fn);
        	    result.put("resultfn",fn);
            	
         }else {        	
         	result.put("errorcode", "01");
         	result.put("errormsg", "充值失败");
         	result.put("result",errorutil.error08());
		}
 
    	
		return jsonutil.toJSONString(result);
    	
    	
    	
    }
    
    //添加公司
    @RequestMapping(value="/addcompany.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String addcompany(
    		@RequestParam("company")String company,
    		@RequestParam("pusername")String pusername,
    		@RequestParam("ppassword")String ppassword,
    		HttpServletRequest request    		
    		){
    	Map result=new HashMap();
    	UUID randomUUID = UUID.randomUUID();
    	String ckey=md5util.getMD5(pusername+randomUUID.toString(),"UTF-8");
    	company companylist=new company();
    	Map cm= companyservice.findcompany(company);
    	if(cm==null){
    		companylist.setCompany(company);
        	companylist.setPusername(pusername);
        	companylist.setPpassword(ppassword);
        	companylist.setCkey(ckey);
//        	companylist.setBeans("5000");     	
        	companyservice.addcompany(companylist);
        	result.put("errorcode","01");
        	result.put("errormsg","添加成功");
        	result.put("result",companylist);
    	}else{
    		result.put("errorcode","09");
        	result.put("errormsg","添加失败");
        	result.put("result",errorutil.error09());    		
    	}
    	  	
		return jsonutil.toJSONString(result);
    	
    	
    	
    	
    }
	
}
