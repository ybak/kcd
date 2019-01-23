package com.service;

import java.util.List;
import java.util.Map;

import com.model.user;

public interface userService {
	    //添加用户
		public void adduser(user user);
		//登陆验证
		public Map finduser(String username,String password);
		//登陆验证
		public Map finduser1(String username);
		//用户遍历
		public List<user> userfind();
		//根据编号查询用户信息
		public Map finduserbyid(int uid);
}
