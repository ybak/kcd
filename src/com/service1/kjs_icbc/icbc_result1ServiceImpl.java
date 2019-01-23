package com.service1.kjs_icbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.icbc1.icbc_result1Mapper;
import com.model.icbc.icbc_result;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class icbc_result1ServiceImpl implements icbc_result1Service{

	@Resource
	private icbc_result1Mapper icbc_result1Mapper;
	
	@Override
	public void addicbc_result(icbc_result icbc_result) {
		icbc_result1Mapper.addicbc_result(icbc_result);
		
	}

	@Override
	public List<icbc_result> findresultbyqryid(int qryid) {
		
		return icbc_result1Mapper.findresultbyqryid(qryid);
	}

	@Override
	public void addzx_result(icbc_result icbc_result) {
		icbc_result1Mapper.addzx_result(icbc_result);
		
	}

	@Override
	public void addkk_result(icbc_result icbc_result) {
		icbc_result1Mapper.addkk_result(icbc_result);
		
	}

	@Override
	public void addcardk_result(icbc_result icbc_result) {
		icbc_result1Mapper.addcardk_result(icbc_result);
		
	}

	@Override
	public void addpreaudit_result(icbc_result icbc_result) {
		icbc_result1Mapper.addpreaudit_result(icbc_result);
		
	}

	@Override
	public List<icbc_result> findzxbyqryid(int qryid) {
		
		return icbc_result1Mapper.findzxbyqryid(qryid);
	}

	@Override
	public List<icbc_result> findkkbyqryid(int qryid) {
		
		return icbc_result1Mapper.findkkbyqryid(qryid);
	}

	@Override
	public List<icbc_result> findcardkbyqryid(int qryid) {
		
		return icbc_result1Mapper.findcardkbyqryid(qryid);
	}

	@Override
	public List<icbc_result> findpreauditbyqryid(int qryid) {
		
		return icbc_result1Mapper.findpreauditbyqryid(qryid);
	}

	@Override
	public icbc_result lastfindresult(int qryid) {
		
		return icbc_result1Mapper.lastfindresult(qryid);
	}

	@Override
	public icbc_result kklastfindresult(int qryid) {
		
		return icbc_result1Mapper.kklastfindresult(qryid);
	}

	@Override
	public icbc_result dklastfindresult(int qryid) {
		
		return icbc_result1Mapper.dklastfindresult(qryid);
	}

}
