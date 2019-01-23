package com.service1.erp_icbc;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.erp_icbc.erp_fiveModelMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class erp_fiveModelServiceImpl implements erp_fiveModelService{

	 @Resource
	 private  erp_fiveModelMapper erp_fiveModelMapper;
	
	@Transactional
	public void save(PageData pd) {
		erp_fiveModelMapper.save(pd);
	}

	@Override
	public List<PageData> findtolist(PageData pd) {
		
		return erp_fiveModelMapper.findtolist(pd);
	}

	@Override
	public PageData findbyid(PageData pd) {
		return erp_fiveModelMapper.findbyid(pd);
	}
	
	@Transactional
	public void deletebyid(PageData pd) {
		erp_fiveModelMapper.deletebyid(pd);
	}

	@Override
	public void updatebyid(PageData pd) {
		erp_fiveModelMapper.updatebyid(pd);
		
	}

}
