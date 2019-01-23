package com.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model.bb;

public interface bbMapper {
    //添加表表数据
	public void addbb(bb bb);
	//根据订单编号查询报表
	public Map findbb(@Param("orderid")String orderid);
	//更新报表
	public void upbbxx(bb bb);
}
