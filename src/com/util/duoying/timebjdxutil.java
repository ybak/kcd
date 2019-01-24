package com.util.duoying;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.util.creditutil;

/**
*
* @author hp
*/
public class timebjdxutil {

    public static void main(String args[]) {
       int i= compare_date("1995-11-12 15:21","1995-11-12 15:22");
       System.out.println("i=="+i);
      System.out.println(totime("445555000"));
    }
    
    public static String totime(String time){    	    	
        //时间戳转化为Sting或Date  
        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long l=new Long(time);
        String d = format.format(l);  
		return d.toString();  
    }
    
    
    public static int compare_date(String DATE1,String DATE2) {              
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm");
        try {
            Date dt1 = df.parse(DATE1);
            Date dt2 = df.parse(DATE2);
            if (dt1.getTime()>dt2.getTime()) {
                System.out.println("d1>d2");
                return 1;
            } else if (dt1.getTime()<dt2.getTime()) {
                System.out.println("d1<d2");
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return 0;
    }
}
