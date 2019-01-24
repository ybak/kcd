package com.mapper1.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface assess_gemsMapper {

	List<Map<String,Object>> getgemslist(@Param("time1")String time1,
			@Param("time2")String time2,
			@Param("keyword")String keyword,
			@Param("gems_fs_id")int gems_fs_id
			);
	List<Map<String,Object>>  getgemslist1();
	
	
	Map<String,Object> getgemsmap(@Param("id")int id);
	
	void upgems_zx(Map<String,Object> map);
	
	List<Map<String,Object>> getgemsmapbyfsid(@Param("id")int id);
	
	Map<String,Object> getgemsmapbyicbc_id(@Param("icbc_id")int icbc_id);
}
