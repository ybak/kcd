package com.service1.erp_icbc;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.erp_icbc.erp_loanBeforeMapper;
import com.model1.icbc.erp.PageData;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class erp_loanBeforeServiceImpl implements erp_loanBeforeService{
	@Resource
	private erp_loanBeforeMapper erp_loanBeforeMapper;
	
	@Override
	public List<PageData> findList(PageData pd) {
		// TODO Auto-generated method stub
		return erp_loanBeforeMapper.findList(pd);
	}

	@Override
	public PageData findById(PageData pd) {
		// TODO Auto-generated method stub
		return erp_loanBeforeMapper.findById(pd);
	}

}
