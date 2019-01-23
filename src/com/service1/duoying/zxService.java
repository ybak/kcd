package com.service1.duoying;

import java.util.List;


import com.model1.zx;

public interface zxService {
	
	//根据客户姓名查询订单信息
		public List<zx> findzxbyc_name(String c_name);
		
		//查询全部数据
		public List<zx> findzx();
		//征信
		public zx zxmap(String c_name);
		//征信大数据
		public zx zxdsjmap(String c_name);
}
