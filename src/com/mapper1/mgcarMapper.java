package com.mapper1;



import java.util.List;
import com.model1.mgcar;



public interface mgcarMapper {
	
    //根据编号查询表中数据
	public List<mgcar> findmgcarbygems_code(String gems_code);
	
     //查询全部数据
	public List<mgcar> findmgcar();
	
	

}
