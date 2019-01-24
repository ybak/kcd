package com.mapper.zx;

import java.util.List;

import com.model.jbapi.jbzxapiuser;

public interface jbzxapiuserMapper {
    //添加API接入方 开户
	public void addapiuser(jbzxapiuser jbzxapiuser);
	//根据appkey 查询信息
	public jbzxapiuser findapiuserbyappkey(String appkey);
	//更新金额
	public void  upmoney(jbzxapiuser jbzxapiuser);
	//通过id查询
	public jbzxapiuser findapiuserbyid(int id);
	//
	public List<jbzxapiuser> apiuserlist();
	//更新操作
	public void upjbzxapiuser(jbzxapiuser jbzxapiuser);
}
