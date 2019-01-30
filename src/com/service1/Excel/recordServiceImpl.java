package com.service1.Excel;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.Excel.recordMapper;
import com.model1.icbc.erp.PageData;
import com.util.Excel.RecordUtil;


@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class recordServiceImpl implements recordService{

	@Autowired
	private recordMapper recordMapper;

	@Override
	public List<PageData> selectRecord(String param, PageData pd) {
		// TODO Auto-generated method stub
		return recordMapper.selectRecord(param, pd);
	}






}
