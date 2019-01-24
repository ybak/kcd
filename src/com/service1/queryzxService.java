package com.service1;

import java.util.List;
import java.util.Map;

import com.model1.queryzx;

public interface queryzxService {
	public Map findqueryzx(String c_name,String c_card_no);
	
	public List<queryzx> findqueryzxlist(List<?> querylist);
	
	
	public List<queryzx> querybydate(Map<String, String> mdate);
}
