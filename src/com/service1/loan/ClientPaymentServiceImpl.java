package com.service1.loan;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mapper1.loan.ClientPaymentMapper;
import com.model1.icbc.erp.PageData;
import com.util.Page;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class ClientPaymentServiceImpl implements ClientPaymentService{
	@Autowired
	private ClientPaymentMapper clientPaymentMapper;
	@Autowired
	private AboutExcelService AboutExcelService;

	@Override
	public Integer addPaySchedule(PageData pd) {
		PageData setInfoTo = new PageData();
		setInfoTo.put("id",pd.get("icbc_id"));
		PageData getInfo = new PageData();
		getInfo = AboutExcelService.icbcInfo(setInfoTo);//通过icbc_id 获取用户基本信息
		//获取放款成功后的字段信息
		pd.getString("yhdksh_61_je"); //贷款金额
		pd.getString("yhdksh_61_syhk"); //首月还款
		int counts = Integer.parseInt(pd.getString("yhdksh_61_fq")); //分期数
		String sqhkr = pd.getString("yhdksh_61_sqhkr"); //首月还款日  "2019-01-25"
		int year = Integer.parseInt(sqhkr.substring(0,4));
		int month = Integer.parseInt(sqhkr.substring(5,7));
		int day = Integer.parseInt(sqhkr.substring(8,10));
		String yh = pd.getString("yhdksh_61_yh"); // 月还
		//生成还款计划
		PageData addPS = new PageData();
		addPS.put("icbc_id",pd.get("icbc_id")); 
		System.err.println(getInfo.getString("c_cardno")+"--99999");
		addPS.put("c_cardno",getInfo.getString("c_cardno")!=""?getInfo.getString("c_cardno"):"");
		
		addPS.put("c_name",getInfo.getString("c_name")!=""?getInfo.getString("c_name"):"");
		addPS.put("should_money",yh); //应还金额
		String should_data="xxxx-yy-mm";
		for(int i=0;i<counts;i++){
			if(month > 12){
				year = year+1;
				month=1;
			}
			should_data = year+"-"+month+"-"+day;
			addPS.put("should_date",should_data);
			addPS.put("overdue_which",i+1);
			clientPaymentMapper.addPaySchedule(addPS);
			month++;
		}	
		return 0;
	}

	@Override
	public List<PageData> selectPayList(PageData pd) {
		// TODO Auto-generated method stub
		return clientPaymentMapper.selectPayList(pd);
	}

	@Override
	public PageData selectPayform(String icbc_id) {
		// TODO Auto-generated method stub
		return clientPaymentMapper.selectPayform(icbc_id);
	}

	@Override
	public List<PageData> selectPaySchedule(String icbc_id) {
		// TODO Auto-generated method stub
		return clientPaymentMapper.selectPaySchedule(icbc_id);
	}
	@Override
	public List<PageData> selectLoanAfter(String icbc_id) {
		// TODO Auto-generated method stub
		return clientPaymentMapper.selectLoanAfter(icbc_id);
	}
	@Override
	public PageData selectZdr(String icbc_id) {
		// TODO Auto-generated method stub
		return clientPaymentMapper.selectZdr(icbc_id);
	}

}
