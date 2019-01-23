package com.service.cars;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.cars.bx1Mapper;
import com.model.cars.bx1;

@Service
public class bx1ServiceImpl implements bx1Service {

	@Resource
	private bx1Mapper bx1Mapper;

	@Override
	public void addbx1(bx1 bx1) {
		bx1Mapper.addbx1(bx1);
	}

}
