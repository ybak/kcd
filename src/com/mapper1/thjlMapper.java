package com.mapper1;

import java.util.List;


import com.model1.thjl;

public interface thjlMapper {

	//
	public List<thjl> findthjlbyc_name(String c_name);
	
	//
	public List<thjl> findthjl();
	
	public thjl thjlmap(String c_name);
}
