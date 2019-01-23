package com.service1.zjf;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.zjf.fshistoryMapper;
import com.model1.zjf.fshistory;

@Service
@Transactional(value = "kcway2") 
public class fshistoryServiceImpl implements fshistoryService{

	@Resource
	private fshistoryMapper fshistorymapper;
	
	@Override
	public fshistory fshistorybyfid(int fid) {
		
		return fshistorymapper.fshistorybyfid(fid);
	}

	@Override
	public void addfshistory(fshistory fshistory) {
		fshistorymapper.addfshistory(fshistory);
		
	}

}
