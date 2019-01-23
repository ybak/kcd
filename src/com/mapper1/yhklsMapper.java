package com.mapper1;

import java.util.List;

import com.model1.yhkls;

public interface yhklsMapper {

	//根据客户姓名查询订单信息
	public List<yhkls> findyhklsbyc_name(String c_name);
	
	//查询所有数据
	public List<yhkls> findyhkls();
}
