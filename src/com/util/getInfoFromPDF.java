package com.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
	/* 2017.11.24
	 * 解析pdf文件中的编号
	 * */
	public class getInfoFromPDF {
		private static String result = null;  // 用来保存pdf文件中的信息
	    private static FileInputStream is = null;  // 输入流
	    private static PDDocument document = null;   
	//获取pdf文件文件中全部信息
    public static String getAllInfoFromPDF(String pdfFilePath){  
        String result = null;  
        FileInputStream is = null;  
        PDDocument document = null;  
        try {  
            is = new FileInputStream(pdfFilePath);  
            PDFParser parser = new PDFParser(new RandomAccessBuffer(is));              
            parser.parse();  
            document = parser.getPDDocument();  
            PDFTextStripper stripper = new PDFTextStripper();  
            result = stripper.getText(document);  
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
        return result;  
    }  
	public static void main(String[] args) throws IOException {
		/*  
		 * 通过递归得到某一路径下所有的目录及其PDF文件
		 */
		// 通过传入文件路径获取文件
		File file = new File("C:/Users/Administrator/Desktop/2/pdf");
		// 把获取到的文件名保存在数组中
	    File[] files = file.listFiles();
	     
	    for(File f:files){
	    	 System.out.println(f);
	    	//获取文件类型，即文件后缀名
	    	int start = f.getAbsolutePath().length()-3;
	    	int end  = f.getAbsolutePath().length();
	    	//得到文件的后缀名
	    	String pdf = f.getAbsolutePath().substring(start, end);
	    	System.out.println(pdf);
	    	//判断是否是pdf格式的文件
	    	if(pdf.equals("pdf") || pdf.equals("PDF")){
	    		// 是pdf格式的文件
	    		//得到全部pdf文件中的信息
	    		String str = getInfoFromPDF.getAllInfoFromPDF(f.getAbsolutePath());
	    		//截取pdf文件中的编号
		    	String code = str.substring(str.indexOf("：")+1,str.indexOf("：")+27);
		    	System.out.println("解析pdf文件后编号为:"+code); 
	    	}
	    }
	}
}
