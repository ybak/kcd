package com.service;

import java.util.List;
import com.model.customer;

public interface customerService {
	       //充值快豆 添加用户公司
		   public void addperson(customer customer);
		
		   //根据公司名称查询员工
		   public List<customer> findbycompany(String owencompany);	
		   //根据等级查询员工信息
		   public List<customer> findbylevel(String level,String owencompany);
		   //验证key
		   public int keypeople(String ckey);
}
