package com.service1.money;

import org.apache.ibatis.annotations.Param;

import com.model1.money.moneyfs;

public interface moneyfsService {
	void addmoneyfs(moneyfs moneyfs);
	moneyfs findmoneyfslastid();
	moneyfs findmoneyfsbyorderid(int orderid);

}
