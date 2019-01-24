package com.service;

import java.util.Map;

import com.model.bb;

public interface bbService {
	    //添加表表数据
		public void addbb(bb bb);
		//根据订单编号查询报表
		public Map findbb(String orderid);
		//更新报表
		public void upbbxx(bb bb);
}
