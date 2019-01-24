package com.service1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

import com.model1.ManagementCenter.assess_fs;
import com.model1.ManagementCenter.kj_icbc;

public interface kj_icbcService {
	//每月报单总量
	public List<HashMap> SelectBill(assess_fs ass_fs);
	
	//每月放款单数,总金额
	public List<HashMap> SelectLoan(assess_fs ass_fs);
	
	//每月已放款未抵押单数,总金额
	public List<HashMap> SelectFk(assess_fs ass_fs);
	
	//每月总订单各省排名
	public List<HashMap> SelectStates(assess_fs ass_fs);
	
	//每月总订单各代理商排名
	public List<HashMap> SelectGems(assess_fs ass_fs);
	
	//每月放款订单各省排名
	public List<HashMap> SelectLoanStates(assess_fs ass_fs);
	
	//每月放款订单各代理商排名
	public List<HashMap> SelectLoanGems(assess_fs ass_fs);
	
	//折线图数据
	public List<HashMap> SelectChart(assess_fs ass_fs);
	
	//贷款金额区间扇形图
	public List<HashMap> SelectMoneyDistribute(assess_fs ass_fs);
	
	//征信通过率查询
	public List<HashMap> SelectCredit(assess_fs ass_fs);
	
	//客户年龄查询统计
	public List<HashMap> SelectClientAge(assess_fs ass_fs);
	
	//新车年龄查询统计
	public List<HashMap> SelectCarsAge(assess_fs ass_fs);
	
	//垫资天数分布图
	public List<HashMap> SelectAdvanceFund(assess_fs ass_fs);
	
	//抵押材料回收情况
	public List<HashMap> SelectRecycle(assess_fs ass_fs);
	
	//二手车每月放款单数和总金额
	public List<HashMap> SelectOldCars(assess_fs ass_fs);
	
	//新车每月放款单数和总金额
	public List<HashMap> SelectNewCars(assess_fs ass_fs);
	
	
	
	
	
	// 查询抵押完成天数情况，对0-15天，15-30天，30-45天，45-60天，60天以上的进行分组查询
	public List<HashMap> SelectResult(assess_fs ass_fs);
	
	
	
	
	
	//每月汽车贷款总订单数
	public int CountSelect(assess_fs ass_fs);
	
	//每月汽车贷款过件单数
	public int CountPass(assess_fs ass_fs);
	
	//每月汽车贷款各省市过件率
	public List<HashMap> SelectCarPassComm(assess_fs ass_fs);
	
	//每月汽车贷款各代理商过件率
	public List<HashMap> SelectCarPassGems(assess_fs ass_fs);
	
	//汽车贷款折线图
	public List<HashMap> SelectCarChart(assess_fs ass_fs);
	
	//汽车放款分布扇形图
	public List<HashMap> SelectCarFk(assess_fs ass_fs);
}
