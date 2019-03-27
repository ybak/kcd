package com.mapper1.loan;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.erp.PageData;

public interface LoanOverdueMapper {
	/**
	 * 电催
	 */
	//查询某一名单的操作记录
	List<PageData> selectResults(PageData pd);
	//查询电催form列表  客户信息+车辆信息+贷款方案信息
	PageData selectPhoneClientCarLoanInfo(PageData pd);
	//查询电催名单
	List<PageData> selectPhoneList(PageData pd);
	
	
	/**
	 * 逾期 
	 */
	//查询一条逾期名单
	PageData selectOverdueOne(PageData pd);
	//修改客户逾期状态
	Integer updateOverdueStatus(PageData pd);
	//查询逾期名单
	List<PageData> selectOverdueList(PageData pd);
	//定时任务-修改客户逾期天数
	Integer updateOverdueDay();
	
	//添加操作记录
	Integer addOperationResult(PageData pd);
}
