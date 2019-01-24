package com.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.alibaba.fastjson.JSONObject;
//贷前  
public class RiskServicePreloan {
//	$testurl = "https://apitest.tongdun.cn/preloan/report/v7?partner_code=$p_code&partner_key=$p_key&app_name=$p_app_name";
//	$okurl = "https://api.tongdun.cn/preloan/report/v8?partner_code=$p_code&partner_key=$p_key&app_name=$p_app_name";
//?partner_code=$p_code&partner_key=$p_key&app_name=$p_app_name
    private static final Log    log          = LogFactory.getLog(RiskServicePreloan.class);
    private static final String submitUrl    = "https://api.tongdun.cn/preloan/apply/v5";
    private static final String queryUrl     = "https://api.tongdun.cn/preloan/report/v8";
    private static final long   WAIT_TIME    = 5 * 1000;

    private static final String PARTNER_CODE = "hdts";// 合作方标识
    private static final String PARTNER_KEY  = "fc6ea2c81e144074955a888631725dae";//合作方密钥
    // api fc6ea2c81e144074955a888631725dae 
    // test 39629fcf80034fa09ed3c63b4168e88b
    private static final String PARTNER_APP  = "hdts_web";//应用名  api hdts_web  test rongzizulin_web

    private HttpsURLConnection   conn;
    private SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();

    /**
     * submit接口示例
     * @param <PreloanSubmitResponse>
     *
     * @param params
     * @return 
     */
    public JSONObject apply(Map<String, Object> params) {

       // PreloanSubmitResponse submitResponse = new PreloanSubmitResponse();
        StringBuilder result = null;
        try {
            String urlString = new StringBuilder().append(submitUrl).append("?partner_code=").append(PARTNER_CODE).append("&partner_key=").append(PARTNER_KEY).append("&app_name=").append(PARTNER_APP).toString();
            URL url = new URL(urlString);
            System.out.println(urlString);
            System.out.println(params);
            // 组织请求参数
            StringBuilder postBody = new StringBuilder();
            for (Map.Entry<String, Object> entry : params.entrySet()) {
                if (entry.getValue() == null) continue;
                postBody.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(),"utf-8")).append("&");
            }
            if (!params.isEmpty()) {
                postBody.deleteCharAt(postBody.length() - 1);
            }
            conn = (HttpsURLConnection) url.openConnection();
            //设置https
            conn.setSSLSocketFactory(ssf);
            // 设置长链接
            conn.setRequestProperty("Connection","Keep-Alive");
            // 设置连接超时          
            // 设置读取超时
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            // 提交参数
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.getOutputStream().write(postBody.toString().getBytes());
            conn.getOutputStream().flush();
            int responseCode = conn.getResponseCode();
            System.out.println(responseCode);
      
