package com.controller.duoying;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.model1.archives;
import com.model1.mgcert;
import com.service1.duoying.archivesService;
import com.service1.duoying.mgcertService;

@Controller
public class duoyingtxtController {
   
	@Autowired
	private mgcertService mgxertservice;
	@Autowired
	private archivesService archivesservice;
	
	@RequestMapping(value="jkrid.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String jkrid(
			String c_carno,
			String r_item6
			){
//		List<mgcert> ml1= mgxertservice.Apijkxxmgcert();	
//		List<mgcert> ml2= mgxertservice.Apimgcert();				
//		for(mgcert m : ml1){
//		    String sm=m.getC_cardno()+"|"+String.valueOf(m.getGems_fs_id());
//			for(mgcert m1 : ml1){
//			String sm1=m1.getC_cardno()+"|"+String.valueOf(m1.getGems_fs_id());	
//			if(sm.equals(sm1)){
//			 System.out.println("sm:"+sm+"=======sm1:"+sm1);	
//			 //System.out.println();
//			}
//			}
//			
//			
//		}

			archives a=archivesservice.Apiarchives(c_carno,r_item6,"0");
			  
			 System.out.println("a:"+a);
		     if(a!=null){
		    	 System.out.println("vin:"+a.getR_item6());
				  System.out.println("³µÅÆºÅ:"+a.getC_carno());
				  System.out.println("×´Ì¬:"+a.getBc_status());
		     }

	  
	     
		return null;
		
		
			
		//return jb.toString();
		
		
		
	}
}
