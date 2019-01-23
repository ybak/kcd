package com.controller.htpdf;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.service1.htpdf.IcbcApplicationService;
import com.util.md5util;

import freemarker.template.Configuration;
import freemarker.template.Template;
public class TestWord {
	
	private IcbcApplicationService  ias;
	
	private String i;
	//服务器根路径
	private static final String fg="/KCDIMG/assess/";
	//拼接目录  实例变量 线程安全
	private  StringBuilder sb=new StringBuilder("upload/").append(new SimpleDateFormat("yyyy/MM/dd/").format(new Date()));//目录;
	Map ms;//接口返回信息
	private Configuration configuration;
	public TestWord( IcbcApplicationService  ias,String i){
		this.ias=ias;
		this.i=i;
		configuration= new Configuration();
		ms=new HashMap();
	}
	 public  Map createDoc(){
		 ms.put("message","成功,请继续下载!");
		 ms.put("code", "0");
		 if(i.equals("") || i==null){
			 ms.put("message", "用户唯一标识错误!");
			 return ms;
		 }
		 Map map=null;
		 try{
			 map=(Map)ias.query2(md5util.MD5(i+"ex")).get(0);
		 } catch (Exception e) {
			 ms.put("message", "用户信息不存在!");
			 return ms;
		 }
		 try{
			 updateDateMap(map);
		} catch (Exception e) {
			// TODO: handle exception
			ms.put("message", "数据处理异常!");
			return ms;
		} 
		 //设置模本装置方法和路径,FreeMarker支持多种模板装载方法。可以重servlet，classpath，数据库教程装载，
		 //configuration.setDirectoryForTemplateLoading("d:/");
           Template t=null; 
           try { 	 
        	   int i=Integer.parseInt(map.get("loanamount").toString());//贷款金额
        	   String s="9.ftl";
        	   configuration.setClassForTemplateLoading(this.getClass(),"ex"); 
               if(i>=100000 && i<500000){//10万以上
        		   s="11.ftl";
        	   }else if(i>=500000){//大额
        		   s="51.ftl";
        	   }
               System.err.println(s);
               configuration.setDefaultEncoding("GBK");  
               t = configuration.getTemplate(s);
               System.err.println(t);
              } catch (IOException e) { 
        	   ms.put("message", "出生模版加载异常!");
   			   return ms;
           } 
           //输出文档路径及名称 
           Writer out = null; 
          StringBuilder  s=null;
	       try {
	    	   //构建目录创建目录
	    	   File f=new File(new StringBuilder(fg).append(sb).toString());
	    	   if (!f.exists()){
	    		   f.mkdirs();
	    		}
	    	    s=new StringBuilder(md5util.MD5(i).toString()).append(".xlsx");
	    	   //输出文件
	   			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new StringBuilder(f.toString()).append("/").append(s).toString()), "utf-8"));
	   	   } catch (Exception e) {
	   		   ms.put("message", "结果模版加载异常!");
	   		   return ms;
	   	   }
	       try { 
	           t.process(map,out);//处理
	       }catch (Exception e) {
	    	   ms.put("message", "数据填充异常!");
	   		   return ms;
		   }
	       ias.create2(new StringBuilder(sb).append(s).toString(),i);
	       ms.put("code", "1");
	       ms.put("loadf",new StringBuilder(sb).append(s).toString());
	      return ms;
	    }
	
	 //数据处理
	 public static void updateDateMap(Map map){
		 if(map.get("carstype").toString().equals("1")){//新车
				map.put("A","þ");
				map.put("B", "¨");
			}else{//二手车
				map.put("A","¨");
				map.put("B", "þ");
			};
			map.put("totalamount",DataConversion.subZeroAndDot(map.get("totalamount").toString()));
			map.put("servicefee",DataConversion.subZeroAndDot(map.get("servicefee").toString()));
			map.put("servicefee",DataConversion.subZeroAndDot(map.get("servicefee").toString()));
			map.put("loanamount",DataConversion.subZeroAndDot(map.get("loanamount").toString()));
			map.put("fpr",DataConversion.subZeroAndDot(map.get("fpr").toString()));
			map.put("pgj",DataConversion.subZeroAndDot(map.get("pgj").toString()));
			map.put("pgj1",DataConversion.subZeroAndDot(DoubleUtil.div2Scale(map.get("pgj").toString(),"10000")));
			map.put("loanamount",DataConversion.subZeroAndDot(map.get("loanamount").toString()));
			map.put("C",DataConversion.subZeroAndDot(DoubleUtil.mul(DoubleUtil.div(map.get("fpr").toString(),map.get("kpj").toString(),4),"100"))+"%");
			map.put("D",DataConversion.subZeroAndDot(DoubleUtil.mul(DoubleUtil.div(map.get("totalamount").toString(),map.get("kpj").toString(),4),"100"))+"%");// 分期本金/车辆价格比例
			map.put("date", "36");
	 }
}
