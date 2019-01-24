package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.model.credit;
import com.model.history;
import com.model.pdfover;
import com.model.ykdutil;
import com.service.creditService;
import com.service.historyService;
import com.service.mdxxService;
import com.service.pdfoverService;
import com.util.creditutil;
import com.util.errorutil;
import com.util.jsonutil;
import com.util.md5util;
import com.util.pathutil;
import com.util.pdfreader;

@Controller
public class pdfoverController {

	@Autowired
    private pdfoverService pfs;
	@Autowired
    private historyService hts;
	@Autowired
    private creditService cds;
	
	@Autowired
    private mdxxService mdxxservice;
	//json 工具类
    jsonutil ju=new jsonutil();
    pathutil pu=new pathutil();
    md5util md5=new md5util();
    
    
    @RequestMapping(value="/listmap.do",produces="text/html;charset=UTF-8")
    public String listmap() {
		
    	List<Map<String,String>> list=new ArrayList<Map<String,String>>();
    	
    	Map<String,String> m1=new HashMap<String,String>();
    	m1.put("name", "马超");
    	m1.put("IDcard_num", "418432199512108412");
    	list.add(m1);
    	
    	Map<String,String> m2=new HashMap<String,String>();
    	m2.put("name", "周瑜");
    	m2.put("IDcard_num", "3214031995121084121");
    	list.add(m2);
    	
    	Map<String,String> m3=new HashMap<String,String>();
    	m3.put("name", "郭嘉");
    	m3.put("IDcard_num","111403199512108412");
    	list.add(m3);
    	
    	
    	String[][] zxcx = 
    {{"马超","418432199512108412"},{"周瑜","3214031995121084121"},{"郭嘉","111403199512108412"},{"测试","411403199411112311"}};
    	
    	
    	
    	
    	
		return "forward:batchquery.do?zxcx="+zxcx;
    	
    	
    	
	}
    
