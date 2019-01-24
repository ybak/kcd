package com.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.bbMapper;
import com.model.bb;
@Service
//@Transactional
public class bbServiceImpl extends BaseMySqlService implements bbService{
    
	 @Resource
	 private bbMapper  bbm;
	
	@Override
	public void addbb(bb bb) {
		bbm.addbb(bb);
		
	}

	@Override
	public Map findbb(String orderid) {
		
		return bbm.findbb(orderid);
	}

	@Override
	public void upbbxx(bb bb) {
		bbm.upbbxx(bb);
		
	}

}
