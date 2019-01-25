package com.mapper1.erp_icbc;

import com.model1.icbc.erp.PageData;

public interface fs_detailsMapper {
	
	//添加
    void save(PageData pd);
    //更新
    void update(PageData pd);
    //单个查询
    PageData findbyid(PageData pd);
  
}
