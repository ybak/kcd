package com.util.newAdd;
import java.text.SimpleDateFormat;
import java.util.Date;
public class TimeStyle {

    public static final String sdfYMD = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    public static final String sdfYMDHM = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
    public static final String sdfYMDHMS = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

    public static void main(String [] args){
        System.err.println(sdfYMD);
        System.err.println(sdfYMDHM);
        System.err.println(sdfYMDHMS);
    }
}
