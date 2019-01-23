package com.service1.money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.money.moneyfs_1Mapper;
import com.model1.money.moneyfs_1;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class moneyfs_1ServiceImpl implements moneyfs_1Service{

	@Autowired
	private moneyfs_1Mapper moneyfs_1Mapper;
	
	@Override
	public void addmoneyfs_1(moneyfs_1 moneyfs_1) {
		moneyfs_1Mapper.addmoneyfs_1(moneyfs_1);
	}

	@Override
	public void addmoneyfs_2(moneyfs_1 moneyfs_1) {
		moneyfs_1Mapper.addmoneyfs_2(moneyfs_1);	
	}

}
