package com.service1.kjs_icbc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_cardk;
import com.model.icbc.icbc_result;
import com.model1.icbc.icbc_dk;

public interface icbc_dkService {
    //É¾³ý
	void del_icbc_dk(int id);
	//
	icbc_dk finddkbyorder(int icbc_id);
	//
	icbc_dk finddk2(int icbc_id);
	//
	void updk(icbc_dk icbc_dk);
	//
	icbc_dk findicbc_cardk(int icbc_id);
	//
	void addicbc_cardk(icbc_dk icbc_dk);
	//
	void upicbc_cardk(icbc_dk icbc_dk);
	// 
	List<icbc_dk> allfinddk();
	// 
	icbc_dk  finddkbyid(int id);
	//
	icbc_dk dkshbyid(int id);
	//
	icbc_dk findjj(int icbc_id);
	//
	icbc_dk findjj_status(int icbc_id);
	//
	List<icbc_dk> kjs_dk(int bc_status);
	//
	int kjs_dk_count();

}
