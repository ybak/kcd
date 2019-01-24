package com.service1.kjs_icbc;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.icbc1.ftpzipMapper;
import com.model1.icbc.icbc_ftpzip;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class ftpzipServiceImpl implements ftpzipService{

	 @Resource
	 private ftpzipMapper ftpzipMapper;
	
	@Override
	public void upftpzip(icbc_ftpzip icbc_ftpzip) {
		ftpzipMapper.upftpzip(icbc_ftpzip);
		
	}

	@Override
	public void addftpzip(icbc_ftpzip icbc_ftpzip) {
		ftpzipMapper.addftpzip(icbc_ftpzip);
		
	}

	@Override
	public icbc_ftpzip findftpzipbyzip_name(String zipname) {
		
		return ftpzipMapper.findftpzipbyzip_name(zipname);
	}

	@Override
	public icbc_ftpzip findftpzipbyicbc_id(int icbc_id) {
		
		return ftpzipMapper.findftpzipbyicbc_id(icbc_id);
	}

}
