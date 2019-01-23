package com.http;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

public class jsonhttp {
    
    private final static String CONTENT_TYPE_TEXT_JSON = "text/json;charset=UTF-8";
    
    
    
  
    public static void close() {
        try {
            Unirest.shutdown();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static String postRequest(String url,String param) throws ClientProtocolException, IOException{
        
        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type","application/x-www-form-urlencoded;charset=utf-8");
        //httpPost.setHeader("ckey",ckey);
        //Gson gson = new Gson();
        //String parameter = gson.toJson(param);
        System.out.println(param);
        
        StringEntity se = new StringEntity(param);      
        //se.setContentType(CONTENT_TYPE_TEXT_JSON);
        //System.out.println(se);
        httpPost.setEntity(se);
        CloseableHttpResponse response = client.execute(httpPost);
        
        HttpEntity entity = response.getEntity();
        
        String result = EntityUtils.toString(entity,"UTF-8");
        
        return result;
    }
    
    public static JsonNode gjc(String text, String cKey){
        String SENTIMENT_URL ="http://apitest.kcway.net/batchqueryzx.do";
        //http://apitest.kcway.net  http://localhost:8080/kcd
        String body =text;  //new JSONArray(new String[]{text}).toString();
        System.out.println(body);
        HttpResponse<JsonNode> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(SENTIMENT_URL)
                    .header("Accept","application/json")
                    .header("ckey",cKey)
                    .body(body)
                    .asJson();
            //Unirest.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonResponse.getBody());
        return jsonResponse.getBody();
    }
    
    public static JsonNode gjc1(String text){
//    	, String cKey
        String SENTIMENT_URL ="http://test.creditplatform.jiayincredit.com/personal/kcway/receive-report";
        //http://apitest.kcway.net
        String body =text;  //new JSONArray(new String[]{text}).toString();
        System.out.println(body);
        HttpResponse<JsonNode> jsonResponse = null;
        try {
            jsonResponse = Unirest.post(SENTIMENT_URL)
                    .header("Accept","application/json")
                    //.header("ckey",cKey)
                    .body(body)
                    .asJson();
            //Unirest.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(jsonResponse.getBody());
        return jsonResponse.getBody();
    }
    
    public static void main(String[] args) {
//    	try {
//    	 String fronttobase="ww1";
//    	String oppositetobase="ww2";
//    	String applytobase="ww3";
//    	 String authorizetobase="ww4";
//    	String hztobase="ww5	";
//    		String str="fronttobase="+fronttobase+"&oppositetobase="+oppositetobase+
//    				"&applytobase="+applytobase+"&authorizetobase="+authorizetobase+"&hztobase="+hztobase;
////    		"orderNo=120&&ckey=c"
//		String s=postRequest("http://apitest.kcway.net/tobase64img.do",str);
//				
//			System.out.println(s);
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    	
    	
//    	List<Map<String, String>> ml=new ArrayList<Map<String, String>>();
//    	Map m=new HashMap();
//    	m.put("orderrNo", "1");
//    	m.put("errcode", "1");
//    	m.put("errmsg", "成功");
//    	m.put("pdfurl", "pdf");
//    	m.put("addtime",creditutil.time());
//    	m.put("sign", "");
//    	m.put("time", "");   
//    	ml.add(m);
//    	System.out.println(jsonutil.toJSONString(ml));
//    	String text=jsonutil.toJSONString(ml).replace("[", "").replace("]", "");
//    	JsonNode jn=gjc1(text);
//    	System.out.println(jn);
    	
    	
    	
    //	System.out.println(creditutil.timetofile(creditutil.time()));
//    	String text="[{'opath':'C:/Users/Administrator/Desktop/1/1.jpg',"
//    			+ "'fname':'4.jpg'"
//    			+ "}]";
//    	String cKey="";
//    	JsonNode jn= gjc1(text);
//    	System.out.println(jn.toString());
//    	代银贵  511025196506044058
    String s2="[{\"c_name\":\"杨文春\",\"c_card_no\":\"152321197404100329\"},"
    			+ "{\"c_name\":\"樊占芳\",\"c_card_no\":\"410482196704155976\"},"
    					+ "{\"c_name\":\"葛竹玲\",\"c_card_no\":\"430603198312152045\"}]";
    	
	String s="[{\"c_name\":\"杨文春\",\"c_card_no\":\"152321197404100329\"},"
			+ "{\"c_name\":\"樊占芳\",\"c_card_no\":\"410482196704155976\"},"
					+ "{\"c_name\":\"葛竹玲\",\"c_card_no\":\"430603198312152045\"},"
							+ "{\"c_name\":\"陈应斌\",\"c_card_no\":\"512921197005048316\"},"
									+ "{\"c_name\":\"李峰\",\"c_card_no\":\"41282819751127301X\"}]";//,{'name':'周瑜','IDcard_num':'3214031995121084121'}]";
  	String s1="[{'name':'杨文春','IDcard_num':'152321197404100329'},{'name':'客户问问','IDcard_num':'411403199512108412'}]";	
    String ckey="640055077d5c49b91dbb1e8cc2809b32";
   	String ckey1="ykd";
    JsonNode jn=gjc(s,ckey);
   	//JsonNode jn=gjc(s);
  	System.out.println(jn.toString());
//  	 List<ykdutil> l=jsonutil.toList(s,ykdutil.class);
//  	 List<ykdutil> l1=jsonutil.toList(s2,ykdutil.class);
//  	 for(int i=0;i<l.size();i++){
//  		 ykdutil y=l.get(i);
//  		 System.out.println(y.getC_name()+"----"+y.getC_card_no());  		 
//  		 for(int j=0;j<l1.size();j++){
//  			 ykdutil y1=l1.get(j); 
//  			if(y.getC_card_no().toString().equals(y1.getC_card_no().toString())){
//  				System.out.println(y1.getC_name()+"----"+y1.getC_card_no());  
//  			}
//  			 
//  		 }
//  		 
//  	 }
  	 
//    	String fronttobase=Base64Test.GetImageStr("C:/Users/Administrator/Desktop/1/1.jpg");
//    	String oppositetobase=Base64Test.GetImageStr("C:/Users/Administrator/Desktop/1/1.jpg");
//    	String applytobase=Base64Test.GetImageStr("C:/Users/Administrator/Desktop/1/1.jpg");
//    	String authorizetobase=Base64Test.GetImageStr("C:/Users/Administrator/Desktop/1/1.jpg");
//    	String hztobase=Base64Test.GetImageStr("C:/Users/Administrator/Desktop/1/1.jpg");
//    	String jsonstring1="{'hztobase':"+hztobase+"}";
//    	
//    	String jsonstring="{"
//    		+ "'fronttobase':'C:/Users/Administrator/Desktop/1/1.jpg',"
//    		+ "'oppositetobase':'C:/Users/Administrator/Desktop/1/1.jpg',"
//    		+ "'applytobase':'C:/Users/Administrator/Desktop/1/1.jpg',"
//    		+ "'authorizetobase':'C:/Users/Administrator/Desktop/1/1.jpg',"
//    		+ "'hztobase':'C:/Users/Administrator/Desktop/1/1.jpg',"
//    		+ "'name':'哈喽',"
//    		+ "'IDcard_num':'12345678910',"
//    		+ "'phone_num':'12345678910',"
//    		+ "'authorize_num':'12345678910',"
//    		+ "'sum_bit':'1',"
//    		+ "'ly':'你好'"
//    		+ "}";
//    jsonstring=jsonstring.replace("[", "").replace("]","");
//    Map jsons=jsonutil.toHashMap(jsonstring);
//    System.out.println(jsons.get("hztobase"));
//    String ckey="56628E4A0C06EBEAFEEEE2A213FA8FC3";
//    JsonNode jn=gjc1(jsonstring,ckey);	
//    System.out.println(jn.toString());
//	    String s="{'czcode':'2','pIDcard':'2','pname':'2','pcall':'2','sname':'2','alevel':'2'},"
//	    		+ "{'czcode':'3','pIDcard':'3','pname':'3','pcall':'3','sname':'3','alevel':'3'}";	   
//    	JsonNode jn=gjc1(s);
//    	System.out.println(jn.toString());
//    	String dataqj="{'sdate':'2017-10-19 11:37:50','edate':'2017-10-19 12:37:50'}";
//    	String ckey="640055077d5c49b91dbb1e8cc2809b32";
//    	JsonNode jn=gjc(dataqj,ckey);
//    	System.out.println(jn.toString());
    	
//    	Map m=jsonutil.toHashMap(dataqj);
//         System.out.println(m.get("sdate"));
//     	//close();
//    	
//    	String d1="2017-09-22 14:31:48";
//    	String d2="";
//		try {
//			String	s=postRequest("http://apitest.kcway.net/queryykd.do",d1,d2,ckey);
//			System.out.println(s);
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		

    	
	}

}
