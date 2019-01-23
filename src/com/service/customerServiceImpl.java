package com.service;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.customerMapper;
import com.model.customer;
@Service
//@Transactional
public class customerServiceImpl extends BaseMySqlService implements customerService{
	@Resource
    private customerMapper ccm;

	@Override
	public void addperson(customer customer) {
		ccm.addperson(customer);
		
	}

	@Override
	public List<customer> findbycompany(String owencompany) {
		
		return ccm.findbycompany(owencompany);
	}

	@Override
	public List<customer> findbylevel(String level,String owencompany) {
		List<customer> result=new ArrayList();
		result=ccm.findbylevel(level, owencompany);
		
		return result;
	}

	@Override
	public int keypeople(String ckey) {
		int keynum=ccm.keypeople(ckey);
		return keynum;
	}

}
