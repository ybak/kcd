package com.controller.ftp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.model1.city.states;

public class mq {

	 public static void main(String[] args) {
		
//		 String[] arr={"a","b","1","c","b"};
//		 
//		 List list=new ArrayList<>();
//		 
//		 list.add("d");
//		 Collections.addAll(list,arr);
//		 System.out.println("运行结果1："+list);
//		 
//		 Set<String> s1=new HashSet<String>();
//	     s1.add("d");
//	     Collections.addAll(s1, arr);
//	     System.out.println("2:"+s1);
//		 System.out.println(getv(2));
		 
		 String badRegex ="^([hH][tT]{2}[pP]://|[hH][tT]{2}[pP][sS]://)(([A-Za-z0-9-~]+).)+([A-Za-z0-9-~\\\\/])+$";
		 String bugUrl ="http://www.fapiao.com/dddp-web/pdf/download?request=6e7JGxxxxx4ILd-kExxxxxxxqJ4-CHLmqVnenXC692m74H38sdfdsazxcUmfcOH2fAfY1Vw__%5EDadIfJgiEf";
	
		 if (bugUrl.matches(badRegex)) {
		 System.out.println("match!!");
		 } else {
		 System.out.println("no match!!");
		 }

	 }
	 
	 
	 public static int getv(int i){
		 int result=0;
		 switch (i) {
		 case 1:
			 System.out.println("1"+"-"+result+"-"+i);
			result=result+i;
         case 2:
        	 System.out.println("2"+"-"+result+"-"+i);
			result=result+i*2;
         case 3: 
        	 System.out.println("3"+"-"+result+"-"+i);
			 result=result+i*3;
		}
		 return result;
	 }
	
	 
}
