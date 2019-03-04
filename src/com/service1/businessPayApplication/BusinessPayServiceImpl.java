package com.service1.businessPayApplication;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.businessPayApplication.BusinessPayMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class BusinessPayServiceImpl implements BusinessPayService{

	@Autowired
	private BusinessPayMapper businessPaymapper;
	@Override
	public List<PageData> selectBusinessPay(String param,int pagenow ,int pagesize) {
		// TODO Auto-generated method stub
		return businessPaymapper.selectBusinessPay(param,pagenow,pagesize);
	}
	@Override
	public List<Map> selectdetail(String id_card,String periods) {
		// TODO Auto-generated method stub
		return businessPaymapper.selectdetail(id_card,periods);
	}
	@Override
	public Map<String, Object> selectCardno(String c_cardno) {
		// TODO Auto-generated method stub
		return businessPaymapper.selectCardno(c_cardno);
	}
	@Override
	public int addBusin(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return businessPaymapper.addBusin(map);
	}
	@Override
	public int addhk(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return businessPaymapper.addhk(map);
	}
	@Override
	public List<Map> selectconfirm(String id_card) {
		// TODO Auto-generated method stub
		return businessPaymapper.selectconfirm(id_card);
	}
	@Override
	public int updateflag(String id_card, String periods,String date,String day) {
		// TODO Auto-generated method stub
		return businessPaymapper.updateflag(id_card, periods,date,day);
	}
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return businessPaymapper.count();
	}
	
}
