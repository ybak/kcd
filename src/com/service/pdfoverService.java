package com.service;

import java.util.List;
import java.util.Map;

import com.model.pdfover;

public interface pdfoverService {
	//添加 pdf数据
    public void addpdf(pdfover po);
    
    public List<pdfover> findbyname(String pdfname);
    public void uppdf(pdfover po);
  //根据uid 查询数据   
    public Map findbyid(String uid);
  //根据uid 查询数据   
    public Map pdflist(String uid);
    
    public Map findpdfurl(String uid);
}
