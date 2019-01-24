package com.service1.kjs_icbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.icbc1.icbc_dkMapper;
import com.model.icbc.icbc_cardk;
import com.model.icbc.icbc_result;
import com.model1.icbc.icbc_dk;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class icbc_dkServiceImpl implements icbc_dkService{

	@Resource
	private icbc_dkMapper icbc_dkMapper;
	
	@Override
	public icbc_dk finddkbyorder(int icbc_id) {		
		return icbc_dkMapper.finddkbyorder(icbc_id);
	}

	@Override
	public void updk(icbc_dk icbc_dk) {
		icbc_dkMapper.updk(icbc_dk);
		
	}

	@Override
	public icbc_dk findicbc_cardk(int icbc_id) {
		
		return icbc_dkMapper.findicbc_cardk(icbc_id);
	}

	@Override
	public void addicbc_cardk(icbc_dk icbc_dk) {
		icbc_dkMapper.addicbc_cardk(icbc_dk);
		
	}

	@Override
	public void upicbc_cardk(icbc_dk icbc_dk) {
		icbc_dkMapper.upicbc_cardk(icbc_dk);
		
	}

	@Override
	public List<icbc_dk> allfinddk() {
		
		return icbc_dkMapper.allfinddk();
	}

	@Override
	public icbc_dk finddk2(int icbc_id) {
		
		return icbc_dkMapper.finddk2(icbc_id);
	}

	@Override
	public icbc_dk finddkbyid(int id) {
		
		return icbc_dkMapper.finddkbyid(id);
	}

	@Override
	public icbc_dk dkshbyid(int id) {
		
		return icbc_dkMapper.dkshbyid(id);
	}

	@Override
	public icbc_dk findjj(int icbc_id) {
		return icbc_dkMapper.findjj(icbc_id);
	}

	@Override
	public icbc_dk findjj_status(int icbc_id) {
		
		return icbc_dkMapper.findjj_status(icbc_id);
	}

	@Transactional
	public void del_icbc_dk(int id) {
		icbc_dkMapper.del_icbc_dk(id);
	}

	@Override
	public List<icbc_dk> kjs_dk(int bc_status) {
		
		return icbc_dkMapper.kjs_dk(bc_status);
	}

	@Override
	public int kjs_dk_count() {
		
		return icbc_dkMapper.kjs_dk_count();
	}



}
