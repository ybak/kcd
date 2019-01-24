package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.ykdbbMapper;
import com.model.ykdbb;
@Service
//@Transactional
public class ykdbbServiceImpl extends BaseMySqlService implements ykdbbService{
	@Resource
    private ykdbbMapper ykdbbmapper;
	@Override
	public List<ykdbb> findbydate(Map<String, String> mdate) {
		
		return ykdbbmapper.findbydate(mdate);
	}

}
