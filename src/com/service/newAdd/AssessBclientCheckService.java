package com.service.newAdd;
import java.util.ArrayList;

import com.model.newAdd.AssessBclientCheck;
import com.model.newAdd.AssessCars;

public interface AssessBclientCheckService {
	//添加留言
	public int addAssessBclientCheck(AssessBclientCheck assessBclientCheck);
	//查询全部数据
	public ArrayList selectAllAssessBclientCheck(int assessid);
	
}
