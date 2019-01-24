package com.mapper.newAdd;

import java.util.List;

import com.model.newAdd.queryBx;
import com.model1.bx;

public interface queryBxMapper {
	// hzj 查询总数
	public int BxCounts();
	// hzj 查询全部的数据
	public List showBxAndKey(int start,int num);
	// hzj 得到 即将插入ID 
	public int getNewId(String tableName,String databaseName);
	// hzj 添加数据  
	public void addBX(queryBx bx);
	//根据客户姓名查询订单信息
	public List<bx> findbxbyc_name(String c_carno);
	//查询所以数据
	public List<bx> findbx();

}
