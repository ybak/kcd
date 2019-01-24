package com.service.newAdd;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.newAdd.AssessCarsItemMapper;

@Service
public class AssessCarsItemServiceImpl implements AssessCarsItemService{
	@Resource
	private  AssessCarsItemMapper assessCarsItemMapper;

	@Override
	public ArrayList selectAllAssessCarsItem(int cars_id) {
		return assessCarsItemMapper.selectAllAssessCarsItem(cars_id);
	}

	
}
