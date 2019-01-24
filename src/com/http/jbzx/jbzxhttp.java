package com.http.jbzx;
/*
 * 赵雪玲   简版征信 API 注册接口
 */
import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class jbzxhttp {
	//public $appkey = "6602e77a-c286-a0b9-13a6-287f438b3336";
   /*
    * 简版征信注册1
    * 
    * 
    * 
    */
	//private String appKey="6602e77a-c286-a0b9-13a6-287f438b3336";
	public static String jbzxzc1(String cardno,
    		String name,
    		String appKey) throws IOException
    {
		String url="http://taifinance.cn/TaiAPI/api/creditReference/doUserCheck";
        CloseableHttpClient client = HttpClients.createDefault();

        HttpUriRequest request = RequestBuilder.post()//get请求
                .setUri(url)
                //.addHeader(APIX_KEY, apixKey)
                .addParameter("cardno", cardno)//身份证号
                .addParameter("name", name)//姓名
                .addParameter("appKey", appKey)//验证key 值
                .build();

        CloseableHttpResponse response = client.execute(request);

        return EntityUtils.toString(response.getEntity());

    }	
    /*
     * 注册2  获取短信验证码
     * 
     */
    public static String jbzxzc2(
    		String username,//注册名
    		String phoneNo,//手机号
    		String cardno,//身份证名字段
    		String appKey//用户令牌
    		) throws IOException
    {
        CloseableHttpClient client = HttpClients.createDefault();

        //获取验证码接口地址
        String reqUrl2 = "http://taifinance.cn/TaiAPI/api/creditReference/getRegSmsCode";

        HttpUriRequest request = RequestBuilder.post()//get请求
                .setUri(reqUrl2)
                //.addHeader(APIX_KEY, apixKey)
                .addParameter("username", username)//用户姓名
                .addParameter("phoneNo" , phoneNo)//手机号
                .addParameter("cardno",cardno)//用户身份证号码
                .addParameter("appKey" ,appKey)//用户令牌
                .build();

        CloseableHttpResponse response = client.execute(request);

        return EntityUtils.toString(response.getEntity());
    }   	
    /*
     *注册3   登录名  密码设置	
     * 
     */
    public static String jbzxzc3(String username,
    		String cardno,//身份证名字段
    		String phoneNo,//手机号
    		String loginName,//登录名
    		String passwd,//密码
    		String smsCode,//短信验证码
    		String appKey//用户令牌
    		) throws IOException
    {
        CloseableHttpClient client = HttpClients.createDefault();

        //获取验证码接口地址
        String reqUrl = "http://taifinance.cn/TaiAPI/api/creditReference/regUserInfo";

        HttpUriRequest request = RequestBuilder.post()//get请求
                .setUri(reqUrl)
                //.addHeader(APIX_KEY, apixKey)
                .addParameter("cardno",cardno)//身份证名字段
                .addParameter("phoneNo", phoneNo)//手机号
                .addParameter("loginName" , loginName)//登录名
                .addParameter("passwd" , passwd)//密码
                .addParameter("smsCode" ,smsCode)//短信验证码
                .addParameter("appKey" ,appKey)//用户令牌
                .build();

        CloseableHttpResponse response = client.execute(request);

        return EntityUtils.toString(response.getEntity());
    }
    
    //测试是否成功
	public static void main(String[] args) throws InterruptedException {
    	String cardno="411403199512108410";
		String username="屠国强";
		String appKey="6602e77a-c286-a0b9-13a6-287f438b3336";
		String phoneNo="13162809518";
		String loginName="lhr13162809518";
		String passwd="lhr13162809518";
		String smsCode="7a93fr";
		
	   //注册1测试
		String s1;
		
		try {
			//8906
			s1 = jbzxzc1(cardno,username,appKey);
			System.out.println(s1);
		
		
//		for(int i=0;i<10;i++){
//			Thread.sleep(1000);
//		System.out.println("等待时间："+(i+1)+"s");
//		}		
		//注册2测试  9005
//		String s2=	jbzxzc2(username, phoneNo, cardno, appKey);
//		System.out.println(s2);
		
//		
////分割线---------------------------------------------------------------------------------------------------------		
		//注册3测试(单独执行)
//		String s3=	jbzxzc3(username, cardno, phoneNo, loginName, passwd, smsCode, appKey);
//		System.out.println(s3);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}