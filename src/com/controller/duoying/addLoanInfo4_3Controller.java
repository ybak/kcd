package com.controller.duoying;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat.Value;
import com.http.TestKuaizhengCustomerCertificationInitialize;
import com.http.duoying.cbshttp;
import com.http.duoying.clwzhttp;
import com.http.duoying.dsjxxhttp;
import com.http.duoying.syncjkrxxHttp;
import com.mashape.unirest.http.JsonNode;
import com.model1.archives;
import com.model1.bank;
import com.model1.carmodel;
import com.model1.mgcert;
import com.model1.thjl;
import com.model1.ylqy;
import com.model1.zx;
import com.service1.queryzxService;
import com.service1.duoying.archivesService;
import com.service1.duoying.bankService;
import com.service1.duoying.carmodelService;
import com.service1.duoying.mgcarService;
import com.service1.duoying.mgcertService;
import com.service1.duoying.thjlService;
import com.service1.duoying.ylqyService;
import com.service1.duoying.zxService;
import com.service1.jsy.jsyylqyService;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.duoying.MD5;
import com.util.duoying.mapbeanutil;
import com.util.duoying.mjtypeutil;
import com.util.duoying.syncutil;
import com.util.duoying.timechange;
import com.util.jsy.WriteStringToTxt;

@Controller
public class addLoanInfo4_3Controller {

	
	@Autowired
	private  mgcarService mgcarservice;	
	@Autowired
	private  ylqyService ylqyservice;
	@Autowired
	private  jsyylqyService jsyylqyservice;	
	@Autowired
	private  bankService bankservice;
	@Autowired
	private  carmodelService carmodelservice;
	@Autowired
	private  archivesService archivesservice;
	@Autowired
	private mgcertService mgcertservice;
	@Autowired
	private thjlService thjlservice;
	@Autowired
	private queryzxService queryzxservice;
	@Autowired
	private zxService zxservice;
	private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCU41GfwgaxN4b5HjL5BcbTPbkBTjhqalo45yXSUaz1jI29Wg1kvG7SEsBJvNGbPJrD5O/0G9nYddaqUo72jcFyiCtMycIvWdFes62Tc/ulezYD6Wyo5lsVPkGmNg/QitwVpcrKFam/GEiErduae9pwfB8zhyfrCA3iiSPVCGP7ywIDAQAB";

	private static String privatekey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJTjUZ/CBrE3hvkeMvkFxtM9uQFOOGpqWjjnJdJRrPWMjb1aDWS8btISwEm80Zs8msPk7/Qb2dh11qpSjvaNwXKIK0zJwi9Z0V6zrZNz+6V7NgPpbKjmWxU+QaY2D9CK3BWlysoVqb8YSISt25p72nB8HzOHJ+sIDeKJI9UIY/vLAgMBAAECgYEAim5IyCdYnZEpN5qyfgK2+FVdHC+kGJ1Fwb541fIGxE+owbNm3JCu4Td5/ZVHtfRFWXoU+HyksbPuoXIdZnQqtWuInNhdPVpiir6/yXSvP5LLfQN6lqkCzapgtuhuz3Cayp58qb0k4ujZ2l5pegNN7a8plqHUSZNoE3VFHMNNTZECQQDYyRm7U+gliPlnO8bpnnU6ciFbiAeXbWS4z+HY2hLHWqFO7U2grBKueJ1yMYDNL8PCGbbyO0bUxDIu07t5KYg1AkEAr9IEzgIYwbCBujRgJ3rj7r5bXsggzTiHLypj+Uvsq0niI2TvHmiYczP0m9lSHmuvZwhcdhd0bufA81Zigi/z/wJBAIcVAGC3Dw/cgzQtjmviXj/WAC0t3TUhaEK03pEmic8JDTzGJ7n3nwhyhgEzEYRJwByBs3rLLv7DZlXBf68nDwUCQHe4mND2mIj7ebqjg34eriqZsHn/6GYVweeaA+1zh7qzWqsjRbf9HSIFFOEywDo6tXuBNAStv/jtEnQgNH/Vy10CQBzWF7XlU9oXiLwoVoe+7JAe7cnfAfG+2nwiuzc0x9oHB1p7rET3u0AMIR6LfC0K2FWheQRYcqsAWyQviIjWa8I=";

