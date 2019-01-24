package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.gskhMapper;
import com.model.gskh;

@Service
public class gskhServiceImpl implements gskhService{

	@Resource
	private gskhMapper gskhmapper;

	@Override
	public void addgskh(gskh gskh) {
		gskhmapper.addgskh(gskh);
		
	}

	@Override
	public Map sltgskh(String name, String ncode) {
		
		return gskhmapper.sltgskh(name, ncode);
	}

	@Override
	public List<gskh> fgsname() {
		
		return gskhmapper.fgsname();
	}

	@Override
	public Map fgsname1(String name) {
		
		return gskhmapper.fgsname1(name);
	}

	@Override
	public Map fgsbyid(int id) {
	
		return gskhmapper.fgsbyid(id);
	}

	@Override
	public void upgskhkd(gskh gskh) {
		gskhmapper.upgskhkd(gskh);
		
	}
	
	
	
	
}
