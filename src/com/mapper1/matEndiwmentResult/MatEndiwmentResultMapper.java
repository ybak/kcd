package com.mapper1.matEndiwmentResult;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.erp.PageData;

public interface MatEndiwmentResultMapper {
	
	/**
	 * 查询并分页 by zp 2019-2-16
	 */
	List<PageData> selectMat(@Param("param") String param);
	
	/**
	 * 查询详情
	 */
	List<Map> selectDetail(@Param("id_card")String id_card,@Param("periods") String periods);
	/**
	 * 计算逾期金额
	 * @param id_card
	 * @param periods
	 * @return
	 */
	 List<Map> selectdetail(@Param("id_card") String id_card);
	/**
	 * 添加前的查询
	 */
	 Map<String, Object> selectid_card(@Param("id_card") String id_card);
	 
	 /**
	  * 添加数据到表中
	  */
	 int addMat(Map<String, Object> map);
	   
	 /**
	  * 添加还款计划
	  */
	 int addhk(Map<String, Object> map);
	
	 /**
	    * 查询用户信息表
	    */
	   Map<String, Object> selectAfree(String id_card);
	   
	/**
	 * 修改状态
	 */
	int updateflag(@Param("id_card") String id_card,@Param("periods") String periods,@Param("dcdate") String dcdate);
	
	/**
	 * 修改垫款次数前查询条数
	 */
	String selectcount(@Param("id_card") String id_card);
	
	/**
	 * 修改confirm_compensatory垫款次数
	 * @param map
	 * @return
	 */
	int updatecount(@Param("id_card") String id_card,@Param("count") String count);
	/**
	 * 修改agree_compensate垫款次数
	 * @param id_card
	 * @param count
	 * @return
	 */
	int updatecount2(@Param("id_card") String id_card,@Param("count") String count);
	
	/**
	 * 修改import_repayment表中状态
	 */
	int updatestate(@Param("id_card") String id_card,@Param("periods") String periods,@Param("dcdate") String dcdate);
}
