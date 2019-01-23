package com.http;
///**  依赖包
// *   <dependency>
// <groupId>org.apache.httpcomponents</groupId>
// <artifactId>httpcore</artifactId>
// <version>4.4.4</version>
// </dependency>
//
// <dependency>
// <groupId>org.apache.httpcomponents</groupId>
// <artifactId>httpclient</artifactId>
// <version>4.5.2</version>
// </dependency>
//
// <dependency>
// <groupId>org.apache.httpcomponents</groupId>
// <artifactId>httpmime</artifactId>
// <version>4.5.2</version>
// </dependency>
//
// <dependency>
// <groupId>org.json</groupId>
// <artifactId>json</artifactId>
// <version>20160212</version>
// </dependency>
// *
// */
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

/**
 * 运营商接入流程示例
 * Created by chris on 2016/11/14.
 */
public class phonecall
{
    private final static String APIX_KEY = "apix-key";

    private static String apixKey = "74b97d95b0864246709347458bd5306e";
    
    

    /**
     * 数据查询 1：根据 token 查询分析报告
     * @param url 接口地址
     * @param token 查询码
     * @return
     * @throws IOException
     */
	public static String analyzedData(String token) throws IOException
    {
		String url="http://e.apix.cn/apixanalysis/mobile/retrieve/phone/data/analyzed";
        CloseableHttpClient client = HttpClients.createDefault();

        HttpUriRequest request = RequestBuilder.get()//get请求
                .setUri(url)
                .addHeader(APIX_KEY, apixKey)
                .addParameter("query_code", token)//图片验证码 江西移动需要此参数
                .build();

        CloseableHttpResponse response = client.execute(request);

        return EntityUtils.toString(response.getEntity());

    }
    
	 /**
     * 数据查询 2：根据 token 查询原始数据 
     * @param url 接口地址
     * @param token 查询码
     * @return
     * @throws IOException
     */
	public static String queryData(String token) throws IOException
    {
		 String url="http://e.apix.cn/apixanalysis/mobile/retrieve/phone/data/query";
        CloseableHttpClient client = HttpClients.createDefault();
  
        HttpUriRequest request = RequestBuilder.get()//get请求
                .setUri(url)
                .addHeader(APIX_KEY, apixKey)
                .addParameter("query_code", token)//图片验证码 江西移动需要此参数
                .build();

        CloseableHttpResponse response = client.execute(request);

        return EntityUtils.toString(response.getEntity());

    }
    /**
     * 获取H5页面信息
     * @param reurl
     * @param successurl
     * @param errurl
     * @param name
     * @param cardnum
     * @param contlist
     * @param showbar
     * @param phoneno
     * @return
     * @throws IOException
     */
    public static String geth5(String callback_url,
			String success_url,
			String failed_url,
			String name,
			String cert_no,
			String contact_list,
			String show_nav_bar,
			String phone_no) throws IOException
    {
        CloseableHttpClient client = HttpClients.createDefault();

        //获取验证码接口地址
        String reqUrl = "http://e.apix.cn/apixanalysis/mobile/yys/phone/carrier/page";

        HttpUriRequest request = RequestBuilder.get()//get请求
                .setUri(reqUrl)
                .addHeader(APIX_KEY, apixKey)
                .addParameter("callback_url", callback_url)//回调url
                .addParameter("success_url" ,success_url)//页面授权成功url
                .addParameter("failed_url",failed_url)//页面授权失败url
                .addParameter("name" ,name)//登记人姓名
                .addParameter("cert_no",cert_no)//登记人身份证号
                .addParameter("contact_list" ,contact_list)//用户联系人
                .addParameter("show_nav_bar",show_nav_bar)//是否显示h5页面导航栏，true显示，false 不显示（默认不填为 true，显示导航栏） 
                .addParameter("phone_no" ,phone_no)//限定的手机号，非必填项。不填写此参 数由用户自己输入手机号，填写此参数 后只能授权该手机号，用户不可编辑。 
                .build();

        CloseableHttpResponse response = client.execute(request);

        return EntityUtils.toString(response.getEntity());
    }

