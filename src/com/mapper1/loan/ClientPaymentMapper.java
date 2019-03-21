package com.mapper1.loan;

import java.util.List;

import com.model1.icbc.erp.PageData;
import com.util.pagedate;

public interface ClientPaymentMapper{
	//查询客户还款情况form 查询主贷人
	PageData selectZdr(String icbc_id);
	//查询客户还款情况form 查询贷后信息
	PageData selectLoanAfter(String icbc_id);
	//查询客户还款情况form 查询客户还款计划
	List<PageData> selectPaySchedule(String icbc_id);
	//查询客户还款情况form 业务状态信息
	PageData selectPayform(String icbc_id);
	//用户放款成功，生成还款计划
	Integer addPaySchedule(PageData pd);
	//查询还款情况列表
	List<PageData> selectPayList(PageData pd);
}
