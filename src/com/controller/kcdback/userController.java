package com.controller.kcdback;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model.user;
import com.model1.admin;
import com.service.creditService;
import com.service.historyService;
import com.service.pdfoverService;
import com.service.userService;
import com.service1.adminService;
import com.util.jsonutil;

@Controller
public class userController {
	@Autowired
    private pdfoverService pfs;
	@Autowired
    private historyService hts;
	@Autowired
    private creditService cds;
	@Autowired
    private userService userservice;
	@Autowired
    private adminService adminservice;
	//json 工具类
    jsonutil ju=new jsonutil();
	/**
	 * 登陆
	 * @param session
	 * @param request
	 * @param username
	 * @param password
	 * @return
	 */
	
    @RequestMapping(value="/ulogin.do",produces="text/html;charset=UTF-8")
	public String ulogin(HttpServletRequest request,
			String username,
			String password,
			String type
			){
    	HttpSession session = request.getSession();  
    	Map adminmap= adminservice.adminlogin(username,password);
    	System.out.println(type);
    	if(adminmap!=null){
    		admin admin= jsonutil.toBean(adminmap,admin.class);
    		request.getSession().setAttribute("admin", admin);
    		request.getSession().setAttribute("adminmap", adminmap);
    		request.getSession().setAttribute("username", adminmap.get("username"));
    		request.getSession().setAttribute("password", adminmap.get("userpass"));
    		request.getSession().setAttribute("name",adminmap.get("name"));
    		request.getSession().setAttribute("id",adminmap.get("id"));
    		request.getSession().setAttribute("bc_title",adminmap.get("bc_title"));
    		
    	    
//    	    System.out.println("上一次访问session的时间"+new Date(session.getLastAccessedTime()));  
//    	    System.out.println("session的有效时长："+session.getMaxInactiveInterval());  
//    		System.out.println(adminmap.get("gemsid"));    		
    		
    		session.setMaxInactiveInterval(30 * 60);
    		if(Integer.parseInt(adminmap.get("gemsid").toString())==0){
    		if(type!=null&&!type.equals("")&&type.equals("kjs")){
    			return "cskjs_wzb/kjs";
    		}else{
    			
    			return "index";
    		}			
		    }else{
	    		if(type!=null&&!type.equals("")&&type.equals("kjs")){
	    			
	    			return "cskjs_wzb/login";
	    		}else{
	    			
	    			return "login";
	    		}
	    		
	    	}
    	}else{
    		if(type!=null&&!type.equals("")&&type.equals("kjs")){
    			return "cskjs_wzb/login";
    		}else{
    			return "login";
    		}
    		
    	}
					
	}
    /**
     * 登出
     * @param session
     * @param request
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(value="/uloginout.do",produces="text/html;charset=UTF-8")
	public String uloginout(HttpSession session,HttpServletRequest request,String username,String password){
    	  //清除Session 
    	  session.invalidate();
		  return "login"; 					
	}
    
    @RequestMapping(value="/userlogin.do",produces="text/html;charset=UTF-8")
    @ResponseBody
	public String login(HttpServletRequest request,String username,String password){
    	Map userlist=new HashMap();
    	String mark="e";
    	System.out.println(username+"用户名");
    	if(!username.equals("")&&!password.equals("")){    		    	
    	userlist=userservice.finduser(username, password);
    	if(userlist!=null){
    		if(userlist.get("username")!=null&&!userlist.get("username").equals("")){    		
        		request.getSession().setAttribute("user",userlist);
        		mark="y";           
        	 }else{
        		mark="s";      		 
        	 }   
    	}   	  	
    	return mark;    	
    	}else{    		
    	return mark;    		
    	}
							
	}
    @RequestMapping(value="/kcdlogin.do",produces="text/html;charset=UTF-8")
	public String kcdlogin(HttpServletRequest request,String username,String password){
    	Map userlist=new HashMap();    	
    	System.out.println(username+"用户名");
    	if(!username.equals("")&&!password.equals("")){    		    	
    	userlist=userservice.finduser(username, password);
    	if(userlist!=null){
    		if(userlist.get("username")!=null&&!userlist.get("username").equals("")){    		
        		request.getSession().setAttribute("user",userlist);
        		return "index";        
        	 }else{
        		return "login";      		 
        	 }   
    	}else{    		
    	return "login";    		
    	}    	
    	}else{    		
    	return "login";    		
    	}
						
	}
    @RequestMapping(value="/tologin.do",produces="text/html;charset=UTF-8")
    @ResponseBody
	public String tologin(HttpServletRequest request,
			@RequestParam(value="id",required=false)String id,
			@RequestParam(value="username1",required=false)String username1,@RequestParam(value="password1",required=false)String password1 ){
    	Map userlist=new HashMap();
//    	String username=request.getAttribute("username").toString();
//    	String password=request.getAttribute("password").toString();
    	System.out.println(username1+"用户名");    	   		    	    	
    		userlist=userservice.finduser(username1, password1);    	
    		if(userlist!=null&&userlist.size()>0){
    		if(userlist.get("username")!=null&&!userlist.get("username").equals("")){    		
        		request.getSession().setAttribute("user",userlist);
        		return "index";        
        	 }else{
        		return "login"+username1+"--1--"+id;      		 
        	 }   
    	}else{
    		
    	return "login"+username1+"--2--"+id;
    		
    	}
							
	}
    
    @RequestMapping(value="/userreg.do",produces="text/html;charset=UTF-8")
    @ResponseBody
	public String reg(HttpServletRequest request,String username,String password,String phonenum){
    	Map usermap=new HashMap();
    	String message="";
    	user u=new user();
    	System.out.println(username+"----------"+password);
    	
    	if(!username.equals("")&&!password.equals("")&&!phonenum.equals("")){
    		usermap=userservice.finduser1(username);
    		//System.out.println(usermap+"sssssssssss");
    	 if(usermap!=null){
    	if(usermap.get("username").equals(username)){
    		message="x";
    	 }
    	 }else {
        		u.setPassword(password);
            	u.setPhonenum(phonenum);
            	u.setUsername(username);        	   		    	    
            	userservice.adduser(u);   
            	message="success";
         }   
    	}else{
    		message="e";
    	}
    	return message;		    									
	}
    
    @RequestMapping(value="/user_list.do",produces="text/html;charset=UTF-8")
    public String user_list(HttpServletRequest request){
    	System.out.println("11111111111111111111");
		List<user> ulist=new ArrayList();
    	ulist=userservice.userfind();
    	request.setAttribute("ulist", ulist);
    	for(user u : ulist){
    		System.out.println(u.getAddtime()+"-----"+u.getUsername());
    	}
    	
    	return "admin_list";    	    	    	    	    	    	    	
    }
    
    @RequestMapping(value="/user_up.do",produces="text/html;charset=UTF-8")
    public String user_up(HttpServletRequest request,int uid){
    	//System.out.println("11111111111111111111");
		Map umap=new HashMap();
		umap=userservice.finduserbyid(uid);
    	request.setAttribute("umap", umap);    	
    	return "admin_add";    	    	    	    	    	    	    	
    }
}
