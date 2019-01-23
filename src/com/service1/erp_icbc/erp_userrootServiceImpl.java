package com.service1.erp_icbc;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.erp_icbc.erp_userrootMapper;
import com.model1.icbc.erp.PageData;
import com.util.pagedate;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class erp_userrootServiceImpl implements erp_userrootService{

	 @Resource
	 private  erp_userrootMapper erp_userrootMapper; 
	
	@Transactional
	public void save(PageData pd) {
		erp_userrootMapper.save(pd);
	}

	@Override
	public List<PageData> findtolist(PageData pd) {
		
		return erp_userrootMapper.findtolist(pd);
	}

	@Override
	public PageData findbyid(PageData pd) {
		return erp_userrootMapper.findbyid(pd);
	}
	
	@Transactional
	public void deletebyid(PageData pd) {
	erp_userrootMapper.deletebyid(pd);
	}

	@Transactional
	public void updatebyid(PageData pd) {
		erp_userrootMapper.updatebyid(pd);
		
	}

	

}
