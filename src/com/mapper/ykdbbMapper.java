package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.ykdbb;

public interface ykdbbMapper {

	
	//根据时间区间查询
	public List<ykdbb> findbydate(Map<String, String> mdate);
}
