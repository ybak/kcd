package com.service.icbc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.icbc.icbc_cardkMapper;
import com.model.icbc.icbc_cardk;
@Service
public class icbc_cardkServiceImpl implements icbc_cardkService{
   
	 @Resource
	 private icbc_cardkMapper icbc_cardkMapper;
	
	@Override
	public icbc_cardk findicbc_cardk(int icbc_id) {
		
		return icbc_cardkMapper.findicbc_cardk(icbc_id);
	}

	@Override
	public void addicbc_cardk(icbc_cardk icbc_cardk) {
		icbc_cardkMapper.addicbc_cardk(icbc_cardk);
		
	}

	@Override
	public void upicbc_cardk(icbc_cardk icbc_cardk) {
		icbc_cardkMapper.upicbc_cardk(icbc_cardk);
		
	}

}
