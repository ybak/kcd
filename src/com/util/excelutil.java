package com.util;
import java.io.FileOutputStream;  
import java.util.ArrayList;  
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;  
import org.apache.poi.hssf.usermodel.HSSFCellStyle;  
import org.apache.poi.hssf.usermodel.HSSFRow;  
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import com.model.yw;  
  
public class excelutil  
{  
	 public static void toexcel(List list){		 		  
	        // 第一步，创建一个webbook，对应一个Excel文件  
	        HSSFWorkbook wb = new HSSFWorkbook();  
	        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
	        HSSFSheet sheet = wb.createSheet("业务表");  
	        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
	        HSSFRow row = sheet.createRow(0);  
	        // 第四步，创建单元格，并设置值表头 设置表头居中  
	        HSSFCellStyle style = wb.createCellStyle();  
	        style.setAlignment(CellStyle.ALIGN_CENTER); // 创建一个居中格式  
	  
	        HSSFCell cell = row.createCell((short) 0);        
	        cell.setCellValue("编号");  
	        cell.setCellStyle(style);  
	       
	        cell = row.createCell((short) 1);         
	        cell.setCellValue("被查询人名称");  
	        cell.setCellStyle(style);  
	       
	        cell = row.createCell((short) 2);         
	        cell.setCellValue("操作人");  
	        cell.setCellStyle(style);  
	       
	        cell = row.createCell((short) 3);        
	        cell.setCellValue("操作人等级");  
	        cell.setCellStyle(style);  
	       
	        cell = row.createCell((short) 4);          
	        cell.setCellValue("操作人所属门店");  
	        cell.setCellStyle(style);  
	       
	        cell = row.createCell((short) 5);          
	        cell.setCellValue("操作状态");  
	        cell.setCellStyle(style);  
	       
	        cell = row.createCell((short) 6);          
	        cell.setCellValue("订单编号");  
	        cell.setCellStyle(style);  
	       
	        cell = row.createCell((short) 7);        
	        cell.setCellValue("所需费用");  
	        cell.setCellStyle(style);  
	       
	        cell = row.createCell((short) 8);        
	        cell.setCellValue("操作时间");  
	        cell.setCellStyle(style);  

	      
	        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  	         
	        yw yw=new yw();
	        for (int i = 0; i < list.size(); i++)  
	        {   
	        	row = sheet.createRow(i + 1);  
	            yw =(yw) list.get(i);  
	            // 第四步，创建单元格，并设置值  
	            row.createCell((short) 0).setCellValue(yw.getId()); 
	            row.createCell((short) 1).setCellValue(yw.getSname());  
	            row.createCell((short) 2).setCellValue(yw.getCzr());  
	            row.createCell((short) 3).setCellValue(yw.getCzrdj());
	            row.createCell((short) 4).setCellValue(yw.getCzrssmd());  
	            row.createCell((short) 5).setCellValue(yw.getCzzt());  
	            row.createCell((short) 6).setCellValue(yw.getOrderid());             
	            row.createCell((short) 7).setCellValue(yw.getSxkd());  
	            row.createCell((short) 8).setCellValue(yw.getCztime());                       
	        }  
	        // 第六步，将文件存到指定位置  
	        try  
	        {  
	            FileOutputStream fout = new FileOutputStream("C:/Users/Administrator/Desktop/1/yw.xls");  
	            wb.write(fout);  
	            fout.close();  
	        }  
	        catch (Exception e)  
	        {  
	            e.printStackTrace();  
	        }  
	    
		 
	 }
      
    /** 
     * @功能：手工构建一个简单格式的Excel 
     */  
    private static List<yw> getStudent() throws Exception  
    {  
        List list = new ArrayList();         
      
        yw y1=new yw();
        y1.setId(1);
        y1.setCzr("1");
        y1.setCzrdj("1");
        y1.setCzrssmd("1");
        y1.setCztime(creditutil.time());
        y1.setCzzt("1");
        y1.setOrderid("1");
        y1.setSname("1");
        y1.setSxkd("1");
      
        yw y2=new yw();
        y2.setId(1);
        y2.setCzr("2");
        y2.setCzrdj("2");
        y2.setCzrssmd("2");
        y2.setCztime(creditutil.time());
        y2.setCzzt("2");
        y2.setOrderid("2");
        y2.setSname("2");
        y2.setSxkd("2");
       
        yw y3=new yw();
        y3.setId(3);
        y3.setCzr("3");
        y3.setCzrdj("3");
        y3.setCzrssmd("3");
        y3.setCztime(creditutil.time());
        y3.setCzzt("3");
        y3.setOrderid("3");
        y3.setSname("3");
        y3.setSxkd("3");
        
        list.add(y1);
        list.add(y2);
        list.add(y3);
        
        return list;  
    }  
  
    public static void main(String[] args) throws Exception  
    {
    	List list = new ArrayList();         
        
        yw y1=new yw();
        y1.setId(1);
        y1.setCzr("1");
        y1.setCzrdj("1");
        y1.setCzrssmd("1");
        y1.setCztime(creditutil.time());
        y1.setCzzt("1");
        y1.setOrderid("1");
        y1.setSname("1");
        y1.setSxkd("1");
      
        yw y2=new yw();
        y2.setId(1);
        y2.setCzr("2");
        y2.setCzrdj("2");
        y2.setCzrssmd("2");
        y2.setCztime(creditutil.time());
        y2.setCzzt("2");
        y2.setOrderid("2");
        y2.setSname("2");
        y2.setSxkd("2");
       
        yw y3=new yw();
        y3.setId(3);
        y3.setCzr("3");
        y3.setCzrdj("3");
        y3.setCzrssmd("3");
        y3.setCztime(creditutil.time());
        y3.setCzzt("3");
        y3.setOrderid("3");
        y3.setSname("3");
        y3.setSxkd("3");
        
        list.add(y1);
        list.add(y2);
        list.add(y3);
    	
        toexcel(list);
    	
    	
    }  
}  
