package com.service.icbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.icbc.icbcMapper;
import com.model.icbc.icbc;

@Service
public class icbcServiceImpl implements icbcService{

	 @Resource
	 private icbcMapper icbcmapper;
	
	@Override
	public void addicbc(icbc icbc) {
		icbcmapper.addicbc(icbc);
		
	}

	@Override
	public void upicbc(icbc icbc) {
		icbcmapper.upicbc(icbc);
		
	}

	@Override
	public icbc findicbcbyorderid(String orderid) {		
		return icbcmapper.findicbcbyorderid(orderid);
	}

	@Override
	public List<icbc> findicbc(int querytype,int bc_status) {	
		
		return icbcmapper.findicbc(querytype,bc_status);			
	}

	@Override
	public icbc findicbcbyid(int id) {
		
		return icbcmapper.findicbcbyid(id);
	}

}
