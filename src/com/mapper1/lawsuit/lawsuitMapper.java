package com.mapper1.lawsuit;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.erp.PageData;

public interface lawsuitMapper {

	/**
	 * 查询列表页所有数据并模糊查询
	 * @param param
	 * @param pd
	 * @return
	 */
	List<PageData> selectlawsuit(@Param(value="param") String param,@Param("pagenow")int pagenow,@Param("pagesize")int pagesize);
	/**
	 * 查询总条数
	 */
	int count();
	/**
	 * 查询列表页所有数据并模糊查询
	 * @param param
	 * @param pd
	 * @return
	 */
	List<PageData> selectlawsuit1(@Param(value="param") String param,@Param("pagenow")int pagenow,@Param("pagesize")int pagesize);
	/**
	 * 查询总条数
	 */
	int count1();
	
	/**
	 * 查询客户个人信息
	 */
	Map<String, Object> selectgrxx(Integer icbc_id);
	/**
	 * 查询车辆信息
	 */
	Map<String, Object> selectclxx(Integer icbc_id);
	/**
	 * 查询贷款方案
	 */
	Map<String, Object> selectdkfa(Integer icbc_id);
	/**
	 * 查询客户逾期期数
	 */
	
	List<Map> selectschedule(Integer icbc_id);
	/**
	 * 查询客户个人信息
	 */
	Map<String, Object> selectgrxx1(Integer icbc_id);
	/**
	 * 查询车辆信息
	 */
	Map<String, Object> selectclxx1(Integer icbc_id);
	/**
	 * 查询贷款方案
	 */
	Map<String, Object> selectdkfa1(Integer icbc_id);
	/**
	 * 查询客户逾期期数
	 */
	
	List<Map> selectschedule1(Integer icbc_id);
	

	//诉讼未处理
	int addTc1(Map<String, Object> detailMap);
	int addTc2(Map<String, Object> detailMap);
	
	/**
	 * 查询记录栏
	 */
	List<Map> selectinput(@Param("icbc_id") Integer icbc_id);
	/**
	 * 查询记录栏
	 */
	List<Map> selectinput1(@Param("icbc_id") Integer icbc_id);

	//更改表中状态
	int updateTcStatus(Integer icbc_id);

	
	
}
