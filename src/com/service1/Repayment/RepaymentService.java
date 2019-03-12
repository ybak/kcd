package com.service1.Repayment;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;


import com.model1.icbc.erp.PageData;

public interface RepaymentService {
	/**
	 * 查询全部数据 by  zp 2019-1-22
	 * @return 
	 */
   List<PageData> selectRepayment( String param,PageData pd);
   /**
    * 主贷人
    */
   Map<String, Object> selectBorrow(String icbc_id);
   
   /**
    * 还款计划
    */
   List<Map> selectschedule(String icbc_id);
   
   /**
    * 还款计划
    */
   List<Map> selectimport();
   
   /**
    * 查询贷后信息
    */
   List<Map> selectafter(String icbc_id);
   
   /**
    * 查询主贷人信息
    */
   Map<String, Object> selectzdr(String icbc_id);
   
   /**
    * 查询期数
    */
   int selectrepay(int icbc_id);
   
   /**
    * 添加分期 插入还款计划
    */

  int addrepay(int icbc_id,String fk_money,int aj_date);
	// 修改还款记录 
  int updateschedule(Map<String, Object> map);
}
