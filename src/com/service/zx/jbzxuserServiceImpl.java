package com.service.zx;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.zx.jbzxuserMapper;
import com.model.jbapi.jbzxuser;
@Service
public class jbzxuserServiceImpl implements jbzxuserService{
     
	@Resource
	private jbzxuserMapper jbzxusermapper;
	 
	@Override
	public void addjbzxuser(jbzxuser jbzxuser) {
		jbzxusermapper.addjbzxuser(jbzxuser);
		
	}

	@Override
	public jbzxuser findjbzxuser(String loginname) {
		
		return jbzxusermapper.findjbzxuser(loginname);
	}

	
}
