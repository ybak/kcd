package com.mapper1.Excel;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface uploadExcelMapper {

	/**
	 * 往数据库中添加表中数据
	 * @param list
	 * @return
	 */
	int addExcel(Map map); 
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
	 * @param map
	 * @return
	 */
	int addOverdue(Map map);
	
}
