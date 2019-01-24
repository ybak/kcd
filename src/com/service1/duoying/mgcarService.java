package com.service1.duoying;

import java.util.List;
import com.model1.mgcar;

public interface mgcarService {
	
	//根据订单号查询订单信息
	public List<mgcar> findmgcarbygems_code(String gems_code); 
	
	//查询全部数据
	public List<mgcar> findmgcar();

}