    //批量查询pdf
    @RequestMapping(value="/batchquery.do",produces="application/json;charset=UTF-8")
    @ResponseBody
    public Map  batchquery(@RequestBody String jsonstring,@RequestHeader String ckey){
    	credit c=new credit();   	     	
     	List<credit> cm=new ArrayList();      
     	Map result1=new HashMap();
     	 List<Map<String,String>> mapList = new ArrayList<Map<String,String>>();
     	 List<Map<String,String>> list=new ArrayList<Map<String,String>>();
     	// System.out.println(ckey);
     	 if(!ckey.equals("")&&ckey!=null){     		      	 
     	 Map m=mdxxservice.mdxxmap(ckey);
     	 //jsonstring="["+jsonstring+"]";
     	 System.out.println(jsonstring);
     	 List<ykdutil> l=jsonutil.toList(jsonstring,ykdutil.class);
     	//System.out.println();
     	if(m!=null&&!m.equals("")&&m.size()>0){
     	//List list=new ArrayList(); 
       //    	String[] name={"马超","周瑜","郭嘉"};
      //    	String[] IDcard_num={"418432199512108412","3214031995121084121","111403199512108412"};
    	for(int j=0;j<l.size();j++){
    		
    		Map result3=new HashMap();
    		ykdutil y=l.get(j);
    		System.out.println(y.getName()+y.getIDcard_num());
    		result3.put("name",y.getName());    		
    		result3.put("IDcard_num",y.getIDcard_num());
    		list.add(result3);
    	} 

     	 
    		 cm=cds.findover(list);
    		 
    		// System.out.println(cm.size()+"-------------");
             if(cm!=null&&!cm.equals("")&&cm.size()>0){
            	 
            	for(int i=0;i<cm.size();i++){
            		Map result=new HashMap();
            		c=cm.get(i);
            		//System.out.println("第"+i+"次：====="+String.valueOf(c.getId()));            	
            		result=pfs.findpdfurl(String.valueOf(c.getId()));
            		if(result.size()>=4){            		
            			result.put("pdfuptime",result.get("pdfuptime").toString().replace(".0", ""));
            			result.put("pdftime",result.get("pdftime").toString().replace(".0", ""));
            			result.put("name",c.getName());
            			result.put("IDcard_num",c.getIDcard_num());
            		}else{
            			result.put("name",c.getName());
            			result.put("IDcard_num",c.getIDcard_num());
            			result.put("pdftime",result.get("pdftime").toString().replace(".0", ""));
            			result.put("msg","此订单未出报告");
            		}	
                		mapList.add(result);            			            	            	
            		//result2.put("result"+i, result);
            	}
            	result1.put("errcode", "00");
            	result1.put("errmsg", "查询成功");
            	result1.put("result",mapList);
            	return result1;
             }else{
            	 result1.put("errcode", "01");
             	 result1.put("errmsg", "未查到订单信息");    
             	 return result1;
             }
     	 }else{
     		 result1.put("errcode", "02");
         	 result1.put("errmsg","用户验证失败"); 
         	 return result1;
     	 }  
     	
     	 }else{
     		 result1.put("errcode", "03");
         	 result1.put("errmsg","ckey不能为null"); 
         	 return result1;
     	 } 
    	
    	    
    }  
    //提交pdf结果
    @RequestMapping(value="/uppdf.do",produces="text/html;charset=UTF-8")
    @ResponseBody
    public String uppdf(HttpServletRequest request,
    		@RequestParam("uid")String uid,
    		@RequestParam("ly")String ly,
    		@RequestParam("zt")String zt
    		){
    	pdfover pdf=new pdfover();
    	Map mpdf=new HashMap();
    	Map result=new HashMap();
    	Map  httpmap=new HashMap();
			//Map  httpresult=new HashMap();
    	UUID randomUUID = UUID.randomUUID();
    	String path;//路径
    	MultipartFile file; //接收文件名
    	String md5str;//随机数MD5加密文件
		try {						
		     //获取支持文件上传的Request对象 MultipartHttpServletRequest
			 MultipartHttpServletRequest mtpreq = (MultipartHttpServletRequest) request;
			 // MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			 //MultipartHttpServletRequest mtpreq = resolver.resolveMultipart(request);
			 //通过 mtpreq 获取文件域中的文件
			 file = mtpreq.getFile("file");
			
			 //File file=new File(filename);
		     //通过MultipartFile 对象获取文件的原文件名 
			 String fileName = file.getOriginalFilename();			 
			 //获取文件的后缀名
			  int i = fileName.lastIndexOf(".");
			  String uuidName = randomUUID.toString().replaceAll("-","");
			   md5str= md5util.getMD5(uuidName,"UTF-8")+fileName.substring(i);
			
			 //获取服务器的路径地址（被上传文件的保存地址）
			 String realPath = 
					 //"C:/Users/tutu/workspace/Xinwen/WebContent/images/";
					 request.getSession().getServletContext().getRealPath("/image/upload");
			 //将路径转化为文件夹 并 判断文件夹是否存在
			 String timepath=realPath+pathutil.getPath().toString()+creditutil.timefile().toString();
			 File dir = new File(timepath);
			 
			 if(!dir.exists()){
			 dir.mkdirs();
			 }
			 //获取一个文件的保存路径
			
			 String pathtype=pathutil.getPath();
			
		      path = timepath+pathtype+md5str;
			 
				} catch (Exception e) {			
					result.put("errorcode","05");
					result.put("errormsg","提交失败");
					result.put("result","pdf内容过长");	
					return jsonutil.toJSONString(result);
				}	
			 // 为文件这服务器中开辟一给新的空间,*没有数据
			 // File newFile = new File(path); 		
			// System.err.println("-----服务器的路径地址为：:"+realPath);
			// System.err.println("-----图片名称为：:"+fileName);
			 //System.err.println("-----图片新名称为：:"+uuidName);
			 //System.err.println("-----图片新路径为：:"+path);
	        // request.setAttribute("uuidName",uuidName);  
			 try {
				 File spath= new File(path);
				 spath.setWritable(true,false);
	    		 file.transferTo(spath);
	    		 }catch (IOException e) {
	    			    result.put("errorcode","05");
	    				result.put("errormsg","提交失败");
	    				result.put("result",errorutil.error05());	
	    				return jsonutil.toJSONString(result);
	    		 }
			 history ht=new history();
			 //mpdf= pdfreader.readFdfbyPageandAll(path);	
			 httpmap=pfs.findbyid(uid);
			 if(httpmap!=null){
				 try {
					     pdf.setPdfname(md5str);
						// pdf.setPdftest(mpdf.toString());
						 pdf.setPdfurl("http://apitest.kcway.net/image/upload/"+creditutil.timefile());
						 pdf.setUid(uid);
						//提交pdf结果
						 pfs.uppdf(pdf);//更新PDF结果
				} catch (Exception e) {
					result.put("errorcode","06");
					result.put("errormsg","提交失败");
					result.put("result",errorutil.error05());
					return jsonutil.toJSONString(result);
				}
			
			 
			 ht.setUid(uid);
			 if(!ly.equals("ly")){
				 ht.setLy(ly); 
			 }
             if(!zt.equals("")){
            	 ht.setZt(zt);
			 }			 
			 hts.hsava(ht);//添加历史记录
			 
			 credit c=new credit();			 
			 c.setId(Integer.parseInt(uid));
			 c.setSum_bit("5");
			 cds.upsubmit(c);//修改查询状态				 
			 mpdf.put("pdfurl","http://apitest.kcway.net/image/upload/"+creditutil.timefile());
			 mpdf.put("pdfname",pdf.getPdfname());
			 mpdf.put("order",pdf.getUid());
			 result.put("errorcode","01");
			 result.put("errormsg","提交成功");
			 result.put("result",mpdf);   		

			 
			 }else {
				result.put("errorcode","06");
				result.put("errormsg","提交失败");
				result.put("result",errorutil.error06());
				return jsonutil.toJSONString(result);
			 }	
    	
		 return jsonutil.toJSONString(result);
    	
    }


