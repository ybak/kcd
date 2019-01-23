package com.controller.kcdback;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.service.companyService;
import com.service.loginService;
import com.util.jsonutil;

@Controller
public class loginController {

	@Autowired
    private loginService loginservice;
	@Autowired
    private companyService companyservice;
	//json 工具类
    jsonutil ju=new jsonutil();
    
    private final Log logger = LogFactory.getLog(getClass());
	
	
	//登陆验证
    @RequestMapping(value="/login.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")

    public String login(HttpServletRequest request,String username,String password){
		Map  m=new HashMap();
		if(username!=null&&!username.equals("")&&password!=null&&!password.equals("")){								
    	m=loginservice.login(username, password);
    	System.out.println(jsonutil.toJSONString(m));
    	String company=(String) m.get("company");
    	if(m.size()>0){
    		
    		if(company!=null){
    			//将用户名放入session，以备后用    		
        		// request.getSession().setMaxInactiveInterval(3);单位是秒
                request.getSession().setAttribute("user",m);	        	    					
    		}else{
    		
    		    Map cmap=companyservice.findcompany(m.get("owencompany").toString());
    			m.putAll(cmap);
    			//将用户名放入session，以备后用    		
        		// request.getSession().setMaxInactiveInterval(3);单位是秒
                request.getSession().setAttribute("user",m);	
        	
    		}
    		
        }else{
        	
        	return "账户或密码错误！！！";
        	
        }   
//    	System.out.println(m.toString());
		}else{
			
			return "账户或密码为空！！！";
			
		}
    	return "loginxx";    	    	    	    	
    }
	
}
