package com.service1.erp_icbc;

import java.util.List;

import com.model1.icbc.erp.PageData;
import com.util.pagedate;

public interface erp_userrootService {
	    //遍历查询 fs表
	    List<PageData> findtolist(PageData pd);
		//添加
		void save(PageData pd);
		//根据id查询
		PageData findbyid(PageData pd);
		//单个删除
		void deletebyid(PageData pd);
		//编辑更新
		void updatebyid(PageData pd);
}
