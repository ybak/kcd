package com.service.newAdd;
import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.newAdd.AssessBclientCheckMapper;
import com.mapper.newAdd.AssessCarsMapper;
import com.model.newAdd.AssessBclientCheck;
import com.model.newAdd.AssessCars;
@Service
public class AssessBclientCheckServiceImpl implements AssessBclientCheckService{
	@Resource
	private  AssessBclientCheckMapper assessBclientCheckMapper;

	@Override
	public int addAssessBclientCheck(AssessBclientCheck assessBclientCheck) {
		return assessBclientCheckMapper.addAssessBclientCheck(assessBclientCheck);
	}

	@Override
	public ArrayList selectAllAssessBclientCheck(int assessid) {
		return assessBclientCheckMapper.selectAllAssessBclientCheck(assessid);
	}
	
}