    /**
     * 获取运营商验证码 
     * @param phoneNo 手机号码
     * @return 响应报文
     * @throws IOException
     */
    public static String getCapcha(String phone_no,
    		String name,
    		String cert_no,
    		String contact_list) throws IOException
    {
        CloseableHttpClient client = HttpClients.createDefault();

        //获取验证码接口地址
        String reqUrl = "http://e.apix.cn/apixanalysis/mobile/yys/phone/capcha";

        HttpUriRequest request = RequestBuilder.get()//get请求
                .setUri(reqUrl)
                .addHeader(APIX_KEY, apixKey)
                .addParameter("phone_no", phone_no)//手机号
                .addParameter("name" , name)//用户姓名
                .addParameter("cert_no",cert_no)//用户身份证号码
                .addParameter("contact_list" ,contact_list)//联系人
                .build();

        CloseableHttpResponse response = client.execute(request);

        return EntityUtils.toString(response.getEntity());
    }

    /**
     * 运营商密码授权登陆 
     * @param phoneNo 手机号码
     * @param passwd 密码
     * @param capcha 图片验证码
     * @param callback 回调地址
     * @return 响应报文
     * @throws IOException
     */
    public static String login(String phone_no, String passwd, String capcha, String callback) throws IOException
    {
        CloseableHttpClient client = HttpClients.createDefault();

        //获取验证码接口地址
        String reqUrl = "http://e.apix.cn/apixanalysis/mobile/yys/phone/login";

        HttpUriRequest request = RequestBuilder.get()//get请求
                .setUri(reqUrl)
                .addHeader(APIX_KEY, apixKey)
                .addParameter("phone_no", phone_no)//手机号
                .addParameter("passwd" , passwd)//服务密码
                .addParameter("capcha", capcha)//验证码
                .addParameter("callback" ,callback)//回调地址
                .build();

        CloseableHttpResponse response = client.execute(request);

        return EntityUtils.toString(response.getEntity());
    }
    
    /**
     * 获取详单图片验证码 
     * @param phoneNo
     * @return
     * @throws IOException
     */
    public static String image(String phone_no) throws IOException
    {
        CloseableHttpClient client = HttpClients.createDefault();

        //获取验证码接口地址
        String reqUrl = "http://e.apix.cn/apixanalysis/mobile/yys/phone/third/image";

        HttpUriRequest request = RequestBuilder.get()//get请求
                .setUri(reqUrl)
                .addHeader(APIX_KEY, apixKey)
                .addParameter("phone_no", phone_no)//手机号
                .build();

        CloseableHttpResponse response = client.execute(request);

        return EntityUtils.toString(response.getEntity());
    }
    

    /**
     * 请求短信验证码授权
     * @param phoneNo 手机号码
     * @return 响应报文
     * @throws IOException
     */
    public static String getSmsCode(String phone_no) throws IOException
    {
        CloseableHttpClient client = HttpClients.createDefault();

        //获取验证码接口地址
        String reqUrl = "http://e.apix.cn/apixanalysis/mobile/yys/phone/smsCode/getSms";

        HttpUriRequest request = RequestBuilder.get()//get请求
                .setUri(reqUrl)
                .addHeader(APIX_KEY, apixKey)
                .addParameter("phone_no", phone_no)//手机号
                .build();

        CloseableHttpResponse response = client.execute(request);

        return EntityUtils.toString(response.getEntity());
    }


    /**
     * 详单短信验证码验证
     * @param phoneNo 手机号码
     * @param smsCode 短信验证码
     * @param name 姓名（陕西，甘肃电信需要）
     * @param certNo 身份证号码（陕西，甘肃电信需要）
     * @param capcha 图片验证码（江西移动需要）
     * @return
     * @throws IOException
     */
    public static String verifySmsCode(String phone_no,
    		String sms_code,
    		String name,
    		String cert_no, 
    		String capcha) throws IOException
    {
        CloseableHttpClient client = HttpClients.createDefault();

        //获取验证码接口地址
        String reqUrl = "http://e.apix.cn/apixanalysis/mobile/yys/phone/smsCode/verify";

        HttpUriRequest request = RequestBuilder.get()//get请求
                .setUri(reqUrl)
                .addHeader(APIX_KEY, apixKey)
                .addParameter("phone_no", phone_no)//手机号
                .addParameter("sms_code", sms_code)//短信验证码
                .addParameter("name", name)//用户姓名，陕西，甘肃电信必须提交此参数
                .addParameter("cert_no", cert_no)//身份证号码，陕西，甘肃电信必须提交此参数
                .addParameter("capcha", capcha)//图片验证码 江西移动需要此参数
                .build();

        CloseableHttpResponse response = client.execute(request);

        return EntityUtils.toString(response.getEntity());
    }



