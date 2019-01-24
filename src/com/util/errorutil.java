package com.util;

import java.util.HashMap;
import java.util.Map;

public class errorutil {			
	public static Map error02(){
		Map errormap=new HashMap();
		errormap.put("errormsg","用户验证失败");
		return errormap;
	}
	public static Map error03(){
		Map errormap=new HashMap();
		errormap.put("errormsg","提交的字段不完整");		
		return errormap;
	}
	public static Map error04(){
		Map errormap=new HashMap();
		errormap.put("errormsg","余额不足");	
		return errormap;
	}
	public static Map error05(){
		Map errormap=new HashMap();
		errormap.put("errormsg","系统异常");		
		return errormap;
	}
	public static Map error06(){
		Map errormap=new HashMap();
		errormap.put("errormsg","未识别的pdf文件或错误的订单编码");		
		return errormap;
	}
	public static Map error07(){
		Map errormap=new HashMap();
		errormap.put("errormsg","无员工信息");		
		return errormap;
	}
	public static Map error08(){
		Map errormap=new HashMap();
		errormap.put("errormsg","未查到公司信息");		
		return errormap;
	}
	public static Map error09(){
		Map errormap=new HashMap();
		errormap.put("errormsg","用户已存在");		
		return errormap;
	}
	public static Map error010(){
		Map errormap=new HashMap();
		errormap.put("errormsg","添加数据失败");		
		return errormap;
	}
	public static Map error011(){
		Map errormap=new HashMap();
		errormap.put("errormsg","未生成报告");		
		return errormap;
	}
	public static Map error012(){
		Map errormap=new HashMap();
		errormap.put("errormsg","订单编号错误");		
		return errormap;
	}
	public static Map error013(){
		Map errormap=new HashMap();
		errormap.put("errormsg","无订单信息");		
		return errormap;
	}
	public static Map error014(){
		Map errormap=new HashMap();
		errormap.put("errormsg","解析错误");		
		return errormap;
	}
	public static Map error015(){
		Map errormap=new HashMap();
		errormap.put("errormsg","没有可用的申请书和授权书");		
		return errormap;
	}
	public static Map error016(){
		Map errormap=new HashMap();
		errormap.put("errormsg","文件格式错误或字段为空");		
		return errormap;
	}
	public static Map error017(){
		Map errormap=new HashMap();
		errormap.put("errormsg","初审完成");		
		return errormap;
	}
}
