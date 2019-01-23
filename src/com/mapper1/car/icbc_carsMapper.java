package com.mapper1.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.assess_cars;

public interface icbc_carsMapper {

	//É¾³ý
	void del_icbc_cars(@Param("id")int id);
	//
	assess_cars findicbc_cars(@Param("icbc_id")int icbc_id);
	//
	assess_cars findicbc_cars1(@Param("icbc_id")int icbc_id);
	//
	assess_cars findicbc_cars2(@Param("icbc_id")int icbc_id);
	//
	List<assess_cars> allfindicbc_cars();
	//
	void upicbc_cars(assess_cars assess_cars);
	//
	assess_cars findlastid();
	//
	void addassess_cars(assess_cars assess_cars);
	//
	void upcodebyid(assess_cars assess_cars);
	//
	assess_cars findcarsbyid(@Param("id")int id);
	//
	assess_cars carsshbyid(@Param("id")int id);
	//
	List<assess_cars> kjs_pg(@Param("bc_status")int bc_status);
	//
	int kjs_pg_count();
	
}
