package com.mapper1.car;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.assess_cars;
import com.model.icbc.bclient_check;

public interface icbc_cars_resultMapper {

	List<bclient_check> findicbc_cars(@Param("assessid")int assessid);
	 //
	 void addbclient_check(bclient_check bc);
	 //
	 bclient_check  findassess_msg(@Param("status")int status,@Param("assessid")int assessid);

	 bclient_check lastfindicbc_cars(@Param("assessid")int assessid);
	 
}
