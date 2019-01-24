package com.mapper1.icbc1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.icbc_dk;

public interface icbc_dkMapper {
    //É¾³ý
	void del_icbc_dk(@Param("id")int id);
	//
	icbc_dk finddkbyorder(@Param("icbc_id")int icbc_id);
	//
	icbc_dk finddk2(@Param("icbc_id")int icbc_id);
	//
	void updk(icbc_dk icbc_dk);	
	//
	icbc_dk	findicbc_cardk(@Param("icbc_id")int icbc_id);
	//
	void addicbc_cardk(icbc_dk icbc_dk);
	//
	void upicbc_cardk(icbc_dk icbc_dk);
	// 
	List<icbc_dk> allfinddk();
	//
	icbc_dk  finddkbyid(@Param("id")int id);
	//
	icbc_dk dkshbyid(@Param("id")int id);
	//
	icbc_dk findjj(@Param("icbc_id")int icbc_id);
	//
	icbc_dk findjj_status(@Param("icbc_id")int icbc_id);
	//
	List<icbc_dk> kjs_dk(@Param("bc_status")int bc_status);
	//
	int kjs_dk_count();
}
