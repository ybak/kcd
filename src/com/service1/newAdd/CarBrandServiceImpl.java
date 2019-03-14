package com.service1.newAdd;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.newAdd.CarBrandMapper;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class CarBrandServiceImpl implements CarBrandService {
	@Resource
	private CarBrandMapper carBrandMapper;

	@Override
	public ArrayList selectAllCarBrand() {
		return carBrandMapper.selectAllCarBrand();
	}

	@Override
	public ArrayList selectAllCarBrand_v2() {
		return carBrandMapper.selectAllCarBrand_v2();
	}
}
