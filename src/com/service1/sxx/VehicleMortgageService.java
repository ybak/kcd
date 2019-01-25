package com.service1.sxx;

import java.util.List;
import java.util.Map;

public interface VehicleMortgageService {

	/**
	 * 查询车辆抵押专员审批后的原始数据 --待处理
	 * @return
	 */
	public List<Map<String, Object>> ToBeProcessed(Integer status);
	
	/**
	 * 根据原始数据处理后得到的idbcid查询专员审核通过后的最终数据 --待处理
	 * @return
	 */
	public List<Map<String, Object>> FindDataByIcbcid(List<Integer> list);
	
}
