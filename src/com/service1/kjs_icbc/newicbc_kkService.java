package com.service1.kjs_icbc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_kk;

public interface newicbc_kkService {
	//É¾³ý
	public void del_icbc_kk(int id);
	//
	icbc_kk findicbc_kkbyid(int icbc_id);
	//
	icbc_kk findicbc_kk2(int icbc_id);
	//
	void upkk(icbc_kk icbc_kk);
	//
	void upicbc_kk(icbc_kk icbc_kk);
	//
	void addicbc_kk(icbc_kk icbc_kk);
	//
	icbc_kk findicbc_kkbyorder(int icbc_id);
	//
	List<icbc_kk> allfindicbc_kk();
	//
	icbc_kk findkkbyid(int id);
	//
	icbc_kk kkshbyid(int id);
	//
	List<icbc_kk> kjs_kk(int bc_status);
	//
	int kjs_kk_count();
}
