package com.util.img;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;

import com.model.index.zxexcel;

public class zxexcelutil {
    /** 
     * 国际路单导出 
     * @param trackingList 
     * @param response 
     * @throws Exception 
     * @date 20**** 
     * @author *** 
     */  

	public static void toxxexcel(List<zxexcel> zxlist,  
            HttpServletResponse response) throws Exception{  		  
        // 第一步，创建一个webbook，对应一个Excel文件  
        HSSFWorkbook wb = new HSSFWorkbook();  
        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
        HSSFSheet sheet = wb.createSheet("worksheet"); 
      
        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
        HSSFRow row = sheet.createRow(0);  
        // 第四步，创建单元格，并设置值表头 设置表头居中  
        HSSFCellStyle style = wb.createCellStyle();
        
        style.setAlignment(CellStyle.ALIGN_CENTER); // 创建一个居中格式  
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);//垂直居中
        style.setBorderBottom(CellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(CellStyle.BORDER_THIN);//左边框
        style.setBorderTop(CellStyle.BORDER_THIN);//上边框
        style.setBorderRight(CellStyle.BORDER_THIN);//右边框        
        HSSFCell cell = row.createCell((short) 0);        
        cell.setCellValue("申请授权书编号");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 1);         
        cell.setCellValue("证件类型");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 2);         
        cell.setCellValue("姓名");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 3);        
        cell.setCellValue("性别");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 4);          
        cell.setCellValue("民族");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 5);          
        cell.setCellValue("通讯地址");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 6);          
        cell.setCellValue("身份证号码");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 7);        
        cell.setCellValue("证件签发机关");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 8);        
        cell.setCellValue("证件有效期");  
        cell.setCellStyle(style);  

        cell = row.createCell((short) 9);        
        cell.setCellValue("联系电话");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 10);        
        cell.setCellValue("查询板式");  
        cell.setCellStyle(style);  
       
        cell = row.createCell((short) 11);        
        cell.setCellValue("曾用名");  
        cell.setCellStyle(style);  
     
        cell = row.createCell((short) 12);        
        cell.setCellValue("通讯地址邮政编码");  
        cell.setCellStyle(style);  
      for(int j=0;j<13;j++){
    	  sheet.setColumnWidth(j, 256*35+184);  
      }
        
      String excelname = null;
        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  	         
        zxexcel zc=new zxexcel();
        for (int i = 0; i < zxlist.size(); i++)  
        {   
        	System.out.println("jsonlength:"+zxlist.size());
        	row = sheet.createRow(i + 1);  
            zc =zxlist.get(i);  
            // 第四步，创建单元格，并设置值  
            row.createCell((short) 0).setCellValue(zc.getCode());             
            row.createCell((short) 1).setCellValue(zc.getZjlx());  
            row.createCell((short) 2).setCellValue(zc.getName());  
            row.createCell((short) 3).setCellValue(zc.getSex());
            row.createCell((short) 4).setCellValue(zc.getMz());  
            row.createCell((short) 5).setCellValue(zc.getTxaddress());  
            row.createCell((short) 6).setCellValue(zc.getIdcard());             
            row.createCell((short) 7).setCellValue(zc.getZjqfjg());  
            row.createCell((short) 8).setCellValue(zc.getZjdate());
            row.createCell((short) 9).setCellValue(zc.getLxdh());
            row.createCell((short) 10).setCellValue(zc.getCxbs());
            row.createCell((short) 11).setCellValue(zc.getCname());
            row.createCell((short) 12).setCellValue(zc.getTxcode());
            row.setRowStyle(style);
            if(zxlist.size()==1){
            	  excelname ="征信_"+zc.getName()+".xls";
                  System.out.println(excelname);
              }  
            }
          
        // 第六步，将文件存到指定位置  
        response.setContentType("text/html;charset=UTF-8");     
        BufferedInputStream in = null;    
        BufferedOutputStream out = null;    
     
        try  
        {  
        	response.setContentType("multipart/form-data");    
            response.setCharacterEncoding("UTF-8");    
            response.setHeader("Content-Disposition", "attachment; filename="+new String(excelname.getBytes("gbk"),"iso-8859-1"));       
            //response.setHeader("Content-Length",String.valueOf()));
            out = new BufferedOutputStream(response.getOutputStream());    
            wb.write(out); 
            //System.out.println("导出完成");   
            out.close();  
        }  
        catch (Exception e)  
        {  
            e.printStackTrace();  
        }  
    }
	 
    public static void main(String[] args) throws Exception {
		zxexcel c=new zxexcel();		
		c.setCode("213231");
		c.setZjlx("213231");
		c.setName("图图");
		c.setSex("213231");
		c.setMz("汉");
		c.setTxaddress("上海浦东新区周浦镇");
		c.setIdcard("41152119920420533X");
		c.setZjqfjg("上海");
		c.setZjdate(" 2013.01.04-2023.01.04");
		c.setLxdh("213231");
		c.setCxbs("0");
		c.setCname("");
		c.setTxcode("edfsfsd");
        zxexcel c1=new zxexcel();		
		c1.setCode("213231");
		c1.setZjlx("");
		c1.setCname("图图");
		c1.setSex("");
		c1.setMz("汉");
		c1.setTxaddress("上海浦东新区周浦镇");
		c1.setIdcard("41152119920420533X");
		c1.setZjqfjg("上海");
		c1.setZjdate(" 2013.01.04-2023.01.04");
		c1.setLxdh("1212321321");
		c1.setCxbs("0");
		c1.setCname("");
		c1.setTxcode("edfsfsd");
        List<zxexcel> zl=new ArrayList<>();
      zl.add(c);	
      zl.add(c1);
      toxxexcel(zl, null);
      
	}
 
}
