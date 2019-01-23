package com.util.duoying;

import java.util.HashMap;
import java.util.Map;

public class  mjtypeutil {
//	机动车状态。
//	0:正常,1:转出,2:被盗抢,3:停驶,4:注销,
//	5:违法未处理,6:海关监管,
//	7:事故未处理,8:嫌疑车,
//	9:查封,10:暂扣,11:强制注销,
//	12:事故逃逸,13:锁定,14:退车 
//	public static final String[] IPOSBTITLE={"板块-bk","状态-zt","公司名称-gsname","审核公告时间-shtime"};
 public static int mjmap(String s){	  
	Map m=new HashMap<>();
	m.put("正常", 0);
	m.put("转出", 1);
	m.put("被盗抢", 2);
	m.put("停驶", 3);
	m.put("注销",4);
	m.put("违法未处理",5);
	m.put("海关监管",6);
	m.put("事故未处理",7); 
	m.put("嫌疑车", 8);
	m.put("查封", 9);
	m.put("暂扣", 10);
	m.put("强制注销", 11);
	m.put("事故逃逸", 12); 
	m.put("锁定", 13);
	m.put("退车", 14);
	m.put("违章未处理", 15);
	int i;
	i=(int) m.get(s);	
	return i;
 }
 public static int UseType(String s){	  
		Map m=new HashMap<>();
		m.put("非运营", 0);
		m.put("运营", 4);
		int i;		
		i=(int) m.get(s);	
		return i;	
		
	 }
 
 
 public static int sgmap(String s){	  
		Map m=new HashMap<>();
		m.put("有", 1);
		m.put("无", 0);
		int i;
		i=(int) m.get(s);	
		return i;
	 }
// 0	移动
// 1	联通
// 2	电信
// 3	虚拟
 public static int yystype(String s){	  
		Map m=new HashMap<>();
		m.put("中国移动", 0);
		m.put("中国联通", 1);
		m.put("中国电信", 2);
		m.put("虚拟", 3);
		int i;
		i=(int) m.get(s);	
		return i;
	 }
 //true 1 false 0
 public static int tfint(Object s){	  
		Map m=new HashMap<>();
		m.put("True", 0);
		m.put("true", 0);
		m.put("False", 1);
		m.put("false", 1);
		m.put("unKnow", 2);
		m.put("unKnow", 2);
		int i=2;
		if(m.get(s)!=null){
		 i=(int) m.get(s);	
		}			
		return i;
	 }
// 0:首期还款计划
// 1:尾期还款计划
// 2:期中还款计划
 public static int hkjh(Object s){	  
		Map m=new HashMap<>();
		m.put("首期还款计划", 0);
		m.put("尾期还款计划", 1);
		m.put("期中还款计划", 2);
//		m.put("false", 1);
//		m.put("unKnow", 2);
//		m.put("unKnow", 2);
		int i;
		i=(int) m.get(s);	
		return i;
	 }
 public static void main(String[] args) {
	System.out.println(tfint("True"));
}
 
}