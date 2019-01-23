package com.controller.icbc.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class GetFileName
{
    public static String [] getFileName(String path)
    {
        File file = new File(path);
        String [] fileName = file.list();
        return fileName;
    }
    public static void getAllFileName(String path,ArrayList<String> fileName)
    {
        File file = new File(path);
        File [] files = file.listFiles();
        String [] names = file.list();
        if(names != null)
        fileName.addAll(Arrays.asList(names));
        for(File a:files)
        {
            if(a.isDirectory())
            {
                getAllFileName(a.getAbsolutePath(),fileName);
            }
        }
    }
    public static void main(String[] args)
    {
//        String [] fileName = getFileName("C:/Users/Administrator/Desktop/carsassess");
//        for(String name:fileName)
//        {
//            System.out.println(name);
//        }
//        System.out.println("--------------------------------");
        ArrayList<String> listFileName = new ArrayList<String>(); 
        getAllFileName("C:/Users/Administrator/Desktop/carsassess",listFileName);
        System.out.println(listFileName);
        for(String name:listFileName)
        {
            System.out.println(name);
        }
         
    }
}
