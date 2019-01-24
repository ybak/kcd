package com.controller.user;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.http.RiskServicePreloan;
import com.model.dsj;
import com.model.gskh;
import com.model.gsrykh;
import com.service.dsjService;
import com.service.gskhService;
import com.service.gsrykhService;
import com.service.mdxxService;
import com.util.creditutil;
import com.util.jsonutil;

import net.sf.json.JSONObject;

@Controller
public class findbigdataController {
	  private static final long   WAIT_TIME    = 5 * 1000;
	
	  @Autowired
	  private mdxxService mdxxservice;
	  
	  @Autowired
	  private gsrykhService khgsservice;
	  
	  @Autowired
	  private dsjService dsjservice;
	  @Autowired
	  private gskhService gskhservice;
	  
	  //获取reportId
    @RequestMapping(value="/toreportId.do",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
	public String toreportId(HttpServletRequest request,String ckey,String name,String ID_card,String mobile){
    	com.alibaba.fastjson.JSONObject jsonobject = null;
    	RiskServicePreloan riskServicePreloan=new RiskServicePreloan();
    	Map<String, Object> params=new HashMap<String, Object>();   
    	Map result=new HashMap();
        Map m=khgsservice.fgsrykh(ckey);
        dsj dsj=new dsj();
    	if(m!=null&&!m.equals("")&&m.size()>0){    		
    		Map gm=gskhservice.fgsbyid(Integer.parseInt(m.get("gsid").toString()));
    		int kd =Integer.parseInt(gm.get("kd").toString());
    		if(kd>10){    			
    			 params.put("name",name); // 姓名
    	         params.put("id_number",ID_card); // 身份证号
    	         params.put("mobile",mobile); // 手机号
    	         jsonobject=riskServicePreloan.apply(params);
    	         System.out.println(jsonobject.toString());
    	         
    	         if(jsonobject!=null&&!jsonobject.equals("")){    	        	 
    	        	     dsj.setIdcard(ID_card);
    	    	         dsj.setKhid(Integer.parseInt(m.get("khid").toString()));
    	    	         dsj.setName(name);
    	    	         dsj.setTime(creditutil.time());
    	    	         dsj.setUptime(creditutil.time());
    	    	         dsj.setPhonenum(mobile);
    	    	         String bg=jsonobject.getString("report_id");
    	    	         dsj.setBgid(bg);    	         
    	    	         System.out.println("ooooooo:"+bg);
    	    	         dsjservice.adddsj(dsj);
    	    	         return jsonobject.toString(); 
    	         }else{
    	        	    result.put("errcode", "03");
    					result.put("errmsg", "未生成报告id");
    					return jsonutil.toJSONString(result).replace("[", "").replace("]", "");     	        	 
    	         }
    	      
    	         
    		}else {
				result.put("errcode", "01");
				result.put("errmsg", "余额不足");
				return jsonutil.toJSONString(result).replace("[", "").replace("]", "");    
			}
    	      
    	}else{
    		result.put("errcode", "02");
			result.put("errmsg", "用户验证失败");
			return jsonutil.toJSONString(result).replace("[", "").replace("]", "");  
    		
    	}
		
    	
		
		
		
		
		
	}


    @RequestMapping(value="/query.do",method=RequestMethod.POST,produces="text/html;charset=UTF-8")
    @ResponseBody
	public String query(HttpServletRequest request,
		 String reportId,
		 String ckey
			){
    	RiskServicePreloan riskServicePreloan=new RiskServicePreloan();
    	com.alibaba.fastjson.JSONObject response = null;
    	 Map result=new HashMap();
    	 Map m=khgsservice.fgsrykh(ckey);
    	 gsrykh khgs=new gsrykh();
    	 gskh gs=new gskh();
    	 if(m!=null&&!m.equals("")&&m.size()>0){
    		
    	       // query接口获取结果
    	        response = riskServicePreloan.query(reportId);
    	        if(response!=null&&!response.equals("")){
    	        	    int gsid=Integer.parseInt(m.get("gsid").toString());
    	        	    Map gm=gskhservice.fgsbyid(gsid);
    	        	    int kd=Integer.parseInt(gm.get("kd").toString())-10;
    	         	    gs.setId(gsid);    	         	    
    	         	    gs.setKd(kd);
    	         	    gskhservice.upgskhkd(gs);
    	         		dsj dsj=new dsj();
    	         		dsj.setBgid(reportId);
    	         		dsj.setUptime(creditutil.time());
    	         		dsjservice.editdsj(dsj);
    	        }else{
    	        	result.put("errcode", "04");
 					result.put("errmsg", "未生成报告");
 					return jsonutil.toJSONString(result).replace("[", "").replace("]", ""); 	    	        	
    	        }
    	     
    	        return response.toString(); 
    	 }else{
    		result.put("errcode", "02");
 			result.put("errmsg", "用户验证失败");
 			return jsonutil.toJSONString(result).replace("[", "").replace("]", ""); 
    		 
    	 }
		
		
		
		
		
		
		
	}
	
	
	
	
	
}
