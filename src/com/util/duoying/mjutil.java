package com.util.duoying;

public class mjutil {
	

public static void main(String[] args) {
	net.sf.json.JSONObject j=new net.sf.json.JSONObject();
    j.put("ab", "123");
    j.put("bc", null);
    String s=j.toString();
    System.out.println(s);
}


}
