package com.service1.kjs_icbc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.icbc1.newicbc_preauditMapper;
import com.model.icbc.icbc_preaudit;
import com.model.icbc.icbc_zx;
@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class newicbc_preauditServiceImpl implements newicbc_preauditService{
    
        @Resource
        private newicbc_preauditMapper icbc_preauditMapper;

	@Override
	public void addpreaudit(icbc_preaudit ip) {		
		icbc_preauditMapper.addpreaudit(ip);
	}

	@Override
	public void uppreaudit(icbc_preaudit ip) {
		icbc_preauditMapper.uppreaudit(ip);
		
	}

	@Override
	public icbc_preaudit findpreauditbyorder(int icbc_id) {		
		return icbc_preauditMapper.findpreauditbyorder(icbc_id);
	}

	@Override
	public icbc_preaudit findpreauditbyid(int icbc_id) {
		
		return icbc_preauditMapper.findpreauditbyid(icbc_id);
	}



}
