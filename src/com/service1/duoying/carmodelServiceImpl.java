package com.service1.duoying;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.mapper1.carmodelMapper;
import com.model1.carmodel;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)  
public class carmodelServiceImpl implements carmodelService{

	@Resource
	private carmodelMapper carmodelMapper;
	
	

	@Override
	public List<carmodel> findcarmodelbyid(int id) {
		
		return carmodelMapper.findcarmodelbyid(id);
	}

	@Override
	public List<carmodel> findcarmodel() {
		
		return carmodelMapper.findcarmodel();
	}

	@Override
	public carmodel modelmap(int id) {
		
		return carmodelMapper.modelmap(id);
	}

	@Override
	public carmodel findcarbyid(int id) {
		
		return carmodelMapper.findcarbyid(id);
	}

}
