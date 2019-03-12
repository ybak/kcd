package com.service1.TrailernotAccepted;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.TrailernotAccepted.TrailernotAcceptedMapper;
import com.mapper1.sxx.VehicleMortgageMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2",rollbackFor = Exception.class)  
public class TrailernotAcceptedServiceImpl implements TrailernotAcceptedService {
	
	@Autowired
	private TrailernotAcceptedMapper trailernotAcceptedMapper;


	/**
	 * 查询列表页所有数据并模糊查询
	 * @param param
	 * @param pd
	 * @return
	 */

	@Override
	public List<PageData> selectTrailernotAccepted(String param, int pagenow, int pagesize) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectTrailernotAccepted(param, pagenow, pagesize);
	}
	/**
	 * 查询总条数
	 */
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.count();
	}
	/**
	 * 查询列表页所有数据并模糊查询
	 * @param param
	 * @param pd
	 * @return
	 */

	@Override
	public List<PageData> selectTrailernotAccepted1(String param, int pagenow, int pagesize) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectTrailernotAccepted1(param, pagenow, pagesize);
	}
	/**
	 * 查询总条数
	 */
	@Override
	public int count1() {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.count1();
	}
	/**
	 * 查询列表页所有数据并模糊查询
	 * @param param
	 * @param pd
	 * @return
	 */

	@Override
	public List<PageData> selectTrailernotAccepted2(String param, int pagenow, int pagesize) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectTrailernotAccepted2(param, pagenow, pagesize);
	}
	/**
	 * 查询总条数
	 */
	@Override
	public int count2() {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.count2();
	}
	//查询客户个人信息 
	@Override
	public Map<String, Object> selectgrxx(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectgrxx(icbc_id);
	}
	//查询车辆信息
	@Override
	public Map<String, Object> selectclxx(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectclxx(icbc_id);
	}
	//查询贷款方案
	@Override
	public Map<String, Object> selectdkfa(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectdkfa(icbc_id);
	}
	//查询客户逾期期数
	@Override
	public List<Map> selectschedule(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectschedule(icbc_id);
	}
	//查询客户个人信息 
	@Override
	public Map<String, Object> selectgrxx1(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectgrxx1(icbc_id);
	}
	//查询车辆信息
	@Override
	public Map<String, Object> selectclxx1(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectclxx1(icbc_id);
	}
	//查询贷款方案
	@Override
	public Map<String, Object> selectdkfa1(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectdkfa1(icbc_id);
	}
	//查询客户逾期期数
	@Override
	public List<Map> selectschedule1(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectschedule1(icbc_id);
	}
	//查询客户个人信息 
	@Override
	public Map<String, Object> selectgrxx2(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectgrxx2(icbc_id);
	}
	//查询车辆信息
	@Override
	public Map<String, Object> selectclxx2(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectclxx2(icbc_id);
	}
	//查询贷款方案
	@Override
	public Map<String, Object> selectdkfa2(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectdkfa2(icbc_id);
	}
	//查询客户逾期期数
	@Override
	public List<Map> selectschedule2(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectschedule2(icbc_id);
	}
	/**
	 * 查询记录栏
	 */
	@Override
	public List<Map> selectinput(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectinput(icbc_id);
	}
	@Override
	public List<Map> selectinput1(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectinput1(icbc_id);
	}
	@Override
	public List<Map> selectinput2(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.selectinput2(icbc_id);
	}
	//拖车未处理
	@Override
	public int addTc1(Map<String, Object> detailMap) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.addTc1(detailMap);
	}
	@Override
	public int addTc2(Map<String, Object> detailMap) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.addTc2(detailMap);
	}
	@Override
	public int addTc3(Map<String, Object> detailMap) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.addTc3(detailMap);
	}
	//修改状态
	@Override
	public int updateTcStatus(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.updateTcStatus(icbc_id);
	}
	@Override
	public int updateTcStatus1(Integer icbc_id) {
		// TODO Auto-generated method stub
		return trailernotAcceptedMapper.updateTcStatus1(icbc_id);
	}
	
	
	



	
	

	
}
