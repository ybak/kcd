package com.http;

import java.io.File;  
import java.io.IOException;  
import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.HttpStatus;  
import org.apache.http.ParseException;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.entity.mime.MultipartEntity;  
import org.apache.http.entity.mime.content.FileBody;  
import org.apache.http.impl.client.DefaultHttpClient;  
import org.apache.http.util.EntityUtils; 


public class filehttp {

    public void SubmitPost(String url, String file36Path, String file48Path, String file72Path,
            String file96Path, String file144Path) {

        HttpClient httpclient = new DefaultHttpClient();

        try {

            HttpPost httppost = new HttpPost(url);

            FileBody file36 = new FileBody(new File(file36Path));
            FileBody file48 = new FileBody(new File(file48Path));
            FileBody file72 = new FileBody(new File(file72Path));
            FileBody file96 = new FileBody(new File(file96Path));
            FileBody file144 = new FileBody(new File(file144Path));

            MultipartEntity reqEntity = new MultipartEntity();

            reqEntity.addPart("fronttobase", file36);// file36为请求后台的File upload;属性
            reqEntity.addPart("oppositetobase", file48);
            reqEntity.addPart("applytobase", file72);
            reqEntity.addPart("authorizetobase", file96);
            reqEntity.addPart("hztobase", file144);
            
            
            httppost.setEntity(reqEntity);
            //httppost.setParams(null);

            HttpResponse response = httpclient.execute(httppost);

            int statusCode = response.getStatusLine().getStatusCode();

            if (statusCode == HttpStatus.SC_OK) {

                System.out.println("服务器正常响应.....");

                HttpEntity resEntity = response.getEntity();

                System.out.println(EntityUtils.toString(resEntity));// httpclient自带的工具类读取返回数据

                System.out.println(resEntity.getContent());//这里是服务端的返回值

                EntityUtils.consume(resEntity);
            }

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                httpclient.getConnectionManager().shutdown();
            } catch (Exception ignore) {

            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        filehttp fileUploadClient = new filehttp();

        fileUploadClient.SubmitPost(
                "http://localhost:8080/kcd/zxsave.do",
                "C:/Users/Administrator/Desktop/2/2.jpg", "C:/Users/Administrator/Desktop/2/2.jpg", "C:/Users/Administrator/Desktop/2/2.jpg", "C:/Users/Administrator/Desktop/2/2.jpg", "C:/Users/Administrator/Desktop/2/2.jpg");
    }

}
