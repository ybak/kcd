package com.mapper.newAdd;
import java.util.ArrayList;

import com.model.newAdd.AssessBclientCheck;

public interface AssessBclientCheckMapper {
	//添加留言
	public int addAssessBclientCheck(AssessBclientCheck assessBclientCheck);
	//查询全部数据
	public ArrayList selectAllAssessBclientCheck(int assessid);
}