	 @RequestMapping(value="/findpdf.do",produces="text/html;charset=UTF-8")
     @ResponseBody
     public String findpdf(HttpServletRequest request,
    		 @RequestParam("orderNo")String orderNo,
    		 @RequestParam("ckey")String ckey
    		 ){					 		
		  Map result=new HashMap();
		 pdfover po=new pdfover();
    	 //history ht=new history();
		 Map m=new HashMap();
		 Map m1=new HashMap();
		 Map m2=new HashMap();
	 	 // m=hts.findhistory(uid);
		 int mkey=mdxxservice.mdxxsize(ckey);
		 if(mkey>0){			
    	 m1=pfs.findbyid(orderNo);
    	 m2=cds.findcreditbyid(Integer.parseInt(orderNo));
		if(m2!=null&&!m2.equals("")){
			
		
    	// System.out.println(m1);
    	 if(m1.get("pdfurl")!=null&&!m1.get("pdfurl").equals("")){
//    	 m1.get("pdftime").toString();
//    	 m1.put("pdftime", m1.get("pdftime").toString());
//    	 m1.put("pdfuptime", m1.get("pdfuptime").toString());
//    	 m2=cds.findbysfz(uid);
//    	 m1.put("ztcode",m2.get("sum_bit"));
   	     m.put("pdfurl","http://apitest.kcway.net/imgage/upload/"+creditutil.timetofile(m1.get("pdfuptime").toString()));	   
   	     m.put("pdfname", m1.get("pdfname").toString());
   	     m.put("orderNo", orderNo);
   	     m.put("pdftime", m1.get("pdftime").toString().replace(".0",""));
   	     result.put("result",m);
   	     result.put("errcode","01");
   	     result.put("errmsg","查询成功");   	   
    	 return jsonutil.toJSONString(result);   
	   }else{
		 result.put("errcode","011");
	   	 result.put("errmsg","查询失败"); 
		 result.put("result",errorutil.error011());
	     return jsonutil.toJSONString(result);  
	  }
		}else{			
			 result.put("errcode","012");
		   	 result.put("errmsg","查询失败"); 
			 result.put("result",errorutil.error012());
		     return jsonutil.toJSONString(result); 
			
		}
		 }else{			
			 result.put("errcode","02");
		   	 result.put("errmsg","查询失败"); 
			 result.put("result",errorutil.error02());
		     return jsonutil.toJSONString(result); 
			
		}
     }
    
