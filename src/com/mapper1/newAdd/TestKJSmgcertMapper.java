package com.mapper1.newAdd;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.newAdd.ssm;
import com.model1.mgcert;
import com.model1.mgcert_result;
import com.model1.ylds;
import com.model1.ylqy;
public interface TestKJSmgcertMapper {
	//查询操作
	public mgcert TestKJSselectCaoZuo(int amid);
	//查询 modelTwo
	public List<ylds> TestKJSselectModelTwo(int mgcertId);
	public List<ylqy> TestKJSselectModelTwoByMomeny(int id);
	//查询 modelOne
	public ylqy TestKJSselectModelOne(String c_cardid);
	//查询所有押证
	public ArrayList TestKJSselectAll(@Param("status") int status,@Param("page") int page,@Param("size") int size);
	//查询总数
	public int TestKJSselectAllCounts();
}
