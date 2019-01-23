package com.service1;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.gemsMapper;
import com.model1.gems;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class gemsServiceImpl implements gemsService{


	 @Autowired
	 private gemsMapper gemsmapper;
	
	
	@Override
	public Map selectname(int id) {
		
		return gemsmapper.selectname(id);
	}


	@Override
	public gems find_api(String appkey) {
		
		return gemsmapper.find_api(appkey);
	}

	
}
