package com.mapper1.erp_icbc;

import java.util.List;
import com.model1.icbc.erp.PageData;

public interface erp_loanBeforeMapper {
	//遍历查询
    List<PageData> findList(PageData pd);
    //根据id查询单个
  	PageData findById(PageData pd);
}
