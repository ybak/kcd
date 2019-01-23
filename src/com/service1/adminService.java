package com.service1;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.admin;

public interface adminService {
	
	//用户 登陆 同步
	public Map adminlogin(String username,String userpass);
	//根据id获取用户信息
	public admin adminbyid(int id);
	//
	admin adminbygems_id(int gems_id);
}
