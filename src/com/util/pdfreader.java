package com.util;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.lowagie.text.Document;  
import com.lowagie.text.DocumentException;  
import com.lowagie.text.pdf.PdfCopy;  
import com.lowagie.text.pdf.PdfImportedPage;  
import com.lowagie.text.pdf.PdfReader;  





public class pdfreader {

    //读取pdf 全部内容
    public static String readFdfbyAll(String pdffile){
        //StringBuffer result=null;
        String str=null;
        FileInputStream is = null;
        PDDocument document = null;
        try {
            is = new FileInputStream(pdffile);
            PDFParser parser = new PDFParser(new RandomAccessBuffer(is));
            parser.parse();
            document = parser.getPDDocument();
            PDFTextStripper stripper = new PDFTextStripper();
            str=stripper.getText(document);
            //result = new StringBuffer(str);
            // System.out.println("------"+str+"--------------");
        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {

                    e.printStackTrace();
                }
            }
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return str;





    }


/*
按页读取，将读取的每一页信息，以页码为key，以内容为value值存入到map中
 */
    public static Map readFdfbyPage(String file) throws Exception {
        // 是否排序
        boolean sort = false;
        // pdf文件名
        String pdfFile = file;
        // 输入文本文件名称
        String textFile = null;
        // 编码方式
        String encoding = "UTF-8";
        // 开始提取页数
        int startPage = 1;
        // 结束提取页数
        int endPage =5;
        // 文件输入流，生成文本文件
        Writer output = null;
        // 内存中存储的PDF Document
        PDDocument document = null;
        Map mpdf=new HashMap();
        List mp=new ArrayList();
        try {
            try {
                // 首先当作一个URL来装载文件，如果得到异常再从本地文件系统//去装载文件
                URL url = new URL(pdfFile);
                //注意参数已不是以前版本中的URL.而是File。
                document = PDDocument.load(new File(pdfFile));
                // 获取PDF的文件名
                String fileName = url.getFile();
                // 以原来PDF的名称来命名新产生的txt文件
                if (fileName.length() > 4) {
                    File outputFile = new File(fileName.substring(0, fileName
                            .length() - 4)
                            + ".txt");
                    textFile = outputFile.getName();
                }
            } catch (MalformedURLException e) {
                // 如果作为URL装载得到异常则从文件系统装载
                //注意参数已不是以前版本中的URL.而是File。
                document = PDDocument.load(new File(pdfFile));
                if (pdfFile.length() > 4) {
                    textFile = pdfFile.substring(0, pdfFile.length() - 4)
                            + ".txt";
                }
            }
            // 文件输入流，写入文件倒textFile
            output = new OutputStreamWriter(new FileOutputStream(textFile),
                    encoding);
            // PDFTextStripper来提取文本
            PDFTextStripper  stripper = null;
            stripper = new PDFTextStripper();
            // 设置是否排序
            stripper.setSortByPosition(sort);
//            // 设置起始页
//            stripper.setStartPage(startPage);
//            // 设置结束页
//            stripper.setEndPage(endPage);



            for(int i=startPage;i<=document.getNumberOfPages();i++){
                stripper = new PDFTextStripper();
                stripper.setSortByPosition(sort);
                // 设置起始页
                stripper.setStartPage(i);
                // 设置结束页
                stripper.setEndPage(i);
                String textT=stripper.getText(document);
//               System.out.println("第" + i+"页");
//               System.out.println( "开始--------------------------------------------------------------------");
//               System.out.println( textT);
//                System.out.println( "--------------------------------------------------------------------结束");
                mpdf.put(i, textT);
//                System.out.println(mpdf.get(i));
            }
            // System.out.println(mpdf.size());
            // 调用PDFTextStripper的writeText提取并输出文本
//            stripper.writeText(document, output);
//            System.out.println(stripper.getEndPage());
//            System.out.println( "*****="+stripper.getText(document));
//            System.out.println("*****22=" + stripper.getTextLineMatrix());
//            System.out.println("*****33=" + stripper.getTextMatrix());
//            System.out.println("*****44=" + stripper.getArticleStart());
//            System.out.println("*****55=" + stripper.getArticleEnd());

        } finally {
            if (output != null) {
                // 关闭输出流
                output.close();
            }
            if (document != null) {
                // 关闭PDF Document
                document.close();
            }
        }
        return mpdf;
    }


