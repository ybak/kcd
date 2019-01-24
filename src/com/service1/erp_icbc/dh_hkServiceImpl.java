package com.service1.erp_icbc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.controller.erp_icbc.utils.PageInfo;
import com.mapper1.erp_icbc.dh_hkMapper;
import com.model1.icbc.erp.HK;
import com.model1.icbc.erp.PageData;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class dh_hkServiceImpl implements dh_hkService{
	@Autowired
	private dh_hkMapper dhhk;

	@Override
	public List<PageData> findtolist(PageData pd) {
		// TODO Auto-generated method stub
		return dhhk.findtolist(pd);
	}
	public  List<Map<String,String>> shkb(String id){
		 return dhhk.shkb(id);
	 }
	@Override
	public void save(PageData pd) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deletebyid(PageData pd) {
		// TODO Auto-generated method stub

	}
	@Override
	public int addhk(HK hk) {
		// TODO Auto-generated method stub
		return dhhk.addhk(hk);
	}
}
