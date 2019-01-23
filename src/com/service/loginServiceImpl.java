package com.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.companyMapper;
import com.mapper.customerMapper;

@Service
//@Transactional
public class loginServiceImpl extends BaseMySqlService implements loginService{

	
	@Resource
    private companyMapper cpm;
	
	@Resource
    private customerMapper ctm;
	
	
	
	@Override
	public Map login(String username, String password) {
		Map m=new HashMap();
		Map m1=new HashMap();
		Map m2=new HashMap();
         m1=cpm.login(username, password);
         m2=ctm.login(username, password);
        String login="";
        if(m1!=null){
			
        	m.putAll(m1);	
			
		}else if(m2!=null){
			m.putAll(m2);	
		}
        System.out.println(m.size()+"mmmmmmmmmmmmmm");
		return m;
       
		
	}

	
	
	
}
