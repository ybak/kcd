package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.hmdMapper;
import com.model.hmd;

@Service
public class hmdServiceImpl implements hmdService{

	@Resource
	private hmdMapper hm;

	@Override
	public void addhmd(hmd hmd) {
	hm.addhmd(hmd);
		
	}

	@Override
	public List<hmd> hmdlist() {
	
		return hm.hmdlist();
	}
}
