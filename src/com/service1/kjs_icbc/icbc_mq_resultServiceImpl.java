package com.service1.kjs_icbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.icbc1.icbc_mq_resultMapper;
import com.model1.icbc.icbc_mq;
import com.model1.icbc.icbc_mq_result;

@Service
@Transactional(value = "kcway2",rollbackFor = Exception.class) 
public class icbc_mq_resultServiceImpl implements icbc_mq_resultService{

	 @Resource
	 private icbc_mq_resultMapper icbc_mq_resultMapper;

	@Override
	public List<icbc_mq_result> findicbc_mq_result(int qryid) {
		
		return icbc_mq_resultMapper.findicbc_mq_result(qryid);
	}

	@Override
	public void addmq_result(icbc_mq_result icbc_mq_result) {
		icbc_mq_resultMapper.addmq_result(icbc_mq_result);
		
	}

	@Override
	public icbc_mq_result lasticbc_mq_result(int qryid) {
		
		return icbc_mq_resultMapper.lasticbc_mq_result(qryid);
	}
	


}
