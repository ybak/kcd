package com.mapper1;

import java.util.List;

import com.model1.ylds;

public interface yldsMapper {

	//跟据数据编号查询数据
	public List<ylds> findyldsbyid(String ACCOUNT_NO);
	
	//查询所有数据
	public List<ylds> findylds();
}
