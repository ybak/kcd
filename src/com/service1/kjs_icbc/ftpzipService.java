package com.service1.kjs_icbc;


import com.model1.icbc.icbc_ftpzip;

public interface ftpzipService {
	
	void upftpzip(icbc_ftpzip icbc_ftpzip);
	
	void addftpzip(icbc_ftpzip icbc_ftpzip);
	
	
	icbc_ftpzip findftpzipbyzip_name(String zipname);
	
	icbc_ftpzip findftpzipbyicbc_id(int icbc_id);
}
