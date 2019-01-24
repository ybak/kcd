package com.controller.icbc.jsp;

import java.util.HashMap;
import java.util.Map;

public class icbcmodel {
	public static void main(String[] args) {
		Map<Object, Object> map= zx_status();
		System.out.println(map.get("0"));
	}
    //征信审核状态
	public static Map<Object, Object> zx_status(){
		 Map<Object, Object> map=new HashMap<>();
		 map.put(0,"草稿箱");
		 map.put(1,"草稿箱");
		 map.put(2,"审核中");
		 map.put(3,"征信通过");
		 map.put(4,"回退补件");
		 map.put(5,"征信不通过");
		 map.put(6,"撤销");
		 map.put(7,"征信不通过(通融审核中)");  //由 征信不通过(用户提交通融) 改为  征信不通过(通融审核中)
		 map.put(8,"征信不通过(通融通过)");
		 map.put(9,"征信不通过(通融不通过)");
		 map.put(10,"征信不通过(附条件通融)"); // 相当于 征信通融的回退补件
		 return map;	
	}
	 //征信审核状态
		public static Map<Object, Object> zxtr_status(){
			 Map<Object, Object> map=new HashMap<>();
			 map.put(1,"审核中");
			 map.put(2,"通融通过");
			 map.put(3,"通融不通过");
			 map.put(4,"附条件通融");
			 return map;	
		}
	//评估审核状态
	public static Map<Object, Object> pg_status(){
		 Map<Object, Object> map=new HashMap<>();
		 map.put(0,"草稿箱");
		 map.put(1,"草稿箱");
		 map.put(2,"审核中");
		 map.put(3,"评估完成");
		 map.put(4,"回退补件");
		 map.put(5,"未用");
		 map.put(6,"撤销");
		 return map;	
	}
    //开卡审核状态
	public static Map<Object, Object> kk_status(){
		 Map<Object, Object> map=new HashMap<>();
		 map.put(0,"草稿箱");
		 map.put(1,"草稿箱");
		 map.put(2,"身份核查中");
		 map.put(3,"开卡审核中");
		 map.put(4,"回退补件");
		 map.put(5,"申请失败");
		 map.put(6,"撤销");
		 map.put(7,"申请成功");
		 map.put(8,"电审回退");
		 map.put(9,"开卡完成");
		 return map;	
	}
	//面签审核状态
	public static Map<Object, Object> mq_status(){
		 Map<Object, Object> map=new HashMap<>();
		 map.put(0,"草稿箱");
		 map.put(1,"草稿箱");
		 map.put(2,"审核中");
		 map.put(3,"审核通过");
		 map.put(4,"回退补件");
		 map.put(5,"未用保留");
		 map.put(6,"撤销");
		 return map;	
	}
	//汽车贷款审核状态
	public static Map<Object, Object> qcdk_status(){
		 Map<Object, Object> map=new HashMap<>();
		 map.put(0,"草稿箱");
		 map.put(1,"草稿箱");
		 map.put(2,"审核中");
		 map.put(3,"过件");
		 map.put(4,"回退补件");
//		 map.put(5,"订单结束(失败)");
//		 map.put(6,"撤销");
//		 map.put(7,"附件待审");
		 map.put(8,"过件附条件");
		 return map;	
	}

	public static Map<Object, Object> icbczx(){
	 Map<Object, Object> map=new HashMap<>();
	 map.put(1,"授权书");
	 map.put(2,"面签照");
	 map.put(3,"身份证正反面复印件");
	 map.put(4,"身份证正面");
	 map.put(5,"身份证反面");
	 return map;	
	}
	//7-7 第三次修改
	public static Map<Object, Object> icbckk(){
		 Map<Object, Object> map=new HashMap<>();
		 map.put(1,"身份证正面");
		 map.put(2,"身份证反面");
		 map.put(3,"借款人基本资料1");
		 map.put(4,"借款人基本资料2");
		 map.put(5,"信用卡申请表1");
		 map.put(6,"信用卡申请表2");
		 map.put(7,"个人税收声明");
		 map.put(8,"面签照");//2018-07-17新增
		 map.put(9,"电话调查申请表");//2018-07-07新增
		 map.put(10,"新增补充材料");
		 return map;	
	}
	public static Map<Object, Object> icbcpg(){
		 Map<Object, Object> map=new HashMap<>();
		 map.put(1,"行驶证正本");
		 map.put(2,"行驶证副本");
		 map.put(3,"驾驶证正本");
		 map.put(4,"驾驶证副本");
		 map.put(5,"产权证1-2页");
		 map.put(6,"产权证3-4页");
		 map.put(7,"产权证5-6页");
		 map.put(8,"车辆铭牌");
		 map.put(9,"车头正面");
		 map.put(10,"前左侧45°");
		 map.put(11,"后右45°");
		 map.put(12,"车尾正面");
		 map.put(13,"发动机舱");
		 map.put(14,"中控台整体");
		 map.put(15,"里程表");
		 map.put(16,"左前车门(开)");
		 map.put(17,"右前车门(开)");
		 map.put(18,"驾驶证正本");
		 map.put(19,"驾驶证副本");
		 map.put(20,"合格证");
		 /* 18=>'右后翼子板边',
			19=>'左后翼子板边',
			20=>'左前车门45度',
			21=>'左后车门45度',
			22=>'右前车门45度',
			23=>'右后车门45度',
			24=>'后备胎窝整体', */
		 return map;	
	}
	
}
