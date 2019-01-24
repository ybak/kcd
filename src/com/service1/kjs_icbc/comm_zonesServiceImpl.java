package com.service1.kjs_icbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.icbc1.comm_zonesMapper;
import com.model1.city.comm_zones;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class comm_zonesServiceImpl implements comm_zonesService{

	 @Autowired
	 private comm_zonesMapper comm_zonesMapper;
	
	public comm_zones findcomm_zones(int id) {
		// TODO Auto-generated method stub
		return comm_zonesMapper.findcomm_zones(id);
	}

	public List<comm_zones> findallcomm_zones() {
		// TODO Auto-generated method stub
		return comm_zonesMapper.findallcomm_zones();
	}

	@Override
	public List<comm_zones> findcomm_zonesbyid(int shengid, int cityid) {

		return comm_zonesMapper.findcomm_zonesbyid(shengid,cityid);
	}

	

}
