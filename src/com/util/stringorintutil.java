package com.util;

public class stringorintutil {
	
	
	public static boolean isNumeric(String str){
		  for (int i = 0; i < str.length(); i++){
		   //System.out.println(str.charAt(i));
		   if (!Character.isDigit(str.charAt(i))){
		    return false;
		   }
		  }
		  return true;
		 }
	
	
	public static void main(String[] args) {
		
	 boolean t=	isNumeric("dsada");
	 if(t){
		 System.out.println(t); 
	 }else{
		 System.out.println("ffffffffffff");
	 }
		
	}
}
