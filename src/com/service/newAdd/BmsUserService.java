package com.service.newAdd;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.formula.functions.T;

import com.model.newAdd.BmsUser;
import com.model.newAdd.pdfdownload;

public interface BmsUserService {
////////////////////团队管理////////////////////	
	// 查询登陆用户的团队人员
	public ArrayList selectLoginUserTeam(int upid);
	
	
////////////////////用户管理////////////////////		
	// 修改用户级别（权限）
	public void updateUserDeptno(int deptno,int uid);
	//模糊查询
	public ArrayList selectUserLike(String uname);
	//删除用户
	public void deleteUserByUid(int uid);
	//修改用户  是否可用
	public int updateUserStatus(int status,int uid);
	//BMS 登陆并验证权限
	public Map checkUser(String username,String password);
	//三级分别查询
	public ArrayList selectOtherUser(int deptno);
	//查询本系统所有的用户
	public ArrayList selectAllUser();
	//添加用户时查询是否重复
	public BmsUser addUserBySelect(String username);
	//添加系统用户
	public int addBMSUser(BmsUser bu);
	
}
