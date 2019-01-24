package com.http;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

import net.sf.json.JSONObject;

public class dsjhttp {

	//?partner_code=$p_code&partner_key=$p_key&app_name=$p_app_name
    private static final Log    log          = LogFactory.getLog(RiskServicePreloan.class);
    private static final String submitUrl    = "https://apitest.tongdun.cn/preloan/apply/v5";
    private static final String queryUrl     = "https://apitest.tongdun.cn/preloan/report/v6";
    private static final long   WAIT_TIME    = 5 * 1000;

    private static final String PARTNER_CODE = "hdts";// 合作方标识
    private static final String PARTNER_KEY  = "39629fcf80034fa09ed3c63b4168e88b";//合作方密钥
    private static final String PARTNER_APP  = "rongzizulin_web";//应用名

	
    public static String dsjUnirest(String name,String id_number,String mobile){
//    	, String cKey
        //String SENTIMENT_URL ="http://www.zhixiangcf.com/wx/receive";
        //http://apitest.kcway.net
        //String body ="orderNo="+orderNo+"&errmsg="+errmsg;  //new JSONArray(new String[]{text}).toString();
        //System.out.println(body);
       String SENTIMENT_URL= new StringBuilder().append(submitUrl).append("?partner_code=").append(PARTNER_CODE).append("&partner_key=").append(PARTNER_KEY).append("&app_name=").append(PARTNER_APP).toString();
       
        HttpResponse<String> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(SENTIMENT_URL)
                   // .header("Content-Type","text/html;charset=UTF-8")
                    .header("Connection","Keep-Alive")
                    .header("Method","post")
                    .field("name", name)
                    .field("id_number", id_number)
                    .field("mobile", mobile)
                    .asString();
            //Unirest.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonResponse.getBody());
        return jsonResponse.getBody();
    }
    public static String dsjresUnirest(String reportId){
//    	, String cKey
        //String SENTIMENT_URL ="http://www.zhixiangcf.com/wx/receive";
        //http://apitest.kcway.net
        //String body ="orderNo="+orderNo+"&errmsg="+errmsg;  //new JSONArray(new String[]{text}).toString();
        //System.out.println(body);
       String SENTIMENT_URL= new StringBuilder().append(queryUrl).append("?partner_code=").append(PARTNER_CODE).append("&partner_key=").append(PARTNER_KEY).append("&report_id=").append(reportId).toString();
       
        HttpResponse<String> jsonResponse = null;
        try {
            jsonResponse = Unirest.get(SENTIMENT_URL)
                   // .header("Content-Type","text/html;charset=UTF-8")
                    .header("Connection","Keep-Alive")
                    .header("Method","get")
                    .queryString("reportId", reportId)
                    //.field("reportId", reportId)
                    //.field("id_number", id_number)
                   // .field("mobile", mobile)
                    .asString();
            //Unirest.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonResponse.getBody());
        return jsonResponse.getBody();
    }
    
    public static void main(String[] args) {
    	String name="赵春风";//姓名
    	String id_number="210105197712340622";//身份证号
    	String mobile="13100000001";//手机号
    	String res=dsjUnirest(name, id_number, mobile);
    	JSONObject js=JSONObject.fromObject(res);
    	
    	System.out.println(js.get("success"));
    	//ER20171207094526B7DF3537
    	String reportId=(String) js.get("report_id");
    	String res1=dsjresUnirest(reportId);
    	System.out.println(res1);
	}
	
}