            if (responseCode==200) {
            	System.out.println("11111111");
                BufferedReader bufferedReader = new BufferedReader(
                                                                   new InputStreamReader(conn.getInputStream(), "utf-8"));
                result = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    result.append(line).append("\n");
                }
                System.out.println("2"+result.toString().trim());
                //return jsonutil.toJSONString(result.toString().trim());
            }
        } catch (Exception e) {
            log.error("[RiskServicePreloan] apply throw exception, details: " + e);
        }
        return JSONObject.parseObject(result.toString().trim());
    }

    public  JSONObject query(String reportId) {
       // PreloanQueryResponse queryResponse = new PreloanQueryResponse();
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
                //return JSON.parseObject(result.toString().trim());
            }
        } catch (Exception e) {
            log.error("[RiskServicePreloan] query throw exception, details: " + e);
        }
        return JSONObject.parseObject(result.toString().trim());
    }

    public static void main(String[] args) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("loan_amount", ""); // 申请借款金额
        params.put("loan_term", ""); // 申请借款期限
        params.put("loan_term_unit", ""); // 期限单位
        params.put("loan_date", ""); // 申请借款日期
        params.put("purpose", ""); // 借款用途
        params.put("apply_province", ""); // 进件省份
        params.put("apply_city", ""); // 进件城市
        params.put("apply_channel", ""); // 进件渠道
        params.put("name", "胡八"); // 姓名 胡八 352123197501281314
        //皮晴晴 320304198404070412  ER2017122917192888A1963A

        params.put("id_number", "352123197501281314"); // 身份证号
        params.put("mobile", "13100000001"); // 手机号
        params.put("card_number", ""); // 银行卡
        params.put("work_phone", ""); // 单位座机
        params.put("home_phone", ""); // 家庭座机
        params.put("qq", ""); // qq
        params.put("email", ""); // 电子邮箱
        params.put("diploma", ""); // 学历
        params.put("marriage", ""); // 婚姻
        params.put("house_property", ""); // 房产情况
        params.put("house_type", ""); // 房产类型
        params.put("registered_address", ""); // 户籍地址
        params.put("home_address", ""); // 家庭地址
        params.put("contact_address", ""); // 通讯地址
        params.put("career", ""); // 职业
        params.put("applyer_type", ""); // 申请人类别
        params.put("work_time", ""); // 工作时间
        params.put("company_name", ""); // 工作单位
        params.put("company_address", ""); // 单位地址
        params.put("company_industry", ""); // 公司行业
        params.put("company_type", ""); // 公司性质
        params.put("occupation", ""); // 职位
        params.put("annual_income", ""); // 年收入
        params.put("is_cross_loan", ""); // 三个月内是否跨平台申请借款
        params.put("cross_loan_count", ""); // 三个月内跨平台申请借款平台个数
        params.put("is_liability_loan", ""); // 三个月内是否跨平台借款负债
        params.put("liability_loan_count", ""); // 三个月内跨平台借款负债平台个数
        params.put("is_id_checked", ""); // 是否通过实名认证
        params.put("contact1_relation", ""); // 第一联系人社会关系
        params.put("concatc1_name", ""); // 第一联系人姓名
        params.put("contact1_id_number", ""); // 第一联系人身份证
        params.put("contact1_mobile", ""); // 第一联系人手机号
        params.put("contact1_addr", ""); // 第一联系人家庭地址
        params.put("contact1_com_name", ""); // 第一联系人工作单位
        params.put("contact1_com_addr", ""); // 第一联系人工作地址
        params.put("contact2_relation", "");
        params.put("contact2_name", "");
        params.put("contact2_id_number", "");
        params.put("contact2_mobile", "");
        params.put("contact2_addr", "");
        params.put("contact2_com_name", "");
        params.put("contact2_com_addr", "");
        params.put("contact3_relation", "");
        params.put("contact3_name", "");
        params.put("contact3_id_number", "");
        params.put("contact3_mobile", "");
        params.put("contact3_addr", "");
        params.put("contact3_com_name", "");
        params.put("contact3_com_addr", "");
        params.put("contact4_relation", "");
        params.put("contact4_name", "");
        params.put("contact4_id_number", "");
        params.put("contact4_mobile", "");
        params.put("contact4_addr", "");
        params.put("contact4_com_name", "");
        params.put("contact4_com_addr", "");
        params.put("contact5_relation", "");
        params.put("contact5_name", "");
        params.put("contact5_id_number", "");
        params.put("contact5_mobile", "");
        params.put("contact5_addr", "");
        params.put("contact5_com_name", "");
        params.put("contact5_com_addr", "");
        params.put("ip_address", ""); // IP地址
        params.put("token_id", ""); // token_id
        params.put("black_box", ""); // black_box
        RiskServicePreloan service = new RiskServicePreloan();
        
        JSONObject riskPreloanResponse = service.apply(params);
        System.out.println(riskPreloanResponse.toString());        
        String[] s= analyzeJsonToArray(riskPreloanResponse,"value");
        System.out.println(s[0]);
        if (!riskPreloanResponse.equals("")) {
            // 等待一定时间后，可调用query接口查询结果。
            // 时间建议：5s后可调用
            try {
                Thread.sleep(WAIT_TIME);
            } catch (Exception e) {
                //
            }
            // query接口获取结果
            JSONObject response = service.query(s[0]);
            System.out.println(response);
            // 其他处理 。。。
        }
    }
    
    
    /**
     * 将json键值对分别解析到数组中
     * 
     * @param jsonject
     *            需要解析的json对象
     * @param type
     *            决定返回值的内容：键或值
     * @return type="key"：返回json对象中"键"的字符串， type="key""value":返回json对象中"值"的字符串
     */
    public static String[] analyzeJsonToArray(JSONObject jsonject, String type) {

    String string = jsonject.toString();
    
    string = string.replace("}", "");
    string = string.replace("{", "");
    string = string.replace("\"", "");
    System.out.println(string);
    String[] strings = string.split(",");

    if (type.equals("key")) {
    String[] stringsNum = new String[strings.length];
    for (int i = 0; i < strings.length; i++) {
    stringsNum[i] = strings[i].split(":")[0];
    }
    return stringsNum;
    } else if (type.equals("value")) {
    String[] stringsName = new String[strings.length];
    for (int i = 0; i < strings.length; i++) {
    stringsName[i] = strings[i].split(":")[1];
    }
    return stringsName;
    } else {
    return null;
    }
    } 
}

            

