package com.service.icbc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.icbc.bclient_checkMapper;
import com.model.icbc.bclient_check;
@Service
public class bclient_checkServiceImpl implements bclient_checkService{

	@Resource
	private bclient_checkMapper bclient_checkMapper;
	 
	@Override
	public void addbclient_check(bclient_check bc) {
		bclient_checkMapper.addbclient_check(bc);
		
	}

	@Override
	public bclient_check findassess_msg(int status, int assessid) {
		
		return bclient_checkMapper.findassess_msg(status, assessid);
	}

}
