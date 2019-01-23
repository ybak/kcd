package com.service1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

public interface kj_icbc_resultService {
	// 查询抵押完成天数情况，对0-15天，15-30天，30-45天，45-60天，60天以上的进行分组查询
	public List<HashMap> SelectResult();
}
