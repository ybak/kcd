package com.service1;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.adminMapper;
import com.model1.admin;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class adminServiceImpl implements adminService{

	 @Autowired
	 private adminMapper adminmapper;
	
	@Override
	public Map adminlogin(String username, String userpass) {
		// TODO Auto-generated method stub
		return adminmapper.adminlogin(username, userpass);
	}

	@Override
	public admin adminbyid(int id) {
		
		return adminmapper.adminbyid(id);
	}

	@Override
	public admin adminbygems_id(int gems_id) {
		
		return adminmapper.adminbygems_id(gems_id);
	}

	
	
}
