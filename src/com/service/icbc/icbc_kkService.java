package com.service.icbc;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_kk;

public interface icbc_kkService {
    //
	void upicbc_kk(icbc_kk icbc_kk);
	//
	void addicbc_kk(icbc_kk icbc_kk);
    //
	icbc_kk findicbc_kkbyorder(int icbc_id);
}
