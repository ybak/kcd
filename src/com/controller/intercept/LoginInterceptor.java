package com.controller.intercept;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.model1.icbc.erp.PageData;

import javax.servlet.http.HttpSession; 
/** 
 * 登录认证的拦截器 
 */
public class LoginInterceptor implements HandlerInterceptor{ 
  
 /** 
  * Handler执行完成之后调用这个方法 
  */
 @Override
public void afterCompletion(HttpServletRequest request, 
   HttpServletResponse response, Object handler, Exception exc) 
   throws Exception { 
    
 } 
  
 /** 
  * Handler执行之后，ModelAndView返回之前调用这个方法 
  */
 @Override
public void postHandle(HttpServletRequest request, HttpServletResponse response, 
   Object handler, ModelAndView modelAndView) throws Exception { 
 } 
  
 /** 
  * Handler执行之前调用这个方法 
  */
 @Override
public boolean preHandle(HttpServletRequest request, HttpServletResponse response, 
   Object handler) throws Exception { 
  //获取请求的URL 
  String url = request.getRequestURI(); 
  System.out.println("请求的url:"+url);
  System.out.println("*****:"+url.indexOf("erp"));
  //URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制 
  if(url.indexOf("ulogin.do")>=0||url.indexOf("erp/erp_login.do")>=0){ 
   return true; 
  } 
  //获取Session 
  HttpSession session = request.getSession(); 
  String username = (String)session.getAttribute("username");  
  PageData pd =(PageData) session.getAttribute("pd"); 
  if(username != null||pd!=null){ 
   return true; 
  }
 
  if(url.indexOf("erp")>0){
	//不符合条件的，跳转到登录界面 
	  request.getRequestDispatcher("/kjs_icbc/login.jsp").forward(request, response);   
  }else{
	//不符合条件的，跳转到登录界面 
	  request.getRequestDispatcher("/cskjs_wzb/login.jsp").forward(request, response);   
  }
  
    
  
  return false; 
 } 
  
} 
