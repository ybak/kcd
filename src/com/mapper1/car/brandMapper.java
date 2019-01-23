package com.mapper1.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.carbrand;

public interface brandMapper {
    //
	public List<carbrand> findbrand();
	//
	public carbrand findbrandbyid(@Param("id")int id);
    //
	public carbrand findbrandbyname(@Param("name")String name);
}
