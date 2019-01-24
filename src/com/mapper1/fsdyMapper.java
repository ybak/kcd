package com.mapper1;

import java.util.List;
import com.model1.fsdy;

public interface fsdyMapper {

	//根据编号查询信息
	public List<fsdy> findfsdybyid(int id);
	
	//查询全部数据
	public List<fsdy> findfsdy();
	
}
