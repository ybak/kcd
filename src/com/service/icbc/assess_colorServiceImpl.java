package com.service.icbc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.icbc.assess_colorMapper;
import com.model.icbc.assess_color;
@Service
public class assess_colorServiceImpl implements assess_colorService{
    @Resource
    private assess_colorMapper assess_colorMapper;
	
	@Override
	public void addcarscolor(assess_color ac) {
		assess_colorMapper.addcarscolor(ac);
		
	}

}
