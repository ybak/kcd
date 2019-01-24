package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.financeMapper;
import com.model.finance;

@Service
//@Transactional
public class financeServiceImpl extends BaseMySqlService implements financeService{

	@Resource
    private financeMapper fnm;

	@Override
	public void savefinance(finance fn) {
		fnm.savefinance(fn);
		
	}

	@Override
	public List<finance> findfinance() {
		
		return fnm.findfinance();
	}

	@Override
	public List<finance> findfinancelimit(int st, int ps) {
		
		return fnm.findfinancelimit(st, ps);
	}

	@Override
	public int findfinancecount() {
		
		return fnm.findfinancecount();
	}
	
}
