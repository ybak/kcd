package com.mapper.icbc;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_kk;

public interface icbc_kkMapper {
    //
	void upicbc_kk(icbc_kk icbc_kk);
	//
	void addicbc_kk(icbc_kk icbc_kk);
    //
	icbc_kk findicbc_kkbyorder(@Param("icbc_id")int icbc_id);
}
