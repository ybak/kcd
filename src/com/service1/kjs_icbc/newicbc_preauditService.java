package com.service1.kjs_icbc;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_preaudit;

public interface newicbc_preauditService {
	   //
	   void addpreaudit(icbc_preaudit ip);
	   //
	   void uppreaudit(icbc_preaudit ip);
	   //
	   icbc_preaudit findpreauditbyorder(int icbc_id);
	   
	   icbc_preaudit findpreauditbyid(int icbc_id);
}
