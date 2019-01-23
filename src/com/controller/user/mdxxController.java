package com.controller.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.mdxx;
import com.service.mdxxService;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.md5util;

@Controller
public class mdxxController {
	@Autowired
	private mdxxService mdxxservice;
	
    @RequestMapping(value="/addmdxx.do",method=RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
	public String addmdxx(HttpServletRequest request,HttpServletResponse response,
			@RequestBody String mdxx
			){
    	//String mdxx=request.getParameter("mdxx");
    	Map result=new HashMap();
    	System.out.println(mdxx);
    	System.out.println(mdxx);
    	mdxx="["+mdxx+"]";
    	List<mdxx> l=new ArrayList<mdxx>();
        l=jsonutil.toList(mdxx,mdxx.class);
    	if(l!=null&&l.size()>0){
        List<Map<String,String>> mdxxs=new ArrayList<Map<String,String>>();
    		mdxx m=new mdxx();
        for(int i=0;i<l.size();i++){
    	    m=l.get(i);
    	   Map res=new HashMap();
    	   UUID randomUUID = UUID.randomUUID();
       	   String ckey=md5util.getMD5(mdxx+randomUUID.toString(),"UTF-8");
    	   res.put("sname",m.getSname());
    	   res.put("alevel",m.getAlevel());
    	   res.put("pname",m.getPname());
    	   res.put("pIDcard",m.getpIDcard());
    	   res.put("pcall",m.getPcall());
    	   res.put("czcode",m.getCzcode());
    	   res.put("addtime",creditutil.time().toString());
    	   res.put("uptime",creditutil.time().toString());
    	   res.put("ckey",ckey);
    	   res.put("kd", "0");
    	   mdxxs.add(res);
       }          			
    	mdxxservice.addmdxx(mdxxs);		    	
    	result.put("errcode", "01");
		result.put("errmsg", "成功");
    	}else{
    		result.put("errcode", "03");
    		result.put("errmsg", "提交的字段不完整");    		
    	}
		return result.toString().replace("[","").replace("]","");
		
	}
    
    
    
}
