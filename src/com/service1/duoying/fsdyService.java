package com.service1.duoying;

import java.util.List;
import com.model1.fsdy;

public interface fsdyService {

	    //根据编号查询信息
		public List<fsdy> findfsdybyid(int id);
		
		//查询所有信息
		public List<fsdy> findfsdy();
		
}
