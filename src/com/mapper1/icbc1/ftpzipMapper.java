package com.mapper1.icbc1;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.icbc_ftpzip;

public interface ftpzipMapper {
    
	
	void upftpzip(icbc_ftpzip icbc_ftpzip);
	
	void addftpzip(icbc_ftpzip icbc_ftpzip);
	
	icbc_ftpzip findftpzipbyzip_name(@Param("zip_name")String zip_name);
	
	icbc_ftpzip findftpzipbyicbc_id(@Param("icbc_id")int icbc_id);
}