    /*
按页读取，将读取的每一页信息，以页码为key，以内容为value值存入到map中,同时
 */
    public static Map readFdfbyPageandAll(String file) throws Exception {
        // 是否排序
        boolean sort = false;
        // pdf文件名
        String pdfFile = file;
        // 输入文本文件名称
        String textFile = null;
        // 编码方式
        String encoding = "UTF-8";
        StringBuffer sbf=new StringBuffer();
        // 开始提取页数
        int startPage = 1;
        // 结束提取页数
        int endPage =5;
        // 文件输入流，生成文本文件
        Writer output = null;
        // 内存中存储的PDF Document
        PDDocument document = null;
        PDFParser p=null;
        Map mpdf=new HashMap();
        try {
            try {
                // 首先当作一个URL来装载文件，如果得到异常再从本地文件系统//去装载文件
                //URL url = new URL(pdfFile);
                //注意参数已不是以前版本中的URL.而是File。
                p=new PDFParser(new RandomAccessBuffer(new FileInputStream(pdfFile)));
                p.parse();
                document = p.getPDDocument();

            } catch (Exception e) {
                System.out.println("e.tostring="+e.toString());
                // 如果作为URL装载得到异常则从文件系统装载
                //注意参数已不是以前版本中的URL.而是File。
                document = PDDocument.load(new File(pdfFile));
//                if (pdfFile.length() > 4) {
//                    textFile = pdfFile.substring(0, pdfFile.length() - 4)
//                            + ".txt";
//                }
            }
            // 文件输入流，写入文件倒textFile
//            output = new OutputStreamWriter(new FileOutputStream(textFile),
//                    encoding);
            // PDFTextStripper来提取文本
            PDFTextStripper stripper = null;
//            stripper = new PDFTextStripper();
//            // 设置是否排序
//            stripper.setSortByPosition(sort);
//            // 设置起始页
//            stripper.setStartPage(startPage);
//            // 设置结束页
//            stripper.setEndPage(endPage);


            stripper = new PDFTextStripper();
            stripper.setSortByPosition(sort);
            //System.out.println("sss="+document.getNumberOfPages());
            String textT="";
            int nullpage=0;//空页标记
            for(int i=startPage;i<=document.getNumberOfPages();i++){
            	 String str=null;
                // 设置起始页
                stripper.setStartPage(i);
                // 设置结束页
                stripper.setEndPage(i);
                textT=stripper.getText(document).trim();
                if(textT.equals("")){
                    //System.out.println("666666666666666");
                    nullpage=nullpage+1;
                    if(nullpage==2){
                        return null;
                    }
                }
               //System.out.println("第" + i + "页");
              // System.out.println( "开始--------------------------------------------------------------------");
              // System.out.println( textT);
             // System.out.println( "--------------------------------------------------------------------结束");
                str=textT;
               //mpdf.put(i,textT);
                sbf.append(textT);
               // System.out.println(mpdf.get(i));
                mpdf.put(i, str);
             }
             
            // System.out.println(mpdf.size());
            // 调用PDFTextStripper的writeText提取并输出文本
//            stripper.writeText(document, output);
//            System.out.println(stripper.getEndPage());
//            System.out.println( "*****="+stripper.getText(document));
//            System.out.println("*****22=" + stripper.getTextLineMatrix());
//            System.out.println("*****33=" + stripper.getTextMatrix());
//            System.out.println("*****44=" + stripper.getArticleStart());
//            System.out.println("*****55=" + stripper.getArticleEnd());

        } finally {
            if (document != null) {
                // 关闭PDF Document
                document.close();
            }
        }
        return mpdf;
    }
       
      public static List<String> forcode(Map hm){
		  List<String> l=new ArrayList<String>();
    	   for(int i=1;i<=hm.size();i++){                		
      		  String str=(String)hm.get(i);        		
              String code = str.substring(str.indexOf("：")+1,str.indexOf("：")+27);
              l.add(code);
      		  //System.out.println("第"+i+"次解析pdf文件后编号为:"+code);
      	   }
    	  return l;   	  
      }
      /** 
       * 截取pdfFile的第from页至第end页，组成一个新的文件名 
       * @param pdfFile 
       * @param subfileName 
       * @param from 
       * @param end 
       */  
      public static void partitionPdfFile(String pdfFile,  
              String newFile, int from, int end) {  
          Document document = null;  
          PdfCopy copy = null;          
          try {  
              PdfReader reader = new PdfReader(pdfFile);            
              int n = reader.getNumberOfPages();            
              if(end==0){  
                  end = n;  
              }  
              ArrayList<String> savepaths = new ArrayList<String>();  
              //String staticpath = pdfFile.substring(0,pdfFile.lastIndexOf("\\")+1);  
              //System.out.println("sssssss:"+staticpath);
              String savepath =newFile;  
              System.out.println("保存路径:"+savepath);
              savepaths.add(savepath);  
              document = new Document(reader.getPageSize(1));  
              copy = new PdfCopy(document, new FileOutputStream(savepaths.get(0)));  
              document.open();  
              for(int j=from;j<=end;j++) {  
                  document.newPage();   
                  PdfImportedPage page=copy.getImportedPage(reader,j);  
                  copy.addPage(page);  
              }  
              document.close();  
    
          } catch (IOException e) {  
              e.printStackTrace();  
          } catch(DocumentException e) {  
              e.printStackTrace();  
          }  
      }  
     
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        pdfreader pdfReader = new pdfreader();
        try {
            // 取得E盘下的SpringGuide.pdf的内容
         //  String str=  pdfReader.readFdfbyAll("C:/Users/Administrator/Desktop/test/上海嘉万融资租赁产品及业务流程介绍V1.12.pdf");
        	// 通过传入文件路径获取文件
    		File file = new File("C:/Users/Administrator/Desktop/2/pdf");
    		// 把获取到的文件名保存在数组中
    	    File[] files = file.listFiles();
    	     
    	    for(File f:files){
    	    	 //System.out.println(f);
    	    	//获取文件类型，即文件后缀名
    	    	int start = f.getAbsolutePath().length()-3;
    	    	int end  = f.getAbsolutePath().length();
    	    	//得到文件的后缀名
    	    	String pdf = f.getAbsolutePath().substring(start, end);
    	    	//System.out.println(pdf);
    	    	//判断是否是pdf格式的文件
    	    	if(pdf.equals("pdf") || pdf.equals("PDF")){
        	Map hm=pdfreader.readFdfbyPageandAll(f.toString());
            
        	System.out.println("---------"+hm.size());
        	for(int i=1;i<=hm.size();i++){                		
        		String str=(String)hm.get(i);        		
                String code = str.substring(str.indexOf("：")+1,str.indexOf("：")+27);
        		System.out.println("第"+i+"次解析pdf文件后编号为:"+code);
        	}
    	    	}
    	    	}
            //  pdfReader.readFdfbyPageandAll("C:/pdf/0107/JuChao/太平鸟首次公开发行A股股票上市公告书.pdf");
            //太平鸟首次公开发行A股股票上市公告书.pdf
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}

