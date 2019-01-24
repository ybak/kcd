package com.service1.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.carbrand;

public interface brandService {
    //
	public List<carbrand> findbrand();
	//
	public carbrand findbrandbyid(int id);
    //
	public carbrand findbrandbyname(String name);
}
