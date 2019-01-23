package com.mapper1.newAdd;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.newAdd.ssm;
import com.model1.mgcert;
import com.model1.mgcert_result;
import com.model1.ylds;
import com.model1.ylqy;
public interface TestKJSmgCertResultMapper {
	//查询操作审批记录
	public List<mgcert_result> TestKJSselectCaoZuoResult(@Param("amid")int amid);
}
