package com.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.companyMapper;
import com.mapper.customerMapper;
import com.model.company;
@Service
//@Transactional
public class companyServiceImpl extends BaseMySqlService implements companyService{

	 @Resource
	 private companyMapper  cpm;
	 @Resource
	 private customerMapper ctm;

	@Override
	public void addcompany(company company) {
		cpm.addcompany(company);
		
	}

	@Override
	public Map findcompany(String company) {
	
		return cpm.findcompany(company);
	}

	@Override
	public void upcompany(company company) {
		cpm.upcompany(company);
		
	}

	@Override
	public int ckynum(String cky) {
		int keynum=cpm.ckynum(cky);
		return keynum;
	}

	@Override
	public Map ckymap(String ckey) {
	Map cm=	cpm.ckymap(ckey);
	Map cm2=ctm.ckymap1(ckey);
	Map cm3=new HashMap();
	Map cm4=new HashMap();
	if(cm2!=null&&cm2.size()!=0){
		System.out.println(cm2.size());
		
		cm3=cpm.findcompany(cm2.get("owencompany").toString());
		
		cm4.put("kd", cm3.get("beans"));
		cm4.put("company",cm2.get("owencompany").toString());
		cm4.put("name",cm2.get("name").toString());
		cm4.put("level",cm2.get("level").toString());
	}
	else{	
		System.out.println(cm.size());
		cm4.put("kd",cm.get("beans"));
		cm4.put("company",cm.get("company"));		
	}
	return cm4;
	
		
	}
	
	

}
