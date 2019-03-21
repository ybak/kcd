package com.service1.loan;
import java.util.List;
import com.model1.icbc.erp.PageData;
public interface AboutExcelService {
	//修改还款计划记录
	Integer updatePaySchedule(PageData pd);
	//查询主订单表信息
	PageData icbcInfo(PageData pd);
	//查询表格记录
	List<PageData> selectRecordList(PageData pd);
	//把excel表格数据录入数据库表中
	Integer excel_to_sql(PageData pd);
	//添加录入表格记录
	Integer addExcelRecord(PageData pd);
	//添加逾期客户到数据库表中
	Integer addOverdueClient(PageData pd);
}
