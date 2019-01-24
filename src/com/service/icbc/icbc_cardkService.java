package com.service.icbc;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_cardk;

public interface icbc_cardkService {
	 //
	 icbc_cardk	findicbc_cardk(int icbc_id);
	 //
	 void addicbc_cardk(icbc_cardk icbc_cardk);
	 //
	 void upicbc_cardk(icbc_cardk icbc_cardk);
}
