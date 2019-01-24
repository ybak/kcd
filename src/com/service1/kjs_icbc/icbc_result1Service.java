package com.service1.kjs_icbc;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_result;

public interface icbc_result1Service {
	//添加日志
		public void addicbc_result(icbc_result icbc_result);
		    //添加日志
			public void addzx_result(icbc_result icbc_result);
			//添加日志
			public void addkk_result(icbc_result icbc_result);
			//添加日志
			public void addcardk_result(icbc_result icbc_result);
			//添加日志
			public void addpreaudit_result(icbc_result icbc_result);

		    //根据id查询
		    public List<icbc_result> findresultbyqryid(int qryid);
		    //根据id查询
			public List<icbc_result> findzxbyqryid(int qryid);
			//根据id查询
			public List<icbc_result> findkkbyqryid(int qryid);
			//根据id查询
			public List<icbc_result> findcardkbyqryid(int qryid);
			//根据id查询
			public List<icbc_result> findpreauditbyqryid(int qryid);
            //
			icbc_result lastfindresult(int qryid);
			//
			icbc_result kklastfindresult(int qryid);
			//
			icbc_result dklastfindresult(int qryid);
}
