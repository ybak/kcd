package com.service.guazi;

import java.util.List;

import com.model.guazi.GuaziRecords;
import com.model.jbapi.jbzxapiuser;
import com.util.Page;
public interface GuaZiService {
	//分页数据（不查询条件）
    List<jbzxapiuser> OneToArr(Page page);
    //分页条数（不带查询条件）
    int OneToArrCount();
    //带查询条件 查询数量
    int OneToArrCountSelective(Page page);
    //添加
    int insert(GuaziRecords guazirecoreds);
    //查询
    String selectbyid(String gid);
}
