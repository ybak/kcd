package com.mapper.zx;

import java.util.List;

import com.model.jbapi.apikchistory;

public interface apikchistoryMapper {

	 //api用户充值记录
	 public void addapikchistory(apikchistory apikchistory);
     //查询记录 
	 public List<apikchistory> findapikchistory(int jauid);


}
