package com.service1.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.carseries;

public interface seriesService {
    //
	public List<carseries> findseries();
	//
	public carseries findseriesbyid(int id);

}
