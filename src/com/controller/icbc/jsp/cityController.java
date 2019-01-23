package com.controller.icbc.jsp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.model1.city.citys;
import com.model1.city.states;
import com.service1.kjs_icbc.citysService;
import com.service1.kjs_icbc.statesService;
import com.util.jsonutil;

@Controller
public class cityController {

	 @Autowired
	 private statesService statesService;
	
	 @Autowired
	 private citysService citysService;
	 
	 
	 @RequestMapping(value="/finfdstates.do",produces="text/html;charset=UTF-8")	
	 @ResponseBody
	 public String finstates(){
	  List<states>	sList=statesService.allfindstates(); 		 
	  return jsonutil.toJSONString(sList);
	 }
	 @RequestMapping(value="/query_states.do",produces="text/html;charset=UTF-8")	
	 @ResponseBody
	 public String query_states(){
	  List<JSONObject> jList=new ArrayList<>();
	  List<states>	sList=statesService.allfindstates(); 	
	  if(sList.size()>0){
		  for(states state : sList){
			  JSONObject ststes=new JSONObject();
			  ststes.put("states_name", state.getName());
			  ststes.put("states_id", state.getId());
			  ststes.put("states_first", state.getChrkey());
			  jList.add(ststes);
		  }
		  JSONObject result=new JSONObject();
          result.put("result",jList);
          result.put("msg","成功");
          result.put("code","200");
          return result.toString();
      }else{
      	JSONObject result=new JSONObject();
          result.put("result","");
          result.put("msg","失败");
          result.put("code","201");
          return result.toString();
      }
	 }
	 @RequestMapping(value="/query_citys.do",produces="text/html;charset=UTF-8")	
	 @ResponseBody
	 public String query_citys(){
	  List<JSONObject> jList=new ArrayList<>();
	  List<citys>	citys=citysService.findallcitys();
	  if(citys.size()>0){
		  for(citys city : citys){
			  JSONObject cityss=new JSONObject();
			  cityss.put("citys_name", city.getName());
			  cityss.put("states_id", city.getState_id());
			  cityss.put("citys_first", city.getChrkey());
			  cityss.put("citys_id", city.getId());
			  jList.add(cityss);
		  }
		  JSONObject result=new JSONObject();
          result.put("result",jList);
          result.put("msg","成功");
          result.put("code","200");
          return result.toString();
      }else{
      	JSONObject result=new JSONObject();
          result.put("result","");
          result.put("msg","失败");
          result.put("code","201");
          return result.toString();
      }
	 }
	 @RequestMapping(value="/fincitys.do",produces="text/html;charset=UTF-8")	
	 @ResponseBody
	 public String fincitys(int state_id){
	    List<citys>	citys=citysService.findcitysbystate_id(state_id);		 
		return jsonutil.toJSONString(citys);
	 }
}
