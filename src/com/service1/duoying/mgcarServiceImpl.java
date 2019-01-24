package com.service1.duoying;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.mgcarMapper;
import com.model1.mgcar;


@Service
@Transactional(value = "kcway2",isolation=Isolation.SERIALIZABLE,rollbackFor = Exception.class)  
public class mgcarServiceImpl implements mgcarService{

	@Resource
	private mgcarMapper mgcarMapper;
	
	@Override
	public List<mgcar> findmgcarbygems_code(String gems_code) {
		// TODO Auto-generated method stub
		return mgcarMapper.findmgcarbygems_code(gems_code);
	}

	@Override
	public List<mgcar> findmgcar() {
		// TODO Auto-generated method stub
		return mgcarMapper.findmgcar();
	}

}
