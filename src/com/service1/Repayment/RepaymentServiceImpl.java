package com.service1.Repayment;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mapper1.Repayment.RepaymentMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class RepaymentServiceImpl implements RepaymentService{

	@Autowired
	private RepaymentMapper repaymentMapper;

	@Override
	public List<PageData> selectRepayment(String param,PageData pd) {
		// TODO Auto-generated method stub
		return repaymentMapper.selectRepayment(param,pd);
	}

	@Override
	public Map<String, Object> selectBorrow(Integer id) {

		return repaymentMapper.selectBorrow(id);
	}

	@Override
	public Map<String, Object> selectschedule(String id_card) {
		// TODO Auto-generated method stub
		return repaymentMapper.selectschedule(id_card);
	}

	@Override
	public List<Map> selectafter(Integer c_cardno) {
		// TODO Auto-generated method stub
		return repaymentMapper.selectafter(c_cardno);
	}

	@Override
	public Map<String, Object> selectzdr(Integer c_cardno) {
		// TODO Auto-generated method stub
		return repaymentMapper.selectzdr(c_cardno);
	}

	
	
	
}