          //contactAreaInfo 联系人位置分析 （数组类型
	    private static Object phoneLocationAnalysis(thjl t) {
	    	List<JSONObject> list = new ArrayList<>();
	    	if(t.getApi_note()!=null&&!t.getApi_note().equals("")){	    		
	    	JSONObject jb=JSONObject.parseObject(t.getApi_note().toString());
	    	if(jb.get("contactAreaInfo")!=null){	    		
	    	JSONArray contactAreaInfo=JSONArray.parseArray(jb.get("contactAreaInfo").toString());	    		        	    	        	    	       
	   	    List ml= jsonutil.toList(contactAreaInfo);	    	        
	       for(int i=0;i<ml.size();i++){
	    	   Map m=(Map) ml.get(i);	
	        JSONObject one = new JSONObject();
	        one.put("region",m.get("area"));// String 是 地区
	        one.put("phoneNumber",m.get("totalNumber"));// int 是 号码数量
	        one.put("callingNumber",m.get("callTimes"));// int 是 主叫次数
	        one.put("callingTime",m.get("callTime"));// int 是 主教时间
	        one.put("calledNumber",m.get("calledTimes"));// int 是 被叫次数
	        one.put("calledTime",m.get("calledTime"));// int 是 被叫时间
	        one.put("percentage",m.get("percent"));// int 是 占比
	        one.put("remark", "联系人位置分析");
	        list.add(one);
	        }
	    	}
	    	}
	        return list;
	    }
	    //messageRecordsInfo 短信记录分析 （数组类型）
	    private static Object phoneSMSAnalysis(thjl t) {
	    	 List<JSONObject> list = new ArrayList<>();
	    	if(t.getApi_note()!=null&&!t.getApi_note().equals("")){
	    	JSONObject jb=JSONObject.parseObject(t.getApi_note());
	    	if(jb.get("messageRecordsInfo")!=null){	    		
	    	JSONArray messageRecordsInfo=JSONArray.parseArray(jb.get("messageRecordsInfo").toString());	    		        	    	        	    	       
	   	    List ml= jsonutil.toList(messageRecordsInfo);	    	       
	       for(int i=0;i<ml.size();i++){
	    	 Map m=(Map) ml.get(i);	 
	        JSONObject one = new JSONObject();
	        one.put("notePhone",m.get("phoneNo"));// string 是 号码
	        one.put("noteNumber",m.get("totalSmsNumber"));// int 是 短信条数
	        one.put("noteAddress",m.get("belongArea"));// string 是 号码归属地
	        one.put("remark", "短信记录分析");
	        list.add(one);
	       }
	    	}
   	       }
	        return list;
	       }
         //consumeInfo 运营商消费分析 （数组类型） 
 	    private static Object phoneConsumeAnalysis(thjl t) {
	        List<JSONObject> list = new ArrayList<>();
	        if(t.getApi_note()!=null&&!t.getApi_note().equals("")){
 	    	JSONObject jb=JSONObject.parseObject(t.getApi_note());
	    	JSONArray consumeInfo=JSONArray.parseArray(jb.get("consumeInfo").toString());
	    	if(jb.get("consumeInfo")!=null){
	   	    List ml= jsonutil.toList(consumeInfo);	    
	       for(int i=0;i<ml.size();i++){ 
	    	Map m=(Map) ml.get(i);	 
	    	JSONObject one = new JSONObject();
	        one.put("month",m.get("month"));// Int 是 月份
	        one.put("callingTime",m.get("callTime"));// Int 是 主叫时间
	        one.put("calledTime",m.get("calledTime"));// Int 是 被叫时间
	        one.put("noteNumber",m.get("totalSmsNumber"));// Int 是 短信数
	        one.put("balance",m.get("payMoney"));// Decimal 是 话费充值额
	        one.put("remark", "运营商消费分析");
	        list.add(one);
	       }
	    	}
	        }
	        return list;
	    }
        //deceitRisk 欺诈风险 （对象
	    private static Object phoneRiskAnalysis(thjl t) {
	    	JSONObject one = new JSONObject();
	    	if(t.getApi_note()!=null&&!t.getApi_note().equals("")){
	    	JSONObject jb=JSONObject.parseObject(t.getApi_note());
	    	if(jb.get("deceitRisk")!=null){
	    	JSONObject deceitRisk=JSONObject.parseObject(jb.get("deceitRisk").toString());	    		        	    	        	    	        
	        one.put("court",mjtypeutil.tfint(deceitRisk.get("calledByCourtNo")));// 枚举<YN> 是 是否出现法院相关号码呼叫
	        one.put("valid",mjtypeutil.tfint(deceitRisk.get("certNoIsValid").toString()));// 枚举<YN> 是 身份证号码有效性
	        if(deceitRisk.get("emergency_contacted")!=null){
	        one.put("urgency",mjtypeutil.tfint(deceitRisk.get("emergency_contacted")));// 枚举<YN> 是 是否联系过紧急联系人	   	      	
	        }
	        one.put("blackList",mjtypeutil.tfint(deceitRisk.get("inBlacklist")));// 枚举<YN> 是 申请人信息是否命中网贷黑名单
	        one.put("shutdown",mjtypeutil.tfint(deceitRisk.get("longTimePowerOff")));// 枚举<YN> 是 是否出现长时间关机  deceitRisk.get("longTimePowerOff")
	        one.put("reality",mjtypeutil.tfint(deceitRisk.get("phoneIsAuth")));// 枚举<YN> 是 运营商是否实名
	        one.put("accordance",mjtypeutil.tfint(deceitRisk.get("samePeople")));// 枚举<YN> 是 运营商实名是否与登记人一致   		
    	    }
    		
    	}
	        one.put("remark", "欺诈风险");
	        return one;
	    }
       //phoneOffInfos 关机详情
	    private static Object phoneWaitRecord(thjl t) {
	        List<JSONObject> list = new ArrayList<>();
	    	if(t.getApi_note()!=null&&!t.getApi_note().equals("")){	    		
	    	JSONObject jb=JSONObject.parseObject(t.getApi_note());
	    	if(jb.get("phoneOffInfos")!=null){
	    	JSONArray phoneOffInfos=JSONArray.parseArray(jb.get("phoneOffInfos").toString());	    		        	    	        
	    	List ml= jsonutil.toList(phoneOffInfos);	    
	       for(int i=0;i<ml.size();i++){
	    	   Map m=(Map) ml.get(i);	    
	        JSONObject one = new JSONObject();
	        if(m.get("beginDate")!=null&&!m.get("beginDate").equals("")){
	        one.put("beginTime",creditutil.datatotime(m.get("beginDate")));// DateTime 是 开始日期	
	        }
	        if(m.get("endDate")!=null&&!m.get("endDate").equals("")){
	        one.put("overTime",creditutil.datatotime(m.get("endDate")) );// DateTime 是 结束日期
	        }
	        one.put("countDay",m.get("days"));// int 是 天数
	        one.put("remark", "关机详情");
	        list.add(one);	      
	        }
	    	}
	    	}
	        return list;
	    }
        //callRecordsInfo 通话记录分析 
	    private static Object phoneCallRecord(thjl t) {
	    	List<JSONObject> list = new ArrayList<>();	  
	    	if(t.getApi_note()!=null&&!t.getApi_note().equals("")){
	    	System.out.println("sss"+t.getApi_note().toString());
	    	JSONObject jb=JSONObject.parseObject(t.getApi_note());
	    	if(jb.get("callRecordsInfo")!=null){	    		
	    	JSONArray callRecordsInfo=JSONArray.parseArray(jb.get("callRecordsInfo").toString());	    		        	           
	    	List ml= jsonutil.toList(callRecordsInfo);
	    	for(int i=0;i<ml.size();i++){	  
	    		Map m=(Map) ml.get(i);
	    	JSONObject one = new JSONObject();
	        one.put("callPhone",m.get("phoneNo"));// String 是 通话号码
	        one.put("callTime",m.get("connTime"));// int 是 通话时长
	        one.put("callNumber",m.get("connTimes"));// int 是 通话次数
	        one.put("calling",m.get("callTimes"));// int 是 主叫
	        one.put("called",m.get("calledTimes"));// int 是 被叫
	        one.put("phoneAddress",m.get("belongArea"));// String 是 号码归宿地
	        one.put("remark","");	    	
	        list.add(one);	     
	    	}	      
	    	}
	    	}
	        return list;
	    }
        // 0 移动
        // 1 联通
        // 2 电信
        // 3 虚拟  phoneInfo 运营商基本信息 （对象） 
	    private static Object addOperatorInfo(thjl t) {
	    	JSONObject one = new JSONObject();
	    	if(!t.getApi_note().equals("")&&t.getApi_note()!=null){
	    	//System.out.println("通讯录:"+t.getApi_note());
	    	JSONObject jb=JSONObject.parseObject(t.getApi_note().toString());
	    	//System.out.println("通话记录:"+jb.get("phoneInfo"));
	    	JSONObject phoneInfo=JSONObject.parseObject(jb.get("phoneInfo").toString());	 
	    	System.out.println("phoneInfo:"+phoneInfo);	    	
	    	if(!phoneInfo.equals("")){
		        one.put("operator",mjtypeutil.yystype(phoneInfo.get("operator").toString()));// 枚举< PhoneServiceProviders > 是 运营商类型
		       if(phoneInfo.get("inNetDate")!=null&&!phoneInfo.get("inNetDate").equals("")){
		    	one.put("netInTime",timechange.change(phoneInfo.getString("inNetDate")));// DateTime 是 入网时间    
		       }		        		       
		        one.put("autonym",phoneInfo.get("realName"));// String 是 实名认证
		        one.put("phone",phoneInfo.get("phoneNo"));// String 是 手机号码
		        if(phoneInfo.get("email")!=null&&!phoneInfo.get("email").equals("")){
		        one.put("email",phoneInfo.get("email").toString().replace("unknow",""));;// String 否 登记邮箱				       	
		        }
		        if(phoneInfo.get("balance")!=null&&!phoneInfo.get("balance").equals("")){
		        	one.put("balance",phoneInfo.get("balance").toString().replace("unknow",""));// Decimal 是 当前余额	
		        }		     
                if(phoneInfo.get("vipLevel")!=null&&!phoneInfo.get("vipLevel").equals("")){
                	one.put("grade",phoneInfo.get("vipLevel"));// Int 是 会员等级 	 	
                } 
		        one.put("integral",phoneInfo.get("pointValue"));// Int 是 积分值
		        one.put("netAge",12);// Int 是 网龄   phoneInfo.get("netAge")
		        one.put("beginCallTime",timechange.change(phoneInfo.getString("firstCallDate")));// DateTime 是 最早通话时间
		        one.put("latelyCallTime",timechange.change(phoneInfo.getString("lastCallDate")));// DateTime 是 最近通话时间
		        if(phoneInfo.get("addr")!=null&&!phoneInfo.get("addr").equals("")){
		    	  one.put("regAddress",phoneInfo.get("addr"));// String 是 登记地址			    	  
		        }
		       }
	        }
	        one.put("remark","运营商基本信息");
	        return one;
	    }

	   /**
	     * 通信数据
	     * 
	     * @return
	     */
	    private static Object addCommInfo(thjl t) {	          
	        JSONObject one = new JSONObject();
	        one.put("bcperson",t.getC_name());// String 是 被查询人
	        one.put("phone",t.getC_tel());// String 是 手机号码
	        one.put("remark","通信数据");// String 是 结果备注
	        
	        one.put("submitLateTime",creditutil.datatotime1(t.getDt_add()));// DateTime 是 提交时间
	        one.put("updateLateTime",creditutil.datatotime1(t.getDt_edit()));// DateTime 是 更新时间
	       
	        return one;
	    
	    }

