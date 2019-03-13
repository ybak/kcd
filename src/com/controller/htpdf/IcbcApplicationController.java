package com.controller.htpdf;
import java.io.File;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.service1.htpdf.IcbcApplicationService;
//类 方法注释快捷键 ALT + SHIFT + J
/*ctrl+shift+b：打开、关闭断点

ctrl+alt+b：开启、跳过已存在的所有断点

         Ctrl+shift+i：查看选中变量的值

         F5：进入当前运行的程序内部

         F6：当前程序的下一行

         F7：跳出函数

         F8：运行完当前断点*/

@Controller
@RequestMapping("/icbc")
public class IcbcApplicationController extends BaseController{
	@Autowired	
	IcbcApplicationService ias;
	private static Logger log = LogManager.getLogger(IcbcApplicationController.class.getName());
	
	//excel下载
	@RequestMapping(value="/excel.do")
	@ResponseBody
	public Map excel(HttpServletRequest request){
		String s=request.getParameter("id");
		return new TestWord(ias,s).createDoc();
	}
	
	//pdf处理
	@RequestMapping(value="/ptreating.do",produces="application/json;charset=utf-8")
	@ResponseBody
	public Object query1(HttpServletResponse response,HttpServletRequest request){
		String s=request.getParameter("id");
		response.setContentType("text/html;charset=UTF-8");
	    response.setCharacterEncoding("UTF-8");
		List<Map> l=null;//查询的结果
		Map map=null;
		if(s!=null && !s.equals("")){
			l=(List) ias.query1(s);
			if(l.size()<=0){
	    		return resultError("该用户信息查询不到");
	    	}
			map=l.get(0);
		}else{
    		return resultError("请输入参数");
		}
		//map
		if(map.size()<=0){
    		return resultError("该用户信息查询不到");
		}else{
			/*<select id="aj_bank" name="aj_bank">
	            <option value="0">请选择按揭银行</option>
	            <option value="1">工行绍兴分行</option>  
	            <option value="2">工行武林支行</option>
	            <option value="3">工行义乌支行</option>            
            </select>*/
			log.info("查询原始合同数据->"+map);
			DocumentHandlerParent dh;
			try {
				if(map.get("bankId").toString().equals("2")){//工行武林支行
					dh=new DocumentHandler2("/htpdf",request,map);
				}else{//城站支行
					dh=new DocumentHandler3("/HangZhouChengZhan",request,map);
				}
				//DocumentHandler3 
				 return dh.fillTemplate();
			} catch (Exception e) {
				log.error("error->"+JSONObject.toJSONString(e.getStackTrace()));
				// TODO Auto-generated catch block
				return resultError(e.getMessage());
			}
		}
	}
	//zip下载
	@RequestMapping(value="/pdonload.do")
	public HttpServletResponse pdonload(String f,HttpServletResponse response){
		//下载地址
		DocumentHandler2.downloadZip(new File(DocumentHandlerParent.root_Directory+f),response);
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