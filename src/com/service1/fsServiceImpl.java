package com.service1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.fsMapper;
import com.model1.fs;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)  
public class fsServiceImpl implements fsService{
  
	
	@Autowired
	 private fsMapper fsmapper;
	@Override
	public List<fs> ffs() {
		
		return fsmapper.ffs();
	}
	@Override
	public List<fs> findfsbyckey(String appkey) {
		
		return fsmapper.findfsbyckey(appkey);
	}
	@Override
	public List<fs> findbypy() {
		
		return fsmapper.findbypy();
	}
	@Override
	public fs findfsbyid(int id) {
		
		return fsmapper.findfsbyid(id);
	}

}
