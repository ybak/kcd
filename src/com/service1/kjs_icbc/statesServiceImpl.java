package com.service1.kjs_icbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.icbc1.statesMapper;
import com.model1.city.states;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class statesServiceImpl implements statesService{

	@Resource
	private statesMapper statesMapper;
	
	@Override
	public states findstates(int id) {
		
		return statesMapper.findstates(id);
	}

	@Override
	public List<states> allfindstates() {		
		return statesMapper.allfindstates();
	}

}
