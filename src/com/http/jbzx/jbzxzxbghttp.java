package com.http.jbzx;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class jbzxzxbghttp {
	 //简版征信 征信报告
	public static String jbzxzxbg1(
    		String appKey,
    		String loginname,
    		String password,
    		String code) throws IOException
    {
		String url="http://taifinance.cn/TaiAPI/api/creditReference/getPersonalCredit";
        CloseableHttpClient client = HttpClients.createDefault();
        //测试输出
        //System.out.println(name +"---"+cardno+"----"+phoneNo+"---"+loginName+"---"+passwd+"---"+appKey);
        HttpUriRequest request = RequestBuilder.get()//get请求
                .setUri(url)
                //.addHeader(APIX_KEY, apixKey)
                .addParameter("appKey",appKey)//
                .addParameter("loginname",loginname)//
                .addParameter("password",password)//
                .addParameter("code",code)//
                .build();
        CloseableHttpResponse response = client.execute(request);
        return EntityUtils.toString(response.getEntity());
    }
	

	public static void main(String[] args) {
		//征信报告参数
		String name="赵雪玲";
		String cardno="410725199602209788";
		String phoneNo="15317756227";
		String loginName="赵雪玲ing";
		String passwd="zxl1996";
		String appKey="5try5";
		//征信报告测试
		String z;
		
			try {
				z=jbzxzxbg1("6602e77a-c286-a0b9-13a6-287f438b3336","q708823141","q708823141","p6thic");
				System.out.println(z);
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			/*
			for(int i=0;i<6;i++){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("等待时间:"+(i+1)+"h");
			}*/
			
	}	
}
