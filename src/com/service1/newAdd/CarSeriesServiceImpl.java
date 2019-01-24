package com.service1.newAdd;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.newAdd.CarSeriesMapper;
import com.model1.newAdd.CarSeries;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class CarSeriesServiceImpl implements CarSeriesService{
	@Resource
	private CarSeriesMapper carSeriesMapper;

	@Override
	public ArrayList selectCarSeriesById(int id) {
		return carSeriesMapper.selectCarSeriesById(id);
	}

}
