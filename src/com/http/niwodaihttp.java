package com.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.hp.hpl.sparta.ParseException;
import com.util.Base64Test;

public class niwodaihttp {

//	http://apitest.kcway.net
	//http://localhost:8080/kcd/
	 public static final String POST_URL="http://localhost:8080/kcd/tofindzx.do";//征信报告提交查询接口地址
	 public static final String POST_URL1="http://apitest.kcway.net/findorder.do";//征信报告查询接口地址
	 public static final String POST_URL2="http://apitest.kcway.net/hqzxbg.do";//征信报告结果实时推送接口
	 public static final String POST_URL3="http://apitest.kcway.net/findingofaudit.do";//征信报告结果实时推送接口
    /** 
     * 征信报告提交查询接口
     */  
    public static String zxtj(String fronttobase,
    		String oppositetobase,
    		String applytobase,
    		String authorizetobase,
    		String hztobase,
    		String ckey,
    		String name,
    		String IDcard_num,
    		String phone_num,
    		String authorize_num,
    		String sum_bit,
    		String ly) { 
    	  StringBuilder sb = new StringBuilder();
        try {  
            URL url = new URL(POST_URL);  
              
            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中  
              
            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)  
            connection.setDoOutput(true);  
              
            // 设置连接输入流为true  
            connection.setDoInput(true);  
              
            // 设置请求方式为post  
            connection.setRequestMethod("POST");  
              
            // post请求缓存设为false  
            connection.setUseCaches(false);  
              
            // 设置该HttpURLConnection实例是否自动执行重定向  
            connection.setInstanceFollowRedirects(true);  
     
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)  
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据  
            // ;charset=utf-8 必须要，不然妙兜那边会出现乱码【★★★★★】  
            connection.setRequestProperty("Content-Type", "application/xml;charset=utf-8");     
            connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)"); 
            //connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)"); 
            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)             
            connection.connect();  
              
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)  
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());  
              
            fronttobase = "fronttobase="+ URLEncoder.encode(fronttobase, "utf-8");        
            oppositetobase = "&oppositetobase="+ URLEncoder.encode(oppositetobase, "utf-8");           
            applytobase = "&applytobase="+ URLEncoder.encode(applytobase, "utf-8");            
            authorizetobase = "&authorizetobase="+ URLEncoder.encode(authorizetobase, "utf-8");        
            hztobase = "&hztobase="+ URLEncoder.encode(hztobase, "utf-8");  
            ckey = "&ckey="+ URLEncoder.encode(ckey, "utf-8");  
            name = "&name="+ URLEncoder.encode(name, "utf-8");  
            IDcard_num = "&IDcard_num="+ URLEncoder.encode(IDcard_num, "utf-8");  
            phone_num = "&phone_num="+ URLEncoder.encode(phone_num, "utf-8");  
            authorize_num = "&authorize_num="+ URLEncoder.encode(authorize_num, "utf-8");  
            sum_bit = "&sum_bit="+ URLEncoder.encode(sum_bit, "utf-8");  
            ly = "&ly="+ URLEncoder.encode(ly, "utf-8"); 
            // 格式 parm = aaa=111&bbb=222&ccc=333&ddd=444  
            String parm =fronttobase+
            		oppositetobase+
            		applytobase+
            		authorizetobase+
            		hztobase+
            		ckey+
            		name+
            		IDcard_num+
            		phone_num+
            		authorize_num+
            		sum_bit+
            		ly;
            		
            // 将参数输出到连接  
            //System.out.println(parm);
            dataout.writeBytes(parm);  
              System.out.println("请求体大小："+parm.length()/1024);
            // 输出完成后刷新并关闭流  
            dataout.flush();  
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)   
              
