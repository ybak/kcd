package com.service1.loan;
import java.util.List;
import com.model1.icbc.erp.PageData;
public interface ClientPaymentService {
	//用户放款成功，生成还款计划
	Integer addPaySchedule(PageData pd);
	
}
