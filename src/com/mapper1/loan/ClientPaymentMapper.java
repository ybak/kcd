package com.mapper1.loan;

import java.util.List;

import com.model1.icbc.erp.PageData;
import com.util.pagedate;

public interface ClientPaymentMapper{
	//用户放款成功，生成还款计划
	Integer addPaySchedule(PageData pd);
}
