package com.service.icbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.icbc.icbc_zxMapper;
import com.model.icbc.icbc_zx;

@Service
public class icbc_zxServiceImpl implements icbc_zxService{

    @Resource
    private icbc_zxMapper icbc_zxMapper;
  
	@Override
	public void addicbc_zx(icbc_zx iz) {		
		icbc_zxMapper.addicbc_zx(iz);
	}

	@Override
	public icbc_zx findicbc_zx(String gems_code) {		
		return icbc_zxMapper.findicbc_zx(gems_code);
	}

	@Override
	public void upicbc_zxorder(icbc_zx iz) {
		icbc_zxMapper.upicbc_zxorder(iz);		
	}

	@Override
	public List<icbc_zx> findicbc(int bc_status) {
		
		return icbc_zxMapper.findicbc(bc_status);
	}



}
