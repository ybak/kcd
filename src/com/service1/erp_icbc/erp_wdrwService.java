package com.service1.erp_icbc;

import java.util.List;

import com.model1.icbc.erp.PageData;

public interface erp_wdrwService {
	    //查询所有
		List<PageData> icbc_list(PageData pd);
		//查询单条数据
	    PageData icbc_form(PageData pd);
	    //添加
	    void save(PageData pd);
	    //修改
	    void update(PageData pd);
}
