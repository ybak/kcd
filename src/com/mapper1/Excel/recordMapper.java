package com.mapper1.Excel;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.erp.PageData;
import com.util.Excel.RecordUtil;

public interface recordMapper {
	/**
	 * 把导入记录添加到数据库
	 * @param list
	 * @return
	 */
	int addRecord(Map map);
	/**
	 * 查询数据库表中数据   并模糊查询
	 * @return
	 */
	List<PageData> selectRecord(@Param(value="param") String param,@Param("pd")PageData pd);
	


}
