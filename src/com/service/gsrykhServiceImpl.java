package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.gsrykhMapper;
import com.model.gsrykh;
@Service
//@Transactional
public class gsrykhServiceImpl extends BaseMySqlService implements gsrykhService{

	
	 @Resource
	 private gsrykhMapper gsrykhmapper;
	 

	@Override
	public void addgsrykh(gsrykh gsrykh) {
		gsrykhmapper.addgsrykh(gsrykh);
		
	}

	
	@Override
	public Map findgsrykh(String khgsname, String khlevel, String khrname, String khsfznum, String khphonenum) {
		
		return gsrykhmapper.findgsrykh(khgsname, khlevel, khrname, khsfznum, khphonenum);
	}

	
	@Override
	public Map fgsrykh(String ckey) {
	
		return gsrykhmapper.fgsrykh(ckey);
	}

	
	@Override
	public void upkd(gsrykh gsrykh) {
		gsrykhmapper.upkd(gsrykh);
		
	}

	
	@Override
	public List<gsrykh> fgsrykhtogsrykh() {
		
		return gsrykhmapper.fgsrykhtogsrykh();
	}

	
	@Override
	public Map fgsrykhtoid(String khgsname) {
		
		return gsrykhmapper.fgsrykhtoid(khgsname);
	}

	
	@Override
	public List<gsrykh> fgsrykhname() {
		
		return gsrykhmapper.fgsrykhname();
	}

	
	@Override
	public List<gsrykh> fgsrykhtoid1(String khgsname) {
		
		return gsrykhmapper.fgsrykhtoid1(khgsname);
	}


	@Override
	public Map fkhbyid(int id) {		
		return gsrykhmapper.fkhbyid(id);
	}

}
