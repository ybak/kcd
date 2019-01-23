package com.service1.duoying;

import java.util.List;


import com.model1.thjl;

public interface thjlService {

	//根据姓名查询表中数据
		public List<thjl> findthjlbyc_name(String c_name);
		
		//查询所有数据
		public List<thjl> findthjl();
		
		public thjl thjlmap(String c_name);
}
