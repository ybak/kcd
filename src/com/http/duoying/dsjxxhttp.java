package com.http.duoying;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.http.RiskServicePreloan;
import com.util.jsonutil;

public class dsjxxhttp {

	
	public static JSONObject dsj(String name,
	String ID_card,
	String mobile){
		RiskServicePreloan r=new RiskServicePreloan();
		Map<String, Object> params=new HashMap<String, Object>();  
		params.put("name",name); // ����
        params.put("id_number",ID_card); // ���֤��
        params.put("mobile",mobile); // �ֻ��
        JSONObject jsonobject=r.apply(params);
        JSONObject js = null;
        //System.out.println(jsonobject.get("success"));
        if(jsonobject.getString("success").equals("true")){
         System.out.println("111111");
         js=r.query(jsonobject.getString("report_id"));
         if(js!=null){
        	 return js;
         }else{
        	 return null;
         }
         
        }else{
       	 return null;
        }	
		
    }
	public static JSONObject dsjresult(
			String report_id
			){
		 JSONObject js = null;		 
		 RiskServicePreloan r=new RiskServicePreloan();
		 js=r.query(report_id);
		 return js;
	}
	
	
	public static void main(String[] args) {
		//name:����
		//ID_card:350322198803142514
		//mobile:15505941222
		//邹龙 330783197809070933
//		JSONObject js1 =dsj("皮晴晴","332521196311290450","15544444444");
//		System.out.println(js1);
//		JSONArray risk_items=JSONArray.parseArray(js1.get("risk_items").toString());
//		List l=jsonutil.toList(risk_items);
		//ER20171229161611FA2BFC80
		JSONObject s= dsjresult("ER201712291512502B63A975");
		
		
		System.out.println(s);
		if(s.get("success").toString()=="true"){
	List risk_items=jsonutil.toList(s.get("risk_items").toString()); 	
	for(int i=0;i<risk_items.size();i++){
		 Map m=(Map) risk_items.get(i);	
		 JSONObject item_detail=JSONObject.parseObject(m.get("item_detail").toString());	
		 System.out.println("item_detail---"+item_detail); 	
		 
		 if(item_detail.get("namelist_hit_details")!=null){
			 List namelist=jsonutil.toList(item_detail.get("namelist_hit_details").toString()); 
			 for(int j=0;j<namelist.size();j++){
				 Map m1=(Map) namelist.get(j); 
				 System.out.println("namelist---"+m1.get("fuzzy_detail_hits")); 
			 if(m1.get("fuzzy_detail_hits")!=null){
				 
				 List<Map<String, Object>> fuzzy=new ArrayList<Map<String, Object>>();
				 String  ja=m1.get("fuzzy_detail_hits").toString();
		          System.out.println(ja+"sss");
				 fuzzy=jsonutil.toList(ja); 
			    for(int l=0;l<fuzzy.size();l++){
			    	Map m2=(Map) fuzzy.get(l); 
			    	System.out.println("fuzzy--"+m2.get("fuzzy_name"));
			    }
			
				 }
			 }
		 }
		 
	}  
			
		}
		
		
		
	}
}
