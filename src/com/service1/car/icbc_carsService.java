package com.service1.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.assess_cars;

public interface icbc_carsService {
	//É¾³ý
	void del_icbc_cars(int id);
	//
	assess_cars findicbc_cars(int icbc_id);
	//
	assess_cars findicbc_cars1(int icbc_id);
	//
	assess_cars findicbc_cars2(int icbc_id);
	//
	void upicbc_cars(assess_cars assess_cars);
	//
	List<assess_cars> allfindicbc_cars();
	//
	assess_cars findlastid();
	//
	void addassess_cars(assess_cars assess_cars);
	//
	void upcodebyid(assess_cars assess_cars);
	//
	assess_cars findcarsbyid(int id);
	//
	assess_cars carsshbyid(int id);
	//
	List<assess_cars> kjs_pg(int bc_status);
	//
	//
	int kjs_pg_count();
}
