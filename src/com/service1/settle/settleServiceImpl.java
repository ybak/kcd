package com.service1.settle;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2",rollbackFor = Exception.class)  
public class settleServiceImpl implements settleService {
	
	@Autowired
	private com.mapper1.settle.settleMapper settleMapper;


	/**
	 * 查询列表页所有数据并模糊查询
	 * @param param
	 * @param pd
	 * @return
	 */

	@Override
	public List<PageData> selectsettle(String param, int pagenow, int pagesize) {
		// TODO Auto-generated method stub
		return settleMapper.selectsettle(param, pagenow, pagesize);
	}
	/**
	 * 查询总条数
	 */
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return settleMapper.count();
	}



	
	//查询客户个人信息 
	@Override
	public Map<String, Object> selectgrxx(Integer icbc_id) {
		// TODO Auto-generated method stub
		return settleMapper.selectgrxx(icbc_id);
	}
	//查询车辆信息
	@Override
	public Map<String, Object> selectclxx(Integer icbc_id) {
		// TODO Auto-generated method stub
		return settleMapper.selectclxx(icbc_id);
	}
	//查询贷款方案
	@Override
	public Map<String, Object> selectdkfa(Integer icbc_id) {
		// TODO Auto-generated method stub
		return settleMapper.selectdkfa(icbc_id);
	}
	//查询客户逾期期数
	@Override
	public List<Map> selectschedule(Integer icbc_id) {
		// TODO Auto-generated method stub
		return settleMapper.selectschedule(icbc_id);
	}

	
	/**
	 * 查询记录栏
	 */
	@Override
	public List<Map> selectinput(Integer icbc_id) {
		// TODO Auto-generated method stub
		return settleMapper.selectinput(icbc_id);
	}


	//诉讼未处理
	@Override
	public int addTc1(Map<String, Object> detailMap) {
		// TODO Auto-generated method stub
		return settleMapper.addTc1(detailMap);
	}
	@Override
	public int count1() {
		// TODO Auto-generated method stub
		return settleMapper.count1();
	}


//	//修改状态
//	@Override
//	public int updateTcStatus(Integer icbc_id) {
//		// TODO Auto-generated method stub
//		return settleMapper.updateTcStatus(icbc_id);
//	}


	
	



	
	

	
}
