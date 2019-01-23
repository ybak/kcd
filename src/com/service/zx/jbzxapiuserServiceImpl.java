package com.service.zx;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.zx.jbzxapiuserMapper;
import com.model.jbapi.jbzxapiuser;
@Service
public class jbzxapiuserServiceImpl implements jbzxapiuserService{
   
	@Resource
	private jbzxapiuserMapper jbzxapiusermapper;
	
	
	@Override
	public void addapiuser(jbzxapiuser jbzxapiuser) {
		jbzxapiusermapper.addapiuser(jbzxapiuser);
		
	}


	@Override
	public jbzxapiuser findapiuserbyappkey(String appkey) {
		
		return jbzxapiusermapper.findapiuserbyappkey(appkey);
	}


	@Override
	public void upmoney(jbzxapiuser jbzxapiuser) {
		jbzxapiusermapper.upmoney(jbzxapiuser);
		
	}


	@Override
	public jbzxapiuser findapiuserbyid(int id) {
		
		return jbzxapiusermapper.findapiuserbyid(id);
	}


	@Override
	public List<jbzxapiuser> apiuserlist() {
		
		return jbzxapiusermapper.apiuserlist();
	}


	@Override
	public void upjbzxapiuser(jbzxapiuser jbzxapiuser) {
		jbzxapiusermapper.upjbzxapiuser(jbzxapiuser);
	}

}
