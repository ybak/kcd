package com.service1.kjs_icbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.icbc1.citysMapper;
import com.model1.city.citys;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class citysServiceImpl implements citysService{
   
	 @Resource	 
	 private citysMapper citysMapper;
	
	@Override
	public citys findcitys(int id) {
		
		return citysMapper.findcitys(id);
	}

	@Override
	public List<citys> findcitysbystate_id(int state_id) {
		
		return citysMapper.findcitysbystate_id(state_id);
	}

	@Override
	public List<citys> findallcitys() {
		
		return citysMapper.findallcitys();
	}

}
