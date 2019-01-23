package com.service1.kjs_icbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.icbc1.newicbc_kkMapper;
import com.model.icbc.icbc_kk;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class newicbc_kkServiceImpl implements newicbc_kkService{

	 @Resource
	 private newicbc_kkMapper newicbc_kkMapper;
	
	@Override
	public icbc_kk findicbc_kkbyid(int icbc_id) {		
		return newicbc_kkMapper.findicbc_kkbyid(icbc_id);
	}

	@Override
	public void upkk(icbc_kk icbc_kk) {
		newicbc_kkMapper.upkk(icbc_kk);
		
	}

	@Override
	public void upicbc_kk(icbc_kk icbc_kk) {
		newicbc_kkMapper.upicbc_kk(icbc_kk);
		
	}

	@Override
	public void addicbc_kk(icbc_kk icbc_kk) {
		newicbc_kkMapper.addicbc_kk(icbc_kk);
		
	}

	@Override
	public icbc_kk findicbc_kkbyorder(int icbc_id) {
		
		return newicbc_kkMapper.findicbc_kkbyorder(icbc_id);
	}

	@Override
	public List<icbc_kk> allfindicbc_kk() {
		
		return newicbc_kkMapper.allfindicbc_kk();
	}

	@Override
	public icbc_kk findicbc_kk2(int icbc_id) {
		
		return newicbc_kkMapper.findicbc_kk2(icbc_id);
	}

	@Override
	public icbc_kk findkkbyid(int id) {
		
		return newicbc_kkMapper.findkkbyid(id);
	}

	@Override
	public icbc_kk kkshbyid(int id) {
		
		return newicbc_kkMapper.kkshbyid(id);
	}

	@Transactional
	public void del_icbc_kk(int id) {
		newicbc_kkMapper.del_icbc_kk(id);
		
	}

	@Override
	public List<icbc_kk> kjs_kk(int bc_status) {
		return newicbc_kkMapper.kjs_kk(bc_status);
	}

	@Override
	public int kjs_kk_count() {
		// TODO Auto-generated method stub
		return newicbc_kkMapper.kjs_kk_count();
	}

}
