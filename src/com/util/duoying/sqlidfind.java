package com.util.duoying;

import java.util.ArrayList;
import java.util.List;

public class sqlidfind {

	
	
	
	public static void main(String[] args) {
          List l1=new ArrayList<>();
          List l2=new ArrayList<>();
          List l3=new ArrayList<>();
          List l4=new ArrayList<>();
          for(int i=0;i<10;i++){
        	l1.add(i); 
        	l2.add(i+1); 
        	l3.add(i+2); 
          }
         
          System.out.println("1:"+l1);
          System.out.println("2:"+l2);
          System.out.println("3:"+l3);
          l4.addAll(l1);
          l4.addAll(l2);
          l4.addAll(l3);
          System.out.println("4:"+l4);
          for(int l=0;l<l4.size();l++){
        	if(l<l3.size()){
        	System.out.println("l3:"+l);
        	}  
          }
          
	}
}
