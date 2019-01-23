package com.http.tyAPI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.httpclient.HttpStatus;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;


public class queryLoanInfoResult {

    /**
     * 以post方式访问
     * 
     * @param url
     *            接口url地址
     * @param xmlBody
     *            xml格式的字符串
     * @return
     */
    public static String post(String url, String xmlBody) {
        HttpClient httpClient = new DefaultHttpClient();
        try {
            HttpPost httpPost = new HttpPost(url);

            StringEntity input = new StringEntity(xmlBody, "UTF-8");
            input.setContentType("application/json");

            httpPost.setEntity(input);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();

            if (statusCode == HttpStatus.SC_OK) {
                HttpEntity httpEntity = httpResponse.getEntity();
                String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                EntityUtils.consume(httpEntity);
                JSONObject j = JSON.parseObject(result);
                System.out.println(result);
                return result;
            } else {
                HttpEntity httpEntity = httpResponse.getEntity();
                String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                EntityUtils.consume(httpEntity);
                JSONObject j = JSON.parseObject(result);
                System.out.println(result);
                return result;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                httpClient.getConnectionManager().shutdown();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return "";
    }

    private static String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCU41GfwgaxN4b5HjL5BcbTPbkBTjhqalo45yXSUaz1jI29Wg1kvG7SEsBJvNGbPJrD5O/0G9nYddaqUo72jcFyiCtMycIvWdFes62Tc/ulezYD6Wyo5lsVPkGmNg/QitwVpcrKFam/GEiErduae9pwfB8zhyfrCA3iiSPVCGP7ywIDAQAB";

    private static String privatekey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJTjUZ/CBrE3hvkeMvkFxtM9uQFOOGpqWjjnJdJRrPWMjb1aDWS8btISwEm80Zs8msPk7/Qb2dh11qpSjvaNwXKIK0zJwi9Z0V6zrZNz+6V7NgPpbKjmWxU+QaY2D9CK3BWlysoVqb8YSISt25p72nB8HzOHJ+sIDeKJI9UIY/vLAgMBAAECgYEAim5IyCdYnZEpN5qyfgK2+FVdHC+kGJ1Fwb541fIGxE+owbNm3JCu4Td5/ZVHtfRFWXoU+HyksbPuoXIdZnQqtWuInNhdPVpiir6/yXSvP5LLfQN6lqkCzapgtuhuz3Cayp58qb0k4ujZ2l5pegNN7a8plqHUSZNoE3VFHMNNTZECQQDYyRm7U+gliPlnO8bpnnU6ciFbiAeXbWS4z+HY2hLHWqFO7U2grBKueJ1yMYDNL8PCGbbyO0bUxDIu07t5KYg1AkEAr9IEzgIYwbCBujRgJ3rj7r5bXsggzTiHLypj+Uvsq0niI2TvHmiYczP0m9lSHmuvZwhcdhd0bufA81Zigi/z/wJBAIcVAGC3Dw/cgzQtjmviXj/WAC0t3TUhaEK03pEmic8JDTzGJ7n3nwhyhgEzEYRJwByBs3rLLv7DZlXBf68nDwUCQHe4mND2mIj7ebqjg34eriqZsHn/6GYVweeaA+1zh7qzWqsjRbf9HSIFFOEywDo6tXuBNAStv/jtEnQgNH/Vy10CQBzWF7XlU9oXiLwoVoe+7JAe7cnfAfG+2nwiuzc0x9oHB1p7rET3u0AMIR6LfC0K2FWheQRYcqsAWyQviIjWa8I=";

    private static JSONObject createHead() {
        JSONObject obj = new JSONObject();
        obj.put("ver", "1.0");// 版本
        obj.put("curTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        obj.put("nonce", new Random().nextInt(10000));// 一个随机数
        obj.put("sign",""); //MD5.sign(privatekey + obj.getString("nonce") + obj.getString("curTime"), "UTF-8"));// 签名
        obj.put("signType", "MD5");// 签名类型
        obj.put("appKey", "adsdasd");// 多盈提供的APPKEY
        return obj;
    }

    public static void core() {
        JSONObject data = new JSONObject();
        List<String> list = new ArrayList<>();
        list.add("1964081408");
        list.add("-2044222800");
        list.add("161448222");
        list.add("-1715196235");
        list.add("725570984");
        list.add("-840080759");
        list.add("-1880912291");
        list.add("1652647298");
        list.add("-1961075495");
        list.add("-950492266");
        list.add("-1100665004");
        list.add("-88679591");
        data.put("idList", list);
        // 先调用同步借款人接口
        final JSONObject obj = createHead();
        obj.put("data", data); // 传递的参数
        cachedThreadPool.execute(new Runnable() {
            String aa = obj.toString();

            @Override
            public void run() {
                post("http://localhost:8080/services/rest/loan/queryLoanInfoResult", aa);
            }
        });
    }
 
    static ExecutorService cachedThreadPool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {
        core();
        cachedThreadPool.shutdown();

    }

}
