package com.service;

import java.util.List;

import com.model.dsj;

public interface dsjService {
    //大数据查询记录
	public void adddsj(dsj dsj);
	//跟新大数据记录
    public void editdsj(dsj dsj);
    //分页查询
    public List<dsj> finddsj(int startPos,int pageSize);
  //查询总数
  	public int finddsjcount();
}
