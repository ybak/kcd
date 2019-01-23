package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.grywlsMapper;
import com.model.grywls;

 @Service
// @Transactional
 public class grywlsServiceImpl extends BaseMySqlService implements grywlsService{
   
	  @Resource
	  private grywlsMapper grywlsmapper;

	@Override
	public void addgrywls(grywls grywls) {
		grywlsmapper.addgrywls(grywls);
		
	}
	  
	  
	
}