//            System.out.println(connection.getResponseCode());                
            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)  
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));   
            String line;  
           // 用来存储响应数据  
              
            // 循环读取流,若不到结尾处  
            while ((line = bf.readLine()) != null) {  
//                sb.append(bf.readLine());  
                sb.append(line).append(System.getProperty("line.separator"));  
            }  
            bf.close();    // 重要且易忽略步骤 (关闭流,切记!)   
            connection.disconnect(); // 销毁连接  
            //System.out.println(sb.toString());  
      
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return sb.toString();  
    }         			
    
    
    /** 
     * 1.2 征信报告查询接口
     */  
    public static String zxcx(String orderNo,String ckey) {  
    	 StringBuilder sb = new StringBuilder(); // 用来存储响应数据  
        try {  
            URL url = new URL(POST_URL1);  
              
            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中  
              
            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)  
            connection.setDoOutput(true);  
              
            // 设置连接输入流为true  
            connection.setDoInput(true);  
              
            // 设置请求方式为post  
            connection.setRequestMethod("POST");  
              
            // post请求缓存设为false  
            connection.setUseCaches(false);  
              
            // 设置该HttpURLConnection实例是否自动执行重定向  
            connection.setInstanceFollowRedirects(true);  
              
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)  
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据  
            // ;charset=utf-8 必须要，不然妙兜那边会出现乱码【★★★★★】  
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");     
              
            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)  
            connection.connect();  
              
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)  
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());  
              
            orderNo = "orderNo="+ URLEncoder.encode(orderNo, "utf-8");        
            ckey = "&ckey="+ URLEncoder.encode(ckey, "utf-8");           
            // 格式 parm = aaa=111&bbb=222&ccc=333&ddd=444  
            String parm =orderNo+ckey;
            		
            // 将参数输出到连接  
            dataout.writeBytes(parm);  
              
            // 输出完成后刷新并关闭流  
            dataout.flush();  
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)   
              
//            System.out.println(connection.getResponseCode());  
              
            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)  
            //System.out.println(connection.getInputStream()+"----http");
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));   
            String line;  
           
              
            // 循环读取流,若不到结尾处  
            while ((line = bf.readLine()) != null) {  
//                sb.append(bf.readLine());  
                sb.append(line).append(System.getProperty("line.separator"));  
            }  
            bf.close();    // 重要且易忽略步骤 (关闭流,切记!)   
            connection.disconnect(); // 销毁连接  
           // System.out.println(sb.toString());  
      
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return sb.toString();  
    }         			
    
    
    
    
    /** 
     * 1.2 征信报告结果实时推送接口
     */  
    public static String hqzxbg(String orderNo,String pdfurl,String addtime) {  
    	 StringBuilder sb = new StringBuilder(); // 用来存储响应数据  
        try {  
            URL url = new URL(POST_URL2);  
              
            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中  
              
            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)  
            connection.setDoOutput(true);  
              
            // 设置连接输入流为true  
            connection.setDoInput(true);  
              
            // 设置请求方式为post  
            connection.setRequestMethod("POST");  
              
            // post请求缓存设为false  
            connection.setUseCaches(false);  
              
            // 设置该HttpURLConnection实例是否自动执行重定向  
            connection.setInstanceFollowRedirects(true);  
              
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)  
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据  
            // ;charset=utf-8 必须要，不然妙兜那边会出现乱码【★★★★★】  
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");     
              
            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)  
            connection.connect();  
              
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)  
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());  
              
            orderNo = "orderNo="+ URLEncoder.encode(orderNo, "utf-8");        
            pdfurl = "&pdfurl="+ URLEncoder.encode(pdfurl, "utf-8"); 
           // pdfname = "&pdfname="+ URLEncoder.encode(pdfname, "utf-8"); 
            addtime = "&addtime="+ URLEncoder.encode(addtime, "utf-8"); 
            // 格式 parm = aaa=111&bbb=222&ccc=333&ddd=444  
            String parm =orderNo+pdfurl+addtime;
            		
            // 将参数输出到连接  
            dataout.writeBytes(parm);  
              
            // 输出完成后刷新并关闭流  
            dataout.flush();  
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)   
              
