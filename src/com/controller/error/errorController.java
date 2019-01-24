package com.controller.error;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;

@Controller
public class errorController {
	
	@RequestMapping("400.do")
	public String handle1(HttpServletRequest request){
		return "404";
	}
	@RequestMapping("404.do")
	public String handle2(HttpServletRequest request){
		return "404";
	}
	@RequestMapping("500.do")
	public String handle3(HttpServletRequest request){
		return "404";
	}
	
    @ResponseBody
    @RequestMapping("/error001.do")
    public String main(){
        throw new NullPointerException("NullPointerException Test!");
    }
}
