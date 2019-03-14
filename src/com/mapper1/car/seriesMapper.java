package com.mapper1.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.carseries;

public interface seriesMapper {
	// 查询全部
	public List<carseries> findseries();

	// 根据id查询
	public carseries findseriesbyid(@Param("id") int id);

	// 查询全部
	public List<carseries> findseries_v2();

	// 根据id查询
	public carseries findseriesbyid_v2(@Param("id") int id);
}
