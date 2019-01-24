package com.service1.duoying;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.thjlMapper;
import com.model1.thjl;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)  
public class thjlServiceImpl implements thjlService{

	@Resource
	private thjlMapper thjlMapper;
	
	

	@Override
	public List<thjl> findthjlbyc_name(String c_name) {
		// TODO Auto-generated method stub
		return thjlMapper.findthjlbyc_name(c_name);
	}

	@Override
	public List<thjl> findthjl() {
		// TODO Auto-generated method stub
		return thjlMapper.findthjl();
	}

	@Override
	public thjl thjlmap(String c_name) {
		// TODO Auto-generated method stub
		return thjlMapper.thjlmap(c_name);
	}

}
