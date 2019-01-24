package com.mapper1.icbc1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.city.states;

public interface statesMapper {

	states findstates(@Param("id")int id);
	
	List<states>  allfindstates();
	
}
