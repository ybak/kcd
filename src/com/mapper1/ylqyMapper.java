package com.mapper1;

import java.util.List;
import com.model1.ylqy;

public interface ylqyMapper {

	//根据数据编号查询数据
	public List<ylqy> findylqybyname(String ACCOUNT_NAME);

	//查询所有数据
	public List<ylqy> findylqy();
	
	//查询一条数据
	public ylqy ylqymap(String ACCOUNT_NAME);
	
	//根据身份证号查询数据
	public ylqy findylqybycardid(String cardid);
}
