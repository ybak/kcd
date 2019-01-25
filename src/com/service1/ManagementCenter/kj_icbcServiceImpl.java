package com.service1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.ManagementCenter.assess_fsMapper;
import com.model1.ManagementCenter.assess_fs;


@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class)
public class kj_icbcServiceImpl implements kj_icbcService{

	@Resource
	private assess_fsMapper assess_fsmapper;
	            
	//每月报单总量
	@Override
	public List<HashMap> SelectBill(assess_fs ass_fs){
		return assess_fsmapper.selectbill(ass_fs);
	}
	//每月放款单数,总金额
	@Override
	public List<HashMap> SelectLoan(assess_fs ass_fs){
		return assess_fsmapper.selectloan(ass_fs);
	}
	//每月已放款未抵押单数,总金额
	@Override
	public List<HashMap> SelectFk(assess_fs ass_fs){
		return assess_fsmapper.selectfk(ass_fs);
	}
	//每月总订单各省排名
	@Override
	public List<HashMap> SelectStates(assess_fs ass_fs){
		return assess_fsmapper.selectstates(ass_fs);
	}
	//每月总订单各代理商排名
	@Override
	public List<HashMap> SelectGems(assess_fs ass_fs){
		return assess_fsmapper.selectgems(ass_fs);
	}
	//每月放款订单各省排名
	@Override
	public List<HashMap> SelectLoanStates(assess_fs ass_fs){
		return assess_fsmapper.selectloanstates(ass_fs);
	}
	//每月放款订单各代理商排名
	@Override
	public List<HashMap> SelectLoanGems(assess_fs ass_fs){
		return assess_fsmapper.selectloangems(ass_fs);
	}	
	//折线图数据
	@Override
	public List<HashMap> SelectChart(assess_fs ass_fs) {
		return assess_fsmapper.selectchart(ass_fs);
	}
	//贷款金额区间扇形图
	@Override
	public List<HashMap> SelectMoneyDistribute(assess_fs ass_fs){
		return assess_fsmapper.selectmoneydistribute(ass_fs);
	}
	//征信通过率查询
	@Override
	public List<HashMap> SelectCredit(assess_fs ass_fs){
		return assess_fsmapper.selectcredit(ass_fs);	
	}
	//客户年龄查询统计
	@Override
	public List<HashMap> SelectClientAge(assess_fs ass_fs) {
		return assess_fsmapper.selectclientage(ass_fs);
	}
	//新车年龄查询统计
	@Override
	public List<HashMap> SelectCarsAge(assess_fs ass_fs){
		return assess_fsmapper.selectcarsage(ass_fs);
	}
	//垫资天数分布图
	@Override
	public List<HashMap> SelectAdvanceFund(assess_fs ass_fs){
		return assess_fsmapper.selectadvancefund(ass_fs);
	}
	//抵押材料回收情况
	@Override
	public List<HashMap> SelectRecycle(assess_fs ass_fs){
		return assess_fsmapper.selectrecycle(ass_fs);
	}
	//二手车每月放款单数和总金额
	public List<HashMap> SelectOldCars(assess_fs ass_fs){
		return assess_fsmapper.selectoldcars(ass_fs);
	}
	//新车每月放款单数和总金额
	public List<HashMap> SelectNewCars(assess_fs ass_fs){
		return assess_fsmapper.selectnewcars(ass_fs);
	}
	// 查询抵押完成天数情况，对0-15天，15-30天，30-45天，45-60天，60天以上的进行分组查询
	@Override
	public List<HashMap> SelectResult(assess_fs ass_fs) {	
		return assess_fsmapper.selectresult(ass_fs);
	}
	
	
	
	
	 //每月汽车贷款总订单数
	@Override
	public int CountSelect(assess_fs ass_fs){
		return assess_fsmapper.countselect(ass_fs);
	}
	 //每月汽车贷款过件单数
	@Override
	public int CountPass(assess_fs ass_fs){
		return assess_fsmapper.countpass(ass_fs);
	}
	//每月汽车贷款各省市过件率
	@Override
	public List<HashMap> SelectCarPassComm(assess_fs ass_fs){
		return assess_fsmapper.selectcarpasscomm(ass_fs);
	}
	//汽车贷款折线图
	@Override
	public List<HashMap> SelectCarChart(assess_fs ass_fs){
		return assess_fsmapper.selectcarchart(ass_fs);
	}
	//汽车放款分布扇形图
	@Override
	public List<HashMap> SelectCarFk(assess_fs ass_fs){
		return assess_fsmapper.selectcarfk(ass_fs);
	}

	//每月汽车贷款各代理商过件率
	@Override
	public List<HashMap> SelectCarPassGems(assess_fs ass_fs) {
		return assess_fsmapper.selectcarpassgems(ass_fs);
	}
}
