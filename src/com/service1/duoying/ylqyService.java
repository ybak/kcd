package com.service1.duoying;

import java.util.List;
import com.model1.ylqy;

public interface ylqyService {

	//根据编号查询数据
	public List<ylqy> findylqybyname(String c_name);
	
	//查询所有数据
	public List<ylqy> finfylqy();
	
	//查询一条数据
    public ylqy ylqymap(String ACCOUNT_NAME);
}
