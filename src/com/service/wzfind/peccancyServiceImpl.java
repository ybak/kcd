package com.service.wzfind;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.wzfind.peccancyMapper;
import com.model.wzfind.peccancy;
@Service
public class peccancyServiceImpl implements peccancyService{

	@Resource
	private peccancyMapper peccancymapper;
	
	@Override
	public void addpeccancy(peccancy peccancy) {
		peccancymapper.addpeccancy(peccancy);
		
	}

	@Override
	public void uppeccancy(peccancy peccancy) {
		peccancymapper.uppeccancy(peccancy);
		
	}

	@Override
	public void upporderstate(peccancy peccancy) {
		peccancymapper.upporderstate(peccancy);
		
	}

	@Override
	public void uporderno(peccancy peccancy) {
		peccancymapper.uporderno(peccancy);
		
	}

	@Override
	public List<peccancy> peccancylist() {
		
		return peccancymapper.peccancylist();
	}

	@Override
	public peccancy findpeccancybyid(int id) {
		
		return peccancymapper.findpeccancybyid(id);
	}

}
