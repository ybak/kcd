package com.service1.loan;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.loan.AboutExcelMapper;
import com.mapper1.loan.ClientPaymentMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class AboutExcelServiceImpl implements AboutExcelService{
	@Autowired
	private AboutExcelMapper aboutExcelMapper;

	@Override
	public List<PageData> selectRecordList(PageData pd) {
		// TODO Auto-generated method stub
		return aboutExcelMapper.selectRecordList(pd);
	}

	@Override
	public Integer excel_to_sql(PageData pd) {
		
		return aboutExcelMapper.excel_to_sql(pd);
	}

	@Override
	public Integer addExcelRecord(PageData pd) {
		// TODO Auto-generated method stub
		return aboutExcelMapper.addExcelRecord(pd);
	}

	@Override
	public Integer addOverdueClient(PageData pd){
		// TODO Auto-generated method stub
		return aboutExcelMapper.addOverdueClient(pd);
	}

	@Override
	public PageData icbcInfo(PageData pd) {
		// TODO Auto-generated method stub
		return aboutExcelMapper.icbcInfo(pd);
	}

	@Override
	public Integer updatePaySchedule(PageData pd) {
		// TODO Auto-generated method stub
		return aboutExcelMapper.updatePaySchedule(pd);
	}

	@Override
	public Integer selectOverdueClintOnAdd(PageData pd) {
		// TODO Auto-generated method stub
		return aboutExcelMapper.selectOverdueClintOnAdd(pd);
	}
	

	


}
