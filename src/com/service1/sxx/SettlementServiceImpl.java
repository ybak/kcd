package com.service1.sxx;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.sxx.SettlementMapper;
import com.mapper1.sxx.TrailerManagementMapper;
import com.mapper1.sxx.VehicleMortgageMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2",rollbackFor = Exception.class)  
public class SettlementServiceImpl implements SettlementService {
	
	@Autowired
	private SettlementMapper settlementMapper;

	@Override
	public List<Map<String, Object>> ToBeProcessed(Integer status) {
		// TODO Auto-generated method stub
		return settlementMapper.ToBeProcessed(status);
	}

	@Override
	public List<PageData> FindDataByIcbcid(List<Integer> list, String param) {
		// TODO Auto-generated method stub
		return settlementMapper.FindDataByIcbcid(list, param);
	}

	
}
