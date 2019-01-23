package com.mapper1;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.gems;

public interface gemsMapper {
	public Map selectname(int id);
	
	
	gems find_api(@Param("appkey")String appkey);

}
