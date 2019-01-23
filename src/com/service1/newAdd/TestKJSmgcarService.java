package com.service1.newAdd;

import java.util.ArrayList;
import java.util.List;

import com.model1.mgcar;
import com.model1.mgcert;
import com.model1.ylds;
import com.model1.ylqy;

public interface TestKJSmgcarService {
	//查询操作
	public mgcar TestKJSselectCaoZuo(int amid);
	//查询 modelTwo
	public List<ylds> TestKJSselectModelTwo(int mgcertId);
	public List<ylqy> TestKJSselectModelTwoByMomeny(int id);
	//查询 modelOne
	public ylqy TestKJSselectModelOne(String c_cardid);
	//查询所有押证信息
	public ArrayList TestKJSselectAll(int status,int page,int size);
	//查询总数
	public int TestKJSselectAllCounts();
}
