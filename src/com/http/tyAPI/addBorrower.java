package com.http.tyAPI;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.util.md5util;



public class addBorrower {
    /**
     * 银行信息 ,复数
     * 
     * @return
     */
    private static List<JSONObject> addBankInfo() {
        List<JSONObject> banks = new ArrayList<>();
        JSONObject oneBank = new JSONObject();
        oneBank.put("bankName", "华夏银行");// 银行名称 bank
        oneBank.put("bankBranchName", "支行");// String 分行/开户行名称 name
        oneBank.put("accountNo", "abc");// String 银行账号 cardunm
        banks.add(oneBank);
        return banks;
    }

    /**
     * 个人信息基础
     * 
     * @return
     */
    private static JSONObject addBaseInfo() {
        JSONObject personalBase = new JSONObject();
        personalBase.put("borrowerId", "fb8c8939-ffb5-4f4b-b381-e079d6b2e171"); // 借款人外部唯一ID 此ID不可重复
                                             // 代表借款人的系统中的唯一指定id,没有的话
        // 可以使用 加盟店ID+身份证做标识(36位)
        personalBase.put("categoryId", "SH");// gems_fs_id 加盟店ID //需要事先同步
                                             // ,此ID+证件号的组合不可重复
        personalBase.put("name", "3");// c_name
        personalBase.put("formerName", "4");//曾用名
        personalBase.put("sex", "1"); 
        personalBase.put("birthDate", "19880210000000");
        personalBase.put("maritalStatus", "7");
        personalBase.put("supportCount", "8");
        personalBase.put("familyCount", "9");
        personalBase.put("educationLevel", "10");
        personalBase.put("mobilePhone", "11");// phone
        personalBase.put("telephone", "12");
        personalBase.put("cityCode", "广东省广州市");// 所在地区 二级
        personalBase.put("instantMessaging", "14");
        personalBase.put("currentAddress", "15");
        personalBase.put("shippingAddress", "16");
        personalBase.put("zipCode", "17");
        personalBase.put("email", "18");
        personalBase.put("arrivalTime", "19880210000000");
        personalBase.put("householdDegisterType", "20");
        personalBase.put("certificateType", "21");// parperstype
        personalBase.put("certificateNo", "22");// parpersnum
        personalBase.put("certificateValidityDate", "19880210000000");
        personalBase.put("driverLicense", "24");
        personalBase.put("riskAssessment", "25");
        personalBase.put("assetsStatisticsDate", "19880210000000");
        personalBase.put("remark", "27");
        personalBase.put("managerId","28");
        return personalBase;
    }

    private static JSONObject addPersonalInfo() {
        JSONObject personal = new JSONObject();
        personal.put("base", addBaseInfo());// 个人数据的基础信息;
        personal.put("bank", addBankInfo());// 个人的银行信息,可以多个
        personal.put("attachment", addAttachment("个人附件"));// // 行驶证 imgstep2_4
        // 身份证正面 imgstep2_5
        // 身份证反面 imgstep2_6
        // 放款流水（或银行卡）imgstep2_10
        // 征信报告 imgstep2_11
        // 2017-7-10新增行驶证背面 imgstep4_11
        // 住家位置1 imgstep2_14
        // 住家位置2 imgstep2_15
        // 住家环境1 imgstep2_16
        // 住家环境2 imgstep2_17
        // 住家证明 imgstep2_18
        // 身份证 c_cardmo
        return personal;
    }

    /**
     * 附件
     */
    private static Object addAttachment(String a) {
        List<JSONObject> attachment = new ArrayList<>();
        JSONObject xxz = new JSONObject();
        attachment.add(xxz);
        xxz.put("fileName", a);
        xxz.put("fileUrl", "2");
        xxz.put("fileType", "1");
        xxz.put("fileString", "2");
        xxz.put("remark", "3");
        return attachment;
    }