//            System.out.println(connection.getResponseCode());  
              
            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)  
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));   
            String line;  
           
              
            // 循环读取流,若不到结尾处  
            while ((line = bf.readLine()) != null) {  
//                sb.append(bf.readLine());  
                sb.append(line).append(System.getProperty("line.separator"));  
            }  
            bf.close();    // 重要且易忽略步骤 (关闭流,切记!)   
            connection.disconnect(); // 销毁连接  
           // System.out.println(sb.toString());  
      
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return sb.toString();  
    }         			
    /** 
     * 1.2 审核信息成功结果异步推送接口 (快加-嘉银征信)
     */  
    public static String shxxresult(String name,
    		String idCard,
    		String phoneNo,
    		String orderNo,
    		String errcode,
    		String errmsg) {  
    	 StringBuilder sb = new StringBuilder(); // 用来存储响应数据  
        try {  
            URL url = new URL(POST_URL3);  
              
            // 将url 以 open方法返回的urlConnection  连接强转为HttpURLConnection连接  (标识一个url所引用的远程对象连接)  
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();// 此时cnnection只是为一个连接对象,待连接中  
              
            // 设置连接输出流为true,默认false (post 请求是以流的方式隐式的传递参数)  
            connection.setDoOutput(true);  
              
            // 设置连接输入流为true  
            connection.setDoInput(true);  
              
            // 设置请求方式为post  
            connection.setRequestMethod("POST");  
              
            // post请求缓存设为false  
            connection.setUseCaches(false);  
              
            // 设置该HttpURLConnection实例是否自动执行重定向  
            connection.setInstanceFollowRedirects(true);  
              
            // 设置请求头里面的各个属性 (以下为设置内容的类型,设置为经过urlEncoded编码过的from参数)  
            // application/x-javascript text/xml->xml数据 application/x-javascript->json对象 application/x-www-form-urlencoded->表单数据  
            // ;charset=utf-8 必须要，不然妙兜那边会出现乱码【★★★★★】  
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");     
              
            // 建立连接 (请求未开始,直到connection.getInputStream()方法调用时才发起,以上各个参数设置需在此方法之前进行)  
            connection.connect();  
              
            // 创建输入输出流,用于往连接里面输出携带的参数,(输出内容为?后面的内容)  
            DataOutputStream dataout = new DataOutputStream(connection.getOutputStream());  
//            String name,
//    		String idCard,
//    		String phoneNo,
//    		String orderNo,
//    		String errcode,
//    		String errmsg
            name = "name="+ URLEncoder.encode(name, "utf-8");        
            idCard = "&idCard="+ URLEncoder.encode(idCard, "utf-8"); 
            phoneNo = "&phoneNo="+ URLEncoder.encode(phoneNo, "utf-8"); 
            orderNo = "&orderNo="+ URLEncoder.encode(orderNo, "utf-8"); 
            errcode = "&errcode="+ URLEncoder.encode(errcode, "utf-8"); 
            errmsg = "&errmsg="+ URLEncoder.encode(errmsg, "utf-8"); 
            // 格式 parm = aaa=111&bbb=222&ccc=333&ddd=444  
            String parm =name+idCard+phoneNo+orderNo+errcode+errmsg;
            		
            // 将参数输出到连接  
            dataout.writeBytes(parm);  
              
            // 输出完成后刷新并关闭流  
            dataout.flush();  
            dataout.close(); // 重要且易忽略步骤 (关闭流,切记!)   
              
//            System.out.println(connection.getResponseCode());  
              
            // 连接发起请求,处理服务器响应  (从连接获取到输入流并包装为bufferedReader)  
            BufferedReader bf = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));   
            String line;  
           
              
            // 循环读取流,若不到结尾处  
            while ((line = bf.readLine()) != null) {  
//                sb.append(bf.readLine());  
                sb.append(line).append(System.getProperty("line.separator"));  
            }  
            bf.close();    // 重要且易忽略步骤 (关闭流,切记!)   
            connection.disconnect(); // 销毁连接  
           // System.out.println(sb.toString());  
      
        } catch (Exception e) {  
            e.printStackTrace();  
        }
		return sb.toString();  
    } 
    
    
    /** 
     * 模拟请求 
     *  
     * @param url       资源地址 
     * @param map   参数列表 
     * @param encoding  编码 
     * @return 
     * @throws ParseException 
     * @throws IOException 
     */  
    public static String send(String url, Map<String,String> map,String encoding) throws ParseException, IOException{  
        String body = "";  
  
        //创建httpclient对象  
        CloseableHttpClient client = HttpClients.createDefault();  
        //创建post方式请求对象  
        HttpPost httpPost = new HttpPost(url);  
          
        //装填参数  
        List nvps = new ArrayList();  
        if(map!=null){  
            for (Entry<String, String> entry : map.entrySet()) {  
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));  
            }  
        }  
        //设置参数到请求对象中  
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));  
  
        System.out.println("请求地址："+url);  
        System.out.println("请求参数："+nvps.toString());  
          
        //设置header信息  
        //指定报文头【Content-type】、【User-Agent】  
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");  
        //httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");  
          
        //执行请求操作，并拿到结果（同步阻塞）  
        CloseableHttpResponse response = client.execute(httpPost);  
        //获取结果实体  
        HttpEntity entity = response.getEntity();  
        if (entity != null) {  
            //按指定编码转换结果实体为String类型  
            body = EntityUtils.toString(entity, encoding);  
        }  
        EntityUtils.consume(entity);  
        //释放链接  
        response.close();  
        return body;  
    }  

