package com.controller.kcdback;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.creditService;
import com.service.imgService;
import com.util.Download;
import com.util.creditutil;

@Controller
public class downloadController {
	
	@Autowired
	private creditService creditservice;
	@Autowired
	private imgService imgservice;
	
    @RequestMapping(value = "/downloadimg.do")  
    @ResponseBody  
    public void downloadimg(String id,String fid,
    		HttpServletResponse response,HttpServletRequest request) throws IOException {      	
    	    Map cm=creditservice.findcreditbyid(Integer.parseInt(id));
    	    Map im=imgservice.fimg(id);
    	    try {
    	    	if(fid.equals("1")){
    	    		if(cm.get("front").equals("2")){    	    		
    	    			Download.downloadimg(request, response,creditutil.timetofile(im.get("addtime").toString()),im.get("frontimg").toString()+".new.jpg");
    	    		}else{
    	    			Download.downloadimg(request, response,creditutil.timetofile(im.get("addtime").toString()),im.get("frontimg").toString());
        	    			
    	    		}
    	    	}
    	    	if(fid.equals("2")){
    	    		if(cm.get("opposite").equals("2")){    	    		
    	    			Download.downloadimg(request, response,creditutil.timetofile(im.get("addtime").toString()),im.get("oppositeimg").toString()+".new.jpg");
    	    		}else{
    	    			Download.downloadimg(request, response,creditutil.timetofile(im.get("addtime").toString()),im.get("oppositeimg").toString());
        	    			
    	    		}
    	    	}
    	    	if(fid.equals("3")){
    	    		if(cm.get("apply").equals("2")){    	    		
    	    			Download.downloadimg(request, response,creditutil.timetofile(im.get("addtime").toString()),im.get("applyimg").toString()+".new.jpg");
    	    		}else{
    	    			Download.downloadimg(request, response,creditutil.timetofile(im.get("addtime").toString()),im.get("applyimg").toString());
        	    			
    	    		}
    	    	}
    	    	if(fid.equals("4")){
    	    		if(cm.get("authorize").equals("2")){    	    		
    	    			Download.downloadimg(request, response,creditutil.timetofile(im.get("addtime").toString()),im.get("authorizeimg").toString()+".new.jpg");
    	    		}else{
    	    			Download.downloadimg(request, response,creditutil.timetofile(im.get("addtime").toString()),im.get("authorizeimg").toString());
        	    			
    	    		}
    	    	}
    	    	if(fid.equals("5")){
    	    		if(cm.get("hz").equals("2")){    	    		
    	    			Download.downloadimg(request, response,creditutil.timetofile(im.get("addtime").toString()),im.get("hzimg").toString()+".new.jpg");
    	    		}else{
    	    			Download.downloadimg(request, response,creditutil.timetofile(im.get("addtime").toString()),im.get("hzimg").toString());
        	    			
    	    		}
    	    	}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    
    }
}
