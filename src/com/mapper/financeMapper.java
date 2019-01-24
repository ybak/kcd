package com.mapper;

import java.util.List;

import com.model.finance;

public interface financeMapper {

	     // 添加 财务流水信息
	     public void  savefinance(finance fn);
	     
	     //查看财务流水信息
	     public List<finance>  findfinance();
	     
	     
	     //分页
	     public List<finance> findfinancelimit(int st,int ps);

	     //查询总数
	     public int findfinancecount();
}
