package com.service;

import java.util.List;
import java.util.Map;

import com.model.gskh;

public interface gskhService {
	    //公司开户
		public void addgskh(gskh gskh);
		//查询公司信息
		public Map sltgskh(String name,String ncode);
		//查询公司名称
		public List<gskh> fgsname();
		
		public Map fgsname1(String name);
		
		public Map fgsbyid(int id);
		
		//
		public void upgskhkd(gskh gskh);
}
