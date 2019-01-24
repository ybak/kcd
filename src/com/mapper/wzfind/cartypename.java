package com.mapper.wzfind;

import java.util.HashMap;
import java.util.Map;

public class cartypename {

public static String cartype(String cartype){
	Map<Object,Object> m=new HashMap<Object,Object>();
	m.put("01", "大型汽车号牌");
	m.put("02", "小型汽车号牌");
	m.put("03", "使馆汽车号牌");
	m.put("04", "领馆汽车号牌");
	m.put("05", "境外汽车号牌");
	m.put("06", "外籍汽车号牌");
	m.put("07", "两、三轮摩托车号牌");
    m.put("08", "轻便摩托车号牌");
    m.put("09", "使馆摩托车号牌");
	m.put("10", "领馆摩托车号牌");
	m.put("11", "境外摩托车号牌");
	m.put("12", "外籍摩托车号牌");
	m.put("13", "农用运输车号牌");
    
	String str= "";
	if(m.get(cartype)!=null&&!m.get(cartype).equals("")){
		str=(String) m.get(cartype);
	}else{
		str=(String) m.get("02");
	}
	
	return str;	
}
	
 public static void main(String[] args) {
	 
	 System.out.println(cartype("03"));
  }
	
}
