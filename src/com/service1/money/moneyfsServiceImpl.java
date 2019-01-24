package com.service1.money;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.money.moneyfsMapper;
import com.model1.money.moneyfs;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class moneyfsServiceImpl implements moneyfsService{
 
	@Autowired
	private moneyfsMapper moneyfsMapper;
	
	@Override
	public void addmoneyfs(moneyfs moneyfs) {
		moneyfsMapper.addmoneyfs(moneyfs);		
	}

	@Override
	public moneyfs findmoneyfslastid() {
		
		return moneyfsMapper.findmoneyfslastid();
	}

	@Override
	public moneyfs findmoneyfsbyorderid(int orderid) {
		
		return moneyfsMapper.findmoneyfsbyorderid(orderid);
	}

}
