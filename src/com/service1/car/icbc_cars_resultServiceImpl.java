package com.service1.car;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.car.icbc_carsMapper;
import com.mapper1.car.icbc_cars_resultMapper;
import com.model.icbc.assess_cars;
import com.model.icbc.bclient_check;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class icbc_cars_resultServiceImpl implements icbc_cars_resultService{
   
	@Resource
	private icbc_cars_resultMapper icbc_cars_resultMapper;

	@Override
	public List<bclient_check> findicbc_cars(int assessid) {
		
		return icbc_cars_resultMapper.findicbc_cars(assessid);
	}

	@Override
	public void addbclient_check(bclient_check bc) {
		icbc_cars_resultMapper.addbclient_check(bc);
		
	}

	@Override
	public bclient_check findassess_msg(int status, int assessid) {
		
		return icbc_cars_resultMapper.findassess_msg(status, assessid);
	}

	@Override
	public bclient_check lastfindicbc_cars(int assessid) {
		
		return icbc_cars_resultMapper.lastfindicbc_cars(assessid);
	}
	
	

}
