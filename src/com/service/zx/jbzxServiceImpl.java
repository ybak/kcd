package com.service.zx;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.zx.jbzxMapper;
import com.model.zxjb;




@Service
public class jbzxServiceImpl implements jbzxService{
     @Resource
	 private jbzxMapper jbzxmapper;

	@Override
	public void addjbzx(zxjb zxjb) {
		jbzxmapper.addjbzx(zxjb);
		
	}

	@Override
	public void upzxjb(zxjb zxjb) {
		jbzxmapper.upzxjb(zxjb);
		
	}

	@Override
	public zxjb findzxjb(String gems_code) {
		
		return jbzxmapper.findzxjb(gems_code);
	}

	@Override
	public List<zxjb> jbzxlist() {
		
		return jbzxmapper.jbzxlist();
	}

	@Override
	public zxjb findjbzxbyid(int id) {
		
		return jbzxmapper.findjbzxbyid(id);
	}
	


}
