//package com.duoying.api;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Random;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//import org.apache.commons.httpclient.HttpStatus;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.entity.StringEntity;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.util.EntityUtils;
//
//import com.alibaba.fastjson.JSONObject;
//import com.duoying.BaseJunit4Test;
//import com.duoying.abs.utils.security.MD5;
//
//public class updateLoanInfo extends BaseJunit4Test {
//
//    /**
//     * 浠ost鏂瑰紡璁块棶
//     * 
//     * @param url
//     *            鎺ュ彛url鍦板潃
//     * @param xmlBody
//     *            xml鏍煎紡鐨勫瓧绗︿覆
//     * @return
//     */
//    public static String post(String url, String xmlBody) {
//        HttpClient httpClient = new DefaultHttpClient();
//        try {
//            HttpPost httpPost = new HttpPost(url);
//
//            StringEntity input = new StringEntity(xmlBody, "UTF-8");
//            input.setContentType("application/json");
//
//            httpPost.setEntity(input);
//
//            HttpResponse httpResponse = httpClient.execute(httpPost);
//            int statusCode = httpResponse.getStatusLine().getStatusCode();
//
//            if (statusCode == HttpStatus.SC_OK) {
//                HttpEntity httpEntity = httpResponse.getEntity();
//                String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
//                EntityUtils.consume(httpEntity);
//                JSONObject j = JSONObject.parseObject(result);
//                System.out.println(result);
//                return result;
//            } else {
//                HttpEntity httpEntity = httpResponse.getEntity();
//                String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
//                EntityUtils.consume(httpEntity);
//                JSONObject j = JSONObject.parseObject(result);
//                System.out.println(result);
//                return result;
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                httpClient.getConnectionManager().shutdown();
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//        return "";
//    }
//
//    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCU41GfwgaxN4b5HjL5BcbTPbkBTjhqalo45yXSUaz1jI29Wg1kvG7SEsBJvNGbPJrD5O/0G9nYddaqUo72jcFyiCtMycIvWdFes62Tc/ulezYD6Wyo5lsVPkGmNg/QitwVpcrKFam/GEiErduae9pwfB8zhyfrCA3iiSPVCGP7ywIDAQAB";
//
//    private static String privatekey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJTjUZ/CBrE3hvkeMvkFxtM9uQFOOGpqWjjnJdJRrPWMjb1aDWS8btISwEm80Zs8msPk7/Qb2dh11qpSjvaNwXKIK0zJwi9Z0V6zrZNz+6V7NgPpbKjmWxU+QaY2D9CK3BWlysoVqb8YSISt25p72nB8HzOHJ+sIDeKJI9UIY/vLAgMBAAECgYEAim5IyCdYnZEpN5qyfgK2+FVdHC+kGJ1Fwb541fIGxE+owbNm3JCu4Td5/ZVHtfRFWXoU+HyksbPuoXIdZnQqtWuInNhdPVpiir6/yXSvP5LLfQN6lqkCzapgtuhuz3Cayp58qb0k4ujZ2l5pegNN7a8plqHUSZNoE3VFHMNNTZECQQDYyRm7U+gliPlnO8bpnnU6ciFbiAeXbWS4z+HY2hLHWqFO7U2grBKueJ1yMYDNL8PCGbbyO0bUxDIu07t5KYg1AkEAr9IEzgIYwbCBujRgJ3rj7r5bXsggzTiHLypj+Uvsq0niI2TvHmiYczP0m9lSHmuvZwhcdhd0bufA81Zigi/z/wJBAIcVAGC3Dw/cgzQtjmviXj/WAC0t3TUhaEK03pEmic8JDTzGJ7n3nwhyhgEzEYRJwByBs3rLLv7DZlXBf68nDwUCQHe4mND2mIj7ebqjg34eriqZsHn/6GYVweeaA+1zh7qzWqsjRbf9HSIFFOEywDo6tXuBNAStv/jtEnQgNH/Vy10CQBzWF7XlU9oXiLwoVoe+7JAe7cnfAfG+2nwiuzc0x9oHB1p7rET3u0AMIR6LfC0K2FWheQRYcqsAWyQviIjWa8I=";
//
//    private static JSONObject createHead() {
//        JSONObject obj = new JSONObject();
//        obj.put("ver", "1.0");// 鐗堟湰
//        obj.put("curTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
//        obj.put("nonce", new Random().nextInt(10000));// 涓�涓殢鏈烘暟
//        obj.put("sign", MD5.sign(privatekey + obj.getString("nonce") + obj.getString("curTime"), "UTF-8"));// 绛惧悕
//        obj.put("signType", "MD5");// 绛惧悕绫诲瀷
//        obj.put("appKey", "adsdasd");// 澶氱泩鎻愪緵鐨凙PPKEY
//        return obj;
//    }
//
//    public static void core() {
//        JSONObject data = new JSONObject();
//        List<JSONObject> list = new ArrayList<>();
//
//        list.add(addOne());
//
//        data.put("loanInfoList", list);
//        // 鍏堣皟鐢ㄥ悓姝ュ�熸浜烘帴鍙�
//        JSONObject obj = createHead();
//        obj.put("data", data); // 浼犻�掔殑鍙傛暟
//        cachedThreadPool.execute(new Runnable() {
//            String aa = obj.toString();
//
//            @Override
//            public void run() {
//                post("http://localhost:8080/services/rest/loan/updateLoanInfo", aa);
//            }
//        });
//    }
//
//    private static JSONObject addOne() {
//        JSONObject one = new JSONObject();
//
//        one.put("loanBase", addLoanBase());// gems_fs_id
//        one.put("updateType", "0");
//        return one;
//    }
//
//    private static JSONObject addLoanBase() {
//        JSONObject one = new JSONObject();
//        one.put("loanBaseId", "1875367290");
//        one.put("disbursementBank", addBankInfo());
//        return one;
//    }
//
//    /**
//     * 閾惰淇℃伅 ,澶嶆暟
//     * 
//     * @return
//     */
//    private static   JSONObject addBankInfo() {
//        JSONObject oneBank = new JSONObject();
//        oneBank.put("bankName", "鍗庡閾惰5");// 閾惰鍚嶇О bank
//        oneBank.put("bankBranchName", "鏀5");// String 鍒嗚/寮�鎴疯鍚嶇О name
//        oneBank.put("accountNo", "abc5");// String 閾惰璐﹀彿 cardunm
//        return(oneBank);
//    }
//
//    static ExecutorService cachedThreadPool = Executors.newFixedThreadPool(5);
//
//    public static void main(String[] args) throws Exception {
//        core();
//        cachedThreadPool.shutdown();
//
//    }
//
//}
