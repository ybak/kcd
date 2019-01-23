package com.service.icbc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_zx;

public interface icbc_zxService {
	    //
		void addicbc_zx(icbc_zx iz);
		//
		icbc_zx findicbc_zx(String gems_code);
		//
		void upicbc_zxorder(icbc_zx iz);
		//
		List<icbc_zx> findicbc(int bc_status);
}
