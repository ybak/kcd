package com.service1.duoying;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.yldsMapper;
import com.model1.ylds;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class yldsServiceImpl implements yldsService{

	@Resource
	private yldsMapper yldsMapper;
	
	

	@Override
	public List<ylds> findyldsbyid(String ACCOUNT_NO) {
		// TODO Auto-generated method stub
		return yldsMapper.findyldsbyid(ACCOUNT_NO);
	}

	@Override
	public List<ylds> findylds() {
		// TODO Auto-generated method stub
		return yldsMapper.findylds();
	}

}
