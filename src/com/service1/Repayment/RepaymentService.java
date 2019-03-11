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
   List<PageData> selectRepayment(@Param("param") String param,PageData pd);
   /**
    * 主贷人
    */
   Map<String, Object> selectBorrow(Integer id);
   
   /**
    * 还款计划
    */
   Map<String, Object> selectschedule(@Param("id_card")String id_card);
   
   /**
    * 查询贷后信息
    */
   List<Map> selectafter(Integer c_cardno);
   
   /**
    * 查询主贷人信息
    */
   Map<String, Object> selectzdr(Integer c_cardno);
}
