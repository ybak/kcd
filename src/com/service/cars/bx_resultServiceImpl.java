package com.service.cars;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.cars.bx_resultMapper;
import com.model.cars.bx_result;
@Service
public class bx_resultServiceImpl implements bx_resultService{

	@Resource
	private bx_resultMapper bx_resultMapper;
	
	@Override
	public void addbx_result(bx_result bx_result) {
		bx_resultMapper.addbx_result(bx_result);		
	}

}
