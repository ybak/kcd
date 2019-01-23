package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mapper.apply_mxMapper;
import com.model.apply_mx;

@Service
public class apply_mxServiceImpl implements apply_mxService{

	
	@Resource
	private apply_mxMapper apply_mxmpper;
 	
	@Override
	public void addapply_mx(apply_mx apply_mx) {
		apply_mxmpper.addapply_mx(apply_mx);
		
	}

}
