package com.mapper1.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.carseries;

public interface seriesMapper {
    //
	public List<carseries> findseries();
	//
	public carseries findseriesbyid(@Param("id")int id);
}