	    /**
	     * 风险评估报告
	     * 
	     * @return
	     */
	    private static Object addRiskResult(JSONObject jn) {	
	    	List<JSONObject> list = new ArrayList<JSONObject>();
	    	List l=new ArrayList<>();
	    	if(jn.get("risk_items")!=null){
	    	l=jsonutil.toList(jn.get("risk_items"));		        
	        for(int i=0;i<l.size();i++){
	        	Map m=(Map)l.get(i);
 	        	JSONObject one = new JSONObject();
	  	        one.put("assessGroup",m.get("group"));// String 是 评估组
	  	        one.put("assessItem",m.get("item_id")); // String 是 评估项
	  	        one.put("assessRisk",m.get("item_name")); // String 是 风险
	  	      JSONObject item_detail=new JSONObject();
	  	      JSONObject detail= new JSONObject();//CheckList 风险检查明细
	  	      if(m.get("item_detail")!=null){
	  	      item_detail =JSONObject.parseObject(m.get("item_detail").toString()); 	  		  	     	
              detail.put("discreditTimes",item_detail.get("discredit_times"));//信贷逾期次数 
	  	      if(item_detail.get("overdue_details")!=null){
	  	    	//JSONArray overdue_details=JSONArray.parseArray(item_detail.get("overdue_details").toString());	 	       
	  	    	List detaillist=jsonutil.toList(item_detail.get("overdue_details").toString());
	  	    	System.out.println("overdue_details:"+detaillist.size());
	  	    	List<JSONObject> list1 = new ArrayList<>();
	  	    	for(int j=0;j<detaillist.size();j++){
	  	    		Map m1=(Map)detaillist.get(j);
	  	    		JSONObject two = new JSONObject();
	  	    		two.put("overdueAmountRange",m1.get("overdue_amount_range"));//逾期金额
	  	    		two.put("overdueCount",m1.get("overdue_count"));//逾期笔数
	  	    		two.put("overdueDayRange",m1.get("overdue_day_range"));//逾期天数
	  	    		if(m1.get("overdue_time")!=null){
	  	    		two.put("overdueTime",timechange.change(m1.get("overdue_time").toString()));//逾期入库时间  	    	
	  	    		}	  	    		
	  	    		list1.add(two);
	  	    	  }
	  	    detail.put("overdueDetails",list1);//逾期详情 list  
	  	      }	  	     	  	      
	  	      detail.put("platformCount",item_detail.get("platform_count"));//多头借贷
	  	      detail.put("platformDetail",item_detail.get("platform_detail"));//借贷详情
	  	      if(item_detail.get("platform_detail_dimension")!=null){
		  	      detail.put("platformDetailDimension",jsonutil.toJSONArray(item_detail.get("platform_detail_dimension")));//澶氬钩鍙扮粏鍒嗙淮搴﹁鎯�  	    	   
	  	      }
              detail.put("highRiskAreas",item_detail.get("high_risk_areas"));//高风险区域	  	      
	  	      detail.put("hitListDatas",item_detail.get("hit_list_datas"));//列表数据
	  	      detail.put("fraudType",item_detail.get("fraud_type"));//风险类型
	  	      detail.put("frequencyDetailList",item_detail.get("frequency_detail_list"));//频度详情 frequency_detail_list
	  	      detail.put("crossFrequencyDetailList",item_detail.get("cross_frequency_detail_list"));//跨事件频度
	  	      detail.put("crossEventDetailList",item_detail.get("cross_event_detail_list"));//跨事件字段
	  	    if(item_detail.get("namelist_hit_details")!=null){
	  	    	  //JSONArray tp=JSONArray.parseArray(item_detail.get("namelist_hit_details").toString());
		  	      String tp=item_detail.get("namelist_hit_details").toString();
	  	    	  List<Map<String, Object>> tl=jsonutil.toList(tp);
		  	      List<JSONObject> tplist=new ArrayList<JSONObject>();
		  	      List<JSONObject> jl=new ArrayList<JSONObject>();
	  	    	for(int t=0;t<tl.size();t++){
	  	    		Map<String, Object> mt=tl.get(t);	  	    		
	 	  	    	JSONObject four = new JSONObject();
	 	  	    	four.put("summary",mt.get("description"));//描述
	 	  	    	four.put("fraudType",mt.get("fraud_type"));//类型
	 	  	    	four.put("hitTypeDisplayname",mt.get("hit_type_displayname"));//匹配类型
	 	  	    	four.put("type",mt.get("type"));//规则标识	  	
	 	  	    	if(mt.get("fuzzy_detail_hits")!=null){
	 	  	    		 List<JSONObject> fl=new ArrayList<JSONObject>();
	 	  	    		 String  ja=mt.get("fuzzy_detail_hits").toString();
	 	  	    		//JSONArray fuzzyjb=JSONArray.parseArray(mt.get("fuzzy_detail_hits").toString());
	 	  	    		 List<Map<String, Object>> js=new ArrayList<Map<String, Object>>();
	 	  	    		 js=jsonutil.toList(ja);
	 	  	    		for(int k=0;k<js.size();k++){
	 	  	    		    Map kd=(Map)js.get(k);
	 	  	    			JSONObject five = new JSONObject();	
	 	  	    			five.put("fraudType",kd.get("fraud_type"));//风险类型
	 	  	    			five.put("fuzzyIdNumber",kd.get("fuzzy_id_number"));//模糊身份证
	 	  	    			five.put("fuzzyName",kd.get("fuzzy_name"));//姓名
	 	  	    			fl.add(five);
	 	  	    		}
		 	  	    	four.put("fuzzyDetailHits",fl);//模糊名单命中详情
		 	  	    	//return four;
	 	  	    	}
	 	  	    	if(mt.get("court_details")!=null){
	 		  	      JSONArray court_details=JSONArray.parseArray(mt.get("court_details").toString());
	 		  	      List cl=jsonutil.toList(court_details);
	 		  	      for(int j=0;j<cl.size();j++){
	 		  	    	 Map d=(Map) cl.get(j);
	 		  	    	JSONObject three = new JSONObject();
	 		  	    	three.put("fraudType",d.get("fraud_type"));//风险类型
	 		  	    	three.put("name",d.get("name"));//被执行人姓名
	 		  	    	three.put("age",d.get("age"));//年龄
	 		  	    	three.put("gender",d.get("gender"));//性别
	 		  	    	three.put("province",d.get("province"));// 省份
	 		  	    	three.put("filingTime",d.get("filing_time"));//立案时间
	 		  	    	three.put("courtName",d.get("court_name"));//执行法院
	 		  	    	three.put("executionDepartment",d.get("execution_department"));//做出执行依据单位
	 		  	    	three.put("duty",d.get("duty"));//生效法律文书确定的义务
	 		  	    	three.put("situation",d.get("situation"));//被执行人的履行情况 
	 		  	    	three.put("discreditDetail",d.get("discredit_detail"));//失信被执行人行为具体情形
	 		  	    	three.put("executionBase",d.get("execution_base"));//执行依据文号
	 		  	    	three.put("caseNumber",d.get("case_number"));//案号
	 		  	    	three.put("executionNumber",d.get("execution_number"));//执行标的
	 		  	    	three.put("executionStatus",d.get("execution_status"));//执行状态
	 		  	    	jl.add(three);
	 		  	      }
	 		  	     
	 		  	 }
	 	  	    	tplist.add(four);
		  	    	   if(mt.get("type")!=null){
		  	    		 if(mt.get("type").toString().equals("grey_list")){
		 	  	        	detail.put("greyList",tplist);//关注名单	  	  
		 	  	    	}
		               if(mt.get("type").toString().equals("fuzzy_list")){
		                 	detail.put("fuzzyList",tplist);//模糊名单
		 	  	    	}
		               if(mt.get("type").toString().equals("black_list")){
		                 	detail.put("blackList",tplist);//风险名单
		 	           }
		  	    	}
	  	    	}	  
	  	      detail.put("courtDetails",jl);//法院详情信息列表
	  	     }
	  	      detail.put("type",item_detail.get("type"));//规则的类型         
             }
	  	        one.put("assessDetail",detail); // String 风险检查项目明细
	  	        one.put("assessLevel",m.get("risk_level")); // String 风险等级	  	        
	  	        one.put("remark","风险评估报告"); // String 是 备注comment
	  	        list.add(one);
	        }
	       }
	        return list;
	    }

	    /**
	     * 风险评估数据
	     * 
	     * @return
	     */
	    private static Object addRiskInfo(JSONObject jn,
	    		String name,
	    		String identity,
	    		String phone,
	    		zx z
	    		) {
            JSONObject json = new JSONObject();
	        json.put("name",name);// 被查询人 name
	        json.put("identity",identity);// 身份证 identity
	        json.put("phone","0000000");// 电话 phone
	        json.put("certificateId","");// 授权书编号 certificate_id
	        json.put("addTime",creditutil.datatotime1(z.getDt_add()));// 建单时间 addtime
	        json.put("submitTime",creditutil.datatotime1(z.getDt_edit()));// 最后提交时间 submittime
	        if(z.getDt_fin()!=null){
		        json.put("updateTme",creditutil.datatotime1(z.getDt_fin()));// 最后更新时间 updatetime
		        json.put("standardDate",creditutil.datatotime1(z.getDt_fin()));// 报告基准日 standard	        	        		        	
	        }else{
		        json.put("updateTme","00000000000000");// 最后更新时间 updatetime
		        json.put("standardDate","00000000000000");// 报告基准日 standard	        	        		        
	        }
            if(jn!=null){
	        	JSONObject address_detect =JSONObject.parseObject(jn.get("address_detect").toString());
		        json.put("risk",jn.get("final_score"));// 风险分 risk
		        json.put("credit",jn.get("credit_score"));// 信用分 credit
		        System.out.println("异常："+address_detect.get("id_card_address"));
		        json.put("identitySite",address_detect.get("id_card_address"));// 身份证归宿地 identitysite
		        json.put("phoneSite",address_detect.get("mobile_address"));// 手机号归属地 phonesite
		        json.put("inspect",jn.get("final_decision"));// 个人基本信息核查 inspect risk_items       
	        }
            json.put("remark", "风险评估数据");// 备注 comment
	        return json;
	    }

