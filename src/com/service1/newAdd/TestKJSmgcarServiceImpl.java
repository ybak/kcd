package com.service1.newAdd;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.newAdd.TestKJSmgcarMapper;
import com.mapper1.newAdd.TestKJSmgcertMapper;
import com.model1.mgcar;
import com.model1.mgcert;
import com.model1.ylds;
import com.model1.ylqy;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class TestKJSmgcarServiceImpl implements TestKJSmgcarService{
	@Resource
	private TestKJSmgcarMapper testKJSmgcarMapper;

	//查询所有押车
	@Override
	public ArrayList TestKJSselectAll(int status, int page, int size) {
		return testKJSmgcarMapper.TestKJSselectAll(status, page, size);
	}

	@Override
	public int TestKJSselectAllCounts() {
		return testKJSmgcarMapper.TestKJSselectAllCounts();
	}
	
	@Override
	public ylqy TestKJSselectModelOne(String c_cardid) {
		return testKJSmgcarMapper.TestKJSselectModelOne(c_cardid);
	}

	@Override
	public List<ylds> TestKJSselectModelTwo(int mgcertId) {
		return testKJSmgcarMapper.TestKJSselectModelTwo(mgcertId);
	}

	@Override
	public List<ylqy> TestKJSselectModelTwoByMomeny(int id) {
		return testKJSmgcarMapper.TestKJSselectModelTwoByMomeny(id);
	}

	@Override
	public mgcar TestKJSselectCaoZuo(int amid) {
		return testKJSmgcarMapper.TestKJSselectCaoZuo(amid);
	}

	
	
}
