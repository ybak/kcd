package com.controller.icbc.jsp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hp.hpl.sparta.xpath.ThisNodeTest;
import com.http.RiskServicePreloan;
import com.util.jsonutil;

@Controller
public class icbc_dsjController {
	
	
	 RiskServicePreloan service = new RiskServicePreloan();
	
	@RequestMapping(value="/dsj_report_id.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String dsj_report_id(String name,
			String phone,
			String cardno
			){
	Map<String, Object> params = new HashMap<String, Object>();
	params.put("name",name); // 姓名 胡八 352123197501281314
    //皮晴晴 320304198404070412  ER2017122917192888A1963A
    params.put("id_number",cardno); // 身份证号
    params.put("mobile",phone); // 手机号    
    JSONObject result=service.apply(params);			
    return result.toJSONString();		
	}
	
	
	@RequestMapping(value="/dsj_result.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String dsj_result(
			String report_id
			){
	JSONObject result = service.query(report_id);			
    return result.toJSONString();		
	}
		
	@RequestMapping(value="/dsj_result_jsp.do",produces = "text/html;charset=UTF-8")
	public String dsj_result_jsp(
			String report_id,
			HttpServletRequest request
			){
	JSONObject result=service.query(report_id);
	//接口调用是否成功
	request.setAttribute("success",result.get("success"));
	//错误代码
	request.setAttribute("reason_code",result.get("reason_code"));
	//错误描述
	request.setAttribute("reason_desc",result.get("reason_desc"));
	//风险分数
	request.setAttribute("final_score",result.get("final_score"));
	//风险结果
	request.setAttribute("final_decision",result.get("final_decision"));
	//归属地解析
	request.setAttribute("address_detect",(Map)result.get("address_detect"));
	
	if(result.get("risk_items")!=null&&!result.get("risk_items").equals("")){
		//扫描出来的风险项
		request.setAttribute("risk_items",(List<Map>)result.get("risk_items"));
		
		List<Map> maps=(List<Map>)result.get("risk_items");
		//risk_items  内容总量
		request.setAttribute("risk_items_count",maps.size());	
		System.out.println("内容总量:"+maps.size());
	}
	
	//credit_score  信用分数
	request.setAttribute("credit_score",result.get("credit_score"));
	
	
	
	return "cskjs_wzb/dsjbg";		
	}
	

  
  
	
   
}
