package com.service1.erp_icbc;

import java.util.List;

import com.model1.icbc.erp.PageData;

public interface erp_loanBeforeService{
	//遍历查询
    List<PageData> findList(PageData pd);
    //查询单个 根据id查询
  	PageData findById(PageData pd);
}	
