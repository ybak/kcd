package com.mapper;

import java.util.Map;

import com.model.img;

public interface imgMapper {
	
	 public void addimg(img img);
	 
	 public void upimg(img img);
	 
	 public Map fimg(String uid);
}
