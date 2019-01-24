package com.mapper1.icbc1;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_preaudit;

public interface newicbc_preauditMapper {
   //
   void addpreaudit(icbc_preaudit ip);
   //
   void uppreaudit(icbc_preaudit ip);
   //
   icbc_preaudit findpreauditbyorder(@Param("icbc_id")int icbc_id);
   
   icbc_preaudit findpreauditbyid(@Param("icbc_id")int icbc_id);
   //
   icbc_preaudit findlastid();
}
