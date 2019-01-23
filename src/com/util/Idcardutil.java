package com.util;

import org.apache.commons.lang.StringUtils;

public class Idcardutil {
	
	public static  Object maskCertId(String certId) {  
	    // TODO Auto-generated method stub  
	      
	    String str ="";  
	    if(certId==null||certId.length()==0) return "";    
	    if(certId.length() ==18){  
	        str =wordMask(certId,6,4,"*");  
	    }  
	    return str;  
	      
	}
	public static  String wordMask(String word, int startLength, int endLength, String pad) {  
	      
	    if(word==null) return StringUtils.leftPad("", startLength+endLength,pad);  
	    if(word.length()<=startLength+endLength) return StringUtils.leftPad("", startLength+endLength,pad);  
	    String startStr = "";  
	    String endStr = "";  
	    int padLength = 0;  
	    if(word.length()>startLength) startStr = StringUtils.substring(word, 0,startLength);  
	    if(word.length()>startLength+endLength) endStr = StringUtils.substring(word, word.length()-endLength);  
	      
	    padLength = word.length()-startLength-endLength;  
	      
	    return startStr + StringUtils.repeat(pad, padLength)+endStr;  
	      
	      
	      
	}  
	public static void main(String[] args) {
	Object str=	maskCertId("411403199512108410");
	System.out.println(str);
	}
}
