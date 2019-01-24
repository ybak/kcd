package com.service1.erp_icbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.erp_icbc.erp_wdrwMapper;
import com.mapper1.erp_icbc.fs_detailsMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class fs_detailsServiceImpl implements fs_detailsService{

	@Autowired
	 private fs_detailsMapper fs_detailsMapper;

	@Transactional
	public void save(PageData pd) {
		fs_detailsMapper.save(pd);
		
	}

	@Transactional
	public void update(PageData pd) {
		fs_detailsMapper.update(pd);
	}

}
