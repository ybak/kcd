package com.mapper.zx;

import java.util.List;

import com.model.jbapi.jbzxapihistory;

public interface jbzxhistoryMapper {

	//简版征信调用记录
	public void addjbzxhistory(jbzxapihistory jbzxapihistory);
	//
	public List<jbzxapihistory> jbzxapihistorylist(int jbzx_id);
}
