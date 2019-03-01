package com.sched;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.http.duoying.syncjkrxxHttp;
import com.mashape.unirest.http.JsonNode;
import com.model1.fs;
import com.service.authorizeService;
import com.service.pdfoverService;
import com.service1.fsService;
import com.util.duoying.syncutil;

import net.sf.json.JSONObject;

@Controller
public class schedjob {
        
   
    @Autowired
    private  pdfoverService pdfoverService;
    
    @Autowired
    private  authorizeService authorizeService;
   
    @Autowired
    private  fsService fsservice;
    
	 

public void t(){
	System.out.println("hello word");
	
}


//多盈同步信息
public void dysync(){
	//从数据库取得数据往下面赋值
	net.sf.json.JSONObject personalBase = new net.sf.json.JSONObject();
    personalBase.put("borrowerId","1"); // 借款人外部唯一ID 此ID不可重复                                             // 代表借款人的系统中的唯一指定id,没有的话
    // 可以使用 加盟店ID+身份证做标识(36位)
    personalBase.put("categoryId","1");// gems_fs_id 加盟店ID //需要事先同步                                             // ,此ID+证件号的组合不可重复
    personalBase.put("name", "3");// c_name
    personalBase.put("formerName", "4");//曾用名
    personalBase.put("sex", "1"); 
    personalBase.put("birthDate", "19880210000000");
    personalBase.put("maritalStatus", "7");
    personalBase.put("supportCount", "8");
    personalBase.put("familyCount", "9");
    personalBase.put("educationLevel", "10");
    personalBase.put("mobilePhone", "11");// phone
    personalBase.put("telephone", "12");
    personalBase.put("cityCode", "广东省广州市");// 所在地区 二级
    personalBase.put("instantMessaging", "14");
    personalBase.put("currentAddress", "15");
    personalBase.put("shippingAddress", "16");
    personalBase.put("zipCode", "17");
    personalBase.put("email", "18");
    personalBase.put("arrivalTime", "19880210000000");
    personalBase.put("householdDegisterType", "20");
    personalBase.put("certificateType", "21");// parperstype
    personalBase.put("certificateNo", "22");// parpersnum
    personalBase.put("certificateValidityDate", "19880210000000");
    personalBase.put("driverLicense", "24");
    personalBase.put("riskAssessment", "25");
    personalBase.put("assetsStatisticsDate", "19880210000000");
    personalBase.put("remark", "27");
    personalBase.put("managerId","28");
    List<JSONObject> banks = new ArrayList<>();
    JSONObject oneBank = new JSONObject();
    oneBank.put("bankName", "华夏银行");// 银行名称 bank
    oneBank.put("bankBranchName", "支行");// String 分行/开户行名称 name
    oneBank.put("accountNo", "abc");// String 银行账号 cardunm
    banks.add(oneBank);
    List<JSONObject> attachment = new ArrayList<>();
    JSONObject xxz = new JSONObject();
    attachment.add(xxz);
    xxz.put("fileName", "1");
    xxz.put("fileUrl", "2");
    xxz.put("fileType", "1");
    xxz.put("fileString", "2");
    xxz.put("remark", "3");
   net.sf.json.JSONObject personal =  syncutil.addPersonalInfo(personalBase,banks,attachment);
   com.alibaba.fastjson.JSONObject data = new com.alibaba.fastjson.JSONObject();
    List<net.sf.json.JSONObject> personalList = new ArrayList<net.sf.json.JSONObject>();
    personalList.add(personal);
    data.put("personalList", personalList);
    // 先调用同步借款人接口
    com.alibaba.fastjson.JSONObject obj = syncutil.createHead(data);
    
    obj.put("data", data);
    //封装数据转为字符串
    String res= obj.toString();
	System.out.println("hello world");
	
}

//多盈同步分类信息
public static void dysyncflxx(){
	List<fs> flist=new ArrayList<fs>();
	//flist=fsservice.ffs();
    com.alibaba.fastjson.JSONObject data = new com.alibaba.fastjson.JSONObject();
    List<JSONObject> list = new ArrayList<>();
    List list1 = new ArrayList();
	  JSONObject one = new JSONObject();
      one.put("categoryId","1");//gems_fs_id
      one.put("categoryName","1");   
      one.put("categoryParentId","0");   
      one.put("level","0");   
      //System.out.println(exerciseStr);
      //System.out.println("---"+jn);		
      list.add(one);



	  data.put("categoryList", list);
	  // 先调用同步借款人接口
	  com.alibaba.fastjson.JSONObject obj=syncutil.createHead(data);
	  obj.put("data", data);
	  String aa = obj.toString();
	  String jn=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/abs-ws/services/rest/sys/addCategory", aa);
	  JSONObject jsonObject = new JSONObject();
	  jsonObject = JSONObject.fromObject(jn.toString());//将String转为JSON数据
	  String exerciseStr = jsonObject.getString("code");//获取key为"_source"的值。
      System.out.println(list1.size());

	



      
      
}

public static void main(String[] args) {
	dysyncflxx();
}

}
