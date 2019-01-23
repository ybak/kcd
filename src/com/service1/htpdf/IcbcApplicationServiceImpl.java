package com.service1.htpdf;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mapper1.htpdf.IcbcApplicationDaoMapper;


@Service
public class IcbcApplicationServiceImpl implements IcbcApplicationService{
	@Autowired
	IcbcApplicationDaoMapper iad;
	
	public List<Map<String,Object>> query1(int i){
		return iad.query1(i);
	}
	public void create1(String pdfname,int id){
		 iad.create1(pdfname, id);
	}
	
	 public List query2(String i){
		 return iad.query2(i);
	 }
	 public void create2(String excelpath,String id){
		 iad.create2(excelpath,id);
	 }
}
