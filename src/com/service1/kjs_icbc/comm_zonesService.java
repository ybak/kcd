package com.service1.kjs_icbc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.city.comm_zones;

public interface comm_zonesService {
	
	comm_zones findcomm_zones(@Param("id")int id);
	
	List<comm_zones>  findallcomm_zones();
	
	List<comm_zones>  findcomm_zonesbyid(@Param("shengid")int shengid,@Param("cityid")int cityid );
}