public static void main(String[] args) {
	niwodaihttp nwd=new niwodaihttp();
	String fronttobase=Base64Test.GetImageStr("E:/快加项目文件文档备份/1/2016-3-24 14-08-41.png");//身份证正面照图片转base64编码
	String oppositetobase=Base64Test.GetImageStr("E:/快加项目文件文档备份/1/2016-3-24 14-08-41.png");//身份证反面照图片转base64编码
	String applytobase=Base64Test.GetImageStr("E:/快加项目文件文档备份/1/2016-3-24 14-08-41.png");//申请书正面照图片转base64编码
	String authorizetobase=Base64Test.GetImageStr("E:/快加项目文件文档备份/1/2016-3-24 14-08-41.png");//授权书正面照图片转base64编码
	String hztobase=Base64Test.GetImageStr("E:/快加项目文件文档备份/1/2016-3-24 14-08-41.png");//合照正面照图片转base64编码
	String ckey="1";//ckey验证码
	String name="刘邦";//客户姓名
	String IDcard_num="411403199512198419";//客户身份证号
	String phone_num="15544345534";//客户手机号
	String authorize_num="12345678910";//授权书编码
	String sum_bit="4";//提交状态 
	String ly="提交查询信息";//备注
//	 String url="https://api.kcway.net/cshttp.do";  
//     Map<String, String> map = new HashMap<String, String>();  
//     map.put("csstr", "js");  
//     map.put("id","1");   
//     String body;
//	try {
//		body = send(url, map,"utf-8");
//	    System.out.println("交易响应结果：");  
//	     System.out.println(body);  
//	} catch (ParseException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}  
 
     //征信信息提交
	//System.out.println();
	String s= zxtj(fronttobase,oppositetobase, applytobase, authorizetobase, hztobase, 
				ckey, name, IDcard_num, phone_num, authorize_num, sum_bit, ly);
	System.out.println(s);
	 String orderno="";
	 //订单查询
//	 System.out.println("请输入要查询的订单:");
//	 String orderNo = new Scanner(System.in).next();
//	 zxcx(orderNo,ckey);
	 
	 
}
	
	
	
	
	
	
	
	
	
}
