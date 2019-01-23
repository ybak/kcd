package com.service;

import java.util.List;
import java.util.Map;

import com.model.history;

public interface historyService {

	//添加记录
	public void hsava(history ht);
	  //查询历史数据
  	public Map findhistory(String uid);
  //查询历史数据
  	public List<history> hlist(String uid);
}
