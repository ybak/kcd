package com.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

	/* 2017.11.24  ---》 2017.11.27更新内容
	 * 解析pdf文件中的编号
	 * */
	public class PDFUtil {
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
    //获取 pdf文件路径 
    public static ArrayList getFilePathFromPDF(String pdfFilePath){
    	ArrayList filePathList = new ArrayList();
    	String FilePath = null;
    	File file = new File(pdfFilePath);
		// 把获取到的文件名保存在数组中
	    File[] files = file.listFiles();
	    if(files != null){
	    	for(File f:files){
	    		//--------------------------1.获取文件路径
	    		FilePath = f.getAbsolutePath();
	    		//获取文件类型，即文件后缀名
		    	int start = f.getAbsolutePath().length()-3;
		    	int end  = f.getAbsolutePath().length();
		    	//得到文件的后缀名
		    	String pdf = f.getAbsolutePath().substring(start, end);
		    	//判断是否是pdf格式的文件
		    	if(pdf.equals("pdf") || pdf.equals("PDF")){
		    		filePathList.add(FilePath);
		    	}
	    	}
	    }
		return filePathList;
    }
  //获取一个pdf文件路径 
    public static String getOneFilePathFromPDF(String pdfFilePath){
    	String filePathList = null;
    	String FilePath = null;
    	File f = new File(pdfFilePath);
		//--------------------------1.获取文件路径
		FilePath = f.getAbsolutePath();
		//获取文件类型，即文件后缀名
    	int start = f.getAbsolutePath().length()-3;
    	int end  = f.getAbsolutePath().length();
    	//得到文件的后缀名
    	String pdf = f.getAbsolutePath().substring(start, end);
    	//判断是否是pdf格式的文件
    	if(pdf.equals("pdf") || pdf.equals("PDF")){
    		filePathList = FilePath;
    	}
		return filePathList;
    }
  //获取一个pdf文件中的编号的前两位
  	public static String getBeforeTwoToOneCodesFromPDF(String pdfFilePath){
  		ArrayList allCode = new ArrayList();
  		String BeforeTwocode = null;  // 用于保存编号
  		//获取到全部的信息
  		String str = getAllInfoFromPDF(pdfFilePath);
  		//输出编号
  		BeforeTwocode = str.substring(str.indexOf("编号：")+3,str.indexOf("：")+3);
  		///////////////////2017.11.27更新内容/////////////////////////////////////////
  		//获取到全部的编号
  		return BeforeTwocode;
  	}
    //获取一个pdf文件中的编号
  	public static ArrayList getOneCodesFromPDF(String pdfFilePath){
  		ArrayList allCode = new ArrayList();
  		String code = null;  // 用于保存编号
  		//获取到全部的信息
  		String str = getAllInfoFromPDF(pdfFilePath);
  		//输出编号
      	code = str.substring(str.indexOf("编号：")+3,str.indexOf("：")+27);
  		///////////////////2017.11.27更新内容/////////////////////////////////////////
  		//获取到全部的编号
  		Set set = new HashSet(); // 把编号存放在
  		Iterator<String> it = null;
  		//
  		String regex = "\\d{26}";  
  		Pattern pattern = Pattern.compile(regex);  
  		Matcher matcher = pattern.matcher(str);  
  		//输出为重复的编号
  		while (matcher.find()) { 
  			//输出为不重复的编号
  			/*set.add(matcher.group());
  			it = set.iterator();*/
  			//输出为重复的编号
  			code = matcher.group();
  			allCode.add(code);
  		}  
  		//输出为不重复的编号
  		/*while (it.hasNext()) {
  			String getCode = it.next();
  			System.out.println("编号为："+getCode);
  		}*/
  		return allCode;
  	}
    //获取 pdf文件中的编号
    public static ArrayList getCodeFromPDF(String pdfFilePath){
    	ArrayList allCode = new ArrayList();
    	ArrayList al = getFilePathFromPDF(pdfFilePath);
    	Iterator itt = al.iterator();
    	String filePath = null; // 用与保存精确路径
    	String code = null;  // 用于保存编号
		while(itt.hasNext()){
			filePath = (String) itt.next();
			//获取到全部的信息
			String str = getAllInfoFromPDF(filePath);
			//输出编号
	    	code = str.substring(str.indexOf("编号：")+3,str.indexOf("：")+27);
			///////////////////2017.11.27更新内容/////////////////////////////////////////
			//获取到全部的编号
			Set set = new HashSet(); // 把编号存放在
			Iterator<String> it = null;
			//
			String regex = "\\d{26}";  
			Pattern pattern = Pattern.compile(regex);  
			Matcher matcher = pattern.matcher(str);  
			//输出为重复的编号
			while (matcher.find()) { 
				//输出为不重复的编号
				/*set.add(matcher.group());
				it = set.iterator();*/
				//输出为重复的编号
				code = matcher.group();
				allCode.add(code);
			}  
			//输出为不重复的编号
			/*while (it.hasNext()) {
				String getCode = it.next();
				System.out.println("编号为："+getCode);
			}*/
    	}
		return allCode;
    }
  
    //获取 pdf文件中的套数
    public static ArrayList getTaoCountsFromPDF(String pdfFilePath){
    	ArrayList taoCounts = new ArrayList();
    	String counts = null;
    	//获取到全部的信息
    	ArrayList al = getFilePathFromPDF(pdfFilePath);
    	Iterator it = al.iterator();
    	while(it.hasNext()){
    		String str = getAllInfoFromPDF((String)it.next());
        	int count=0,StringStart=0;
    		while(str.indexOf("金融信用信息基础数据库个人信用信息采集授权书", StringStart)>=0 && StringStart<str.length()){
    			//当字符串出现子串时，返回子字符串索引
    			count++;
    			StringStart=str.indexOf("金融信用信息基础数据库个人信用信息采集授权书", StringStart)+"金融信用信息基础数据库个人信用信息采集授权书".length();//得到新的start值。
    		}
    		counts = String.valueOf(count);
    		taoCounts.add(counts);
    	}
		return taoCounts;
    }
    //获取 一个pdf文件中的套数
    public static String getOneTaoCountsFromPDF(String pdfFilePath){
    	String taoCounts = null;
    	//获取到全部的信息
    	String str = getAllInfoFromPDF(pdfFilePath);
    	int count=0,StringStart=0;
		while(str.indexOf("金融信用信息基础数据库个人信用信息采集授权书", StringStart)>=0 && StringStart<str.length()){
			//当字符串出现子串时，返回子字符串索引
			count++;
			StringStart=str.indexOf("金融信用信息基础数据库个人信用信息采集授权书", StringStart)+"金融信用信息基础数据库个人信用信息采集授权书".length();//得到新的start值。
		}
		taoCounts = String.valueOf(count);
		return taoCounts;
    }
    public static void main(String[] args){
    	//F:\\kuaiJinSuo_DuoYing\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\hzj\\upload
    	// 获取文件的路径
    	/*ArrayList al = getFilePathFromPDF("F:\\pdf文件解析");
    	Iterator it = al.iterator();
		while(it.hasNext()){
    		System.out.println("文件路径为："+it.next());
    	}*/
    	// 获取文件的编号
		/*ArrayList al21 = getCodeFromPDF("F:\\pdf文件解析");
    	Iterator it1 = al21.iterator();
		while(it1.hasNext()){
    		System.out.println("编号为："+it1.next());
    	}*/
    	// 获取文件套数
		/*ArrayList al1 = getTaoCountsFromPDF("F:\\pdf文件解析");
		Iterator it2 = al1.iterator();
		while(it2.hasNext()){
    		System.out.println("该pdf文件中的套数为："+it2.next());
    	}*/
    	//获取一个pdf文件中的编号
    	/*ArrayList al =  getOneCodesFromPDF("F:\\pdf文件解析\\快车道200.pdf");
    	Iterator it = al.iterator();
		while(it.hasNext()){
    		System.out.println("编号为："+it.next());
    	}*/
    	//获取 一个pdf文件中的套数
    	/*String taoCounts = getOneTaoCountsFromPDF("F:\\pdf文件解析\\快车道200.pdf");
    	System.out.println(taoCounts+"********");*/
    	String BeforeTwo = getBeforeTwoToOneCodesFromPDF("F:\\pdf文件解析\\典当200_部分1.pdf");
    	System.out.println(BeforeTwo);
    }
}
