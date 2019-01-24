package com.service1.zjf;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.zjf.zjferrmsgMapper;
import com.model1.zjf.zjferrmsg;
@Service
@Transactional(value = "kcway2") 
public class zjferrmsgServiceImpl implements zjferrmsgService{

	@Resource
	private zjferrmsgMapper zjferrmsgmapper;
	
	@Override
	public void savezjferrmsg(zjferrmsg zmsg) {
		zjferrmsgmapper.savezjferrmsg(zmsg);		
	}

}
