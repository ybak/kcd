package com.controller.erp_icbc.YunXin;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import com.alibaba.fastjson.JSON;
/**
 * @Description:TODO
 * @author:LiWang
 * @time:2018年8月22日
 */
public class HttpYX {
	/**
		获取网易云视频通讯ID
	 */
	public static String getToken(String accid){
		//设置参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("accid",accid));
		return HttpYX.doPost(YXConstant.CreateToken,nvps);
	}
	//获取移动端上传终端用户
	public static String geMobileUpload(String accid){
		//设置参数
		Map map=new HashMap(2);
		map.put("accid",accid);
		map.put("type",1);
		return HttpYX.doPost(YXConstant.CreateMobileUpload,map);
	}
	/**添加好友
	 * @param accid网易云通信ID，最大长度32字符，必须保证一个 APP内唯一（只允许字母、数字、半角下划线_、@、半角点以及半角-组成，不区分大小写，会统一小写处理，请注意以此接口返回结果中的accid为准）。
	 * @param faccid 被添加accid
	 */
	public static String addBuddy(String accid,String faccid){
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		nvps.add(new BasicNameValuePair("accid",accid));
		nvps.add(new BasicNameValuePair("faccid",faccid));
		nvps.add(new BasicNameValuePair("type","1"));//1直接加好友，2请求加好友，3同意加好友，4拒绝加好友
		return HttpYX.doPost(YXConstant.AddFriends,nvps);
	}
	/**
	 * post请求
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url,Object nvps){
		CloseableHttpResponse response=null;
		BufferedReader in=null;
        try {  
        	 //创建默认的httpclient
            CloseableHttpClient client = HttpClients.createDefault();
            //创建post请求对象
            HttpPost httpPost = new HttpPost(url);
            String appKey = YXConstant.appKey;
            String appSecret = YXConstant.appSecret;
            String nonce = "19970419";
            String curTime = String.valueOf((new Date()).getTime() / 1000L);
            String checkSum = CheckSumBuilder.getCheckSum(appSecret, nonce ,curTime);//参考 计算CheckSum的java代码
            // 设置请求的header
            httpPost.addHeader("AppKey", appKey);
            httpPost.addHeader("Nonce", nonce);
            httpPost.addHeader("CurTime", curTime);
            httpPost.addHeader("CheckSum", checkSum);
            httpPost.setURI(new URI(url));
        	if(nvps instanceof Map) {//如果为 map类型的数据
        		httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
        	    httpPost.setEntity(new StringEntity(JSON.toJSONString(nvps),Charset.forName("UTF-8")));
    		}else if(nvps instanceof java.util.List){
    			 httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
    			//设置请求参数
                httpPost.setEntity(new UrlEncodedFormEntity((List<? extends NameValuePair>) nvps,HTTP.UTF_8)); 
    		}else if(nvps instanceof String){
    			httpPost.addHeader("Content-Type", "application/json;charset=utf-8");
    			httpPost.setEntity(new StringEntity(nvps.toString(),Charset.forName("UTF-8")));
    		}
        	 response = client.execute(httpPost);  
            int code = response.getStatusLine().getStatusCode();
            if(code == 200){	//请求成功
            	in = new BufferedReader(new InputStreamReader(response.getEntity()  
                        .getContent(),"utf-8"));
                StringBuffer sb = new StringBuffer("");  
                String line = "";  
                String NL =System.getProperty("line.separator");  
                while ((line = in.readLine()) != null) {  
                    sb.append(line + NL);  
                }           
                return sb.toString();
            }
        }catch(Exception e){
        	e.printStackTrace();
        }finally {
        	if(response!=null){
        		try {
					response.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}   
		}
        return null;
	}
	 /**
     * httpclient get请求
     * 
     * @throws Exception
     */
    public static String doGet(String url) {
    	//System.out.println(url);
        //创建一个httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建httpGet对象
        HttpGet hg = new HttpGet(url);
        CloseableHttpResponse response=null;
        try {
            //请求服务
             response = client.execute(hg);
            //获取响应码
            int statusCode = response.getStatusLine().getStatusCode();
            if (statusCode == 200) {
                //获取返回实例entity
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    InputStream content = entity.getContent();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(content));
                    String line = "";
                    StringBuffer sb = new StringBuffer("");  
                    while ((line = bufferedReader.readLine()) != null){
                    	sb.append(line);
                    }
                    bufferedReader.close();
          
                    return sb.toString();
                }
            } 
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			//关闭response和client
            try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return null;
    }
}
