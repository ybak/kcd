package com.http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.util.Base64Test;

public class TestKuaizhengCustomerCertificationInitialize {

    
    
	public static void main(String[] args) throws Exception {
		TestKuaizhengCustomerCertificationInitialize kj = new TestKuaizhengCustomerCertificationInitialize();
		Base64Test b=new Base64Test();
		String filestr= Base64Test.getImageStr("C:/Users/Administrator/Desktop/cc6c0df99e57f498be621278bb0907a.jpg");
		
//		File file = new File("C:\\Users\\钟\\Desktop\\base身份证照片.txt");
//		String filestr = kj.txt2String(file);		
		String strURL = "http://localhost:8080/kcd/tofindzx.do";
		String fronttobase = filestr;
		String oppositetobase = filestr;
		String applytobase = filestr;
		String authorizetobase = filestr;
		String hztobase = filestr;
		String name = "测试";
		String IDcard_num = "429001199405030283";
		String phone_num = "15010219309";
		String authorize_num = "012345";
		String sum_bit = "4";
		String ckey = "1";
		String ly = "测试";
		
//		 fronttobase = "fronttobase="+0;        
//         oppositetobase = "&oppositetobase="+0;           
//         applytobase = "&applytobase="+0;            
//         authorizetobase = "&authorizetobase="+0;        
//         hztobase = "&hztobase="+0;  
//         ckey = "&ckey="+ckey;  
//         name = "&name="+name;  
//         IDcard_num = "&IDcard_num="+IDcard_num;  
//         phone_num = "&phone_num="+phone_num;  
//         authorize_num = "&authorize_num="+authorize_num;  
//         sum_bit = "&sum_bit="+sum_bit;  
//         ly = "&ly="+ly; 
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
        System.out.println("parm字节数"+parm.length());	
    	//String result = TestKuaizhengCustomerCertificationInitialize.getpost(strURL,parm);
String result1 = kj.postzx(strURL, fronttobase, oppositetobase, applytobase, authorizetobase, hztobase, name, IDcard_num, phone_num, authorize_num, sum_bit, ckey, ly);
        System.out.println(result1);
//		JSONObject jsonobject = new JSONObject(result);
//		String errcode = jsonobject.getString("errcode");
//		String errmsg = jsonobject.getString("errmsg");
//		String orderNo = "";
//		orderNo = (String) jsonobject.get("orderNo");
//		System.out.println("errcode："+errcode);
//		System.out.println("errmsg："+errmsg);
//		System.out.println("orderNo："+orderNo);
	}

