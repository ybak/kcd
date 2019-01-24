package com.util.duoying;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

public class bllwxs {
	   /*  
     * 判断是否为整数   
     * @param str 传入的字符串   
     * @return 是整数返回true,否则返回false   
   */    
     public static boolean isInteger(String str) {      
       Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");      
       return pattern.matcher(str).matches();      
     }    
 
 
   /*   
     * 判断是否为浮点数，包括double和float   
     * @param str 传入的字符串   
     * @return 是浮点数返回true,否则返回false   
   */      
     public static boolean isDouble(String str) {      
       Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");      
       return pattern.matcher(str).matches();      
     } 
	public static boolean isNumeric(String str){
		  for (int i = 0; i < str.length(); i++){
		   System.out.println(str.charAt(i));
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }
	
	
	public static double xshlw(Object ob){
		double dbj=0 ;   
		DecimalFormat jd = new DecimalFormat("#0.00");			
		//System.out.println(xsd);
        dbj=(double) ob;
        boolean tf= isIntegerForDouble(dbj);
        if(tf!=true){
        int xsd=ob.toString().indexOf(".");
        int ws=Integer.parseInt(ob.toString().substring(xsd+3,xsd+4));
        	System.out.println("非整数double:"+dbj);
        if(ws>4){
        	dbj=Double.parseDouble(jd.format(Double.parseDouble(ob.toString())));
        	System.out.println("五入:"+dbj);
        }else{ 
        	int two=Integer.parseInt(ob.toString().substring(xsd+2,xsd+3));
        	two=two+1;
        	dbj=Double.parseDouble(ob.toString().substring(0,xsd+2)+two);        	
        	System.out.println("四不舍:"+dbj);
        }		    	
        }else{
        	System.out.println("整数double:"+dbj);
        }
		return dbj;			
	 }
	/** 
	 * 判断double是否是整数 
	 * @param obj 
	 * @return 
	 */  
	public static boolean isIntegerForDouble(double obj) {  
	    double eps = 1e-10;  // 精度范围  
	    return obj-Math.floor(obj) < eps;  
	} 	
	public static void main(String[] args) {		
		double s=bllwxs.xshlw(40.002131);	
		//double obj=40.00000;
		//System.out.println(isIntegerForDouble(obj)); 
		System.out.println(s);		
	}
}
