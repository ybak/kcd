package com.service;

import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.mapper.imgMapper;
import com.model.img;
@Service
//@Transactional
public class imgServiceImpl extends BaseMySqlService implements imgService{
     @Resource
     private imgMapper imgmapper;	  
	
     
     @Override
	public void addimg(img img) {
		imgmapper.addimg(img);
	}
	
	
	@Override
	public void upimg(img img) {
		imgmapper.upimg(img);
		
	}


	@Override
	public Map fimg(String uid) {
		
		return imgmapper.fimg(uid);
	}

}
