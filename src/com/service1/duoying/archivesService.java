package com.service1.duoying;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.archives;

public interface archivesService {
	
	//根据订单编号查询订单信息
	public List<archives> findarchivesbyc_name(String c_carno);

	//查询全部数据 
	public List<archives> findarchives();
	
	public archives archivesmap(String c_carno);
	
	//api 查车档
	public archives Apiarchives(String c_carno,
			String r_item6,
			String query_type
			);
}
