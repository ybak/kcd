package com.mapper1.icbc1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.city.citys;

public interface citysMapper {

	citys findcitys(@Param("id")int id);
	
	
	List<citys> findcitysbystate_id(@Param("state_id")int state_id);

	List<citys> findallcitys();
}
