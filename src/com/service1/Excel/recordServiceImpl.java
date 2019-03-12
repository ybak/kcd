package com.service1.Excel;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.Excel.recordMapper;
import com.mapper1.Excel.uploadExcelMapper;
import com.model1.icbc.erp.PageData;
import com.util.Excel.RecordUtil;


@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class recordServiceImpl implements recordService{

	@Autowired
	private recordMapper recordMapper;
	@Autowired
	private uploadExcelMapper uploadExcelMapper;

	@Override
	public List<PageData> selectRecord(String param, PageData pd) {
		// TODO Auto-generated method stub
		return recordMapper.selectRecord(param, pd);
	}
	/**
	 * 根据身份证号查询数据条数
	 * @param id_card
	 * @return
	 */
	@Override
	public int count(String id_card) {
		// TODO Auto-generated method stub
		return uploadExcelMapper.count(id_card);
	}
	/**
	 * 通过身份证号查询到逾期客户
	 * @param id_card
	 * @return
	 */
	@Override
	public List<Map> selectOverdue(String id_card) {
		// TODO Auto-generated method stub
		return uploadExcelMapper.selectOverdue(id_card);
	}
	/**
	 * 把逾期客户名单添加到表中
	 * @param map
	 * @return
	 */
	@Override
	public int addOverdue(Map map) {
		// TODO Auto-generated method stub
		return uploadExcelMapper.addOverdue(map);
	}








}
