package com.service1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.ManagementCenter.kj_icbc_resultMapper;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class kj_icbc_resultServiceImpl implements kj_icbc_resultService{
	@Resource
	private kj_icbc_resultMapper kj_icbc_resultmapper;
	// 查询抵押完成天数情况，对0-15天，15-30天，30-45天，45-60天，60天以上的进行分组查询
	@Override
	public List<HashMap> SelectResult() {	
		return kj_icbc_resultmapper.selectresult();
	}
}
