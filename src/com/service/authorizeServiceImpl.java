package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.authorizeMapper;
import com.model.authorize;

@Service
//@Transactional
public class authorizeServiceImpl extends BaseMySqlService implements authorizeService{
	 @Resource
	 private authorizeMapper  ahm;

	@Override
	public List<authorize> fauthorize(int aid) {		
		return ahm.fauthorize(aid);
	}

	@Override
	public void upaid(authorize authorize) {
		
		ahm.upaid(authorize);
		
	}
	 
}
