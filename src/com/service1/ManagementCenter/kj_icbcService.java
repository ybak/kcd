package com.service1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

public interface kj_icbcService {
	//每月报单总量
	public List<HashMap> SelectBill();
	//每月放款单数,总金额
	public List<HashMap> SelectLoan();
	//每月已放款未抵押单数,总金额
	public List<HashMap> SelectFk();
	//每月总订单各省排名
	public List<HashMap> SelectStates();
	//每月总订单各省排名
	public List<HashMap> SelectGems();
	//每月总订单各省排名
	public List<HashMap> SelectLoanStates();
	//每月总订单各省排名
	public List<HashMap> SelectLoanGems();
	//折线图数据
	public List<HashMap> SelectChart();
	//贷款金额区间扇形图
	public List<HashMap> SelectMoneyDistribute();
	//征信通过率查询
	public List<HashMap> SelectCredit();
	//客户年龄查询统计
	public List<HashMap> SelectClientAge();
	//新车年龄查询统计
	public List<HashMap> SelectCarsAge();
	//垫资天数分布图
	public List<HashMap> SelectAdvanceFund();
	//抵押材料回收情况
	public List<HashMap> SelectRecycle();
	//二手车每月放款单数和总金额
	public List<HashMap> SelectOldCars();
	//新车每月放款单数和总金额
	public List<HashMap> SelectNewCars();
}
