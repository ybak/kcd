package com.mapper1.ManagementCenter;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.model1.ManagementCenter.kjs_icbc_cardk;



public interface kjs_icbc_cardkMapper {
	//kjs_icbc_cardk	findicbc_cardk(@Param("icbc_id")int icbc_id);
	//每月汽车贷款总订单数
	public int countselect();
	//每月汽车贷款过件单数
	public int countpass();
	//每月汽车贷款各省市全部件数及过件数
	public List<HashMap> selectcarpasscomm();
	//每月汽车贷款各代理商全部件数及过件数
	public List<HashMap> selectcarpassgems();
	//汽车贷款折线图
	public List<HashMap> selectchart();
	//汽车放款分布扇形图
	public List<HashMap> selectcarfk();
}
