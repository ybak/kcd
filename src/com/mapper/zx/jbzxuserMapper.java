package com.mapper.zx;

import com.model.jbapi.jbzxuser;

public interface jbzxuserMapper {
    //添加查询简版征信用户信息
	public void addjbzxuser(jbzxuser jbzxuser);
	//查询
	public jbzxuser findjbzxuser(String loginname);
}
