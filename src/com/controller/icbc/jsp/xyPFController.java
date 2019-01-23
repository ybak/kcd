package com.controller.icbc.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controller.PFmodel.Customer;
import com.controller.PFmodel.KjICBCController;
import com.model.icbc.icbc;
import com.service1.kjs_icbc.newicbcService;

import net.sf.json.JSONObject;

@Controller
public class xyPFController {

	@Autowired
	private newicbcService newicbcService;
	
	@RequestMapping(value="/xypf.do",produces="text/html;charset=UTF-8")  
	@ResponseBody
	public String xypf(
			int id
			){
		KjICBCController kc=new KjICBCController();
		Customer customer=new Customer();
		String defaultvalue="0";
		JSONObject result=new JSONObject();
		icbc icbc=newicbcService.findicbcbyid(id);
			try {
				kc.icbc(customer,icbc.getZx_result());
				defaultvalue=JSONObject.fromObject(kc.bigdate(customer,icbc.getDsj_result())).getJSONArray("rulesetResult").getJSONObject(1).getJSONArray("variables").getJSONObject(0).get("defaultValue").toString();
				result.put("code","1");
				result.put("msg",defaultvalue);
				return result.toString();
			} catch (Exception e) {
				result.put("code","0");
				result.put("msg","分析异常,请稍后重试!");
				return result.toString();
			}		
	}
	 
}
