package com.controller.dyapi;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.http.dyapi.dyapihttp;
import com.model1.mgcert;
import com.service1.duoying.mgcertService;
import com.util.creditutil;
import com.util.jsonutil;
import com.util.duoying.MD5;
import com.util.duoying.timebjdxutil;

@Controller
public class dysendxxController {

	@Autowired
	private mgcertService mgcertservice;
	
	@RequestMapping(value="kjs_send.do",produces="text/html;charset=UTF-8")
    @ResponseBody
	public String send(String id,
			String kjs_type,
			String time,
			String sign
			){
		if(id==null||kjs_type==null||time==null||sign==null
		   ||id.equals("")||kjs_type.equals("")
		   ||time.equals("")||sign.equals("")
				){
			JSONObject jb=new JSONObject();
			jb.put("code","202");
			jb.put("ret","");
			jb.put("msg","非空字段为空");
		    return jb.toString();
		}
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		  Calendar nowTime = Calendar.getInstance();
		  nowTime.add(Calendar.MINUTE, 3);
		  String d1=sdf.format(nowTime.getTime());
		  //System.out.println(sdf.format(nowTime.getTime()));
		  String d2=timebjdxutil.totime(time);			 
		  int i= timebjdxutil.compare_date(d2,d1);
		  if(i==1){
			    JSONObject jb=new JSONObject();
				jb.put("code","203");
				jb.put("ret","");
				jb.put("msg","验证时效超过三分钟");
			    return jb.toString(); 
		  }
//		        8=>'assess_mgcar',
//				9=>'assess_mgcert',
//				10=>'assess_mgnewcar',
//				17=>'assess_mgxc',
		String sg=MD5.sign(id+time+"kcway","UTF-8");	
		if(sign.equals(sg)){				 
		try {
			String s4=dyapihttp.kjsjkrxxhttp(id,kjs_type,"http://localhost:8080/kcd/kjs_tjcs.do");//kjs_jkrxx.do	
			JSONObject j4=JSONObject.parseObject(s4);
			if(j4.getString("code").equals("200")){
				    		mgcert mgcert=new mgcert();
				    		mgcert.setId(Integer.parseInt(id));
				    		mgcert.setZjf_type("2");
			                if(kjs_type.equals("8")){
				            	mgcertservice.upmgcar(mgcert);
				            }else
				            if(kjs_type.equals("9")){
				            	mgcertservice.upmgcert(mgcert); 		   
				            }else
				            if(kjs_type.equals("10")){
				            	mgcertservice.upmgnewcar(mgcert);
				            } 			    		
				    		return j4.toString();
		    }else{
				    		return s4;	
			}
		} catch (IOException e) {
			JSONObject jb=new JSONObject();
			jb.put("code","201");
			jb.put("ret","");
			jb.put("msg","同步失败"+e);
		    return jb.toString();
		}			
		}else{
			JSONObject jb=new JSONObject();
			jb.put("code","203");
			jb.put("ret","");
			jb.put("msg","sign验证失败");
		    return jb.toString();
		}

	}
	@RequestMapping(value="findcert111.do",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String findcert111(){
	mgcert mg=	new mgcert();
	mg.setZjf_type("1");
	//mg.setSpcount(1);
	mg.setId(222);
	mgcertservice.upmgcert(mg);
	return mg.toString();
	}
	
	
	public static String kjshttp(String id,
			String kjs_type,
			String time,
			String sign,
			String url
			) throws IOException
    {
//		String url="http://localhost:8080/kcd/kjs_send.do";
        CloseableHttpClient client = HttpClients.createDefault();
      //输出测试1
        HttpUriRequest request = RequestBuilder.get()//get请求
                .setUri(url)
                .addParameter("id", id)
                .addParameter("kjs_type",kjs_type)
                .addParameter("time",time)
                .addParameter("sign",sign)
                .build();
        CloseableHttpResponse response = client.execute(request);
        return EntityUtils.toString(response.getEntity());

    }  
	
	
	
	
	public static void main(String[] args) {
		String id ="204";
		String kjs_type ="9";
		String time =String.valueOf(new Date().getTime());
		String sign;
		sign=MD5.sign(id+time+"kcway","UTF-8");			
		String s = null;
		try {
			s = kjshttp(id,kjs_type,time,sign,"http://localhost:8080/kcd/kjs_send.do");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(s);
		
//		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		  Date now = new Date();
//		  System.out.println("当前时间：" + sdf.format(now));
//		//方法一：
//		  Date afterDate = new Date(now .getTime() + 300000);
//		  System.out.println(sdf.format(afterDate ));
//		//方法二：
//		  Calendar nowTime = Calendar.getInstance();
//		  nowTime.add(Calendar.MINUTE, 3);
//		  System.out.println(sdf.format(nowTime.getTime()));
	}
	
	
}
