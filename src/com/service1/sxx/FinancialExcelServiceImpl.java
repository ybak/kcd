package com.service1.sxx;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.sxx.financialExcel.FinancialExcelMapper;

@Service
@Transactional(value = "kcway2",rollbackFor = Exception.class)  
public class FinancialExcelServiceImpl implements FinancialExcelService {
	
	@Autowired
	private FinancialExcelMapper financialExcelMapper;

	@Override
	public Map GetLoanInformationbyid(Integer id) {
		// TODO Auto-generated method stub
		return financialExcelMapper.GetLoanInformationbyid(id);
	}

	@Override
	public List<Map> ExportBuyCarInstallmentExcel(String Institutions, String Bank) {
		// TODO Auto-generated method stub
		return financialExcelMapper.ExportBuyCarInstallmentExcel(Institutions, Bank);
	}

	@Override
	public List<Map> FindBuyCarInstallmentExcelByStatus() {
		// TODO Auto-generated method stub
		return financialExcelMapper.FindBuyCarInstallmentExcelByStatus();
	}

	@Override
	public List<Map> FindFirstPaymentDate() {
		// TODO Auto-generated method stub
		return financialExcelMapper.FindFirstPaymentDate();
	}

	@Override
	public List<String> FindInstitutionsNameList() {
		// TODO Auto-generated method stub
		return financialExcelMapper.FindInstitutionsNameList();
	}

	@Override
	public List<String> FindBankNameList() {
		// TODO Auto-generated method stub
		return financialExcelMapper.FindBankNameList();
	}

}
