package com.controller.erp_icbc.loanAfter;

import com.model1.icbc.erp.PageData;

/**
 * 添加逾期客户操作记录
 * @author 三十画生
 * 2019-3-21
 */
public class AddResult {
	//从逾期手动点击进入电催名单
	public static PageData addResult(PageData pdsession,PageData pdOne){
		PageData addResult = new PageData();
		addResult.put("qryid",pdOne.get("id"));
		addResult.put("mid_add",pdsession.get("id"));
		addResult.put("mid_edit",pdsession.get("id"));
		addResult.put("type_id",pdOne.get("type_id"));
		addResult.put("type_status",pdOne.get("type_status"));
		addResult.put("remark", "手动点击,逾期客户进入电催");
		addResult.put("result_msg", "手动点击,逾期客户进入电催");
		addResult.put("icbc_id", pdOne.get("icbc_id"));
		addResult.put("result_value",addResult.toString());
		return addResult;
	}
}
