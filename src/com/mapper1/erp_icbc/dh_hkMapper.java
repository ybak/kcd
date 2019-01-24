package com.mapper1.erp_icbc;
import java.util.List;
import java.util.Map;
import com.model1.icbc.erp.HK;
import com.model1.icbc.erp.PageData;
public interface dh_hkMapper {
	 List<PageData> findtolist(PageData pd);
	 //添加还款信息
	 int addhk(HK hk);
	 //还款天数 报表
	 List<Map<String,String>> shkb(String id);
}
