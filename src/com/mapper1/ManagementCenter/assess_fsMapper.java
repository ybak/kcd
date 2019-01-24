package com.mapper1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

import com.model1.ManagementCenter.assess_fs;

public interface assess_fsMapper {
	
	//每月总订单各代理商排名
	public List<HashMap> selectgems(assess_fs ass_fs); 
	
	
	//每月放款订单各代理商排名
	public List<HashMap> selectloangems(assess_fs ass_fs); 
	
	
	//每月汽车贷款各代理商全部件数及过件数
	public List<HashMap> selectcarpassgems(assess_fs ass_fs);
	
	
	
	//每月报单总量
	public List<HashMap> selectbill(assess_fs ass_fs);
	
	//每月放款单数,总金额
	public List<HashMap> selectloan(assess_fs ass_fs);
	
	//每月已放款未抵押单数,总金额
	public List<HashMap> selectfk(assess_fs ass_fs);
	
	//每月总订单各省排名
	public List<HashMap> selectstates(assess_fs ass_fs); 
	
	
	//每月放款订单各省排名
	public List<HashMap> selectloanstates(assess_fs ass_fs); 
	

	
	//折线图数据
	public List<HashMap> selectchart(assess_fs ass_fs);
	
	//贷款金额区间扇形图
	public List<HashMap> selectmoneydistribute(assess_fs ass_fs);
	
	//征信通过率查询
	public List<HashMap> selectcredit(assess_fs ass_fs);
	
	//客户年龄查询统计
	public List<HashMap> selectclientage(assess_fs ass_fs);
	
	//新车年龄查询统计
	public List<HashMap> selectcarsage(assess_fs ass_fs);
	
	//垫资天数分布图
	public List<HashMap> selectadvancefund(assess_fs ass_fs);
	
	//抵押材料回收情况
	public List<HashMap> selectrecycle(assess_fs ass_fs);
	
	//二手车每月放款单数和总金额
	public List<HashMap> selectoldcars(assess_fs ass_fs);
	
	//新车每月放款单数和总金额
	public List<HashMap> selectnewcars(assess_fs ass_fs);
	
	
	//------------------------------------------------------------------------------------------------------
	
	
	// 查询抵押完成天数情况，对0-15天，15-30天，30-45天，45-60天，60天以上的进行分组查询
	public List<HashMap> selectresult(assess_fs ass_fs);
	
	
	//------------------------------------------------------------------------------------------------------
	
	
	//每月汽车贷款总订单数
	public int countselect(assess_fs ass_fs);
	
	//每月汽车贷款过件单数
	public int countpass(assess_fs ass_fs);
	
	//每月汽车贷款各省市全部件数及过件数
	public List<HashMap> selectcarpasscomm(assess_fs ass_fs);
	

	
	//汽车贷款折线图
	public List<HashMap> selectcarchart(assess_fs ass_fs);
	
	//汽车放款分布扇形图
	public List<HashMap> selectcarfk(assess_fs ass_fs);
}
