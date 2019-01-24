package com.service1.newAdd;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.newAdd.TestKJSmgCertResultMapper;
import com.mapper1.newAdd.TestKJSmgcertMapper;
import com.model1.mgcert;
import com.model1.mgcert_result;
import com.model1.ylds;
import com.model1.ylqy;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class TestKJSmgCertResultServiceImpl implements TestKJSmgCertResultService{
	@Resource
	private TestKJSmgCertResultMapper testKJSmgCertResultMapper;
	
	//查询操作审批记录
	public List<mgcert_result> TestKJSselectCaoZuoResult(int amid) {
		return testKJSmgCertResultMapper.TestKJSselectCaoZuoResult(amid);
	}
	

	
	
}
