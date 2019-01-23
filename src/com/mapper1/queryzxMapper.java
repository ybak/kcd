package com.mapper1;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.queryzx;

public interface queryzxMapper {

	public Map findqueryzx(@Param("c_name")String c_name,@Param("c_card_no")String c_card_no);
	
	
	public List<queryzx> findqueryzxlist(List<?> querylist);
	
	public List<queryzx> querybydate(Map<String, String> mdate);
	
	

}
