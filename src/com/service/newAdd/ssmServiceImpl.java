package com.service.newAdd;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.newAdd.ssmMapper;
import com.model.newAdd.ssm;
@Service
public class ssmServiceImpl implements ssmService{
	@Resource
	private  ssmMapper ssmMapper;
	
	@Override
	public void addSSM(ssm ssm) {
		ssmMapper.addSSM(ssm);
	}
	
}
