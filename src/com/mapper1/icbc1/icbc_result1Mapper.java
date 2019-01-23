package com.mapper1.icbc1;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model.icbc.icbc_result;

public interface icbc_result1Mapper {

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
	public List<icbc_result> findresultbyqryid(@Param("qryid")int qryid);
	    //根据id查询
		public List<icbc_result> findzxbyqryid(@Param("qryid")int qryid);
		//根据id查询
		public List<icbc_result> findkkbyqryid(@Param("qryid")int qryid);
		//根据id查询
		public List<icbc_result> findcardkbyqryid(@Param("qryid")int qryid);
		//根据id查询
		public List<icbc_result> findpreauditbyqryid(@Param("qryid")int qryid);

		icbc_result lastfindresult(@Param("qryid")int qryid);
		
		icbc_result kklastfindresult(@Param("qryid")int qryid);
		
		icbc_result dklastfindresult(@Param("qryid")int qryid);
		
}
