package com.service1.Repayment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.Repayment.OverdueMapper1;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class OverdueServiceImpl implements OverdueService{

	@Autowired
	private OverdueMapper1 overdueMapper1;
	
	@Override
	public List<PageData> selectoverdue(String param, PageData pd) {
		// TODO Auto-generated method stub
		return overdueMapper1.selectoverdue(param, pd);
	}
	
	
}
