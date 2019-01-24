package com.service.zx;

import java.util.List;

import com.model.zxjb;
import com.model.jbapi.jbzx;

public interface jbzxService {
    //简版征信查询记录添加
	public void addjbzx(zxjb zxjb);
	//简版征信更新
	public void upzxjb(zxjb zxjb);
	
	//根据订单查询
	public zxjb findzxjb(String gems_code);
	
	//遍历
	public List<zxjb> jbzxlist();
	//审核内容
	public zxjb findjbzxbyid(int id);
}
