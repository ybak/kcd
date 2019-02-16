package com.mapper1.sxx;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.erp.PageData;

public interface SettlementMapper {

	/**
	 * 查询车辆抵押专员审批后的原始数据 
	 * @return
	 */
	public List<Map<String, Object>> ToBeProcessed(@Param("status") Integer status);
	
	/**
	 * 根据原始数据处理后得到的idbcid查询专员审核通过后的最终数据 --待处理
	 * @return
	 */
	public List<PageData> FindDataByIcbcid(@Param("list") List<Integer> list, @Param("param") String param);
	
}
