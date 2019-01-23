package com.mapper1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

public interface kj_icbcMapper {
	//每月报单总量
	public List<HashMap> selectbill();
	//每月放款单数,总金额
	public List<HashMap> selectloan();
	//每月已放款未抵押单数,总金额
	public List<HashMap> selectfk();
	//每月总订单各省排名
	public List<HashMap> selectstates(); 
	//每月总订单各代理商排名
	public List<HashMap> selectgems(); 
	//每月总订单各省排名
	public List<HashMap> selectloanstates(); 
	//每月总订单各代理商排名
	public List<HashMap> selectloangems(); 
	//折线图数据
	public List<HashMap> selectchart();
	//贷款金额区间扇形图
	public List<HashMap> selectmoneydistribute();
	//征信通过率查询
	public List<HashMap> selectcredit();
	//客户年龄查询统计
	public List<HashMap> selectclientage();
	//新车年龄查询统计
	public List<HashMap> selectcarsage();
	//垫资天数分布图
	public List<HashMap> selectadvancefund();
	//抵押材料回收情况
	public List<HashMap> selectrecycle();
	//二手车每月放款单数和总金额
	public List<HashMap> selectoldcars();
	//新车每月放款单数和总金额
	public List<HashMap> selectnewcars();
	
}
