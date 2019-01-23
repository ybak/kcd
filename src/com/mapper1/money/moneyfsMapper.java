package com.mapper1.money;

import org.apache.ibatis.annotations.Param;

import com.model1.money.moneyfs;

public interface moneyfsMapper {
void addmoneyfs(moneyfs moneyfs);
moneyfs findmoneyfslastid();

moneyfs findmoneyfsbyorderid(@Param("orderid")int orderid);
}
