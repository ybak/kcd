package com.service.icbc;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.mapper.icbc.icbc_kkMapper;
import com.model.icbc.icbc_kk;
@Service
public class icbc_kkServiceImpl implements icbc_kkService{

	 @Resource
	 private icbc_kkMapper icbc_kkMapper;
	
	@Override
	public void upicbc_kk(icbc_kk icbc_kk) {
		icbc_kkMapper.upicbc_kk(icbc_kk);
		
	}

	@Override
	public void addicbc_kk(icbc_kk icbc_kk) {
		icbc_kkMapper.addicbc_kk(icbc_kk);
		
	}

	@Override
	public icbc_kk findicbc_kkbyorder(int icbc_id) {
		
		return icbc_kkMapper.findicbc_kkbyorder(icbc_id);
	}


}
