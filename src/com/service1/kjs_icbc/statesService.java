package com.service1.kjs_icbc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.city.states;

public interface statesService {
	states findstates(int id);
	
	List<states>  allfindstates();
}
