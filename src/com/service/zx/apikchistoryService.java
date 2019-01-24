package com.service.zx;

import java.util.List;

import com.model.jbapi.apikchistory;

public interface apikchistoryService {
	 //api用户充值记录
	 public void addapikchistory(apikchistory apikchistory);
    //查询记录 
	 public List<apikchistory> findapikchistory(int jauid);
}
