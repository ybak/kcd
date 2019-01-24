package com.service1.car;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.car.brandMapper;
import com.model1.carbrand;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class brandServiceImpl implements brandService{
  
	 @Resource
	 private brandMapper brandMapper;
	@Override
	public List<carbrand> findbrand() {
		
		return brandMapper.findbrand();
	}
	@Override
	public carbrand findbrandbyid(int id) {
		
		return brandMapper.findbrandbyid(id);
	}
	@Override
	public carbrand findbrandbyname(String name) {
		
		return brandMapper.findbrandbyname(name);
	}

}