    public static void main(String[] args) throws IOException, InterruptedException, JSONException
    {
        //初始必填参数
        String phoneNo = "15093111875";//手机号码
        String passwd = "110990";//密码

        //非必填参数
        String callback = "";//回掉地址

        //程序声明参数
        String name = "";
        String certNo = "";
        String capcha = "";
        String smsCode = "";

        //第一步 获取登录验证码
        String resp = getCapcha(phoneNo, name, name, name);

        JSONObject json = new JSONObject(resp);
        String retCode = json.getString("errorCode");
        System.out.println(retCode);
        if(StringUtils.equals(retCode, "0"))
        {
            String codeType = json.getString("imgUrl");
            if(StringUtils.isBlank(codeType))
            {
                System.out.println("登录不需要验证码");
            }
            else if(StringUtils.equals("smsCode", codeType))
            {
                System.out.println("请输入收到的短信验证码：");
                capcha = new Scanner(System.in).next();
            }
            else
            {
                String imgUrl = json.getString("imgUrl");
                System.out.println(String.format("请识别返回的图片验证码，验证码地址为[%s]：", imgUrl));
                capcha = new Scanner(System.in).next();
            }
        }
        else
        {
            System.out.println(String.format("请求失败！ | [%s]", json.getString("errorMsg")));
        }

        //第二步 登录
        resp = login(phoneNo, passwd, capcha, callback);

        json = new JSONObject(resp);
        retCode = json.getString("errorCode");
        if(StringUtils.equals(retCode, "0"))
        {
            Boolean isFinish = json.getBoolean("result");
            if(isFinish)
            {
                String token = json.getString("token");
                System.out.println(String.format("恭喜，授权完成！ | 授权token为[%s]", token));
                System.exit(0);
            }
            else
            {
                System.out.println("授权还未结束，需要执行第三四步，稍等！");
            }
        }
        else
        {
            System.out.println(String.format("请求失败！ | [%s]", json.getString("errorMsg")));
        }

        String operator = json.getString("operator");

        if(StringUtils.contains(operator, "移动"))
        {
            //需要等待60秒，才可获取短信验证码
            Thread.sleep(50000);
        }

        //第三步 获取短信验证码
        resp = getSmsCode(phoneNo);

        json = new JSONObject(resp);
        retCode = json.getString("errorCode");

        if(StringUtils.equals(retCode, "0"))
        {
            if(StringUtils.contains(operator, "电信"))
            {
                if(StringUtils.contains(operator, "陕西")  || StringUtils.contains(operator, "甘肃") )
                {
                    System.out.println("请输入用户姓名:");
                    name = new Scanner(System.in).next();
                    System.out.println("请输入用户身份证号码:");
                    certNo = new Scanner(System.in).next();

                }
            }
            else if(StringUtils.contains(operator, "移动"))
            {
                if(StringUtils.contains(operator, "江西"))
                {
                    String imgUrl = json.getString("imgUrl");
                    System.out.println(String.format("请识别返回的图片验证码，验证码地址为[%s]：", imgUrl));
                    capcha = new Scanner(System.in).next();
                } 
            }

            System.out.println("请输入获取到的短信验证码:");
            smsCode = new Scanner(System.in).next();
        }
        else
        {
            System.out.println(String.format("请求失败！ | [%s]", json.getString("errorMsg")));
        }

        //第四步 短信验证码校验
        resp = verifySmsCode(phoneNo, smsCode, name, certNo, capcha);
        json = new JSONObject(resp);
        retCode = json.getString("errorCode");

        if(StringUtils.equals(retCode, "0"))
        {
            String token = json.getString("token");
            System.out.println(String.format("恭喜，授权完成！ | 授权token为[%s]", token));
            System.exit(0);
        }
        else
        {
            System.out.println(String.format("请求失败！ | [%s]", json.getString("errorMsg")));
        }

        //第五步 获取报告
        //String token = "";//获取到的token
        //String reqUrl = "http://e.apix.cn/apixanalysis/mobile/retrieve/phone/data/; //获取分析报告url
        //String reqUrl = "http://e.apix.cn/apixanalysis/mobile/retrieve/phone/data/query";//获取原始报告url
        //String retData = getData(reqUrl, token);//获取分析报告
    }




}

