package com.controller.duoying;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class otherController {

	   /**
	    * ÆäËü
	    * @return
	    */
	   @RequestMapping(value="other.do",produces = "text/html;charset=UTF-8")
	   @ResponseBody
	   public String other(){
		   
		   
		   
		return null;
	   }
	
}
