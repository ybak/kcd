package com.service.icbc;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.assess_cars;

public interface assess_carsService {
	//ĞÂÔö
    public void addassess_cars(assess_cars acars );
    //
    public void upcodebyid(assess_cars acars);
    //
    public assess_cars findcarsbycode(String code);
    //
    public assess_cars findcarsbyorder(int orderid);
}
