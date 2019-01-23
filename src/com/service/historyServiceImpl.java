package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.historyMapper;
import com.model.history;
@Service
//@Transactional
public class historyServiceImpl extends BaseMySqlService implements  historyService{

	   @Resource
	    private historyMapper htm;
	
	@Override
	public void hsava(history ht) {
		// TODO Auto-generated method stub
		htm.hsava(ht);
	}

	@Override
	public Map findhistory(String uid) {
		// TODO Auto-generated method stub
		return htm.findhistory(uid);
	}

	@Override
	public List<history> hlist(String uid) {
		
		return htm.hlist(uid);
	}

	
	
	
}
