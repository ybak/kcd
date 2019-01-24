package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.history;

public interface historyMapper {
    //添加历史记录
	public void hsava(history ht);
	//查询历史数据
	public Map findhistory(String uid);
	//查询历史数据
	public List<history> hlist(String uid);
	
}
