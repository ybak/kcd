package com.service1.car;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.car.seriesMapper;
import com.model1.carseries;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class seriesServiceImpl implements seriesService{
    @Resource
    private seriesMapper seriesMapper;
	
	@Override
	public List<carseries> findseries() {
		
		return seriesMapper.findseries();
	}

	@Override
	public carseries findseriesbyid(int id) {
		
		return seriesMapper.findseriesbyid(id);
	}

}
