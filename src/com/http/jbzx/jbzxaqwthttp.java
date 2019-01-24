package com.http.jbzx;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class jbzxaqwthttp {
	
	
	 //简版征信安全问题1
	public static String jbzxaq1(String loginName,
    		String passwd,
    		String appKey) throws IOException
    {
		String url="http://taifinance.cn/TaiAPI/api/creditReference/getQuestions";
        CloseableHttpClient client = HttpClients.createDefault();
      //输出测试1
          //System.out.println(loginName +"---"+passwd+"----"+appKey);
        HttpUriRequest request = RequestBuilder.post()//get请求
                .setUri(url)
                //.addHeader(APIX_KEY, apixKey)
                .addParameter("loginName", loginName)// 登录名称
                .addParameter("passwd", passwd)//登录密码
                .addParameter("appKey", appKey)//用户令牌
                .build();

        CloseableHttpResponse response = client.execute(request);

        return EntityUtils.toString(response.getEntity());

    }	
	    //简版征信安全问题2
		public static String jbzxaq2(
				String loginName,
	    		String password,
	    		String qFirst,
	    		String qSecond,
	    		String qThird,
	    		String qFouth,
	    		String qFivth,
	    		String appKey) throws IOException
		
	    {
			//输出测试2
			//System.out.println(loginName+"---"+password +"---"+qFirst+"----"+qSecond+"---"+qThird+"---"+qFouth+"---"+qFivth+"---"+appKey);
	        CloseableHttpClient client = HttpClients.createDefault();
	      //获取验证码接口地址
	        String url="http://taifinance.cn/TaiAPI/api/creditReference/submitAnswer";
	        HttpUriRequest request = RequestBuilder.post()//get请求
	                .setUri(url)
	                //.addHeader(APIX_KEY, apixKey)
	                .addParameter("loginName",loginName)// 登录名称
	                .addParameter("password",password)//登录密码
	                .addParameter("qFirst",qFirst)//问题1
	                .addParameter("qSecond",qSecond)//问题2
	                .addParameter("qThird",qThird)//问题3
	                .addParameter("qFouth",qFouth)//问题4
	                .addParameter("qFivth",qFivth)//问题5
	                .addParameter("appKey",appKey)//用户令牌
	                .build();

	        CloseableHttpResponse response = client.execute(request);

	        return EntityUtils.toString(response.getEntity());

	    }	
	 
	    //简版征信安全问题3
		public static String jbzxaq3(String loginName,
	    		String password,
	    		String code,
	    		String appKey) throws IOException
	    {
			String url="http://taifinance.cn/TaiAPI/api/creditReference/getPersonalCredit";
	        CloseableHttpClient client = HttpClients.createDefault();
	      //输出测试3
	         System.out.println(loginName +"---"+password+"----"+code+"---"+appKey);
	        HttpUriRequest request = RequestBuilder.post()//get请求
	                .setUri(url)
	                //.addHeader(APIX_KEY, apixKey)
	                .addParameter("loginName", loginName)// 登录名称
	                .addParameter("password", password)//登录密码
	                .addParameter("code", code)//短信验证码
	                .addParameter("appKey", appKey)//用户令牌
	                .build();

	        CloseableHttpResponse response = client.execute(request);

	        return EntityUtils.toString(response.getEntity());
	    }	
		
  public static void main(String[] args) {
	//安全问题测试参数
		String loginName="lhr13162809518";
		String passwd="lhr13162809518";
	  	String appKey="6602e77a-c286-a0b9-13a6-287f438b3336";
		String qFirst="以上都不是";
		String qSecond="以上都不是";
		String qThird ="以上都不是";
		String qFouth ="未婚";
		String qFivth="河南省商丘市";
		String code="58790";
	//安全问题测试1
	String c1;
	try {		
//		c1 = jbzxaq1(loginName,passwd,appKey);
//		  System.out.println(c1);
	
/*		for(int i=0;i<10;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("等待时间："+(i+1)+"s");
		}*/		
				
	//安全问题测试2
//	   String c2=jbzxaq2(loginName,passwd,qFirst,qSecond,qThird,qFouth,qFivth,appKey);
//	   System.out.println(c2);
			
		//c2 = jbzxaq2(loginName, password, qFirst, qSecond,qThird,qFouth,qFivth,appKey);
				
	 //安全问题测试3
	   String c3=jbzxaq3(loginName,passwd,code,appKey);
	   		System.out.println(c3);
		} catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  	}
  }





