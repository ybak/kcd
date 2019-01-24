package com.mapper.icbc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_zx;

public interface icbc_zxMapper {
    //
	void addicbc_zx(icbc_zx iz);
	//
	icbc_zx findicbc_zx(@Param("gems_code")String gems_code);
	//
	void upicbc_zxorder(icbc_zx iz);
	//
	List<icbc_zx> findicbc(@Param("bc_status")int bc_status);

}
