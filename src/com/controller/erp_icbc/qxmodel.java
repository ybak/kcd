package com.controller.erp_icbc;

import java.util.HashMap;
import java.util.Map;

import com.util.duoying.mapbeanutil;

public class qxmodel {

	 //权限 英-汉
	public Map<Object,Object> qx(){
		Map<Object, Object> map=new HashMap<>();
		map.put("glzx","管理中心");
		
		map.put("zhgl","账户管理");
		map.put("zhgl/gsgl","公司管理");
		map.put("zhgl/tjgs","添加公司");
		map.put("zhgl/rygl","人员管理");
		map.put("zhgl/tjry","添加人员");
		map.put("zhgl/zhqx","账号权限");
		
		map.put("wlghd","武林工行贷");
		map.put("wlghd/zx","征信");
		map.put("wlghd/qcpg","汽车评估");
		map.put("wlghd/kk","开卡");
		map.put("wlghd/ssmq","视频面签");
		map.put("wlghd/qcdk","汽车贷款");
		return map;
	}
	 //权限对应
	 public static final String[] QX = 
		    {"管理中心-glzx",
			 "账户管理-zhgl",
			 "公司管理-zhgl/gsgl",
			 "添加公司-zhgl/tjgs",
			 "人员管理-zhgl/rygl",
			 "添加人员-zhgl/tjry",
			 "账号权限-zhgl/zhqx",
			 "武林工行贷-wlghd",
			 "征信-wlghd/zx",
			 "汽车评估-wlghd/qcpg",
			 "开卡-wlghd/kk",
			 "视频面签-wlghd/ssmq",
			 "汽车贷款-wlghd/qcdk"
			 };
     //权限 汉-英
	 public Map<String,String> qx_d(){
		 String[] strings=qxmodel.QX;
		 Map<String, String> map=new HashMap<>();
		 for(int i=0;i<strings.length;i++){
			 String[] s1=strings[i].split("-");
			 map.put(s1[0], s1[1]);
			 //System.out.println(s1[0]+"-"+s1[1]); 
			 
		 }
		return map;
	 }
	 
	 public static void main(String[] args) {
		
		 String[] strings=qxmodel.QX;
		 Map<String, String> map=new HashMap<>();
		 for(int i=0;i<strings.length;i++){
			 String[] s1=strings[i].split("-");
			 map.put(s1[0], s1[1]);
			 System.out.println(s1[0]+"-"+s1[1]); 
			 
		 }
		 System.out.println(map);
	 }
	 
	
}
