//package com.http;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Map;
// 
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
// 
//import com.alibaba.fastjson.JSON;
// 
//public class dqhttp {
// 
//    private static final Log log = LogFactory.getLog(dqhttp.class);
//    private static final String apiUrl = "https://api.tongdun.cn/postloan/monitor/v2";
// 
//    private HttpURLConnection conn;
// 
//    public RiskPostloanResponse invoke(Map<String, Object> params) {
//        try {
//            URL url = new URL(apiUrl);
//            // 组织请求参数
//            StringBuilder postBody = new StringBuilder();
//            for (Map.Entry<String, Object> entry : params.entrySet()) {
//                if (entry.getValue() == null) continue;
//                postBody.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue().toString(),
//                        "utf-8")).append("&");
//            }
// 
//            if (!params.isEmpty()) {
//                postBody.deleteCharAt(postBody.length() - 1);
//            }
// 
//            conn = (HttpURLConnection) url.openConnection();
//            // 设置长链接
//            conn.setRequestProperty("Connection", "Keep-Alive");
//            // 设置连接超时
//            conn.setConnectTimeout(1000);
//            // 设置读取超时
//            conn.setReadTimeout(3000);
//            // 提交参数
//            conn.setRequestMethod("POST");
//            conn.setDoOutput(true);
//            conn.getOutputStream().write(postBody.toString().getBytes());
//            conn.getOutputStream().flush();
//            int responseCode = conn.getResponseCode();
//            if (responseCode != 200) {
//                log.warn("RiskServicePostloan] invoke failed, response status:" + responseCode);
//                return null;
//            }
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
//            StringBuilder result = new StringBuilder();
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                result.append(line).append("\n");
//            }
//            return JSON.parseObject(result.toString().trim(), RiskPostloanResponse.class);
//        } catch (Exception e) {
//            log.error("[RiskServicePostLoan] invoke throw exception, details: " + e);
//        }
//        return null;
//    }
// 
//    public static void main(String[] args) {
//        Map<String, Object> params = new HashMap<String, Object>();
//        params.put("partner_code", "salesdemo");                        // 此处值填写您的合作方标识
//        params.put("partner_key", "c71d5ca75bec48dbbd00174404a09581");  // 合作方密钥
//        params.put("app_name", "show");                                 // 应用名称
//        params.put("report_id", "ER2016041111501310606186");            // 报告编号
//        params.put("sequence_id", "");
//        params.put("loan_term", 6);                                     // 放款期限
//        params.put("loan_term_unit", "DAY");                            // 贷款期限单位
//        params.put("loan_amount", 1000);                                // 放款金额
//        params.put("loan_date", 1440056827154L);                        // 放款日期
//        params.put("begin_scan_time", System.currentTimeMillis() + 86400000L + 1000L);  // 扫描开始时间
//        params.put("end_scan_time", 1521532027000L);                    // 扫描结束时间
//        params.put("scan_period", "7");                                 // 扫描周期
//        params.put("operator","");                                      // 操作员
//        RiskPostloanResponse riskResp = new dqhttp().invoke(params);
//        System.out.println(riskResp.toString());
//    }
// 
//}
//            
