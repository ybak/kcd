package com.service1.htpdf;
import java.util.List;
import java.util.Map;

public interface IcbcApplicationService{
	 public List<Map<String,Object>> query1(String i);
	 public void create1(String pdfname,int id);
	 public List query2(String i);
	 public void create2(String pdfpath,String id);
}

