package com.service.icbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.icbc.icbc_resultMapper;
import com.model.icbc.icbc_result;
@Service
public class icbc_resultServiceImpl implements icbc_resultService{

	@Resource
	private icbc_resultMapper icbc_resultMapper;
	
	@Override
	public void addicbc_result(icbc_result icbc_result) {
		icbc_resultMapper.addicbc_result(icbc_result);
		
	}

	@Override
	public List<icbc_result> findresultbyqryid(int qryid) {
		
		return icbc_resultMapper.findresultbyqryid(qryid);
	}

	@Override
	public void addzx_result(icbc_result icbc_result) {
		icbc_resultMapper.addzx_result(icbc_result);
		
	}

	@Override
	public void addkk_result(icbc_result icbc_result) {
		icbc_resultMapper.addkk_result(icbc_result);
		
	}

	@Override
	public void addcardk_result(icbc_result icbc_result) {
		icbc_resultMapper.addcardk_result(icbc_result);
		
	}

	@Override
	public void addpreaudit_result(icbc_result icbc_result) {
		icbc_resultMapper.addpreaudit_result(icbc_result);
		
	}

	@Override
	public List<icbc_result> findzxbyqryid(int qryid) {
		
		return icbc_resultMapper.findzxbyqryid(qryid);
	}

	@Override
	public List<icbc_result> findkkbyqryid(int qryid) {
		
		return icbc_resultMapper.findkkbyqryid(qryid);
	}

	@Override
	public List<icbc_result> findcardkbyqryid(int qryid) {
		
		return icbc_resultMapper.findcardkbyqryid(qryid);
	}

	@Override
	public List<icbc_result> findpreauditbyqryid(int qryid) {
		
		return icbc_resultMapper.findpreauditbyqryid(qryid);
	}

}
