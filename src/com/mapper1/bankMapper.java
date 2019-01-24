package com.mapper1;

import java.util.List;
import com.model1.bank;

public interface bankMapper {
	//根据编号查询数据
	public List<bank> findbankbycode(String code);	
	//查询全部数据
	public List<bank> findbank();
	//获取单个数据
	public bank bankmap(String code);
	//获取单个数据
	public bank bankmap1(int id);
}
