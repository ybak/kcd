package com.service.guazi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper.guazi.GuaziRecordsMapper;
import com.model.guazi.GuaziRecords;
import com.model.jbapi.jbzxapiuser;
import com.util.Page;

@Service
public class GuaZiServiceImpl implements GuaZiService{
	@Autowired
	private GuaziRecordsMapper grm;
	@Override
	public List<jbzxapiuser> OneToArr(Page page) {
		// TODO Auto-generated method stub
		return grm.OneToArr(page);
	}

	@Override
	public int OneToArrCount() {
		// TODO Auto-generated method stub
		return grm.OneToArrCount();
	}

	@Override
	public int OneToArrCountSelective(Page page) {
		// TODO Auto-generated method stub
		return grm.OneToArrCountSelective(page);
	}

	@Override
	public int insert(GuaziRecords guazirecoreds) {
		// TODO Auto-generated method stub
		return grm.insert(guazirecoreds);
	}

	@Override
	public String selectbyid(String gid) {
		// TODO Auto-generated method stub
		return grm.selectbyid(gid);
	}
	
}
