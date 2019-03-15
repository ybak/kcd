package com.mapper1.Repayment;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.erp.PageData;

public interface OverdueMapper1 {
	/**
	 * 查询逾期名单
	 * @param param
	 * @param pd
	 * @return
	 */
	List<PageData> selectoverdue(@Param("param")String param,@Param("pd")PageData pd,@Param("fsid") int fsid,@Param("fs_id") int fs_id);
}
