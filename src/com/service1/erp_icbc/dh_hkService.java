package com.service1.erp_icbc;
import java.util.List;
import java.util.Map;
import com.model1.icbc.erp.HK;
import com.model1.icbc.erp.PageData;
public interface dh_hkService {
	//遍历查询
	 List<PageData> findtolist(PageData pd);
	 int addhk(HK hk);
	 //根据id查询某个用户的还贷图
	 List<Map<String,String>> shkb(String id);
	//添加
	void save(PageData pd);
	//单个删除
	void deletebyid(PageData pd);
}
