package com.service1.duoying;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.bankMapper;
import com.model1.bank;


@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)  
public class bankServiceImpl implements bankService{

	@Resource
	private bankMapper bankMapper;
	
	

	@Override
	public List<bank> findbankbycode(String code) {
		// TODO Auto-generated method stub
		return bankMapper.findbankbycode(code);
	}

	@Override
	public List<bank> findbank() {
		// TODO Auto-generated method stub
		return bankMapper.findbank();
	}

	@Override
	public bank bankmap(String code) {
		
		return bankMapper.bankmap(code);
	}

	@Override
	public bank bankmap1(int id) {
		
		return bankMapper.bankmap1(id);
	}

}
