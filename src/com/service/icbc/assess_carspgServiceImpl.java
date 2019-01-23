package com.service.icbc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.icbc.assess_carspgMapper;
import com.model.icbc.assess_carspg;
@Service
public class assess_carspgServiceImpl implements assess_carspgService{
     @Resource
     private assess_carspgMapper assess_carspgMapper; 
	
	@Override
	public void addcarspg(assess_carspg acs) {
		assess_carspgMapper.addcarspg(acs);
		
	}

}
