package com.service1.send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.send.admin_msgMapper;
import com.model1.send.admin_msg;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class admin_msgServiceImpl implements admin_msgService{

	@Autowired
	private admin_msgMapper admin_msgMapper;
	
	@Transactional
	public void addadmin_msg(admin_msg admin_msg) {
		admin_msgMapper.addadmin_msg(admin_msg);
	}

}
