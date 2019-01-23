package com.service1.jsy;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.ylqyMapper;
import com.model1.ylqy;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class jsyylqyServiceImpl implements jsyylqyService{

	@Resource
	private ylqyMapper ylqymapper;
	
	@Override
	public ylqy findylqybycardid(String cardid) {
		
		return ylqymapper.findylqybycardid(cardid);
	}

}
