package com.controller.icbc;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.controller.icbc.util.GetFileName;
import com.util.jsonutil;
@Controller
public class getfilenameController {

	
	@RequestMapping(value="getfilename.do")
	@ResponseBody
	public String getfilename(String filename){
		GetFileName gfn=new GetFileName();
		ArrayList<String> listFileName = new ArrayList<String>(); 
		gfn.getAllFileName(filename, listFileName);		
		return jsonutil.toJSONString(listFileName);
	}
}