	public String postJson(String strURL, String fronttobase, String oppositetobase, String applytobase, String authorizetobase, String hztobase, String name, String IDcard_num, String phone_num, String authorize_num, String sum_bit, String ckey, String ly) {
		try {
			URL url = new URL(strURL);// 创建连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
//			connection.setRequestMethod("POST"); // 设置请求方式
//			connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
//   		    connection.setRequestProperty("Content-Type","application/json"); // 设置发送数据的格式
//			connection.setRequestProperty("Charset", "UTF-8");
			connection.connect();
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
			out.append("fronttobase="+fronttobase);
//			out.append("&oppositetobase="+oppositetobase);
//			out.append("&applytobase="+applytobase);
//			out.append("&authorizetobase="+authorizetobase);
//			out.append("&hztobase="+hztobase);
//			out.append("&name="+name);
//			out.append("&IDcard_num="+IDcard_num);
//			out.append("&phone_num="+phone_num);
//			out.append("&authorize_num="+authorize_num);
//			out.append("&sum_bit="+sum_bit);
//			out.append("&ckey="+ckey);
//			out.append("&ly="+ly);			
			out.flush();
			out.close();
			// 读取响应
			int length = connection.getContentLength();// 获取长度
			InputStream is = connection.getInputStream();
			if (length != -1) {
				byte[] data = new byte[length];
				byte[] temp = new byte[512];
				int readLen = 0;
				int destPos = 0;
				while ((readLen = is.read(temp)) > 0) {
					System.arraycopy(temp, 0, data, destPos, readLen);
					destPos += readLen;
				}
				String result = new String(data, "UTF-8"); // utf-8编码
				System.out.println(result);
				return result;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null; // 自定义错误信息
	}
	
    /**
     * 登录
     * @param phoneNo 手机号码
     * @param passwd 密码
     * @param capcha 图片验证码
     * @param callback 回调地址
     * @return 响应报文
     * @throws IOException
     */
    public static String postzx(String strURL,
    		String fronttobase,
    		String oppositetobase,
    		String applytobase,
    		String authorizetobase,
    		String hztobase,
    		String name,
    		String IDcard_num,
    		String phone_num,
    		String authorize_num,
    		String sum_bit,
    		String ckey,
    		String ly) throws IOException
    {
        CloseableHttpClient client = HttpClients.createDefault();

        //获取验证码接口地址
       // String reqUrl = "http://apitest.kcway.net/authorizelogin.do";

        HttpUriRequest request = RequestBuilder.get()//get请求
                .setUri(strURL)
                 //.addHeader(APIX_KEY, apixKey)
                .addParameter("fronttobase", fronttobase)//手机号
                .addParameter("oppositetobase" , oppositetobase)//服务密码
                .addParameter("applytobase", applytobase)//验证码
                .addParameter("authorizetobase" ,authorizetobase)//回调地址
                .addParameter("hztobase", hztobase)//手机号
                .addParameter("name" , name)//服务密码
                .addParameter("IDcard_num", IDcard_num)//验证码
                .addParameter("phone_num" , phone_num)//回调地址
                .addParameter("authorize_num", authorize_num)//手机号
                .addParameter("sum_bit" , sum_bit)//服务密码
                .addParameter("ckey", ckey)//验证码
                .addParameter("ly" , ly)//回调地址
                .build();
        //System.out.println(request.);
        CloseableHttpResponse response = client.execute(request);
        return EntityUtils.toString(response.getEntity());
    }
	
	 public static String getpost(String SENTIMENT_URL,String text){
//		 String SENTIMENT_URL ="http://apitest.kcway.net/batchqueryzx.do";
	        //http://apitest.kcway.net  http://localhost:8080/kcd
	        String body =text;  //new JSONArray(new String[]{text}).toString();
	        //System.out.println("图片字节数:"+body);
	        HttpResponse<JsonNode> jsonResponse = null;
	        try {
	            jsonResponse = Unirest.post(SENTIMENT_URL)
	            		.header("Content-Type","text/html;charset=UTF-8")
	                    //.header("ckey",cKey)
	                    .body(body)
	                    .asJson();
	            //Unirest.shutdown();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        //System.out.println(jsonResponse.getBody());
	        return jsonResponse.getBody().toString();
	    }
	/**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
    public static String txt2String(File file){
    	String line = "";
        try{
        	/* 读入TXT文件 */  
            InputStreamReader reader = new InputStreamReader(new FileInputStream(file)); // 建立一个输入流对象reader  
            BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
            line = br.readLine();  
//            while (line != null) {
//                line = br.readLine(); // 一次读入一行数据  
//            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return line;
    }

	/**  
     * 将一个输入流转换成指定编码的字符串  
     *   
     * @param inputStream  
     * @param encode  
     * @return  
     */  
    private String changeInputStream(InputStream inputStream, String encode) {  
  
        // 内存流  
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();  
        byte[] data = new byte[1024];  
        int len = 0;  
        String result = null;  
        if (inputStream != null) {  
            try {  
                while ((len = inputStream.read(data)) != -1) {  
                    byteArrayOutputStream.write(data, 0, len);  
                }  
                result = new String(byteArrayOutputStream.toByteArray(), encode);  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return result;  
    }  

}