package com.service1.sxx;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.sxx.financialExcel.TrailerManagementMapper;
import com.mapper1.sxx.financialExcel.VehicleMortgageMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2",rollbackFor = Exception.class)  
public class TrailerManagementServiceImpl implements TrailerManagementService {
	
	@Autowired
	private TrailerManagementMapper trailerManagementMapper;

	@Override
	public List<Map<String, Object>> ToBeProcessed(Integer status) {
		// TODO Auto-generated method stub
		return trailerManagementMapper.ToBeProcessed(status);
	}

	@Override
	public List<PageData> FindDataByIcbcid(List<Integer> list, String param) {
		// TODO Auto-generated method stub
		return trailerManagementMapper.FindDataByIcbcid(list, param);
	}

	
}
