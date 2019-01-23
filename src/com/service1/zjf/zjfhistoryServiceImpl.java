package com.service1.zjf;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.zjf.zjfhistoryMapper;
import com.model1.zjf.zjfhistory;

@Service
@Transactional(value = "kcway2",rollbackFor = Exception.class) 
public class zjfhistoryServiceImpl implements zjfhistoryService{

	@Resource
	private zjfhistoryMapper zhmapper;
	
	@Override
	public void addsynhistory(zjfhistory zh){
		zhmapper.addsynhistory(zh);		
	}

}
