package com.controller.PFmodel;
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.URL;
import java.util.Currency;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
/**
 * 大数据征信demo
 * 2018年4月25日
 */
public class RiskServicePreloan {
    private static final Log  log= LogFactory.getLog(RiskServicePreloan.class);
    private static final String submitUrl    = "https://api.tongdun.cn/preloan/apply/v5";
    private static final String queryUrl     = "https://api.tongdun.cn/preloan/report/v8";
    private static final long   WAIT_TIME    = 5 * 1000;
    private static final String PARTNER_CODE = "hdts";// 合作方标识
    private static final String PARTNER_KEY  = "fc6ea2c81e144074955a888631725dae";//合作方密钥
    private static final String PARTNER_APP  = "hdts_web";//应用名  api hdts_web  test rongzizulin_web
    private HttpsURLConnection   conn;
    private SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();
    public  JSONObject query(String reportId) {
    	 StringBuilder result = null;
        try {
            String urlString = new StringBuilder().append(queryUrl).append("?partner_code=").append(PARTNER_CODE).append("&partner_key=").append(PARTNER_KEY).append("&report_id=").append(reportId).toString();
            URL url = new URL(urlString);
            conn = (HttpsURLConnection) url.openConnection();
            //设置https
            conn.setSSLSocketFactory(ssf);
            // 设置长链接
            conn.setRequestProperty("Connection", "Keep-Alive");
            // 设置连接超时          
            // 设置读取超时
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            // 提交参数
            conn.setRequestMethod("GET");
            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), "utf-8"));
                result = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line).append("\n");
                }
            }
        } catch (Exception e) {
            log.error("[RiskServicePreloan] query throw exception, details: " + e);
        }
        return JSONObject.parseObject(result.toString().trim());
    }
    public void Customer(Customer customer){ 
    	  RiskServicePreloan service = new RiskServicePreloan();
    	  JSONObject jsonObject=service.query("ER2017040814362018354777");
    	  System.out.println(jsonObject.toJSONString());
    	  JSONArray  ja1=(JSONArray) jsonObject.get("risk_items");//获得所有的风险项
    	  if(ja1!=null){////扫描出来的风险项不为空
    		  for(int i=0;i<ja1.size();i++){
    			  JSONObject jo=(JSONObject) ja1.get(i);//获得这个风险项
    			  JSONObject jo2= (JSONObject)jo.get("item_detail");//检查详情
    			  Object ss1=jo2.get("platform_count");
    			  String s=jo.getString("item_id");
    			  if(ss1!=null){
    				  if(s.equals("3393158")){ //7天内申请人在多个平台申请借款
        				  customer.setSeven_days(ss1.toString());
         			  }else if(s.equals("3393160")){ //一个月内申请人在多个平台申请借款
        				   customer.setOne_month(ss1.toString());//多头借款
         			  }else if(s.equals("3393162")){ //3个月内申请人在多个平台申请借款
           				   customer.setThree_month(ss1.toString());
         			  }else if(s.equals("3393164")){ //6个月内申请人在多个平台申请借款
    	   				   customer.setSix_month(ss1.toString());
        			  }else if(s.equals("3393166")){ //12个月内申请人在多个平台申请借款
    	   				   customer.setTwelve_month(ss1.toString());
    	    		 }
    				  continue;
    			  }
	   			 if(s.equals("10")){ // 法院执行 失信人
	   				   JSONArray ja2=(JSONArray) jo2.get("namelist_hit_details");//命中名单详情列表
	   				   for(int j=0;j<ja2.size();j++){
	   					JSONArray ja3=ja2.getJSONObject(j).getJSONArray("court_details");//法院详情列表
	   					for(int z=0;z<ja3.size();z++){
	   						JSONObject jo3=(JSONObject)ja3.get(z);//法院详情
	   						String s0=jo3.get("fraud_type").toString();//欺诈类型  "法院失信"，"法院执行"，"法院结案"中的一种
	   						String s1=jo3.getString("situation").toString();//情况
	   						if(s0.equals("法院失信")){//曾经失信过
	   							customer.setIs_credit("1");
	   							continue;
	   						}
	   						if(s0.equals("法院执行")){
	   							if(s1.equals("已结案") && !customer.getCourt_execution().equals("2")){//被执行人的履行情况：已结案 并且没有未结案的
	   								customer.setCourt_execution("1");
	   							}else{
	   								customer.setCourt_execution("2");
	   							}
	   							continue;
	   						}
	   						if(s0.equals("法院结案")  && !customer.getCourt_execution().equals("2")){//存在法院结案 并且没有在执行中的
	   							customer.setCourt_execution("1");
	   							continue;
	   						}
	   					  }
	   				    }
	    			 }	
	    		  } 	
	    		 Demo_TaiRA.fun(customer); 
	    	  }  	
    	}
}