	    /**
	     * 还款计划
	     * 
	     * @return
	     * @throws ParseException 
	     */
	    private static Object addRepaymentPlan(
				String sq,
				String time,
				String lx,int qs,double bj) throws ParseException {
	        List<JSONObject> list = new ArrayList<>();	        
	        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat dfs = new SimpleDateFormat("yyyyMMddHHmmss");
			   // SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");// 日期格式		
	        for (int i = 0; i < qs; i++) {
	            JSONObject one = new JSONObject();
	            one.put("period",i+1);// 期数	  
	            //System.out.println("time:"+time);
	    	    Date date = df.parse(time);
	    		Date d= addDate(date,30);
	    		//System.out.println(df.format(d));
	    		//time= todata(df.format(d).toString()); 		
	            one.put("repaymentDate",todata(df.format(d).toString()));// 是 应还日期
	            one.put("repaymentPrincipal",bj);// 否 应还本金
	            if(i+1==1){
	            	one.put("periodType",0);// 还款计划
	            }else if(i+1==qs){
	            	one.put("periodType",1);// 还款计划
	            }else{
	            	one.put("periodType",2);// 还款计划
	            }
	            one.put("repaymentInterest",lx);// 否 应还利息
	            one.put("repaymentCost",0);// 应还费用
	            one.put("repaymentTotal",sq);// 应还小计
	            one.put("remark ","还款计划");// 备注
	            time=df.format(d).toString();	           
	            list.add(one);
	        }
	        return list;
	    }
	    
	    //日期加多少天
		public static Date addDate(Date date,long day) throws ParseException {							
			 long time = date.getTime(); //得到指定日期的毫秒数
			 day = day*24*60*60*1000; //要加上的天数转换成毫秒数
			 time+=day; //相加得到新的毫秒数
			 return new Date(time); // 将毫秒数转换成日期
			}
		//日期转换 21312312 格式
		public static String todata(String time) throws ParseException {						
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");// 日期格式
			Date date =df.parse(time); // 指定日期
			//df1.format(date);
		    return df1.format(date).toString(); 
		    
		}

	    /**
	     * 车辆违章记录 复数
	     * 
	     * @return
	     */
	    private static Object addCarPeccancy(
	    		 String carorg,
				 String lsprefix,
				 String lsnum,
				 String lstype,
				 String engineno,
				 String frameno 
	    		) {
	    	List<JSONObject> list = new ArrayList<>();
	    	JsonNode clwz=clwzhttp.query(carorg, lsprefix, lsnum, lstype, engineno, frameno);	    	
	       //System.out.println("违章记录："+clwz.toString().length());
	    	if(clwz!=null&&!clwz.equals("")){
	    	JSONObject jb=JSONObject.parseObject(clwz.toString());
	        if(jb.get("status").equals("0")){
		JSONObject result=JSONObject.parseObject(jb.get("result").toString());
	         List<Map<String, Object>>  jl= jsonutil.toList(result.get("list"));
	         for(int i=0;i<jl.size();i++){
	        	Map<String, Object> m=jl.get(i);
	 		    JSONObject one = new JSONObject();
	 		    if(m.get("time")!=null){
	 		    	one.put("peccancyTime",creditutil.datatotime1(m.get("time")));// 违章时间 	
	 		    }		        
		        one.put("peccancyAddress",m.get("address"));// 违章地点
		        one.put("peccancyContent",m.get("content"));// 违章内容
		        one.put("peccancyNo",m.get("number"));// 违章编号
		        one.put("peccancyPrice",m.get("price"));// 罚款金额
		        one.put("peccancyScore",m.get("score"));// 扣分
		        one.put("remark","车辆违章记录 ");// 备注  
		        list.add(one);
	         }

	        }
	        }
	        return list;
	    }

	    /**
	     * 车辆维修记录 复数
	     * 
	     * @return
	     */
	    private static Object addCarMaintainRecord(List l) {
	        List<JSONObject> list = new ArrayList<>();
	        for(int i=0;i<l.size();i++){	   
	        Map m=(Map) l.get(i);
	        JSONObject one = new JSONObject();
	        if(m.get("date")!=null){
	        one.put("serviceLateTime",creditutil.datatotime(m.get("date").toString()));// 时间			        
	        }	        
	        one.put("serviceLateType",m.get("type"));// 类型
	        //one.put("kilometre",m.get("date"));// 公里数
	        one.put("item",m.get("content"));// 项目
	        one.put("materials",m.get("materal"));// 材料
	        one.put("remark","车辆维修记录");// 备注
	        list.add(one);
	        }
	        return list;
	    }
	    /**
	     * 车辆保养
	     * 
	     * @return
	     */
	    private static Object addCarMaintain(mgcert m,JSONObject cbs) {
	        JSONObject one = new JSONObject();	        
	        one.put("submitTime",creditutil.timefiles()); // 提交时间
	        one.put("standardDate",creditutil.timefiles()); // 报告基准日
	        one.put("drivingimg","驾驶证图片"+m.getImgstep2_4()); // 行驶证照片
	        if(cbs!=null){
	        	one.put("carModel",cbs.get("modelName")); // 车型
	 	        one.put("carSeries",cbs.get("seriesName")); // 车系
	 	        one.put("vinNo",cbs.get("vin")); // VIN码
	 	        one.put("generateTime",cbs.get("makeReportDate")); // 报告生成时间
	 	        one.put("generateId",cbs.get("reportNo")); // 报告编号
	 	        one.put("manufacturer",cbs.get("manufacturer")); // 生产厂商
	 	        one.put("productionDate",cbs.get("makeDate")); // 生产年份
	 	        one.put("place",cbs.get("productionArea")); // 产地
	 	        one.put("carType",cbs.get("carType")); // 车辆类型
	 	        one.put("variableBox",cbs.get("transmissionType"));// 变数箱类型
	 	        one.put("displacement",cbs.get("displacement")); // 排量
	 	        one.put("fire",cbs.get("carFireFlag"));  // 是否火烧
	 	        one.put("water",cbs.get("carWaterFlag")); // 是否水泡
	 	        one.put("importance",cbs.get("carComponentRecordsFlag")); // 重要组成部件是否有维修
	 	        one.put("construction",cbs.get("carConstructRecordsFlag"));// 结构件是否有维修
	 	        one.put("normal",cbs.get("mileageIsNormalFlag")); // 公里数是否正常
	 	        one.put("kilometre",cbs.get("mileageEstimate")); // 预估公里数
	 	        if(cbs.get("lastMainTainTime")!=null){
	 	        	  one.put("upkeepLateTime",timechange.change(cbs.get("lastMainTainTime"))); // 最后一次保养时间
	 		 	        	
	 	        }
	 	        one.put("upkeepNumber",cbs.get("mainTainTimes"));// 每年保养次数
	 	        if(cbs.get("lastRepairTime")!=null){
	 	        	one.put("serviceLateTime",timechange.change(cbs.get("lastRepairTime")));// 最后一次维修时间		
	 	        }        
	 	        one.put("kilometreYear",cbs.get("mileageEveryYear")); // 每年行驶公数数
	 	        one.put("remark",cbs.get("remark"));// 备注remark 
	        }
	       
	        return one;
	    }

	    /**
	     * 车辆档案
	     * 
	     * @return
	     */
	    private static Object addCarArchives(archives arc) {
	        JSONObject clda = new JSONObject();
	        clda.put("plateNumber", arc.getR_item1());// 车辆号码/牌照
            clda.put("owner", arc.getR_item2());// 机动车所有人
            clda.put("idcardNo", arc.getR_item3());// 身份证号码
            clda.put("brandCn", arc.getR_item4());// 中文品牌
            clda.put("vehicleModel", arc.getR_item5());// 车辆型号
            clda.put("vehicleIdentificationCode", arc.getR_item6());// 车辆识别代号
            clda.put("engineNumber", arc.getR_item7());// 发动机号
            if(arc.getR_item8()!=null&&!arc.getR_item8().equals("")){
            	clda.put("useType",mjtypeutil.UseType(arc.getR_item8()));// 使用性质。	
            }
            clda.put("registrationAuthority", arc.getR_item9());// 登记机关
            clda.put("carColor", arc.getR_item10());// 车身颜色
            if(arc.getR_item11()!=null&&!arc.getR_item11().equals("")){
            	if(arc.getR_item11().toString().substring(arc.getR_item11().toString().length()-1,
            			arc.getR_item11().toString().length()).equals("浜�"))
            			{
            		clda.put("passengerCount",arc.getR_item11()+"人");// 核定载客		
            	}else{
            		clda.put("passengerCount",arc.getR_item11());//// 核定载客	            		
            	}
            }
                clda.put("driverLicenseCode", arc.getR_item12());// 行驶证芯编码
            	clda.put("initialRegistrationDate",timechange.change(arc.getR_item13()));// 初次登记日期      	
                clda.put("registrationDate",timechange.change(arc.getR_item14()));// 出厂登记日期              	
	            clda.put("scrapDate",timechange.change(arc.getR_item15()));// 强制报废期止     	
                clda.put("insuranceValidityDate",timechange.change(arc.getR_item16()));// 保险有效期止
                clda.put("verifyValidityDate",timechange.change(arc.getR_item18()));// 校验有效期止		
            // Map m=new HashMap<>();
            //int mj = 0;
            if(arc.getR_item17()!=null){
            if(arc.getR_item17().equals("是")){
            	 clda.put("isNewEnergy",1);// 新能源汽车      	
            }
            if(arc.getR_item17().equals("否")){
            	 clda.put("isNewEnergy",0);// 新能源汽车  
            }        	
           }
                    
            clda.put("power", arc.getR_item19());// 排量功率
            System.out.println("机动车状态："+arc.getR2_item1());
            if(arc.getR2_item1()!=null){           
            	//mjtypeutil.mjmap(arc.getR2_item1())
                clda.put("carStatus",arc.getR2_item1());// 机动车状态。                 
            }
            if(arc.getR2_item2()!=null){
                clda.put("accidentEscape",mjtypeutil.sgmap(arc.getR2_item2()));// 事故逃逸  
            }
            clda.put("vehicleDeck", arc.getR2_item3());// 车辆套牌
            clda.put("vehicleRobbery", arc.getR2_item4());// 车辆盗抢
            clda.put("mortgageSign", arc.getR2_item5());// 抵押标记
            clda.put("mortgageTime",timechange.change(arc.getR2_item6()));// 抵押时间             	
            if(arc.getDt_fin()!=null){
            	clda.put("reportDate",creditutil.datatotime1(arc.getDt_fin()));// 报告基准日	
            }else{
            	clda.put("reportDate","00000000000000");// 报告基准日
            }
            clda.put("mortgageHolder",arc.getR2_item7());// 抵押权人            
            clda.put("historyMortgage", arc.getR2_item8());// 历史抵押
            //clda.put("submitTime", "");// 历史抵押
	        return clda;
            }

