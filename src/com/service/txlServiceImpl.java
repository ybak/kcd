package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.txlMapper;
import com.model.txl;

@Service
public class txlServiceImpl implements txlService{
   
	 @Resource
	 private txlMapper tm;

	@Override
	public void addtxl(txl txl) {
		tm.addtxl(txl);
		
	}

	@Override
	public void uptime(txl txl) {
		tm.uptime(txl);
		
	}

	@Override
	public List<txl> txlcx() {
		
		return tm.txlcx();
	}

	@Override
	public int txlnum() {
		
		return tm.txlnum();
	}
}
