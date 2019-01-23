package com.service.zx;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.zx.jbzxhistoryMapper;
import com.model.jbapi.jbzxapihistory;
@Service
public class jbzxhistoryServiceImpl implements jbzxhistoryService{
   @Resource
   private jbzxhistoryMapper jbzxhistorymapper;

@Override
public void addjbzxhistory(jbzxapihistory jbzxapihistory) {
	jbzxhistorymapper.addjbzxhistory(jbzxapihistory);
	
}

@Override
public List<jbzxapihistory> jbzxapihistorylist(int jbzx_id) {
	
	return jbzxhistorymapper.jbzxapihistorylist(jbzx_id);
}
   
   
	
}
