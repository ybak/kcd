package com.service1.duoying;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.fsdyMapper;
import com.model1.fsdy;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)  
public class fsdyServiceImpl implements fsdyService{

	@Resource
	private fsdyMapper fsdyMapper;
	
	@Override
	public List<fsdy> findfsdybyid(int id) {
		// TODO Auto-generated method stub
		return fsdyMapper.findfsdybyid(id);
	}

	@Override
	public List<fsdy> findfsdy() {
		// TODO Auto-generated method stub
		return fsdyMapper.findfsdy();
	}

}
