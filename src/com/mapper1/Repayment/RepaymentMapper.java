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
   Map<String, Object> selectBorrow(@Param("id")Integer id);
   
   /**
    * 还款计划
    */
   Map<String, Object> selectschedule(@Param("id_card")String id_card);
   
   /**
    * 查询贷后信息
    */
   List<Map> selectafter (@Param("c_cardno")String c_cardno);
   
   /**
    * 查询主贷人信息
    */
   Map<String, Object> selectzdr(String c_cardno);

}
