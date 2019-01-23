package com.controller.htpdf;
import java.io.File;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service1.htpdf.IcbcApplicationService;

@Controller
@RequestMapping("/icbc")
public class IcbcApplicationController {
	@Autowired	
	IcbcApplicationService ias;
	
	
	//excel下载
	@RequestMapping(value="/excel.do")
	@ResponseBody
	public Map excel(HttpServletRequest request){
		String s=request.getParameter("id");
		return new TestWord(ias,s).createDoc();
	}
	
	//pdf处理
	@RequestMapping(value="/ptreating.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String query1(HttpServletResponse response,HttpServletRequest request){
		String s=request.getParameter("id");
		DocumentHandler2 dh=new DocumentHandler2();
		response.setContentType("text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
		return dh.fillTemplatePDF1(ias,s,response,request);
	}
	//zip下载
	@RequestMapping(value="/pdonload.do")
	public HttpServletResponse pdonload(String f,HttpServletResponse response){
		DocumentHandler2.downloadZip(new File(f),response);
		return response;
	}
	//实时进度
	@RequestMapping("/jd.do")
	@ResponseBody
	public int jd(HttpServletRequest request){
		//System.out.println("session"+request.getSession().getId());
		int i=0;
		try{
			 i=(int) ProgressSingleton.get(request.getSession().getId());
		} catch (Exception e) {
			// TODO: handle exception
		}
		 return i;
	}
}