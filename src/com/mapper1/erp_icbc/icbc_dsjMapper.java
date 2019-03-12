package com.mapper1.erp_icbc;

import com.model1.icbc.erp.PageData;

public interface icbc_dsjMapper {

	void savekjs_icbc_dsj(PageData pd);

	PageData findbyid(PageData pd);

	void upkjs_icbc_dsj(PageData pd);
}
