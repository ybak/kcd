package com.mapper1.Electricity;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.erp.PageData;

public interface ElectricityMapper {
	
	/**
	 * 查询数据
	 * @param param
	 * @param pagesize
	 * @param pagenow
	 * @return
	 */
	List<PageData> select(@Param("param") String param,@Param("pagenow") int pagenow,@Param("pagesize") int pagesize);

	/**
	 * 查询总条数
	 */
	int count();
		
	
	/**
	 * 插入电催录入栏数据
	 */
	int addInput(Map<String, Object> map);
	
	/**
	 * 查询记录栏
	 */
	List<Map> selectinput(@Param("icbc_id") String icbc_id);
	
	/**
	 * 查询客户逾期期数
	 */
	
	List<Map> selectschedule(String icbc_id);
	/**
	 * 查询客户个人信息
	 */
	Map<String, Object> selectgrxx(String icbc_id);
	
	/**
	 * 查询车辆信息
	 */
	Map<String, Object> selectclxx(String icbc_id);
	
	/**
	 * 查询贷款详情
	 */
	Map<String, Object> selectdkxx(String icbc_id);
	
	/**
	 * 申请拖车
	 */
	int applica(Map<String, Object> map);
	
	/**
	 * 申请诉讼
	 */
	int applicass(Map<String, Object> map);
	
	/**
	 * 修改逾期表中状态为拖车
	 */
	int updatestate(String icbc_id);
	
	/**
	 * 修改逾期表中状态为诉讼
	 */
	int updateSSstate(String icbc_id);
	
}
