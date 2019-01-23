package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.ywMapper;
import com.model.yw;
@Service
//@Transactional
public class ywServiceImpl extends BaseMySqlService implements ywService {
    @Resource
    private ywMapper ywmapper;
	
	@Override
	public void saveyw(yw yw) {
		ywmapper.saveyw(yw);

	}

	@Override
	public List<yw> fywlist() {
		
		return ywmapper.fywlist();
	}

}
