package com.service1.Repayment;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mapper1.Repayment.RepaymentMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class RepaymentServiceImpl implements RepaymentService{

	@Autowired
	private RepaymentMapper repaymentMapper;

	@Override
	public List<PageData> selectRepayment(String param,PageData pd) {
		// TODO Auto-generated method stub
		return repaymentMapper.selectRepayment(param,pd);
	}

	@Override
	public Map<String, Object> selectBorrow(String icbc_id) {
		// TODO Auto-generated method stub
		return repaymentMapper.selectBorrow(icbc_id);
	}

	@Override
	public List<Map> selectschedule(String icbc_id) {
		// TODO Auto-generated method stub
		return repaymentMapper.selectschedule(icbc_id);
	}

	@Override
	public List<Map> selectafter(String icbc_id) {
		// TODO Auto-generated method stub
		return repaymentMapper.selectafter(icbc_id);
	}

	@Override
	public Map<String, Object> selectzdr(String icbc_id) {
		// TODO Auto-generated method stub
		return repaymentMapper.selectzdr(icbc_id);
	}

	@Override
	public int selectrepay(int icbc_id) {
		// TODO Auto-generated method stub
		return repaymentMapper.selectrepay(icbc_id);
	}

	@Override
	public int addrepay(int icbc_id, String fk_money, int aj_date) {
		// TODO Auto-generated method stub
		int result=0;
		Map<String, Object> map = repaymentMapper.selectID(icbc_id);
		Map<String, Object> addmap = new HashMap<String, Object>();
		int myyh=0;
		if(null != map){
			//本息合计=本金合计*（1+利率
			BigDecimal mm = new BigDecimal(fk_money);
			double lv2 = (double)map.get("dk_lv")/100 + 1;
			//利率
			BigDecimal bb2 = new BigDecimal(String.valueOf(lv2));
			BigDecimal ee2 = mm.multiply(bb2);//乘法
				
			//贷款期限
			BigDecimal cc2=new BigDecimal( map.get("aj_date").toString());
			//每月应还=本息合计/贷款期数
			BigDecimal dd2 = ee2.divide(cc2, 2, RoundingMode.HALF_UP);
			System.out.println("================:"+dd2);
			myyh = dd2.intValue();
		}
		
		//得到当前时间
		Date date = new Date();  	
		int year=Integer.parseInt(new SimpleDateFormat("yyyy").format(date));//取到年份值
		int month=Integer.parseInt(new SimpleDateFormat("MM").format(date))+1;//取到鱼粉值  
		String day="10";//每月还款日	
		
		addmap.put("should_money", myyh);
		
		addmap.put("icbc_id", icbc_id);
		addmap.put("name", map.get("c_name"));
		addmap.put("cardno", map.get("c_cardno"));
		String should_data=null;
		for(int i=0;i<aj_date;i++){
			if(month > 12){
				year = year+1;
				month=1;
			}
			should_data = year+"-"+month+"-"+day;
			addmap.put("should_date", should_data);
			repaymentMapper.addrepay(addmap);
			month++;
		}		
		return result;
	}

	@Override
	public List<Map> selectimport() {
		// TODO Auto-generated method stub
		
		return repaymentMapper.selectimport();
	}
	// 修改还款记录 
	
	@Override
	public int updateschedule(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return repaymentMapper.updateschedule(map);
	}
	
}
