package com.mapper1.newAdd;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.newAdd.ssm;
import com.model1.mgcar_result;
import com.model1.mgcert;
import com.model1.mgcert_result;
import com.model1.ylds;
import com.model1.ylqy;
public interface TestKJSmgCarResultMapper {
	//查询操作审批记录
	public List<mgcar_result> TestKJSselectCaoZuoResultCar(@Param("amid")int amid);
}
