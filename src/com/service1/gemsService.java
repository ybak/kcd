package com.service1;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.gems;

public interface gemsService {

	public Map selectname(int id);
	
	gems find_api(String appkey);
}
