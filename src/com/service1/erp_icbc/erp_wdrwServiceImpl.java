package com.service1.erp_icbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.erp_icbc.erp_wdrwMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class erp_wdrwServiceImpl implements erp_wdrwService{

	 @Autowired
	 private erp_wdrwMapper erp_wdrwMapper;
	
	@Override
	public List<PageData> icbc_list(PageData pd) {
		return erp_wdrwMapper.icbc_list(pd);
	}

	@Override
	public PageData icbc_form(PageData pd) {
		
		return erp_wdrwMapper.icbc_form(pd);
	}

	@Transactional
	public void save(PageData pd) {
		erp_wdrwMapper.save(pd);
		
	}

	@Transactional
	public void update(PageData pd) {
		erp_wdrwMapper.update(pd);
		
	}

}
