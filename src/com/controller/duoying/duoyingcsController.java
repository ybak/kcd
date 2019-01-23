package com.controller.duoying;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.model1.carmodel;
import com.model1.mgcert;
import com.service1.duoying.carmodelService;
import com.service1.duoying.mgcertService;

@Controller
public class duoyingcsController {

	 @Autowired
	  private carmodelService carmodelservice;
	 @Autowired
	  private mgcertService mgcertservice;
	
	@RequestMapping(value="dyuceshi.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String dyuceshi(){
	
		 
	 List<mgcert> ml=mgcertservice.Apijkxxmgcert();
	 List<JSONObject>  jl=new ArrayList<JSONObject>();
		for(mgcert m : ml ){			
			carmodel c=carmodelservice.modelmap(m.getCarid());
			JSONObject car=new JSONObject();
			car.put("name", m.getC_name());
			car.put("carname", c.getName());
			jl.add(car);
		}
		
		return jl.toString();
	}
	
	
	
	
}
