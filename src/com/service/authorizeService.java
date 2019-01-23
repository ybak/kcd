package com.service;

import java.util.List;

import com.model.authorize;

public interface authorizeService {
	public List<authorize> fauthorize(int aid);
	
	
	public void upaid(authorize authorize);
}
