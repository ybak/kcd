package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.dsjMapper;
import com.model.dsj;


@Service
public class dsjServiceImpl implements dsjService{
	
	@Resource
    private dsjMapper dm;

	@Override
	public void adddsj(dsj dsj) {
		dm.adddsj(dsj);
		
	}

	@Override
	public void editdsj(dsj dsj) {
		dm.editdsj(dsj);
		
	}

	@Override
	public List<dsj> finddsj(int startPos, int pageSize) {
		
		return dm.finddsj(startPos,pageSize);
	}

	@Override
	public int finddsjcount() {
		
		return dm.finddsjcount();
	}
	
	
	
}
