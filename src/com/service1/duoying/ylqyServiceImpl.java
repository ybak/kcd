package com.service1.duoying;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mapper1.ylqyMapper;
import com.model1.ylqy;


@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class ylqyServiceImpl implements ylqyService{

	@Resource
	private ylqyMapper ylqyMapper;
	
	

	@Override
	public List<ylqy> findylqybyname(String ACCOUNT_NAME) {
		
		return ylqyMapper.findylqybyname(ACCOUNT_NAME);
	}

	@Override
	public List<ylqy> finfylqy() {
		
		return ylqyMapper.findylqy();
	}

	@Override
	public ylqy ylqymap(String ACCOUNT_NAME) {
		
		return ylqyMapper.ylqymap(ACCOUNT_NAME);
	}

}
