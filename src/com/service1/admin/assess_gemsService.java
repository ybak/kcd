package com.service1.admin;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface assess_gemsService {
	List<Map<String,Object>> getgemslist(String time1,
			String time2,
			String keyword,
			int gems_fs_id);
	List<Map<String,Object>>  getgemslist1();
	Map<String,Object> getgemsmap(int id);
	
	void upgems_zx(Map<String,Object> map);
	
	List<Map<String,Object>> getgemsmapbyfsid(int id);
	
	Map<String,Object> getgemsmapbyicbc_id(int icbc_id);
}
