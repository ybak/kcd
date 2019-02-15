package com.service1.sxx;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.sxx.financialExcel.LitigationManagementMapper;
import com.mapper1.sxx.financialExcel.TrailerManagementMapper;
import com.mapper1.sxx.financialExcel.VehicleMortgageMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2",rollbackFor = Exception.class)  
public class LitigationManagementServiceImpl implements LitigationManagementService {
	
	@Autowired
	private LitigationManagementMapper litigationManagementMapper;

	@Override
	public List<Map<String, Object>> ToBeProcessed(Integer status) {
		// TODO Auto-generated method stub
		return litigationManagementMapper.ToBeProcessed(status);
	}

	@Override
	public List<PageData> FindDataByIcbcid(List<Integer> list, String param) {
		// TODO Auto-generated method stub
		return litigationManagementMapper.FindDataByIcbcid(list, param);
	}

	
}
