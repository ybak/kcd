package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.userMapper;
import com.model.user;

@Service
//@Transactional
public class userServiceImpl extends BaseMySqlService implements userService{
   
	@Resource
    private	 userMapper usermapper;

	@Override
	public void adduser(user user) {
		usermapper.adduser(user);
		
	}

	
	@Override
	public Map finduser(String username, String password) {
	  
		   return usermapper.finduser(username, password);
	 
	
	 
	 
	}


	@Override
	public Map finduser1(String username) {
		return usermapper.finduser1(username);
	}

	
	@Override
	public List<user> userfind() {
		//System.out.println("sssssssssss");

		return usermapper.userfind();
	}


	@Override
	public Map finduserbyid(int uid) {
		
		return usermapper.finduserbyid(uid);
	}
	
}
