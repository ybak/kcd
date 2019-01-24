package com.service1.kjs_icbc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.city.citys;

public interface citysService {
	citys findcitys(int id);
	
	List<citys> findcitysbystate_id(int state_id);
	
	List<citys> findallcitys();
}
