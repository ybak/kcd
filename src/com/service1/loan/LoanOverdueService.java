package com.service1.loan;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.model1.icbc.erp.PageData;

public interface LoanOverdueService {
	//查询逾期名单
	List<PageData> selectOverdueList(PageData pd);
}
