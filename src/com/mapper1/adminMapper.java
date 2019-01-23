package com.mapper1;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.admin;

public interface adminMapper {

	//用户 登陆 同步
	public Map adminlogin(@Param("username")String username,@Param("userpass")String userpass);

    //根据id获取用户信息
	public admin adminbyid(@Param("id")int id);
	
	 //根据id获取用户信息
	admin adminbygems_id(@Param("gems_id")int gems_id);




}
