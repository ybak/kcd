package com.service.icbc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.icbc.assess_carsMapper;
import com.model.icbc.assess_cars;

@Service
public class assess_carsServiceImpl implements assess_carsService{
   
	 @Resource
	 private assess_carsMapper assess_carsMapper;
	
	@Override
	public void addassess_cars(assess_cars acars) {
		assess_carsMapper.addassess_cars(acars);
		
	}

	@Override
	public void upcodebyid(assess_cars acars) {
		assess_carsMapper.upcodebyid(acars);
		
	}

	@Override
	public assess_cars findcarsbycode(String code) {
		
		return assess_carsMapper.findcarsbycode(code);
	}

	@Override
	public assess_cars findcarsbyorder(int orderid) {
		
		return assess_carsMapper.findcarsbyorder(orderid);
	}
  
	
	
}