	    /**
	     * 共借人信息 复数
	     * 
	     * @return
	     */
	    private static List<JSONObject> addCoborrower(String name,String cardno) {
	       List<JSONObject> list = new ArrayList<>();
	       JSONObject a = new JSONObject();
	       a.put("name",name);
	        //;//
	       a.put("certificateNo",cardno);
	       //  ;// String 是 证件号码 ct_cardno
	       //a.put("phone", "电话");
	       // ;// String 是 电话
	       a.put("remark", "共借人信息");
	       // ;// String 否
	       a.put("certificateType", "1");
	       list.add(a);
	       return list;
	    }

	    /**
	     * 银行,单个
	     * 
	     * @return
	     */
	    private static JSONObject addBankInfo2( 
	    	String bankName,
	    	String bankBranchName,
	    	String accountNo
	    		) {
	        JSONObject oneBank = new JSONObject();
	        oneBank.put("bankName",bankName);// 银行名称 bank
	        oneBank.put("bankBranchName",bankBranchName);// String 分行/开户行名称 name
	        oneBank.put("accountNo",accountNo);// String 银行账号 cardunm
	        return oneBank;
	    }

	    // 附件
	    private static JSONObject addAttachment(String a,String url,String fileType) {
	       // List<JSONObject> attachment = new ArrayList<JSONObject>();
	        JSONObject xxz = new JSONObject();	
	        xxz.put("fileName", a);
	        xxz.put("fileUrl", url);
	        xxz.put("fileType",fileType);
	        xxz.put("fileString","0");
	        xxz.put("remark", "附件");	       
	        return xxz;
	    }

	
    @RequestMapping(value="addLoanInfo.do",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addLoanInfo() throws ParseException{    	
    	//String resultjson1=null;
    	Map<Object,Object> resultjson1 = new HashMap<Object,Object>();  
        List<JSONObject> loanInfoList = new ArrayList<>();	      	
    	String obj1=null;
    	List<mgcert> mgall = new ArrayList<mgcert>();
    	List<mgcert> mgcert = new ArrayList<mgcert>();
    	List<mgcert> mgcar = new ArrayList<mgcert>();
    	List<mgcert> mgnewcar = new ArrayList<mgcert>();
    	mgcert=mgcertservice.Apijkxxmgcert();
    	//mgcert=mgcertservice.findmgcertlist();
    	//mgcar =mgcertservice.findmgcar();
    	//mgnewcar =mgcertservice.findmgnewcar();
    	//mgcert.addAll(mgcar);
    	//mgcert.addAll(mgnewcar);
    	//System.out.println("总条数:"+mgcert.size());    	
		String resultjson=null;
		//mgall.addAll(mgcert);
		//mgall.addAll(mgcar);
		//mgall.addAll(mgnewcar);
		DecimalFormat jd = new DecimalFormat("#.00");
    	for(int i=0;i<mgcert.size();i++){    
//	        try {
        	//loanBase
        	JSONObject loanInfo = new JSONObject(true);
        	JSONObject loanInfomg = new JSONObject(true);
        	JSONObject loanInfo1 = new JSONObject(true);// 代表一个数据的集合
            JSONObject authInfo = new JSONObject(true);
    		mgcert mt=new mgcert();
    		mt=mgcert.get(i);    		
    		loanInfo.put("loanBaseId",mt.getGems_code()+"|"+"mgcert|");// 借款信息外部唯一指定ID	new Random().nextInt()                                                               // gems_code
    		loanInfo.put("loanNo","mgcert|"+mt.getGems_code());// 借款信息外部唯一指定ID	new Random().nextInt()                                                           // gems_code
		    
    		//loanBaseId  顺序还下  身份证+供应商ID
//    		if(i<mgcert.size()){
//    			 loanInfo.put("loanBaseId",mt.getId()+"|"+"mgcert");// 借款信息外部唯一指定ID	new Random().nextInt()                                                          // gems_code
//    		       	
//    		}
//    		if(i>mgcert.size()){
//
//    		if(i<mgcar.size()+mgcert.size()){
//   			 loanInfo.put("loanBaseId",mt.getId()+"|"+"mgcar");// 借款信息外部唯一指定ID	new Random().nextInt()                                                           // gems_code	       	
//   		     }
//		    }
//    		if(i>mgcar.size()+mgcert.size()){
//    			if(i<mgall.size()){
//    				 loanInfo.put("loanBaseId",mt.getId()+"|"+"mgnewcar");// 借款信息外部唯一指定ID	new Random().nextInt()                                                // gems_code	       	
//    		   		    	
//    			}
//    		}
	        loanInfo.put("borrowerId",mt.getC_cardno()+"|"+String.valueOf(mt.getGems_fs_id()));//mt.getC_cardno()+"|"+String.valueOf(mt.getGems_fs_id()));// 借款人外部指定ID,必须先同步借款人,
	        loanInfo.put("categoryId","4");// 外部分类ID(归属哪个部门或者门店,需事先同步),没有的情况下填0	mt.getGems_fs_id()                                       // 加盟店 gems_fs_id
	        loanInfo.put("borrowerType", "0");// 外部借款人类型(为兼容不同类型的借款人有同样id),0:个人,1企业
	        loanInfo.put("projectUuid","cd26b0ca-ad0a-4044-95a6-b6cb1b71bbc4");// 项目编号,由本平台提供 PRJ0001
	        loanInfo.put("managerId",mt.getGems_id()); // 客户经理ID gems_id
	        loanInfo.put("approvalAmount",mt.getC_mgprice_result()); // 终审贷款金额 c_mgprice_result
	        loanInfo.put("rateType", "1");//利率类型
	        loanInfo.put("loanType","0"); // 贷款类型。0:车贷
	        loanInfo.put("approvalRate","0");// 终审利率 q_lv
	        loanInfo.put("isNeedCollateralAudit", "");// 需要抵押品审核 1是
//	        loanInfo.put("loanInvest", "");// 贷款投向。
//	        loanInfo.put("loanStatus", "");// 贷款投向。
//	        loanInfo.put("loanPurpose", "");// 贷款用途。
	        loanInfo.put("loanTerm",mt.getC_mgdays()/30);// 借款期数 periods
	        
	        loanInfo.put("applyDate",creditutil.datatotime1(mt.getDt_edit()));// 申请日期 dt_edit
	        
	        loanInfo.put("applyLoanDuration",mt.getC_mgdays());// 申请借款时长 c_mgdays
	        loanInfo.put("applyAmount",Double.parseDouble(mt.getC_mgprice())*10000);// 申请借款金额 c_mgprice
            loanInfo.put("guaranteeType","1");// 担保方式。	        
	        if(mt.getC_mgtype()==0){//先息后本
	        	loanInfo.put("repaymentType","1");// 还款方式。 c_mgtype
	        }
	        if(mt.getC_mgtype()==1){//等额本息
	        	loanInfo.put("repaymentType","6");// 还款方式。 c_mgtype	
	        }
	        loanInfo.put("interestCalculationCycle","1");// 利息计算周期。0:日计息,1:月计息。
	        loanInfo.put("repaymentCalculationType","0");// 还款日期计算策略。0:每月固定日期。
	        int qs=mt.getC_mgdays()/30;
	        loanInfo.put("repaymentCycle",qs);// 还款周期
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		   // SimpleDateFormat df1 = new SimpleDateFormat("yyyyMMdd");// 日期格式
			SimpleDateFormat dftime = new SimpleDateFormat("yyyy-MM-dd");// 日期格式
 	        loanInfo.put("interestStartDateType","0");//计息开始日期。0:发放贷款日期。
            if(mt.getDt_fk()!=null){
            	 loanInfo.put("baseDay",creditutil.datatotime1(mt.getDt_fk()));//计息开始日期。0:发放贷款日期。                	
            }else{
            	 loanInfo.put("baseDay","00000000000000");//计息开始日期。0:发放贷款日期。
                 
            }
           
//	        //String time=s;
//	        //还款计划
//	        if(mt.getDt_fk()!=null){
//		    loanInfo1.put("repaymentPlan",addRepaymentPlan(
//		    sq,
//		    mt.getDt_fk(),
//		    lx,qs,bj));	 
//	        }    	        
//          loanInfo.put("everyRepaymentAmount",mq);//每期还款金额 mq_money	        	        
//          loanInfo.put("firstRepaymentAmount",sq);//首期还款金额 sq_money
//          loanInfo.put("lastRepaymentAmount", wq);//尾期还款金额 wq_money
//          loanInfo.put("cycleDayCount","30");//int每周期天数
//	        loanInfo.put("isAvoidFestival","");// 还款计划避开节假日
//	        loanInfo.put("isAllowAdvanceRepayment","");// 允许提前还款
	    	String bankName = "";// 银行名称 bank
	    	String bankBranchName = "";// String 分行/开户行名称 name
	    	String accountNo = "";// String 银行账号 cardunm
	    	String c_name=mt.getC_name();
	    	List<ylqy>  ylist=new ArrayList<>();
	    	System.out.println("c_name:"+c_name);
	    	JSONObject bif = new JSONObject(true);
	    	ylqy y=jsyylqyservice.findylqybycardid(mt.getC_cardno());		    	
	    	if(y!=null){	    		
	    			if(y.getBANK_CODE()!=null){
	    				 bank b= bankservice.bankmap(y.getBANK_CODE());	
	    				 System.out.println("y.getBANK_CODE():"+y.getBANK_CODE());
	    				 if(b!=null){
	    			      bankName=b.getName(); 
	    			      System.out.println("bankName"+bankName);
	    				 }	
	    	             bif=addBankInfo2(bankName,y.getBANK_NAME(),y.getACCOUNT_NO());  	    	             
	    	 	    	 loanInfo.put("repaymentBank",bif);// 还款银行账户 Sig_bank	 	  	 
	    			}	    		
	    	}	    	
	    	    	       
	       //  loanInfo.put("repaymentPrincipal",bj);// 应还本金 yhbj_money
	       // System.out.println(bj+"bj");
	       // loanInfo.put("repaymentInterest",lx);// 应还利息 yhlx_money
	        //loanInfo.put("repaymentCost","0");// 应还费用
	       // loanInfo.put("repaymentTotal",bj+bj*0.0068*qs);// 应还总额 yhbj_money+ yhlx_money
	        List<JSONObject> attachment = new ArrayList<JSONObject>();
	        //"http://a.kcway.net/assess/"
	        if(mt.getImgstep2_7()!=null&&!mt.getImgstep2_7().equals("")){
	        	JSONObject a1=addAttachment("申请表","http://a.kcway.net/assess/"+mt.getImgstep2_7(),"0");
	        	attachment.add(a1);
	        }
	        if(mt.getImgstep2_8()!=null&&!mt.getImgstep2_8().equals("")){
	        	JSONObject a2=addAttachment("快加评估报告","http://a.kcway.net/assess/"+mt.getImgstep2_8(),"0");	
	        	attachment.add(a2);
	        }
	        if(mt.getImgstep2_9()!=null&&!mt.getImgstep2_9().equals("")){
	            JSONObject a3=addAttachment("保单（商业）","http://a.kcway.net/assess/"+mt.getImgstep2_9(),"0");	
	            attachment.add(a3);
	        }
            if(mt.getImgstep2_12()!=null&&!mt.getImgstep2_12().equals("")){
            	JSONObject a4=addAttachment("共借人身份证正面","http://a.kcway.net/assess/"+mt.getImgstep2_12(),"0");	
            	attachment.add(a4);
            }
	        if(mt.getImgstep2_13()!=null&&!mt.getImgstep2_13().equals("")){
	        	JSONObject a5=addAttachment("共借人身份证反面","http://a.kcway.net/assess/"+mt.getImgstep2_13(),"0");
	        	attachment.add(a5);
	        }	   
	        if(mt.getImgstep3_1()!=null&&!mt.getImgstep3_1().equals("")){
	        	JSONObject a6=addAttachment("合同1","http://a.kcway.net/assess/"+mt.getImgstep3_1(),"0");
	        	attachment.add(a6);
	        }   
	        if(mt.getImgstep3_2()!=null&&!mt.getImgstep3_2().equals("")){
	        	JSONObject a7=addAttachment("合同2","http://a.kcway.net/assess/"+mt.getImgstep3_2(),"0");
	        	attachment.add(a7);
	        } 
	        if(mt.getImgstep3_3()!=null&&!mt.getImgstep3_3().equals("")){
	        	JSONObject a8=addAttachment("合同3","http://a.kcway.net/assess/"+mt.getImgstep3_3(),"0");
	        	attachment.add(a8);
	        }	
	        if(mt.getImgstep3_4()!=null&&!mt.getImgstep3_4().equals("")){
	        	JSONObject a9=addAttachment("合同4","http://a.kcway.net/assess/"+mt.getImgstep3_4(),"0");	
	        	attachment.add(a9);
	        }
	        if(mt.getImgstep3_5()!=null&&!mt.getImgstep3_5().equals("")){
	        	JSONObject a10=addAttachment("合同5","http://a.kcway.net/assess/"+mt.getImgstep3_5(),"0");	
	        	attachment.add(a10);
	        }	
	        if(mt.getImgstep3_6()!=null&&!mt.getImgstep3_6().equals("")){
	        	JSONObject a11=addAttachment("合同6","http://a.kcway.net/assess/"+mt.getImgstep3_6(),"0");	
	        	attachment.add(a11);
	        }
	        if(mt.getImgstep3_7()!=null&&!mt.getImgstep3_7().equals("")){
	        	JSONObject a12=addAttachment("合同7","http://a.kcway.net/assess/"+mt.getImgstep3_7(),"0");	
	        	attachment.add(a12);
	        }
	        if(mt.getImgstep3_8()!=null&&!mt.getImgstep3_8().equals("")){
	        	JSONObject a13=addAttachment("合同8","http://a.kcway.net/assess/"+mt.getImgstep3_8(),"0");	
	        	attachment.add(a13);
	        }
	        if(mt.getImgstep3_9()!=null&&!mt.getImgstep3_9().equals("")){
	        	JSONObject a14=addAttachment("合同9","http://a.kcway.net/assess/"+mt.getImgstep3_9(),"0");		
	        	attachment.add(a14);
	        }
	        if(mt.getImgstep3_10()!=null&&!mt.getImgstep3_10().equals("")){
	        	JSONObject a15=addAttachment("合同10","http://a.kcway.net/assess/"+mt.getImgstep3_10(),"0");	
	        	attachment.add(a15);
	        }
	        if(mt.getImgstep3_11()!=null&&!mt.getImgstep3_11().equals("")){
	        	JSONObject a16=addAttachment("合同11","http://a.kcway.net/assess/"+mt.getImgstep3_11(),"0");	
	        	attachment.add(a16);
	        }
	        if(mt.getImgstep3_12()!=null&&!mt.getImgstep3_12().equals("")){
	        	JSONObject a17=addAttachment("合同12","http://a.kcway.net/assess/"+mt.getImgstep3_12(),"0");	
	        	attachment.add(a17);
	        }	
	        if(mt.getImgstep3_13()!=null&&!mt.getImgstep3_13().equals("")){
	        	JSONObject a18=addAttachment("合同13","http://a.kcway.net/assess/"+mt.getImgstep3_13(),"0");
	        	attachment.add(a18);
	        }
	        if(mt.getImgstep3_14()!=null&&!mt.getImgstep3_14().equals("")){
	        	JSONObject a19=addAttachment("补充1","http://a.kcway.net/assess/"+mt.getImgstep3_14(),"0");
	        	attachment.add(a19);
	        }
	        if(mt.getImgstep3_15()!=null&&!mt.getImgstep3_15().equals("")){
	        	JSONObject a20=addAttachment("补充2","http://a.kcway.net/assess/"+mt.getImgstep3_15(),"0");
	        	attachment.add(a20);
	        }	
	        if(mt.getImgstep3_16()!=null&&!mt.getImgstep3_16().equals("")){
	        	JSONObject a21=addAttachment("签约视频","http://a.kcway.net/assess/"+mt.getImgstep3_16(),"0");
	        	attachment.add(a21);
	        }	
	        if(mt.getImgstep4_12()!=null&&!mt.getImgstep4_12().equals("")){
	        	JSONObject a22=addAttachment("其他补充1","http://a.kcway.net/assess/"+mt.getImgstep4_12(),"0");	
	        	attachment.add(a22);
	        }
	        if(mt.getImgstep4_13()!=null&&!mt.getImgstep4_13().equals("")){
	        	JSONObject a23=addAttachment("其他补充2","http://a.kcway.net/assess/"+mt.getImgstep4_13(),"0");
	        	attachment.add(a23);
	        }
            if(mt.getImgstep4_14()!=null&&!mt.getImgstep4_14().equals("")){
            	JSONObject a24=addAttachment("其他补充3","http://a.kcway.net/assess/"+mt.getImgstep4_14(),"0");	
            	attachment.add(a24);
	        }	        
	        loanInfo.put("attachment",attachment);
	        /**
	         * 	共同借款人       
	         */
	        //loanInfo.put("coborrower", addCoborrower(mt.getCt_name(),mt.getCt_cardno()));// 共同借款人
	        // 抵押物
	        mgcert m=mt;	        
	        List<JSONObject> list = new ArrayList<>();		
	        List<JSONObject> list1 = new ArrayList<>();	
	        carmodel c=carmodelservice.modelmap(m.getCarid());	       
	           if(c!=null){	    	        	   
	        	System.out.println("id"+c.getId());
	        	JSONObject one = new JSONObject(true);
	        	JSONObject one1 = new JSONObject(true);
	        	archives arc=archivesservice.Apiarchives(m.getC_carno(),m.getC_vin(),"0");
	        	if(arc!=null){
	        	 if(arc.getR_item6()!=null){
	        		 one.put("collateralUniqueId",arc.getR_item6());//车辆识别代号	 
	        	 }else{
	        		 one.put("collateralUniqueId","00000000000");//车辆识别代号 
	        	 }
	        	}else{
	            one.put("collateralUniqueId","00000000000");//车辆识别代号	 
	        	 }
		        one.put("name",c.getName());// 名称
		        one.put("collateralType","2");// 抵押物类型
		        one.put("ownerName",m.getC_name());//产权人姓名
		        one.put("ownerIdcardNo",m.getC_cardno());// 产权人身份证号
		        one.put("newPrice",c.getPrice());// 新品价格
		       // one.put("invoiceNo","");//发票号码
		       // one.put("valuation","");//估值
		       // one.put("mortgageAmount","");//抵押金额
		        if(m.getImgstep4_1()!=null&&!m.getImgstep4_1().equals("")){
		        	JSONObject aa1=addAttachment("车辆铭牌","http://a.kcway.net/assess/"+m.getImgstep4_1(),"0");
		        	list.add(aa1);
		        }
		        if(m.getImgstep4_2()!=null&&!m.getImgstep4_2().equals("")){
		        	JSONObject aa2=addAttachment("车前45度","http://a.kcway.net/assess/"+m.getImgstep4_2(),"0");
		        	list.add(aa2);
		        }
		        if(m.getImgstep4_3()!=null&&!m.getImgstep4_3().equals("")){
		        	 JSONObject aa3=addAttachment("车后45度","http://a.kcway.net/assess/"+m.getImgstep4_3(),"0");
		        	 list.add(aa3);
		        }
		       if(m.getImgstep4_4()!=null&&!m.getImgstep4_4().equals("")){
		    	   JSONObject aa4=addAttachment("发动机舱","http://a.kcway.net/assess/"+m.getImgstep4_4(),"0");
		    	   list.add(aa4);
		       }
		        if(m.getImgstep4_5()!=null&&!m.getImgstep4_5().equals("")){
		        	JSONObject aa5=addAttachment("后备箱","http://a.kcway.net/assess/"+m.getImgstep4_5(),"0");
		        	list.add(aa5);
		        }
		        if(m.getImgstep4_6()!=null&&!m.getImgstep4_6().equals("")){
		        	JSONObject aa6=addAttachment("中控台","http://a.kcway.net/assess/"+m.getImgstep4_6(),"0");
		        	list.add(aa6);
		        }
		        if(m.getImgstep4_7()!=null&&!m.getImgstep4_7().equals("")){
		        	JSONObject aa7=addAttachment("仪表台公里数","http://a.kcway.net/assess/"+m.getImgstep4_7(),"0");	
		        	list.add(aa7);
		        }
		        if(m.getImgstep4_8()!=null&&!m.getImgstep4_8().equals("")){
		        	JSONObject aa8=addAttachment("人车合影","http://a.kcway.net/assess/"+m.getImgstep4_8(),"0");
		        	list.add(aa8);
		        }
		        if(m.getImgstep4_9()!=null&&!m.getImgstep4_9().equals("")){
		        	JSONObject aa9=addAttachment("车辆补充1","http://a.kcway.net/assess/"+m.getImgstep4_9(),"0");	
		        	list.add(aa9);
		        }
		        if(m.getImgstep4_10()!=null&&!m.getImgstep4_10().equals("")){
		        	JSONObject aa10=addAttachment("车辆补充2","http://a.kcway.net/assess/"+m.getImgstep4_10(),"0");	
		        	list.add(aa10);
		        }
		        if(m.getImgstep2_1()!=null&&!m.getImgstep2_1().equals("")){
		        	JSONObject aa11=addAttachment("产权证1-2页","http://a.kcway.net/assess/"+m.getImgstep2_1(),"0");	
		        	list.add(aa11);
		        }
		        if(m.getImgstep2_2()!=null&&!m.getImgstep2_2().equals("")){
		        	JSONObject aa12=addAttachment("产权证3-4页","http://a.kcway.net/assess/"+m.getImgstep2_2(),"0");	
		        	list.add(aa12);
		        }
		        if(m.getImgstep2_3()!=null&&!m.getImgstep2_3().equals("")){
		        	JSONObject aa13=addAttachment("产权证5-6页","http://a.kcway.net/assess/"+m.getImgstep2_3(),"0");
		        	list.add(aa13);
		        }		        				        
		        one.put("attachment",list);// List<CommonAttachment>		                                                      // 鍚�瑙侀檮浠�
		        archives ar=new archives();
		        archives arcbs=new archives();
//              query_type 0为查车档  1查博士
		        ar=archivesservice.Apiarchives(m.getC_carno(),m.getC_vin(),"0");
		        arcbs=archivesservice.Apiarchives(m.getC_carno(),m.getC_vin(),"1");
		        String vin="";
		        String enginno="";
		        if(ar!=null){
		    	    System.out.println("车辆查档--------"+ar.getId());
			        one.put("carArchives",addCarArchives(ar));// CarArchives 否 车辆档案         
			        vin=ar.getC_vin();
			        enginno=ar.getR_item7();	
			        System.out.println("-----------");
			      JSONObject cbs=null;  
                if(arcbs!=null&&!arc.equals("")){
                	if(arcbs.getCbs_orderid()!=null&&!arcbs.getCbs_orderid().equals("")){                		
                		cbs = cbshttp.cbsresult(arcbs.getCbs_orderid());	    					
                        // System.out.println("查博士:"+cbs+"---vin:"+vin+"-----enginno:"+enginno);
        		        one.put("carMaintain",addCarMaintain(m,cbs));// CarMaintain 否 车辆保养信息		       
                        if(cbs!=null){
         		    	   if(cbs.get("normalRepairRecords")!=null&&!cbs.get("normalRepairRecords").equals("")){
         		    	   String con=cbs.getString("normalRepairRecords");
         		    	   List l= jsonutil.toList(con);
         			       one.put("carMaintainRecord",addCarMaintainRecord(l));// List<CarMaintainRecord > 否 车辆保养记录	        	    		   
         	    	       }
                	}
                }

               }		
				 String carorg="";
				 String lsprefix="";
				 String lsnum="";
				 if(arc.getC_carno()!=null&&!arc.getC_carno().equals("")){
				  lsprefix=arc.getC_carno().substring(0,1);// 车牌前缀 utf8	 
				  lsnum=arc.getC_carno().substring(1,arc.getC_carno().length());// 车牌					
				 }
				 String lstype="02";
				 String engineno="";
				 String frameno="";
				 if(arc.getR_item7()!=null&&!arc.getR_item7().equals("")){
					 engineno=arc.getR_item7();// 发动机号
				 }
				 if(arc.getR_item6()!=null&&!arc.getR_item6().equals("")){
					 frameno=arc.getR_item6();// 车架号
				 }				 				 
				 //System.out.println(c);
				 try {
				 one.put("carPeccancy",addCarPeccancy(carorg, lsprefix, lsnum, lstype, engineno, frameno));// List<CarPeccancyRecord > 鍚�	                                                 // 杞﹁締杩濈珷				      
				} catch (Exception e) {
					
				}
				   //one.put("remark","");// 否 备注 
		       }
				 list1.add(one);
	        //loanInfo1.put("authInfo",authInfo);
	        }	  
	           /**
	            * 抵押物	          
	            */
	        loanInfo.put("collateral",list1);
	       // loanInfomg.put("collateral",list1);	 	      
	       zx z=zxservice.zxmap(c_name);
           List<JSONObject> rzxxfj=new ArrayList<JSONObject>();
	        if(z!=null){
		        if(z.getResult_pdf()!=null&&!z.getResult_pdf().equals("")){
		        JSONObject rzxx= addAttachment("认证信息附件","http://a.kcway.net/"+z.getResult_pdf(),"0");
		        rzxxfj.add(rzxx);	
		        }
	        }	
	        authInfo.put("creditInvestigate",rzxxfj);//addAttachment("认证信息附件")
	        JSONObject jn=new JSONObject(true);
	        String name =mt.getC_name();//名称
	        String ID_card=mt.getC_cardno();//身份证号
	        String mobile="";//手机号	
	        if(y!=null){
	        	ID_card=y.getC_cardid();
	        	mobile=y.getTEL();
	        }    
	        zx zdsj=zxservice.zxdsjmap(name);
	        System.out.println("name:"+name);
	        System.out.println("ID_card:"+ID_card);
	        System.out.println("mobile:"+mobile);
	        if(zdsj!=null){
		        if(zdsj.getReport_id()!=null){
		        	//ER201712291528576B32AA72
		           jn=dsjxxhttp.dsjresult(zdsj.getReport_id());
		           // String s=txt2String(new File("C:/Users/Administrator/Desktop/大数据返回测试数据.txt"));		        	
		           // jn=JSONObject.parseObject(s);
		            if(jn.get("success").toString().equals("true")){
			        		authInfo.put("riskInfo",addRiskInfo(jn,name,ID_card,mobile,zdsj));
			 	        	authInfo.put("riskResult",addRiskResult(jn));//
			 	        	//return jn.toJSONString();
			 	        }else{
			 	        	authInfo.put("riskInfo",addRiskInfo(null,name,ID_card,mobile,zdsj));
			 	        }
		        }  	
		        
	        }          		
      
            System.out.println("你的名字:"+name);
	        //
            if(name!=null){            	           
	        thjl t=thjlservice.thjlmap(name);
	        System.out.println("风险评估报告:"+t);
	        if(t!=null){	        	
	        System.out.println("风险评估报告:"+t.getId());
		    authInfo.put("phoneCommInfo", addCommInfo(t));
		    if(!t.getApi_note().equals("")&&t.getApi_note()!=null){
	        authInfo.put("phoneOperatorInfo",addOperatorInfo(t));
	        authInfo.put("phoneCallRecord", phoneCallRecord(t));
	        authInfo.put("phoneWaitRecord", phoneWaitRecord(t));	        
	        authInfo.put("phoneRiskAnalysis", phoneRiskAnalysis(t));	        
	        authInfo.put("phoneConsumeAnalysis", phoneConsumeAnalysis(t));
	        authInfo.put("phoneSMSAnalysis", phoneSMSAnalysis(t));
	        authInfo.put("phoneLocationAnalysis", phoneLocationAnalysis(t));
		    }		    
	        }		        
            }
            
	        loanInfo1.put("loanBase",loanInfo);
	        // System.out.println("authInfo"+authInfo);
	        loanInfo1.put("authInfo",authInfo);
	        //loanInfo1.put("repaymentPlan", addRepaymentPlan());	
	        loanInfoList.add(loanInfo1);   
//			} catch (Exception e) {
//				 System.out.println(e.toString());
//				 return  "111111111";
//			}
	       
	        // 先调用同步借款人接口
	        
    		 //obj1=obj.toString();
	           // System.out.println("第"+i+"次--------"+obj.toString());	
	         //resultjson1=resultjson1+"-++++++++-"+resultjson.toString();
	         //resultjson1.put("res"+i,resultjson.toString());
	         //System.out.println(resultjson1.toString());
    		} 
    	
    	String s;   	       			      
    	if(null!=loanInfoList&&loanInfoList.size()>0){
    	  JSONObject data = new JSONObject();   		
	    	int pointsDataLimit =1;//限制条数
	    	Integer size = loanInfoList.size();
	    	//pointsDataLimit
	    	if(pointsDataLimit<size){
	    	int part = size/pointsDataLimit;//分批数
	    	System.out.println("共有 ： "+size+"条，！"+" 分为 ："+part+"批");
	    	//
	    	for (int i=1;i <=part;i++){
	    	JSONObject obj = new JSONObject(true);		
	    	//100条
	        List<JSONObject> listPage =loanInfoList.subList(0,pointsDataLimit);   
//	    	System.out.println(listPage);
	        data.put("loanInfoList",listPage); 
	       	System.out.println("每批数据:"+listPage.size()); 
	      	//System.out.println(data.isEmpty());
	      	 obj=syncutil.createHead(data); 	       	 
	       	 obj.put("data",data); // 传递的参数   	       	       
//	         s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/addLoanInfo",obj.toString());				    		         	      	       	
//		     net.sf.json.JSONObject js=jsonutil.toJSONObject(s.toString());
//		     if(obj!=null&&!obj.equals("")){
//	         if(js.get("code").toString().equals("500")){
//	            // System.out.println("code:======"+js.get("code"));
//		     new WriteStringToTxt().WriteStringToFile5("C:/Users/Administrator/Desktop/json字符串/json异常"+i+".txt",obj.toString());		       			      
//		     } 	
//	     }
	    resultjson=resultjson+obj.toString();
	         //	剔除
	       	//System.out.println("返回参数："+s);
       	loanInfoList.subList(0,pointsDataLimit).clear();  
	      // return data.toString();	
	      }
	    if(!loanInfoList.isEmpty()){
	    	data.put("loanInfoList", loanInfoList); 
	       	System.out.println("剩下的数据:"+loanInfoList.size());//表示最后剩下的数据
	    	JSONObject obj=syncutil.createHead(data); 
	       	obj.put("data",data); // 传递的参数             
	        //s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/addLoanInfo",obj.toString());				    		         	        
	       	resultjson=resultjson+obj.toString();
//	       	net.sf.json.JSONObject js=jsonutil.toJSONObject(s.toString());
//	     	if(js.get("code").toString().equals("500")){
//            // System.out.println("code:======"+js.get("code"));
//	        new WriteStringToTxt().WriteStringToFile5("C:/Users/Administrator/Desktop/json字符串/jsonisjson异常剩余.txt",obj.toString());		       			      
//	     	}
	        }
	   }else{
		 data.put("loanInfoList", loanInfoList); 
	     System.out.println("小于2条数据:"+loanInfoList.size());
	 	 JSONObject obj=syncutil.createHead(data); 
       	 obj.put("data",data); // 传递的参数        	        	
       	 //s=syncjkrxxHttp.dyhttp("http://abs.51duoying.com:8082/ws/services/rest/loan/addLoanInfo",obj.toString());				    		         	      
       	 resultjson=obj.toString();
//	       	net.sf.json.JSONObject js=jsonutil.toJSONObject(s.toString());
//	     	if(js.get("code").toString().equals("500")){
//         // System.out.println("code:======"+js.get("code"));
//	        new WriteStringToTxt().WriteStringToFile5("C:/Users/Administrator/Desktop/json字符串/jsonisjson异常最后一条.txt",obj.toString());		       			      
//	     	}
	   }
	   }else{
	    System.out.println("没有数据!!!");
	   }
      
       	//System.out.println("MD5："+MD5.sign(data.toString(), "UTF-8"));   	
       	//data.put("MDssssssssss",MD5.sign(JSONObject.toJSONString(data), "UTF-8")); // 传递的参数       	
       	//data.put("txt","XXXX"+JSONObject.toJSONString(data) ); 
       return resultjson;		
	}
    /**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append(System.lineSeparator()+s);
            }
            br.close();    
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }
    
    public static void main(String[] args) {
   // TestKuaizhengCustomerCertificationInitialize tk=new TestKuaizhengCustomerCertificationInitialize();
    String s=txt2String(new File("C:/Users/Administrator/Desktop/test.txt"));
    
    JSONObject jn=JSONObject.parseObject(s);
	System.out.println(jn);
//    	String s="["
//                    +"{"
//                     +   "\"overdue_amount_range\": \"(5000, 10000]\","
//                    +    "\"overdue_time\": \"2016-10\""
//                  + " },"
//                  + " {"
//                 +       "\"overdue_amount_range\": \"(10000, 50000]\","
//                 +       "\"overdue_time\":\"2016-05\""
//                +    "},"
//                 +   "{"
//                 +       "\"overdue_amount_range\": \"(10000, 50000]\","
//                 +       "\"overdue_time\": \"2015-09\","
//                 +       "\"overdue_day_range\": \"(90, 180]\""
//                 +  " },"
//                 +   "{"
//                 +      " \"overdue_time\": \"2016-01\""
//                 +   "}"
//                +"]";
//		List l= jsonutil.toList(s);
//		for(int i=0;i<l.size();i++){
//			Map m=(Map) l.get(i);
//			System.out.println(m.get("overdue_time"));	
//		}
		
	}
}
