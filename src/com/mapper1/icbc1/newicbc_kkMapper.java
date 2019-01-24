package com.mapper1.icbc1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_kk;

public interface newicbc_kkMapper {
	//É¾³ý
	public void del_icbc_kk(@Param("id") int id);
	//
	icbc_kk findicbc_kk2(@Param("icbc_id")int icbc_id);
	//
	icbc_kk findicbc_kkbyid(@Param("icbc_id")int icbc_id);
	//
	void upkk(icbc_kk icbc_kk);
	// 
	List<icbc_kk> allfindicbc_kk();
	//
	void upicbc_kk(icbc_kk icbc_kk);
	//
	void addicbc_kk(icbc_kk icbc_kk);
	//
	icbc_kk findicbc_kkbyorder(@Param("icbc_id")int icbc_id);
	//
	icbc_kk findkkbyid(@Param("id")int id);
	//
	icbc_kk kkshbyid(@Param("id")int id);
    //
	List<icbc_kk> kjs_kk(@Param("bc_status")int bc_status);
	//
	int kjs_kk_count();
}
