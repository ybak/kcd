package com.service1.lawsuit;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2",rollbackFor = Exception.class)  
public class lawsuitServiceImpl implements lawsuitService {
	
	@Autowired
	private com.mapper1.lawsuit.lawsuitMapper lawsuitMapper;


	/**
	 * 查询列表页所有数据并模糊查询
	 * @param param
	 * @param pd
	 * @return
	 */

	@Override
	public List<PageData> selectlawsuit(String param, int pagenow, int pagesize,int fsid,int fs_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectlawsuit(param, pagenow, pagesize,fsid,fs_id);
	}
	/**
	 * 查询总条数
	 */
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return lawsuitMapper.count();
	}
	/**
	 * 查询列表页所有数据并模糊查询
	 * @param param
	 * @param pd
	 * @return
	 */

	@Override
	public List<PageData> selectlawsuit1(String param, int pagenow, int pagesize,int fsid,int fs_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectlawsuit1(param, pagenow, pagesize,fsid,fs_id);
	}
	/**
	 * 查询总条数
	 */
	@Override
	public int count1() {
		// TODO Auto-generated method stub
		return lawsuitMapper.count1();
	}
	
	//查询客户个人信息 
	@Override
	public Map<String, Object> selectgrxx(Integer icbc_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectgrxx(icbc_id);
	}
	//查询车辆信息
	@Override
	public Map<String, Object> selectclxx(Integer icbc_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectclxx(icbc_id);
	}
	//查询贷款方案
	@Override
	public Map<String, Object> selectdkfa(Integer icbc_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectdkfa(icbc_id);
	}
	//查询客户逾期期数
	@Override
	public List<Map> selectschedule(Integer icbc_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectschedule(icbc_id);
	}
	//查询客户个人信息 
	@Override
	public Map<String, Object> selectgrxx1(Integer icbc_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectgrxx1(icbc_id);
	}
	//查询车辆信息
	@Override
	public Map<String, Object> selectclxx1(Integer icbc_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectclxx1(icbc_id);
	}
	//查询贷款方案
	@Override
	public Map<String, Object> selectdkfa1(Integer icbc_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectdkfa1(icbc_id);
	}
	//查询客户逾期期数
	@Override
	public List<Map> selectschedule1(Integer icbc_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectschedule1(icbc_id);
	}
	
	/**
	 * 查询记录栏
	 */
	@Override
	public List<Map> selectinput(Integer icbc_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectinput(icbc_id);
	}
	@Override
	public List<Map> selectinput1(Integer icbc_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectinput1(icbc_id);
	}

	//诉讼未处理
	@Override
	public int addTc1(Map<String, Object> detailMap) {
		// TODO Auto-generated method stub
		return lawsuitMapper.addTc1(detailMap);
	}
	@Override
	public int addTc2(Map<String, Object> detailMap) {
		// TODO Auto-generated method stub
		return lawsuitMapper.addTc2(detailMap);
	}

	//修改状态
	@Override
	public int updateTcStatus(Integer icbc_id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.updateTcStatus(icbc_id);
	}
	@Override
	public Map<String, Object> selectjll(int id) {
		// TODO Auto-generated method stub
		return lawsuitMapper.selectjll(id);
	}


	
	



	
	

	
}
