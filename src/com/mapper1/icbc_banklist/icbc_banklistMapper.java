package com.mapper1.icbc_banklist;

import java.util.List;

import com.model1.icbc.erp.PageData;

public interface icbc_banklistMapper {

	// 获取icbc_banklist 所有信息
	List<PageData> geticbc_banklist();

	// 添加
	void saveicbc_banklist(PageData pd);

	// 编辑
	void upicbc_banklist(PageData pd);

	// 根据fsid查询
	List<PageData> geticbc_banklistbyID(PageData pd);

	PageData geticbc_bank(int id);
}
