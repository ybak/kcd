package com.mapper.icbc;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.assess_cars;

public interface assess_carsMapper {
	//ĞÂÔö
    public void addassess_cars(assess_cars acars );
    //
    public void upcodebyid(assess_cars acars);
    //
    public assess_cars findcarsbycode(@Param("code")String code);
    
    //
    public assess_cars findcarsbyorder(@Param("orderid")int orderid);
    
    
}
