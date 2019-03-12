package com.service1.erp_icbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.erp_icbc.icbc_dsjMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class icbc_dsjServiceImpl implements icbc_dsjService {
	@Autowired
	private icbc_dsjMapper icbc_dsjMapper;

	@Override
	public void savekjs_icbc_dsj(PageData pd) {
		icbc_dsjMapper.savekjs_icbc_dsj(pd);
	}

	@Override
	public PageData findbyid(PageData pd) {
		return icbc_dsjMapper.findbyid(pd);
	}

	@Override
	public void upkjs_icbc_dsj(PageData pd) {
		icbc_dsjMapper.upkjs_icbc_dsj(pd);
	}

}
