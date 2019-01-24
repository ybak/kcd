package com.service1.kjs_icbc;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.icbc1.newicbcMapper;
import com.model.icbc.icbc;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class newicbcServiceImpl implements newicbcService{

	 @Resource
	 private newicbcMapper newicbcMapper;
	  
	
	@Override
	public void addicbc(icbc icbc) {
		newicbcMapper.addicbc(icbc);
		
	}

	@Override
	public void upicbc(icbc icbc) {
		newicbcMapper.upicbc(icbc);
		
	}

	@Override
	public icbc findicbcbyorderid(String orderid) {
		
		return newicbcMapper.findicbcbyorderid(orderid);
	}

	@Override
	public List<icbc> findicbc(int querytype,int bc_status) {
		
		return newicbcMapper.findicbc(querytype,bc_status);
	}

	@Override
	public icbc findicbcbyid(int id) {
		
		return newicbcMapper.findicbcbyid(id);
	}

	@Override
	public void upicbc_tag(icbc icbc) {
		newicbcMapper.upicbc_tag(icbc);
		
	}

	@Override
	public icbc findlastid() {
		
		return newicbcMapper.findlastid();
	}

	@Override
	public List<icbc> searchicbc(String time1, String time2, int querytype, int bc_status, int gems_fs_id,
			int book_status, int card_status, String icbcname) {
		return newicbcMapper.searchicbc(time1, time2, querytype, bc_status, gems_fs_id, book_status, card_status, icbcname);
	}

	@Override
	public icbc findicbcbyorderid2(String orderid) {
		
		return newicbcMapper.findicbcbyorderid2(orderid);
	}

	@Override
	public int findicbccount() {
		
		return newicbcMapper.findicbccount();
	}

	@Override
	public void up_fk(icbc icbc) {
		newicbcMapper.up_fk(icbc);
		
	}

	@Transactional
	public void del_icbc(int id) {
		newicbcMapper.del_icbc(id);
		
	}

	@Override
	public List<icbc> kjs_zx(int bc_status) {
		
		return newicbcMapper.kjs_zx(bc_status);
	}

	@Override
	public int kjs_zx_count() {
		return newicbcMapper.kjs_zx_count();
	}



}
