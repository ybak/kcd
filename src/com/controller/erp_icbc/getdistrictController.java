package com.controller.erp_icbc;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.model1.city.comm_zones;
import com.service1.kjs_icbc.comm_zonesService;

@Controller
public class getdistrictController {

	 @Autowired
	 private comm_zonesService comm_zonesService;
	
	@RequestMapping(value = "erp/getcomm_zones.do")
	@ResponseBody
	public List getcomm_zones(int shengid,int cityid) {		
	    List<comm_zones> comm_zones=comm_zonesService.findcomm_zonesbyid(shengid, cityid);
		return comm_zones;
	}
	
}
