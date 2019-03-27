package com.service1.loan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.Repayment.OverdueMapper1;
import com.mapper1.loan.LoanOverdueMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class LoanOverdueServiceImpl implements LoanOverdueService{

	@Autowired
	private LoanOverdueMapper loanOverdueMapper;

	@Override
	public List<PageData> selectOverdueList(PageData pd) {
		// TODO Auto-generated method stub
		return loanOverdueMapper.selectOverdueList(pd);
	}

	@Override
	public Integer updateOverdueStatus(PageData pd) {
		// TODO Auto-generated method stub
		return loanOverdueMapper.updateOverdueStatus(pd);
	}

	@Override
	public Integer addOperationResult(PageData pd) {
		// TODO Auto-generated method stub
		return loanOverdueMapper.addOperationResult(pd);
	}

	@Override
	public PageData selectOverdueOne(PageData pd) {
		// TODO Auto-generated method stub
		return loanOverdueMapper.selectOverdueOne(pd);
	}

	@Override
	public List<PageData> selectPhoneList(PageData pd) {
		// TODO Auto-generated method stub
		return loanOverdueMapper.selectPhoneList(pd);
	}

	@Override
	public PageData selectPhoneClientCarLoanInfo(PageData pd) {
		// TODO Auto-generated method stub
		return loanOverdueMapper.selectPhoneClientCarLoanInfo(pd);
	}

	@Override
	public List<PageData> selectResults(PageData pd) {
		// TODO Auto-generated method stub
		return loanOverdueMapper.selectResults(pd);
	}

	@Override
	public Integer updateOverdueDay() {
		// TODO Auto-generated method stub
		return loanOverdueMapper.updateOverdueDay();
	}
	
}
