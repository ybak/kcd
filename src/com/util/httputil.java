package com.util;


public class httputil {
	
	

    public static void main(String[] args) {
		
    	int s=40;
    	int i=30;
    	
    	int d=s%i;
    	int d1=s/i;
    	if(d==0){
    		d1=s/i;	
    	}else{
    		d1=s/i+1;
    	}

    	System.out.println(d1);
    	
	}
}
