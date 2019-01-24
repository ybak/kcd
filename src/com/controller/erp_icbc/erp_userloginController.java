package com.controller.erp_icbc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.controller.erp_icbc.utils.MemoryData;
import com.model1.icbc.erp.PageData;
import com.service1.erp_icbc.erp_userrootService;
import com.util.jsonutil;
import com.util.stringorintutil;
import com.util.duoying.MD5;

@Controller
public class erp_userloginController {

	  @Autowired
	  private erp_userrootService  erp_userrootService;
	  /**
	   * erp系统登录
	   * @param username
	   * @param password
	   * @param request
	   * @return
	   */
	  @RequestMapping(value="erp/erp_login.do",produces = "text/html;charset=UTF-8")
	  @ResponseBody
	  public String erp_login(
			  String username,
			  String password,
			  HttpServletRequest request
			  ){
		System.out.println("用户名密码："+username+"--"+password);
		JSONObject result=new JSONObject();
		PageData pdData=new PageData();
		pdData.put("dn", "login");
		pdData.put("username",username);
		pdData.put("password",MD5.sign(MD5.sign(password,"UTF-8"),"UTF-8"));
		
		PageData pd=erp_userrootService.findbyid(pdData);
		System.out.println("用户信息:"+pd);
		if(pd!=null&&!pd.equals("")){
			HttpSession session = request.getSession();  
			session.setAttribute("pd", pd);
			session.setMaxInactiveInterval(60 * 60);
			result.put("code",1);
			result.put("msg","登陆成功!~");
		}else{
			result.put("code",0);
			result.put("msg","用户名或密码错误!!!");
		}
		return result.toJSONString(); 
	  }
	  /**
	   * erp退出登录
	   * @param request
	   * @return
	   */
	  @RequestMapping(value="erp/erp_outlogin.do",produces = "text/html;charset=UTF-8")  
	  public String erp_outlogin(
			  HttpServletRequest request
			  ){
		HttpSession session = request.getSession();  
		 //清除Session 
  	      session.invalidate();
		  return "kjs_icbc/login"; 
	  }
	
	
}
