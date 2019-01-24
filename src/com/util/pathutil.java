package com.util;

public class pathutil {

	    public static String getPath(){
	    	String msg="";
	        String os_name = System.getProperties().get("os.name").toString().toLowerCase();
	        //System.out.println(os_name);
	        if(os_name.indexOf("windows")!=-1){
	        	msg="\\";
	            return msg;
	        }else if(os_name.indexOf("linux")!=-1){
	        	msg="/";
	        	return msg;
	        }
	        return null;
	    }

}
