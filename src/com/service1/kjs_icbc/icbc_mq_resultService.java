package com.service1.kjs_icbc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.icbc_mq_result;

public interface icbc_mq_resultService {
	
	List<icbc_mq_result> findicbc_mq_result(int qryid);
	
	void addmq_result(icbc_mq_result icbc_mq_result);
	
	icbc_mq_result lasticbc_mq_result(int qryid);
}
