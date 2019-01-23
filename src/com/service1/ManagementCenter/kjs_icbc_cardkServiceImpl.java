package com.service1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper1.ManagementCenter.kjs_icbc_cardkMapper;

@Service
@Transactional(value = "kcway2", rollbackFor = Exception.class) 
public class kjs_icbc_cardkServiceImpl implements kjs_icbc_cardkService{
	@Resource
	 private kjs_icbc_cardkMapper kjs_icbc_cardkmapper;
	
	 //每月汽车贷款总订单数
	@Override
	public int CountSelect(){
		return kjs_icbc_cardkmapper.countselect();
	}
	 //每月汽车贷款过件单数
	@Override
	public int CountPass(){
		return kjs_icbc_cardkmapper.countpass();
	}
	//每月汽车贷款各省市全部件数及过件数
	@Override
	public List<HashMap> SelectCarPassComm(){
		return kjs_icbc_cardkmapper.selectcarpasscomm();
	}
	//每月汽车贷款各省市全部件数及过件数
	@Override
	public List<HashMap> SelectCarPassGems(){
		return kjs_icbc_cardkmapper.selectcarpassgems();
	}
	//汽车贷款折线图
	@Override
	public List<HashMap> SelectChart(){
		return kjs_icbc_cardkmapper.selectchart();
	}
	//汽车放款分布扇形图
	@Override
	public List<HashMap> SelectCarFk(){
		return kjs_icbc_cardkmapper.selectcarfk();
	}
}
