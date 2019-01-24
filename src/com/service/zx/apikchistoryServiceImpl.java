package com.service.zx;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.zx.apikchistoryMapper;
import com.model.jbapi.apikchistory;

@Service
public class apikchistoryServiceImpl implements apikchistoryService{

	@Resource
	private apikchistoryMapper apikchistoryMapper;
	 
	@Override
	public void addapikchistory(apikchistory apikchistory) {
		apikchistoryMapper.addapikchistory(apikchistory);
		
	}

	@Override
	public List<apikchistory> findapikchistory(int jauid) {
		
		return apikchistoryMapper.findapikchistory(jauid);
	}

}
