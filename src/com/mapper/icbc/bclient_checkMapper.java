package com.mapper.icbc;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.bclient_check;

public interface bclient_checkMapper {

	 //
	 void addbclient_check(bclient_check bc);
	 //
	 bclient_check  findassess_msg(@Param("status")int status,@Param("assessid")int assessid);
}
