package com.http.zxceshi;

import java.util.HashMap;
import java.util.Map;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.util.Base64Test;
import com.util.jsonutil;
import com.util.md5util;

import net.sf.json.JSONObject;

public class zxdemo {
	 public static String zxup(String url,String data){
//	    	, String cKey
	        String SENTIMENT_URL =url;//"http://cesi3.0.zhiyujinrong.com/index.php/Api/Index/index/token/9164152B7EB0AF6EA589B1BE06073304.html";        
	        //http://apitest.kcway.net
	        //String body ="orderNo="+orderNo+"&errmsg="+errmsg;  //new JSONArray(new String[]{text}).toString();
	        //System.out.println(body);
	        HttpResponse<String> jsonResponse = null;
	        try {
	            jsonResponse = Unirest.post(SENTIMENT_URL)
	                    .header("Content-Type","application/json;charset=UTF-8")
	                    //.header("ckey",cKey)
	                    .body(data)
	                    .asString();
	            //Unirest.shutdown();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        //System.out.println(jsonResponse.getBody());
	        return jsonResponse.getBody();
	    }
	 public static void main(String[] args) {
	    	String filebase=Base64Test.getImageStr("C:/Users/Administrator/Desktop/test-idcard.jpg");
			String strURL = "http://apitest.kcway.net/to_query_zx.do";
			String fronttobase = filebase;
			String oppositetobase = filebase;
			String applytobase = filebase;
			String authorizetobase = filebase;
			String hztobase = filebase;
			String name = "愿dan快乐";
			String IDcard_num = "429001199405030283";
			String phone_num = "15010219309";
			String authorize_num = "012345";
			String sum_bit = "4";
			String ckey = "1";
			String ly = "测试";
			String orderid="237";
	        Map m=new HashMap<>();
	        //System.out.println(md5util.getMD5(fronttobase,"UTF-8"));
	        //System.out.println(md5util.JM(md5util.getMD5(fronttobase,"UTF-8")));
	        m.put("fronttobase", fronttobase);
	        m.put("oppositetobase", oppositetobase);
	        m.put("applytobase", applytobase);
	        m.put("authorizetobase", authorizetobase);
	        m.put("hztobase", hztobase);
	        m.put("ckey", ckey);
	        m.put("name", name);
	        m.put("idcard_num", IDcard_num);
	        m.put("phone_num", phone_num);
	        m.put("authorize_num", authorize_num);
	        m.put("sum_bit", sum_bit);
	        m.put("ly", ly);
	        m.put("orderid",orderid);
	        JSONObject js= jsonutil.toJSONObject(m);
	        System.out.println("json大小："+js.toString().length());
	    	String s=zxup(strURL,js.toString());
	        // String s=appadd(url, js.toString());
	    	System.out.println("返回数据："+s);
		}
}
