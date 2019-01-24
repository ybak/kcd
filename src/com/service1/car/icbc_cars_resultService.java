package com.service1.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.assess_cars;
import com.model.icbc.bclient_check;

public interface icbc_cars_resultService {

	List<bclient_check> findicbc_cars(int assessid);
	 //
	 void addbclient_check(bclient_check bc);
	 //
	 bclient_check  findassess_msg(int status,int assessid);

	 bclient_check lastfindicbc_cars(int assessid);
}
