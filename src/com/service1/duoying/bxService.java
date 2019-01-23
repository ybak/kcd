package com.service1.duoying;

import java.util.List;


import com.model1.bx;

public interface bxService {

	//根据客户姓名查询订单信息
		public List<bx> findbxbyc_name(String c_carno);
		
		//查询所以数据
		public List<bx> findbx();
}
