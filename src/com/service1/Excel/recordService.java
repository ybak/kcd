package com.service1.Excel;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.erp.PageData;
import com.util.Excel.RecordUtil;

public interface recordService {

	/**
	 * 查询数据库表中数据   并模糊查询
	 * @return
	 */
	List<PageData> selectRecord(@Param(value="param") String param,@Param("pd")PageData pd);
	/**
	 * 根据身份证号查询数据条数
	 * @param id_card
	 * @return
	 */
	int count(@Param("id_card") String id_card);
	/**
	 * 通过身份证号查询到逾期客户
	 * @param id_card
	 * @return
	 */
	List<Map> selectOverdue(@Param("id_card") String id_card );
	/**
	 * 把逾期客户名单添加到表中
	 * @param overdueMap
	 * @return
	 */
	int addOverdue(Map map);


}
