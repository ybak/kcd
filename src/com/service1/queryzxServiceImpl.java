package com.service1;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.queryzxMapper;
import com.model1.queryzx;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)  
public class queryzxServiceImpl implements queryzxService{
  
  @Autowired
  private queryzxMapper queryzxMapper;
	 

	@Override
	public List<queryzx> findqueryzxlist(List<?> querylist) {
//		 System.out.println(querylist.size());
		return queryzxMapper.findqueryzxlist(querylist);
	}


	@Override
	public Map findqueryzx(String c_name, String c_card_no) {
		
		return queryzxMapper.findqueryzx(c_name, c_card_no);
	}


	@Override
	public List<queryzx> querybydate(Map<String, String> mdate) {
		
		return queryzxMapper.querybydate(mdate);
	}

	
}
