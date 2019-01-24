package com.mapper.icbc;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_cardk;

public interface icbc_cardkMapper {
 //
 icbc_cardk	findicbc_cardk(@Param("icbc_id")int icbc_id);
 //
 void addicbc_cardk(icbc_cardk icbc_cardk);
 //
 void upicbc_cardk(icbc_cardk icbc_cardk);
}
