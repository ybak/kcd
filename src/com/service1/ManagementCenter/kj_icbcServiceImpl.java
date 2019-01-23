package com.service1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.ManagementCenter.kj_icbcMapper;


@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class kj_icbcServiceImpl implements kj_icbcService{
	@Resource
	 private kj_icbcMapper kj_icbcmapper;
	
	//每月报单总量
	@Override
	public List<HashMap> SelectBill(){
		return kj_icbcmapper.selectbill();
	}
	//每月放款单数,总金额
	@Override
	public List<HashMap> SelectLoan(){
		return kj_icbcmapper.selectloan();
	}
	//每月已放款未抵押单数,总金额
	@Override
	public List<HashMap> SelectFk(){
		return kj_icbcmapper.selectfk();
	}
	//每月总订单各省排名
	@Override
	public List<HashMap> SelectStates(){
		return kj_icbcmapper.selectstates();
	}
	//每月总订单各代理商排名
	@Override
	public List<HashMap> SelectGems(){
		return kj_icbcmapper.selectgems();
	}
	//每月总订单各省排名
	@Override
	public List<HashMap> SelectLoanStates(){
		return kj_icbcmapper.selectloanstates();
	}
	//每月总订单各代理商排名
	@Override
	public List<HashMap> SelectLoanGems(){
		return kj_icbcmapper.selectloangems();
	}	
	//折线图数据
	@Override
	public List<HashMap> SelectChart() {
		return kj_icbcmapper.selectchart();
	}
	//贷款金额区间扇形图
	@Override
	public List<HashMap> SelectMoneyDistribute(){
		return kj_icbcmapper.selectmoneydistribute();
	}
	//征信通过率查询
	@Override
	public List<HashMap> SelectCredit(){
		return kj_icbcmapper.selectcredit();	
	}
	//客户年龄查询统计
	@Override
	public List<HashMap> SelectClientAge() {
		return kj_icbcmapper.selectclientage();
	}
	//新车年龄查询统计
	@Override
	public List<HashMap> SelectCarsAge(){
		return kj_icbcmapper.selectcarsage();
	}
	//垫资天数分布图
	@Override
	public List<HashMap> SelectAdvanceFund(){
		return kj_icbcmapper.selectadvancefund();
	}
	//抵押材料回收情况
	@Override
	public List<HashMap> SelectRecycle(){
		return kj_icbcmapper.selectrecycle();
	}
	//二手车每月放款单数和总金额
	public List<HashMap> SelectOldCars(){
		return kj_icbcmapper.selectoldcars();
	}
	//新车每月放款单数和总金额
	public List<HashMap> SelectNewCars(){
		return kj_icbcmapper.selectnewcars();
	}
}
