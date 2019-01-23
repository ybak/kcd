package com.controller.erp_icbc;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.CharArrayBuffer;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class getjhshController{

	private static final String province_URL ="http://v.juhe.cn/usedcar/province"; //省份列表
	private static final String city_URL = "http://v.juhe.cn/usedcar/city";//城市列表
	private static final String brand_URL ="http://v.juhe.cn/usedcar/brand"; //品牌列表
	private static final String series_URL = "http://v.juhe.cn/usedcar/series";//车系列表
	private static final String car_URL ="http://v.juhe.cn/usedcar/car"; //车型列表
	private static final String year_URL = "http://v.juhe.cn/usedcar/year";//车型年份列表
	private static final String assess_URL ="http://v.juhe.cn/usedcar/assess"; //精确估值
	private static final String KEY ="bf90509de7b2874b3bae02d589e6c70a"; //AppKey
	
	public static void main(String[] args) {
		//1获取省份列表
		Map<String,String> map1=new HashMap<>();
		map1.put("key",KEY);
		map1.put("dtype","");
		String json1= postMap(province_URL,map1);
		System.out.println("省份列表："+json1);
		
	}	
	@RequestMapping(value = "kjrz/getprovince.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getprovince(){
		        //1获取省份列表
		Map<String,String> map1=new HashMap<>();
		map1.put("key",KEY);
		map1.put("dtype","");
		String json1= postMap(province_URL,map1);
		return json1;
	}
	@RequestMapping(value = "kjrz/getcity.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getcity(String province){
		        //1获取省份列表
		Map<String,String> map1=new HashMap<>();
		map1.put("key",KEY);
		map1.put("dtype","");
		map1.put("province",province);
		String json1= postMap(city_URL,map1);
		return json1;
	}
	@RequestMapping(value = "kjrz/getbrand.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getbrand(String vehicle){
		        //1获取省份列表
		Map<String,String> map1=new HashMap<>();
		map1.put("key",KEY);
		map1.put("dtype","");
		map1.put("vehicle",vehicle);
		String json1= postMap(brand_URL,map1);
		return json1;
	}
	@RequestMapping(value = "kjrz/getseries.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getseries(String brand){
		        //1获取省份列表
		Map<String,String> map1=new HashMap<>();
		map1.put("key",KEY);
		map1.put("dtype","");
		map1.put("brand",brand);
		String json1= postMap(series_URL,map1);
		return json1;
	}
	@RequestMapping(value = "kjrz/getcar.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getcar(String series){
		        //1获取省份列表
		Map<String,String> map1=new HashMap<>();
		map1.put("key",KEY);
		map1.put("dtype","");
		map1.put("series",series);
		String json1= postMap(car_URL,map1);
		return json1;
	}
	@RequestMapping(value = "kjrz/getyear.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getyear(String car){
		        //1获取省份列表
		Map<String,String> map1=new HashMap<>();
		map1.put("key",KEY);
		map1.put("dtype","");
		map1.put("car",car);
		String json1= postMap(year_URL,map1);
		return json1;
	}
	@RequestMapping(value = "kjrz/getassess.do", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getassess(
			String carstatus,
			String purpose,
			String city,
			String car,
			String province,
			String useddate,
			String useddateMonth,
			String mileage,
			String price
			){
		        //1获取省份列表
		Map<String,String> map1=new HashMap<>();
		map1.put("key",KEY);
		map1.put("dtype","");
		map1.put("carstatus",carstatus);
		map1.put("purpose",purpose);
		map1.put("city",city);
		map1.put("province",province);
		map1.put("car",car);
		map1.put("useddate",useddate);
		map1.put("useddateMonth",useddateMonth);
		map1.put("mileage",mileage);
		map1.put("price",price);
		String json1= postMap(assess_URL,map1);
		return json1;
	}
	/**
     * get请求，参数拼接在地址上
     * @param url 请求地址加参数
     * @return 响应
     */
    public String get(String url)
    {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get);
            if(response != null && response.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity entity =response.getEntity();
                result = entityToString(entity);
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                if(response != null)
                {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    /**
     * 发送post请求，参数用map接收
     * @param url 地址
     * @param map 参数
     * @return 返回值
     */
    public static String postMap(String url,Map<String,String> map) {
        String result = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        List<NameValuePair> pairs = new ArrayList<NameValuePair>();
        for(Map.Entry<String,String> entry : map.entrySet())
        {
            pairs.add(new BasicNameValuePair(entry.getKey(),entry.getValue()));
        }
        CloseableHttpResponse response = null;
        try {
            post.setEntity(new UrlEncodedFormEntity(pairs,"UTF-8"));
            response = httpClient.execute(post);
            if(response != null && response.getStatusLine().getStatusCode() == 200)
            {
                HttpEntity entity = response.getEntity();
                result = entityToString(entity);
            }
            return result;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpClient.close();
                if(response != null)
                {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
	
    
    
    
    private static String entityToString(HttpEntity entity) throws IOException {
        String result = null;
        if(entity != null)
        {
            long lenth = entity.getContentLength();
            if(lenth != -1 && lenth < 2048)
            {
                result = EntityUtils.toString(entity,"UTF-8");
            }else {
                InputStreamReader reader1 = new InputStreamReader(entity.getContent(), "UTF-8");
                CharArrayBuffer buffer = new CharArrayBuffer(2048);
                char[] tmp = new char[1024];
                int l;
                while((l = reader1.read(tmp)) != -1) {
                    buffer.append(tmp, 0, l);
                }
                result = buffer.toString();
            }
        }
        return result;
    }
}