    /**
     * 同步借款人
     */
    private static void submitBorrower() {
        JSONObject data = new JSONObject();
        List<JSONObject> personalList = new ArrayList<>();
        personalList.add(addPersonalInfo());
        data.put("personalList", personalList);
        // 先调用同步借款人接口
        final JSONObject obj = createHead();
        obj.put("data", data); // 传递的参数
        cachedThreadPool.execute(new Runnable() {
            String aa = obj.toString();          
            @Override
            public void run() {
                post("http://localhost:8080/services/rest/borrower/addPersonal", aa);
            }
        });
    }

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
                System.out.println(url+"----"+xmlBody);
            StringEntity input = new StringEntity(xmlBody, "UTF-8");
            input.setContentType("application/json");

            httpPost.setEntity(input);

            HttpResponse httpResponse = httpClient.execute(httpPost);
            int statusCode = httpResponse.getStatusLine().getStatusCode();

            if (statusCode ==HttpStatus.SC_OK) {
                HttpEntity httpEntity = httpResponse.getEntity();
                String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                EntityUtils.consume(httpEntity);
                JSONObject j = JSON.parseObject(result);
                if (j.get("code").toString().equals("500"))
                    System.out.println(result);
                return result;
            } else {
                HttpEntity httpEntity = httpResponse.getEntity();
                String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                EntityUtils.consume(httpEntity);
                JSONObject j = JSON.parseObject(result);
                if (j.get("code").toString().equals("500"))
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

    private static String privatekey = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJTjUZ/CBrE3hvkeMvkFxtM9uQFOOGpqWjjnJdJRrPWMjb1aDWS8btISwEm80Zs8msPk7/Qb2dh11qpSjvaNwXKIK0zJwi9Z0V6zrZNz+6V7NgPpbKjmWxU+QaY2D9CK3BWlysoVqb8YSISt25p72nB8HzOHJ+sIDeKJI9UIY/vLAgMBAAECgYEAim5IyCdYnZEpN5qyfgK2+FVdHC+kGJ1Fwb541fIGxE+owbNm3JCu4Td5/ZVHtfRFWXoU+HyksbPuoXIdZnQqtWuInNhdPVpiir6/yXSvP5LLfQN6lqkCzapgtuhuz3Cayp58qb0k4ujZ2l5pegNN7a8plqHUSZNoE3VFHMNNTZECQQDYyRm7U+gliPlnO8bpnnU6ciFbiAeXbWS4z+HY2hLHWqFO7U2grBKueJ1yMYDNL8PCGbbyO0bUxDIu07t5KYg1AkEAr9IEzgIYwbCBujRgJ3rj7r5bXsggzTiHLypj+Uvsq0niI2TvHmiYczP0m9lSHmuvZwhcdhd0bufA81Zigi/z/wJBAIcVAGC3Dw/cgzQtjmviXj/WAC0t3TUhaEK03pEmic8JDTzGJ7n3nwhyhgEzEYRJwByBs3rLLv7DZlXBf68nDwUCQHe4mND2mIj7ebqjg34eriqZsHn/6GYVweeaA+1zh7qzWqsjRbf9HSIFFOEywDo6tXuBNAStv/jtEnQgNH/Vy10CQBzWF7XlU9oXiLwoVoe+7JAe7cnfAfG+2nwiuzc0x9oHB1p7rET3u0AMIR6LfC0K2FWheQRYcqsAWyQviIjWa8I=";

    private static JSONObject createHead() {
        JSONObject obj = new JSONObject();
        obj.put("ver", "1.0");// 版本
        obj.put("curTime", new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
        obj.put("nonce", new Random().nextInt(10000));// 一个随机数
        obj.put("sign",md5util.getMD5(privatekey + obj.getString("nonce") + obj.getString("curTime"),"UTF-8"));// 签名 MD5.sign(privatekey + obj.getString("nonce") + obj.getString("curTime"), "UTF-8")
        obj.put("signType", "MD5");// 签名类型
        obj.put("appKey", "adsdasd");// 多盈提供的APPKEY
        return obj;
    }

    static ExecutorService cachedThreadPool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws Exception {
        submitBorrower();
        cachedThreadPool.shutdown();

    }

}
