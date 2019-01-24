package com.service;

import java.util.Map;

import com.model.company;

public interface companyService {

	    // 添加公司员工
		public void addcompany(company company);
		//根据公司名称查询公司信息
		public Map findcompany(String company);
		//更新beans
		public void upcompany(company company);
		//验证key值
		 public int ckynum(String ckey);
		 
		 public Map ckymap(String ckey);
}
