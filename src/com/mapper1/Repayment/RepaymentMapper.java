package com.mapper1.Repayment;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.erp.PageData;
import com.util.duoying.mapbeanutil;
public interface RepaymentMapper {
	/**
	 * 查询全部数据 by  zp 2019-1-22
	 * @return 
	 */
   List<PageData> selectRepayment(@Param("param") String param,@Param("pd")PageData pd);
   
   /**
    * 主贷人
    */
   Map<String, Object> selectBorrow(@Param("icbc_id")String icbc_id);
   
   /**
    * 还款计划
    */
   List<Map> selectschedule(@Param("icbc_id")String icbc_id);
     
   /**
    * 查询贷后信息
    */
   List<Map> selectafter (@Param("icbc_id")String icbc_id);
   
   /**
    * 查询主贷人详情信息 模态框
    */
   Map<String, Object> selectzdr(@Param("icbc_id")String icbc_id);

   /**
    * 查询期数
    */
   int selectrepay(int icbc_id);
   
   /**
    * 还款计划
    */
   List<Map> selectimport();
   
   /**
    * 添加分期 插入还款计划
    */
  int addrepay(Map<String, Object> map);
  //在service里调用
  Map<String, Object> selectID(@Param("id")int id);
	// 修改还款记录 
  int updateschedule(Map<String, Object> map);
  
}