	 @RequestMapping(value ="/httpadd.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	 @ResponseBody
	 public String httpadd(
			   String pdfurl,
	           String pdftest,
	           String pdfname,
	           String uid,
	           String pdfuptime,
	           String pdftime){
		
		 Map  m=new HashMap();
		 m.put(pdfurl, "pdfurl");
		 m.put(pdftest, "pdftest");
		 m.put(pdfname, "pdfname");
		 m.put(uid, "uid");
		 m.put(pdfuptime, "pdfuptime");
		 m.put(pdftime, "pdftime");
		 m.put("http", "接口获取数据");
		 return jsonutil.toJSONString(m);
		 
		 
		 
		 
	 }
    
	@RequestMapping(value="/addpdf.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addpdf(HttpServletRequest request			
			){				
		Map mpdf=new HashMap();
		try {						
		  //获取支持文件上传的Request对象 MultipartHttpServletRequest
			 MultipartHttpServletRequest mtpreq = (MultipartHttpServletRequest) request;
			// MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
			 //MultipartHttpServletRequest mtpreq = resolver.resolveMultipart(request);
			 //通过 mtpreq 获取文件域中的文件
			 MultipartFile file = mtpreq.getFile("file");
			
			 //File file=new File(filename);
		  //通过MultipartFile 对象获取文件的原文件名 
			 String fileName = file.getOriginalFilename();
			 
			 //获取文件的后缀名
			 //int i = fileName.lastIndexOf(".");
			//String uuidName = randomUUID.toString().replaceAll("-","")+fileName.substring(i);
			 //获取服务器的路径地址（被上传文件的保存地址）
			 String realPath = 
					 //"C:/Users/tutu/workspace/Xinwen/WebContent/images/";
					 request.getSession().getServletContext().getRealPath("/image/upload");
			 //将路径转化为文件夹 并 判断文件夹是否存在
			 File dir = new File(realPath);
			 if(!dir.exists()){
			 dir.mkdirs();
			 }
			 //获取一个文件的保存路径
			 String path = realPath+"/"+fileName;
			 // 为文件这服务器中开辟一给新的空间,*没有数据
			 // File newFile = new File(path); 		
			 System.err.println("-----服务器的路径地址为：:"+realPath);
			 System.err.println("-----图片名称为：:"+fileName);
			 //System.err.println("-----图片新名称为：:"+uuidName);
			 System.err.println("-----图片新路径为：:"+path);
	        // request.setAttribute("uuidName",uuidName);  
			 try {
	    		 file.transferTo(new File(path));
	    		 } catch (IllegalStateException e) {
	    		 // TODO Auto-generated catch block
	    		 e.printStackTrace();
	    		 } catch (IOException e) {
	    		 // TODO Auto-generated catch block
	    		 e.printStackTrace();
	    		 }
             List<pdfover> plist =new ArrayList<pdfover>();
             pdfover po1 =new pdfover();
             pdfover po2 =new pdfover();
			 mpdf= pdfreader.readFdfbyPageandAll(path);	        
			 plist=pfs.findbyname(fileName);
			 
			 if(plist.size()==0){	
				 System.out.println("0");
				 po1.setPdftest(mpdf.toString());
		         po1.setPdfurl(path);
		         po1.setPdfname(fileName);
		         po1.setUid("1111111111111111111111");
				 pfs.addpdf(po1);	
			 }else{
				 System.out.println("1");
				 po2.setPdftest(mpdf.toString());
		         po2.setPdfurl(path);
		         po2.setPdfname(fileName);
		         po2.setUid("11111111111");
				 pfs.uppdf(po2);;				 				 
			 }
			 
			 
			         		    						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		return mpdf.toString();
								
	}
	
	//pdf 查询
	@RequestMapping(value="/pdfend.do",method=RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String pdfend(HttpServletRequest request,String uid){
		Map pdfmap=new HashMap();
		pdfmap=pfs.pdflist(uid);	
		return jsonutil.toJSONString(pdfmap);						
	}
	
}
