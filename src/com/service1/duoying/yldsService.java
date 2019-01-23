package com.service1.duoying;

import java.util.List;


import com.model1.ylds;

public interface yldsService {

	//跟据数据编号查询数据
		public List<ylds> findyldsbyid(String ACCOUNT_NO);
		
		//查询所有数据
		public List<ylds> findylds();
	
}
