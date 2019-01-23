package com.service;

import java.util.List;

import com.model.txl;

public interface txlService {
	    //通讯录查询记录
		public void addtxl(txl txl);
		//
		public void uptime(txl txl);
		//
		public List<txl> txlcx();
		//
		public int txlnum();
}
