package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.applyMapper;
import com.model.apply;
@Service
//@Transactional
public class applyServiceImpl extends BaseMySqlService implements applyService{

	 @Resource
	 private applyMapper  apm;
	
	@Override
	public List<apply> fapply(int aid,int start,int num) {
		
		return apm.fapply(aid,start,num);
	}

	@Override
	public void addapply(apply apply) {
		apm.addapply(apply);
	}


	@Override
	public Map fapplybyname(String name) {
		
		return apm.fapplybyname(name);
	}


	@Override
	public int fapplylenth(int aid) {
		// TODO Auto-generated method stub
		return apm.fapplylenth(aid);
	}


	@Override
	public void upapply(apply apply) {
		apm.upapply(apply);
		
	}

	@Override
	public int alllenth() {
		
		return apm.alllenth();
	}


	@Override
	public List<apply> allapply(int start, int num) {
		
		return apm.allapply(start, num);
	}

	@Override
	public List<apply> KCDapply(int start, int num,int url_fenlei) {
		return apm.KCDapply(url_fenlei, start, num);
	}

	@Override
	public int KCDCounts(int fenlei) {
		return apm.KCDCounts(fenlei);
	}

	@Override
	public apply findapplybycode(String acode) {
		
		return apm.findapplybycode(acode);
	}

	@Override
	public void delapply(String applyurl) {
		apm.delapply(applyurl);
		
	}

	@Override
	public List<apply> findbyacodeandtype(String acode, int apply_address) {
		
		return apm.findbyacodeandtype(acode, apply_address);
	}
}
