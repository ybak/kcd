package com.service1.Electricity;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.Electricity.ElectricityMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class ElectricityServiceImpl implements ElectricityService{

	@Autowired
	private ElectricityMapper electricityMapper;

	@Override
	public List<PageData> select(String param, int pagenow, int pagesize,int fsid,int fs_id) {
		// TODO Auto-generated method stub
		return electricityMapper.select(param, pagenow, pagesize,fsid,fs_id);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return electricityMapper.count();
	}


	//插入电催录入栏数据
	@Override
	public int addInput(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return electricityMapper.addInput(map);
	}

	@Override
	public List<Map> selectinput(String icbc_id) {
		// TODO Auto-generated method stub
		return electricityMapper.selectinput(icbc_id);
	}

	@Override
	public Map<String, Object> selectgrxx(String icbc_id) {
		// TODO Auto-generated method stub
		return electricityMapper.selectgrxx(icbc_id);
	}

	/**
	 * 查询客户逾期期数
	 */
	@Override
	public List<Map> selectschedule(String icbc_id) {
		// TODO Auto-generated method stub
		return electricityMapper.selectschedule(icbc_id);
	}

	@Override
	public int applica(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return electricityMapper.applica(map);
	}

	@Override
	public int applicass(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return electricityMapper.applicass(map);
	}

	@Override
	public Map<String, Object> selectclxx(String icbc_id) {
		// TODO Auto-generated method stub
		return electricityMapper.selectclxx(icbc_id);
	}

	@Override
	public Map<String, Object> selectdkxx(String icbc_id) {
		// TODO Auto-generated method stub
		return electricityMapper.selectdkxx(icbc_id);
	}

	@Override
	public int updatestate(String icbc_id) {
		// TODO Auto-generated method stub
		return electricityMapper.updatestate(icbc_id);
	}

	@Override
	public int updateSSstate(String icbc_id) {
		// TODO Auto-generated method stub
		return electricityMapper.updateSSstate(icbc_id);
	}

	@Override
	public Map<String, Object> selectjll(int id) {
		// TODO Auto-generated method stub
		return electricityMapper.selectjll(id);
	}
}
