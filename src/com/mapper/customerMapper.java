package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.customer;

public interface customerMapper {

	//充值快豆 添加用户公司
	public void addperson(customer customer);
	
	//登陆验证
    public Map login(String username,String password);
    
   //根据公司名称查询员工
   public List<customer> findbycompany(String owencompany);
   //根据等级查询员工信息
   public List<customer> findbylevel(String level,String owencompany);
   //验证key
   public int keypeople(String ckey);
   
   public Map ckymap1(String ckey);
}
