package com.http.duoying;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.chaboshi.util.CBS;
import com.http.RiskServicePreloan;
import com.util.jsonutil;



public class cbshttp
{
//	protected $userid = "60206";
//	protected $keySecret = "b2082f585b0fcb96f19283bb74e5f235"; 	
	public static JSONObject chaboshi(String vin,String callbackurl,String enginno,String licenseplate) throws InterruptedException{
		JSONObject jsonoj = null;
		String userid = "60206";
		String keySecret = "b2082f585b0fcb96f19283bb74e5f235";	  
	    String brand= CBS.getInstance(userid, keySecret).getCheckBrand(vin);	   
	    JSONObject j= JSONObject.parseObject(brand);
	    System.out.println("code:"+j);
	    if(j.getString("Code").equals("1106")){
		String buy= CBS.getInstance(userid, keySecret).getBuyReport(vin, enginno, licenseplate, callbackurl);
		// System.out.println(buy);
		JSONObject j1= JSONObject.parseObject(buy);
		Thread.sleep(10000);
	    if(j1.getString("Code").equals("0")){
	    String orderId=j1.getString("orderId");
		String json=CBS.getInstance(userid, keySecret).getNewReportJson(orderId); 	
		jsonoj= JSONObject.parseObject(json);
		 }	    
	   }
	return jsonoj;
	  	  
  }
	
	public static JSONObject cbsresult(String orderid){
		 JSONObject jsonoj = null;
		 String userid = "60206";
		 String keySecret = "b2082f585b0fcb96f19283bb74e5f235";
		 String json=CBS.getInstance(userid, keySecret).getNewReportJson(orderid); 	
		 jsonoj= JSONObject.parseObject(json);			
		 return jsonoj;
	 }
	
	
	public static void main(String[] args) {
		
		
		
		JSONObject s= cbsresult("b683b7bdce5a4031b5871f81bb6401b3");
		
		System.out.println(s.get("normalRepairRecords"));
//		LVHRM181XE5055914
//		3060743
//		闽DA601P

		String vin="LVHRM181XE5055914";
		String callbackurl="";
		String enginno="";
		String licenseplate="";
		 JSONObject b;
		try {
			 b = chaboshi(vin,null,null,null);
			 System.out.println(b);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		 //String c= b.getString("normalRepairRecords");
		// System.out.println(c);
		// List l= jsonutil.toList(c);
//		 for(int i=0;i<l.size();i++){
//			 Map m=(Map) l.get(i);
//			 System.out.println(m);
//		 }
//		String name="皮晴晴 ";
//		String ID_card="370404199006301915";
//		String mobile="6230901807030310952";
//		RiskServicePreloan r=new RiskServicePreloan();
//		Map<String, Object> params=new HashMap<String, Object>();  
//		 params.put("name",name); // 姓名
//         params.put("id_number",ID_card); // 身份证号
//         params.put("mobile",mobile); // 手机号
//         JSONObject jsonobject=r.apply(params);
//         System.out.println(jsonobject);
		// JSONObject t= jsonutil.toJSONObject(c.replace("[", "").replace("]", ""));
		// System.out.println(l.size());
		//System.out.println(b);
	}
}