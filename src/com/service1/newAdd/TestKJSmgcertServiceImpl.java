package com.service1.newAdd;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.newAdd.TestKJSmgcertMapper;
import com.model1.mgcert;
import com.model1.mgcert_result;
import com.model1.ylds;
import com.model1.ylqy;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class TestKJSmgcertServiceImpl implements TestKJSmgcertService{
	@Resource
	private TestKJSmgcertMapper testKJSmgcertMapper;

	//查询所有押证
	@Override
	public ArrayList TestKJSselectAll(int status, int page, int size) {
		return testKJSmgcertMapper.TestKJSselectAll(status, page, size);
	}

	@Override
	public int TestKJSselectAllCounts() {
		return testKJSmgcertMapper.TestKJSselectAllCounts();
	}
	
	@Override
	public ylqy TestKJSselectModelOne(String c_cardid) {
		return testKJSmgcertMapper.TestKJSselectModelOne(c_cardid);
	} 

	@Override
	public List<ylds> TestKJSselectModelTwo(int mgcertId) {
		return testKJSmgcertMapper.TestKJSselectModelTwo(mgcertId);
	}

	@Override
	public List<ylqy> TestKJSselectModelTwoByMomeny(int id) {
		return testKJSmgcertMapper.TestKJSselectModelTwoByMomeny(id);
	}

	@Override
	public mgcert TestKJSselectCaoZuo(int amid) {
		return testKJSmgcertMapper.TestKJSselectCaoZuo(amid);
	}

	
}
