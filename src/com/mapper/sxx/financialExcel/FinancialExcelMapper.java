package com.mapper.sxx.financialExcel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface FinancialExcelMapper {

	/**
	 * 根据ID查询贷款信息
	 * @param id
	 * @return
	 */
	Map GetLoanInformationbyid(Integer id);
	/**
	 * 查询表中需要的各种基本资料
	 * @return
	 */
	List<Map> ExportBuyCarInstallmentExcel(@Param(value="Institutions")String Institutions, @Param(value="Bank")String Bank);
	
	/**
	 * 根据status查询时间信息
	 * @param status
	 * @return
	 */
	List<Map> FindBuyCarInstallmentExcelByStatus();
	
	/**
	 * 查询首期还款日
	 * @return
	 */
	List<Map> FindFirstPaymentDate();
	
	/**
	 * 查询所有的合作机构名称
	 * @return
	 */
	List<String> FindInstitutionsNameList();
	
	/**
	 * 查询所有的银行名称
	 * @return
	 */
	List<String> FindBankNameList();
	
}
