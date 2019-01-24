package com.mapper1.htpdf;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IcbcApplicationDaoMapper {
	 public List<Map<String,Object>> query1(int i);
	 public void create1(@Param("pdfpath")String pdfpath,@Param("id")int id);
	 public List query2(String i);
	 public void create2(@Param("excelpath")String pdfpath,@Param("id")String id);

}
