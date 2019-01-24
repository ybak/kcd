package com.controller.erp_icbc;

import java.util.HashMap;
import java.util.Map;

public class erp_fifteenModel {
	public static Map<Object, Object> fifteenModel(){
		 Map<Object, Object> map=new HashMap<>();
		 map.put(1,"征信查询");
		 map.put(2,"征信通融");
		 map.put(3,"车辆评估");
		 map.put(4,"银行电审");
		 map.put(5,"开卡申请");
		 map.put(6,"视频面签");
		 map.put(7,"跨区域业务审批");
		 map.put(8,"汽车贷款");
		 map.put(9,"内审通融");
		 map.put(10,"资金分配");
		 map.put(11,"银行贷款申请");
		 map.put(12,"公司归档");
		 map.put(13,"抵押归档");
		 map.put(14,"业务信息修改");
		 map.put(15,"退单退费");
		 return map;	
	}
	
	public static void main(String[] args) {
		Map map=fifteenModel();
		System.out.println(map.get(15));
	}
}
