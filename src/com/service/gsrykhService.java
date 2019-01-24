package com.service;

import java.util.List;
import java.util.Map;

import com.model.gsrykh;

public interface gsrykhService {
	 //¿ª»§
	public void addgsrykh(gsrykh gsrykh);
	//
	public Map findgsrykh(String khgsname,
			 String khlevel,
			 String khrname,
			 String khsfznum,
			 String khphonenum);
	
	public Map fkhbyid(int id);
	public Map fgsrykh(String ckey);
	
	public void upkd(gsrykh gsrykh);
	
	public List<gsrykh> fgsrykhtogsrykh();
	
	public Map fgsrykhtoid(String khgsname);
	public List<gsrykh> fgsrykhtoid1(String khgsname);
	public List<gsrykh> fgsrykhname();
}
