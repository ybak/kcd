package com.controller.duoying;

public class queryLoanInfoResultController {
    
	public static void main(String[] args) {
		 String s1="2008-01-25 09:12:09";
		 String s2="2008-01-29 09:12:11";
		 java.text.DateFormat df=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 java.util.Calendar c1=java.util.Calendar.getInstance();
		 java.util.Calendar c2=java.util.Calendar.getInstance();
		 try{

		 c1.setTime(df.parse(s1));

		 c2.setTime(df.parse(s2));

		 }catch(java.text.ParseException e){

		 System.err.println("格式不正确");

		 }

		 int result=c1.compareTo(c2);

		 if(result==0)

		 System.out.println("c1相等c2");

		 else if(result<0)

		 System.out.println("c1小于c2");

		 else

		 System.out.println("c1大于c2");
		
	}
}
