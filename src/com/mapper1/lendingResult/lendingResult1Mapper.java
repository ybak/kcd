package com.mapper1.lendingResult;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.model1.icbc.erp.PageData;

public interface lendingResult1Mapper {
	/**
		 * 查询所有数据并模糊查询
		 * @param param
		 * @param pd
		 * @return
		 */
		List<PageData> selectlendingResult1(@Param(value="param") String param,@Param("pd")PageData pd);
		/**
		 * 添加前查询列表页
		 * @param c_cardno
		 * @return
		 */
		Map<String, Object> selectCardno(@Param("c_cardno") String c_cardno);
		/**
		 * 查询详情页
		 * @param id_card
		 * @param periods
		 * @return
		 */
		List<Map> selectdetail(@Param("id_card") String id_card,@Param("periods") String periods);
		/**
		 * 查询用户信息是否在表中有相同数据
		 * @param id_card
		 * @return
		 */
		Map<String, Object> selectconfirm(String id_card);
		/**
		 * 修改状态
		 * @param id_card
		 * @param periods
		 * @return
		 */
		int updateflag(@Param("id_card") String id_card,@Param("periods") String periods,@Param("dcdate") String dcdate,@Param("myyh") String myyh);
		/**
		 * 添加数据到表中
		 * @param map
		 * @return
		 */
		int addlendingResult1(Map<String, Object> map);
		/**
		 * 添加还款计划到表中
		 * @param map
		 * @return
		 */
		int adddetail1(Map<String, Object> map);
		/**
		 * 修改import_repayment表中状态
		 */
		int updatestate(@Param("id_card") String id_card,@Param("periods") String periods,@Param("dcdate") String dcdate);
		/**
		 * 修改partner_details表中状态
		 */
		int updatedetail1(@Param("id_card") String id_card,@Param("periods") String periods,@Param("dcdate") String dcdate);
		/**
		 * 修改partner_details表中状态
		 */
		int updatedetail(@Param("id_card") String id_card,@Param("periods") String periods,@Param("dcdate") String dcdate);
}

