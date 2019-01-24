package com.service1.kjs_icbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.icbc1.icbc_mqMapper;
import com.model1.icbc.icbc_mq;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class icbc_mqServiceImpl implements icbc_mqService{

	 @Resource
	 private icbc_mqMapper icbc_mqMapper;
	
	@Override
	public icbc_mq findmqbyicbc(int icbc_id) {
		
		return icbc_mqMapper.findmqbyicbc(icbc_id);
	}

	@Override
	public void upmq(icbc_mq icbc_mq) {
		icbc_mqMapper.upmq(icbc_mq);
		
	}

	@Override
	public List<icbc_mq> allfindmq() {
	
		return icbc_mqMapper.allfindmq();
	}

	@Override
	public icbc_mq findmqbyicbc2(int icbc_id) {
		
		return icbc_mqMapper.findmqbyicbc2(icbc_id);
	}

	@Override
	public void savemq(icbc_mq icbc_mq) {
		icbc_mqMapper.savemq(icbc_mq);
		
	}

	@Override
	public icbc_mq findlastid() {
		
		return icbc_mqMapper.findlastid();
	}

	@Override
	public icbc_mq findmqbyid(int id) {
		
		return icbc_mqMapper.findmqbyid(id);
	}

	@Override
	public icbc_mq mqshbyid(int id) {
		return icbc_mqMapper.mqshbyid(id);
	}

	@Transactional
	public void del_icbc_mq(int id) {
		icbc_mqMapper.del_icbc_mq(id);
		
	}

	@Override
	public List<icbc_mq> kjs_mq(int bc_status) {
		
		return icbc_mqMapper.kjs_mq(bc_status);
	}

	@Override
	public int kjs_mq_count() {
		
		return icbc_mqMapper.kjs_mq_count();
	}

}
