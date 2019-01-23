package com.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import com.mapper.pdfoverMapper;
import com.model.pdfover;
@Service
//@Transactional
public class pdfoverServiceImpl extends BaseMySqlService implements pdfoverService{

	    @Resource
	    private pdfoverMapper pfm;
	
	
	@Override
	public void addpdf(pdfover po) {
		pfm.addpdf(po);
		
	}


	@Override
	public List<pdfover>  findbyname(String pdfname) {
		// TODO Auto-generated method stub
		return pfm.findbyname(pdfname);
	}


	@Override
	public void uppdf(pdfover po) {
		pfm.uppdf(po);
		
	}


	@Override
	public Map findbyid(String uid) {
		
		return pfm.findbyid(uid);
	}


	@Override
	public Map pdflist(String uid) {
		
		return pfm.pdflist(uid);
	}


	@Override
	public Map findpdfurl(String uid) {
		
		return pfm.findpdfurl(uid);
	}

}
