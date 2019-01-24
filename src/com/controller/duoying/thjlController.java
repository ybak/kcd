package com.controller.duoying;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import com.model1.thjl;

import com.service1.duoying.thjlService;


import net.sf.json.JSONArray;

import net.sf.json.JSONObject;

@Controller
public class thjlController {
	
	@Autowired
	private thjlService thjlService;

	@RequestMapping(value="findthjl.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findquerythjl(){
		List<thjl> thjl = new ArrayList<thjl>();
		List<JSONObject> list = new ArrayList<>();
		Map<String,Object> map=new HashMap<String,Object>();
		List<Map<String,Object>> maplist=new ArrayList<Map<String,Object>>();
		thjl = thjlService.findthjl();
		thjl th = new thjl();
		for(int i= 0;i<thjl.size();i++){
			th = thjl.get(i);
		Map<String,Object> thmap=new HashMap<String,Object>();
		thmap.put("id", th.getId());
		thmap.put("mid_add", th.getMid_add());
		thmap.put("mid_edit", th.getMid_edit());
		thmap.put("dt_add", th.getDt_add());
		thmap.put("dt_edit", th.getDt_edit());
		thmap.put("bc_status", th.getBc_status());
		thmap.put("quert_type", th.getQuery_type());
		thmap.put("gems_id", th.getGems_id());
		thmap.put("gems_fs_id", th.getGems_fs_id());
		thmap.put("c_name", th.getC_name());
		thmap.put("c_tel", th.getC_tel());
		thmap.put("c_cardno", th.getC_cardno());
		thmap.put("gems_code", th.getGems_code());
		thmap.put("api_status", th.getApi_status());
		thmap.put("api_token", th.getApi_token());
		//thmap.put("api_note", th.getApi_note());
		maplist.add(thmap);
        System.out.println(th.getApi_note());
		
		}
		
		
	

		String jsonStr = "";
		jsonStr = th.getApi_note();
		System.out.println("jsonStr"+jsonStr);
		Map<Object, Object> result = jsonToMap(jsonStr);
		//第一层数据
		System.out.println("编号"+result.get("_id"));
		System.out.println(result.get("basicInfo"));//
		System.out.println(result.get("callRecordsInfo"));//
		System.out.println(result.get("consumeInfo"));
		System.out.println(result.get("contactAreaInfo"));
		System.out.println(result.get("deceitRisk"));
		System.out.println(result.get("messageRecordsInfo"));
		System.out.println(result.get("phoneInfo"));
		System.out.println(result.get("phoneOffInfos"));
		System.out.println("手机号码："+result.get("phone_no"));
		System.out.println(result.get("specialCallInfo"));
		System.out.println("token"+result.get("token"));
		
		//第二层数据toArrayList
		
        Map<Object, Object> id = jsonToMap(result.get("_id"));//
		System.out.println(id.get("$oid"));
		
/*		Map<Object, Object> phoneno = jsonToMap(result.get("phone_no"));//手机号
		System.out.println(phoneno.get("phone_no"));
		
		Map<Object, Object> token = jsonToMap(result.get("token"));
		System.out.println(token.get("token"));*/
		
		
		
		
		Map<Object,Object> basicInfo = jsonToMap(result.get("basicInfo"));//基本信息
		System.out.println(basicInfo.get("age"));//年龄
		System.out.println(basicInfo.get("birthArea"));//出生日期
		System.out.println(basicInfo.get("birthday"));//出生地
		System.out.println(basicInfo.get("certNo"));//身份证号码
		System.out.println(basicInfo.get("phoneBelongArea"));//手机号归属地
		System.out.println("电话号码："+basicInfo.get("phoneNo"));//登记手机号
		System.out.println(basicInfo.get("reportID"));//报告编号
		System.out.println(basicInfo.get("reportTime"));//报告时间
		System.out.println(basicInfo.get("sex"));//年龄
		
		Map<Object,Object> phoneInfo = jsonToMap(result.get("phoneInfo"));//运营商基本信息
		System.out.println(phoneInfo.get("addr"));//登记地址
		System.out.println(phoneInfo.get("balance"));//当前余额
		System.out.println(phoneInfo.get("certNo"));//认证省份证号
		System.out.println(phoneInfo.get("email"));//登记邮箱
		System.out.println(phoneInfo.get("firstCallDate"));//最早通话时间
		System.out.println(phoneInfo.get("inNetDate"));//入网时间
		System.out.println(phoneInfo.get("lastCallDate"));//最近通话时间
		System.out.println(phoneInfo.get("netAge"));//网龄
		System.out.println(phoneInfo.get("operator"));//运营商类型
		System.out.println(phoneInfo.get("phoneNo"));//手机号
		System.out.println(phoneInfo.get("pointValue"));//积分值
		System.out.println(phoneInfo.get("realName"));//认证实名
		System.out.println(phoneInfo.get("vipLevel"));//会员等级
		JSONObject one6 = new JSONObject();
	        one6.put("operator", phoneInfo.get("operator"));// 枚举< PhoneServiceProviders > 是 运营商类型
	        // 0 移动
	        // 1 联通
	        // 2 电信
	        // 3 虚拟
	        one6.put("netInTime", phoneInfo.get("inNetDate"));// DateTime 是 入网时间
	        one6.put("autonym", phoneInfo.get("realName"));// String 是 实名认证
	        one6.put("phone", phoneInfo.get("phoneNo"));// String 是 手机号码
	        one6.put("email", phoneInfo.get("email"));// String 否 登记邮箱
	        one6.put("balance", phoneInfo.get("balance"));// Decimal 是 当前余额
	        one6.put("grade", phoneInfo.get("vipLevel"));// Int 是 会员等级
	        one6.put("integral", phoneInfo.get("pointValue"));// Int 是 积分值
	        one6.put("netAge", phoneInfo.get("netAge"));// Int 是 网龄
	        one6.put("beginCallTime", phoneInfo.get("firstCallDate"));// DateTime 是 最早通话时间
	        one6.put("latelyCallTime", phoneInfo.get("lastCallDate"));// DateTime 是 最近通话时间
	        one6.put("regAddress", phoneInfo.get("addr"));// String 是 登记地址
	        one6.put("remark", "remark");
		   list.add(one6);
	        
	        
		Map<Object, Object> deceitRisk = jsonToMap(result.get("deceitRisk"));
		System.out.println(deceitRisk.get("calledByCourtNo"));//是否出现法院相关号码呼叫
		System.out.println(deceitRisk.get("certNoIsValid"));//身份证号码有效性
		System.out.println(deceitRisk.get("emergency_contacted"));//是否联系过紧急联系人
		System.out.println(deceitRisk.get("inBlacklist"));//申请人信息是否命中网贷黑名单
		System.out.println(deceitRisk.get("longTimePowerOff"));//是否出现过长时间关机
		System.out.println(deceitRisk.get("phoneIsAuth"));//运营商是否实名
		System.out.println(deceitRisk.get("samePeople"));//运营商实名是否与登记人一致
		JSONObject one3 = new JSONObject();
	        one3.put("court", deceitRisk.get("calledByCourtNo"));// 枚举<YN> 是 是否出现法院相关号码呼叫
	        one3.put("valid", deceitRisk.get("certNoIsValid"));// 枚举<YN> 是 身份证号码有效性
	        one3.put("urgency", deceitRisk.get("emergency_contacted"));// 枚举<YN> 是 是否联系过紧急联系人
	        one3.put("blackList", deceitRisk.get("inBlacklist"));// 枚举<YN> 是 申请人信息是否命中网贷黑名单
	        one3.put("shutdown", deceitRisk.get("longTimePowerOff"));// 枚举<YN> 是 是否出现长时间关机
	        one3.put("reality", deceitRisk.get("phoneIsAuth"));// 枚举<YN> 是 运营商是否实名
	        one3.put("accordance", deceitRisk.get("samePeople"));// 枚举<YN> 是 运营商实名是否与登记人一致
	        one3.put("remark", "remark");
		    list.add(one3);
		
		List<Map<Object, Object>> callRecordsInfo = toList(result.get("callRecordsInfo"));//通话记录分析
		for(int a=0;a<callRecordsInfo.size();a++){
	    Map<Object, Object> call=new HashMap<Object,Object>();
	    call= callRecordsInfo.get(a);
	    System.out.println(call.get("belongArea"));//号码归属地
		System.out.println(call.get("callTimes"));//主叫次数
		System.out.println(call.get("calledTimes"));//被叫次数
		System.out.println(call.get("connTime"));//通话时长
		System.out.println(call.get("connTimes"));//通话次数
		System.out.println(call.get("identifyInfo"));//号码标识
		System.out.println("号码："+call.get("phoneNo"));//号码
		JSONObject one5 = new JSONObject();
        one5.put("callPhone", call.get("phoneNo"));// String 是 通话号码
        one5.put("callTime", call.get("connTime"));// int 是 通话时长
        one5.put("callNumber", call.get("connTimes"));// int 是 通话次数
        one5.put("calling", call.get("callTimes"));// int 是 主叫
        one5.put("called", call.get("calledTimes"));// int 是 被叫
        one5.put("phoneAddress", call.get("belongArea"));// String 是 号码归宿地
        one5.put("remark", "remark");
        list.add(one5);
		}
		

		List<Map<Object, Object>> consumeInfo = toList(result.get("consumeInfo"));//运营商消费分析
		for(int b=0;b<consumeInfo.size();b++){
	    Map<Object, Object> consume=new HashMap<Object,Object>();
	    consume= consumeInfo.get(b);
	    System.out.println(consume.get("callTime"));//主叫时间
		System.out.println(consume.get("calledTime"));//被叫时间
		System.out.println(consume.get("month"));//月份
		System.out.println(consume.get("payMoney"));//话费充值额
		System.out.println(consume.get("totalSmsNumber"));//短信数
		JSONObject one2 = new JSONObject();
        one2.put("month", consume.get("month"));// Int 是 月份
        one2.put("callingTime", consume.get("callTime"));// Int 是 主叫时间
        one2.put("calledTime", consume.get("calledTime"));// Int 是 被叫时间
        one2.put("noteNumber", consume.get("totalSmsNumber"));// Int 是 短信数
        one2.put("balance", consume.get("payMoney"));// Decimal 是 话费充值额
        one2.put("remark", "remark");
        list.add(one2);
		
		}
		
		
		List<Map<Object, Object>> contactAreaInfo = toList(result.get("contactAreaInfo"));//联系人位置分析
		for(int c=0;c<contactAreaInfo.size();c++){
	    Map<Object, Object> contact=new HashMap<Object,Object>();
	    contact= contactAreaInfo.get(c);
	    System.out.println(contact.get("area"));//地区
		System.out.println(contact.get("callTime"));//主叫时间
		System.out.println(contact.get("callTimes"));//主叫次数
		System.out.println(contact.get("calledTime"));//被叫时间
		System.out.println(contact.get("calledTimes"));//被叫次数
		System.out.println(contact.get("percent"));//占比
		System.out.println(contact.get("totalNumber"));//号码数量
		
		
        JSONObject one = new JSONObject();
        one.put("region", contact.get("area"));// String 是 地区
        one.put("phoneNumber", contact.get("totalNumber"));// int 是 号码数量
        one.put("callingNumber", contact.get("callTimes"));// int 是 主叫次数
        one.put("callingTime", contact.get("callTime"));// int 是 主教时间
        one.put("calledNumber", contact.get("calledTimes"));// int 是 被叫次数
        one.put("calledTime", contact.get("calledTime"));// int 是 被叫时间
        one.put("percentage", contact.get("percent"));// int 是 占比
        one.put("remark", "remark");
        list.add(one);
		}
		
		List<Map<Object, Object>> messageRecordsInfo = toList(result.get("messageRecordsInfo"));//短信记录分析
		for(int d=0;d<messageRecordsInfo.size();d++){
	    Map<Object, Object> message=new HashMap<Object,Object>();
	    message= messageRecordsInfo.get(d);
	    System.out.println(message.get("belongArea"));//号码归属地
		System.out.println(message.get("identifyInfo"));//号码标识
		System.out.println(message.get("phoneNo"));//号码
		System.out.println(message.get("totalSmsNumber"));//条数
		
		
	        JSONObject one1 = new JSONObject();
	        one1.put("notePhone", message.get("phoneNo"));// string 是 号码
	        one1.put("noteNumber", message.get("totalSmsNumber"));// int 是 短信条数
	        one1.put("noteAddress", message.get("belongArea"));// string 是 号码归属地
	        one1.put("remark", "remark");
	        list.add(one1);
		
		}
		
		List<Map<Object, Object>> phoneOffInfos = toList(result.get("phoneOffInfos"));//关机详情
		for(int e=0;e<phoneOffInfos.size();e++){
	    Map<Object, Object> phoneOff=new HashMap<Object,Object>();
	    phoneOff= phoneOffInfos.get(e);
	    System.out.println(phoneOff.get("beginDate"));//关机开始日期
		System.out.println(phoneOff.get("days"));//关机天数
		System.out.println(phoneOff.get("endDate"));//关机结束日期
		JSONObject one4 = new JSONObject();
        one4.put("beginTime", phoneOff.get("beginDate"));// DateTime 是 开始日期
        one4.put("overTime",phoneOff.get("endDate") );// DateTime 是 结束日期
        one4.put("countDay", phoneOff.get("days"));// int 是 天数
        one4.put("remark", "remark");
        list.add(one4);
		
		
		}
		
		
		List<Map<Object, Object>> specialCallInfo = toList(result.get("specialCallInfo"));//通话短信需求分析
		for(int f=0;f<specialCallInfo.size();f++){
	    Map<Object, Object> special=new HashMap<Object,Object>();
	    special= specialCallInfo.get(f);
	    System.out.println(special.get("connTimes"));//通话次数
		System.out.println(special.get("identityInfo"));//对方标识
		System.out.println(special.get("month"));//月份
		System.out.println(special.get("phoneNo"));//对方号码
		System.out.println(special.get("smsTimes"));//短信条数
		
		}
		map.put("list",list);
		maplist.add(map);
		return maplist.toString();
		}



   

	public static Map<Object, Object> jsonToMap(Object jsonObj) {
        JSONObject jsonObject = JSONObject.fromObject(jsonObj);
        Map<Object, Object> map = jsonObject;
        return map;
    }
	
	public static List<Map<Object, Object>> toList(Object object)
    {
        List<Map<Object, Object>> list = new ArrayList<Map<Object, Object>>();
        JSONArray jsonArray = JSONArray.fromObject(object);
        for (Object obj : jsonArray)
        {
            JSONObject jsonObject = (JSONObject) obj;
            Map<Object, Object> map = new HashMap<Object, Object>();
            Iterator it = jsonObject.keys();
            while (it.hasNext())
            {
                String key = (String) it.next();
                Object value = jsonObject.get(key);
                map.put(key, value);
            }
            list.add(map);
        }
        return list;
    }
	
	
}
