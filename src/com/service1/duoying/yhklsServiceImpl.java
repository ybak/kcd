package com.service1.duoying;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.yhklsMapper;
import com.model1.yhkls;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class yhklsServiceImpl implements yhklsService{

	@Resource
	private yhklsMapper yhklsMapper;
	
	

	@Override
	public List<yhkls> findyhklsbyc_name(String c_name) {
		// TODO Auto-generated method stub
		return yhklsMapper.findyhklsbyc_name(c_name);
	}

	@Override
	public List<yhkls> findyhkls() {
		// TODO Auto-generated method stub
		return yhklsMapper.findyhkls();
	}

}
