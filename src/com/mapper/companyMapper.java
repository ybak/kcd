package com.mapper;

import java.util.Map;

import com.model.company;

public interface companyMapper {

	 // 添加公司员工
	 public void addcompany(company company);

	 //登陆验证
	 public Map login(String username,String password);
	
	 //根据公司名称查询公司信息
	 public Map findcompany(String company);
	
	 //充值
	 public void upcompany(company company);
	 
	 //验证key值
	 public int ckynum(String ckey);
	 
	 public Map ckymap(String ckey);
}
