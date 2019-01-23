package com.service.icbc;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.bclient_check;

public interface bclient_checkService {
	 //
	 void addbclient_check(bclient_check bc);
	 //
	 bclient_check  findassess_msg(int status,int assessid);

}
