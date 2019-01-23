package com.service1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

public interface kjs_icbc_cardkService {
	//每月汽车贷款总订单数
	public int CountSelect();
	//每月汽车贷款过件单数
	public int CountPass();
	//每月汽车贷款各省市全部件数及过件数
	public List<HashMap> SelectCarPassComm();
	//每月汽车贷款各代理商全部件数及过件数
	public List<HashMap> SelectCarPassGems();
	//汽车贷款折线图
	public List<HashMap> SelectChart();
	//汽车放款分布扇形图
	public List<HashMap> SelectCarFk();
}
