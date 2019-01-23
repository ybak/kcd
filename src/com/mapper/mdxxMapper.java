package com.mapper;

import java.util.List;
import java.util.Map;

import com.model.mdxx;

public interface mdxxMapper {
    //添加门店及人员信息
	public void addmdxx(List<Map<String, String>> mdxx);
	//用户验证
	public int mdxxsize(String ckey);
	//用户验证
	public Map mdxxmap(String ckey);
	//用户验证
	public int mdxxsize1(String sname,String pname,String pIDcard);
	//快豆扣费
	public void upmdxx(mdxx mdxx);
	//mdxxlist
	public List<mdxx> mdxxlist(int st,int ps);
	//数据总数
	public int mdxxnum();
	//
	public List<mdxx> mdxxckey();
	
	//
	public List<mdxx> mdxxbyname();
	
 }
