package com.controller.htpdf;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.alibaba.fastjson.JSON;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PRAcroForm.FieldInformation;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopyFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.service1.htpdf.IcbcApplicationService;
import com.util.duoying.MD5;
/**
 * @author LiWang
 */
public class DocumentHandler2 {
	private WordDisposition wd = null;//实例化内部类
	private File file = null;//world输出外层目录
	//C:/Users/Administrator/Desktop/word/haha1/  /KCDIMG/assess/upload/
	//服务器存放生成pdf的地址
	private String stair_file="/KCDIMG/assess/";
	private String savepdfpath="upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
	private static String pdftemplatepath=null;//模板全路径
	private final static String  PTCATALOG="/htpdf";//模板pdf的存放目录
	private String sessionid;
	private int progress = 0;//文件进度
	private final static String[] DPDF={"1.pdf","55.pdf","9.pdf","10.pdf","11.pdf","18.pdf","20.pdf","21.pdf","25.1.pdf","25.pdf","26.pdf","5.pdf","2.pdf","27.pdf","28.pdf","29.pdf","30.pdf","31.pdf"};
	private final static String[] NPDF={"3.pdf","4.pdf","39.pdf","51.pdf"};
	public DocumentHandler2() {
		stair_file=stair_file+savepdfpath;//组合路径
		wd = new WordDisposition();
	}
	/**结果集
	 * @author:LiWang 
	 */
	public class WordDisposition {
		 int code = 1;// code为0失败 1为成功
		 String message = "压缩包已生成！";// 提示消息
		private String loadf;
		private Map<String, String> map = new HashMap<String, String>();
		public int getCode() {return code;}
		public void setCode(int code) {this.code = code;}
		public String getMessage() {return message;}
		public void setMessage(String message) {this.message = message;}
		public String getLoadf() {return loadf;}
		public void setLoadf(String loadf) {this.loadf = loadf;}
		public Map<String, String> getMap() {return map;}
		public void setMap(Map<String, String> map) {this.map = map;}
	}
	public static String readPath(HttpServletRequest request,String s){
		return request.getSession().getServletContext().getRealPath(s);
	}
	//这里抛弃只使用 list 和addAll()方法的形势
	@SuppressWarnings("unchecked")
	public String fillTemplatePDF1(IcbcApplicationService ias,String s,HttpServletResponse response,HttpServletRequest request){
		List<Map> l=null;//查询的结果
		Map map=null;//失败信息
		int ii=0;
		if(s!=null && !s.equals("")){
			try {
				ii=Integer.parseInt(s);
				l=(List) ias.query1(ii);
				if(l.size()<=0){
					wd.code=0;
		    		wd.message="该用户信息查询不到";
		    		return JSON.toJSONString(wd);
		    	}
				map=l.get(0);
			} catch (Exception e) {
				//不为数字
				wd.code=0;
	    		wd.message="参数格式有误!"+s;	
	    		return JSON.toJSONString(wd);
			}
		}else{
			//不为数字
			wd.code=0;
    		wd.message="请输入参数!";	
    		return JSON.toJSONString(wd);
		}
		//map
		if(map.size()<=0){
			wd.code=0;
    		wd.message="该用户信息查询不到！";
    	}else{
    		sessionid=request.getSession().getId();
    		DataConversion.dataDisposeToMap(map,wd);
    		if(wd.code==0){//数据处理错误 直接返回
    			 return  JSON.toJSON(wd).toString();
    		}
    		List<String> l1=new ArrayList<String>();
    		List<String> l2=new  ArrayList<String>();
    		int iii=1;
    		if(Integer.parseInt(map.get("loanamount").toString())<150000){
    			l1.add("43.pdf");//收入声明
    			if(!map.get("gid").toString().equals("")){
    				l1.add("14.pdf");//共借人一送达地址确认书
    				l1.add("15.pdf");//共借人一送达地址确认书
    				l1.add("7.pdf");//共借人一配偶共同还款承诺书
    				l2.add("47.pdf");//共借人一收入声明
    				l2.add("53.pdf");//共借人一住房资产证明
        			iii++;
        		}
        		if(!map.get("gid2").toString().equals("")){
        			l1.add("16.pdf");//共借人二送达地址确认书
        			l1.add("17.pdf");//共借人二送达地址确认书
        			l1.add("8.pdf");//共借人二共同还款承诺书
        			l2.add("49.pdf");//共借人二收入声明
        			l2.add("54.pdf");//共借人二住房资产证明
        			iii++;
        		}
        		if(!map.get("pIDnumber").toString().equals("")){
        			l1.add("12.pdf");//送达地址确认书
        			l1.add("13.pdf");//送达地址确认书
        			l1.add("6.pdf");//共同还款承诺书
        			l1.add("45.pdf");//收入声明
        			l2.add("52.pdf");//配偶个人资方资产证明
        			l1.remove("18.pdf");
        			iii++;
        			if(!map.get("gid").toString().equals("") && map.get("gid2").toString().equals("") ){
        				l1.add("19.pdf");//单身说明书
        			}
        		}
    		}else{
    			l2.add("44.pdf");//个人薪金收入证明
    			if(!map.get("gid").toString().equals("")){
    				l1.add("14.pdf");//共借人一送达地址确认书
    				l1.add("15.pdf");//共借人一送达地址确认书
    				l1.add("7.pdf");//共借人一配偶共同还款承诺书
    				l2.add("48.pdf");//共借人一个人薪金收入证明
    				l2.add("53.pdf");//共借人一住房资产证明
        			iii++;
        		}
        		if(!map.get("gid2").toString().equals("")){
        			l1.add("16.pdf");//共借人二送达地址确认书
        			l1.add("17.pdf");//共借人二送达地址确认书
        			l1.add("8.pdf");//共借人二共同还款承诺书
        			l2.add("50.pdf");//共借人二个人薪金收入证明
        			l2.add("54.pdf");//共借人二住房资产证明
        			iii++;
        		}
        		if(!map.get("pIDnumber").toString().equals("")){
        			l1.add("12.pdf");//送达地址确认书
        			l1.add("13.pdf");//送达地址确认书
        			l1.add("6.pdf");//共同还款承诺书
        			l2.add("46.pdf");//个人薪金收入证明
        			l2.add("52.pdf");//配偶个人资方资产证明
        			l1.remove("18.pdf");
        			iii++;
        			if(!map.get("gid").toString().equals("") && map.get("gid2").toString().equals("") ){
        				l1.add("19.pdf");//单身说明书
        			}
        		}
    		}
    		if(map.get("dztype").toString().equals("2")){//2垫资 1不垫资
    			l1.add("34.pdf");//借款借据金锤版垫资使用！！！
    			l1.add("35.pdf");//委托划款授权书垫资使用 ！！！
    			l1.add("36.pdf");//委托代购协议书垫资使用 ！！！
    		}
    		if(iii>2){
    			l2.add("40.pdf");//情况说明
    		}
    		
    		//身份证md5一下
    		String md5p=MD5.sign(map.get("IDnumber"),"UTF-8");
    		StringBuilder sbs=new StringBuilder(stair_file).append(md5p).append("1");
        	file = new File(sbs.toString());
    		if (file.exists()){
            	deleteDir(file);//存在则删除
    		}
        	file.mkdirs();//创建
            BaseFont bfChinese = null;
            try {
            	//设置中文
				bfChinese= BaseFont.createFont( "STSongStd-Light" ,"UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
			} catch (Exception e1) {
				wd.code=0;
  	            wd.setMessage("字体加载异常!");
  	            DocumentHandler2.deleteDir(file);//删除存放临时pdf目录和目录下的文件
  	            return  JSON.toJSON(wd).toString();
			};
		
			if(pdftemplatepath==null){
				pdftemplatepath=readPath(request,PTCATALOG);//pdf模板路径
			}
		
			copys(NPDF,wd,sbs);
			pdfs(DPDF,wd,sbs,map,bfChinese);
			copys(l2.toArray(new String[l2.size()]),wd,sbs);
			pdfs(l1.toArray(new String[l1.size()]),wd,sbs,map,bfChinese);
        	 if(wd.map.size()>=(l1.size()+l2.size())){//全部失败
         		wd.message="pdf没有生成！";
         		wd.code=0;
         	}else{
         	   addn();//生成完毕
     		   File[] arr = file.listFiles();
     		   arr=sort(arr);//排序
     		  StringBuilder  pdfpath=new StringBuilder(stair_file).append(md5p).append(".pdf");
     		   	try {
     			   merge(arr,pdfpath.toString(),wd.map);
     			   String s8=new StringBuilder(savepdfpath).append(md5p).append(".pdf").toString();
     			   wd.setLoadf(s8);
     			   addn();//组合完毕
     			   ias.create1(s8,ii);
     		    } catch (Exception e) {
     				wd.message="pdf容器异常!";
     	    		wd.code=0;
     	    		DocumentHandler2.deleteDir(new File(pdfpath.toString()));
     			}
         	}
    	}
    	//无论成功或者失败 删除world
    	try {
    		ProgressSingleton.remove(sessionid);
		} catch (NullPointerException e) {
			// 键为null
		}
		return JSON.toJSONString(wd); 
	  }
		//拷贝
		public static void copys(String[] l2,WordDisposition wd,StringBuilder sbs){
			File f=null;
			File newPath=null;
			for(String sss0:l2){
				f=new File(pdftemplatepath+"/"+sss0);
				try {
					newPath=new File(new StringBuilder(sbs.toString()).append("/").append(sss0).toString());
					copyFile(f,newPath);
				} catch (IOException e){
					 wd.code=0;
	  	             wd.map.put(f.getName(),"拷贝异常!");
	  	             continue;
				}
			}
		}
		//pdf填充
		public static void pdfs(String[] l1,WordDisposition wd,StringBuilder sbs,Map map,BaseFont bfChinese){
			File f=null;
			 for (String sss1:l1) { 
      		   	    f=new File(pdftemplatepath+"/"+sss1);
	                PdfStamper stamp = null;
	     		    PdfReader reader = null;
					try {
						reader = new PdfReader(new FileInputStream(f));
					} catch (IOException e){
						 wd.code=0;
		  	             wd.map.put(f.getName(),"出生模板加载异常!");
		  	             continue;
					}
	     		    FileOutputStream outputstream = null;
					try {
						outputstream = new FileOutputStream(new StringBuilder(sbs.toString()).append("/").append(sss1).toString());
					} catch (FileNotFoundException e) {
						 wd.code=0;
		  	             wd.map.put(f.getName(),"结果模板加载异常!");
		  	             continue;
					}
	     		    try {
						stamp = new PdfStamper(reader,outputstream);
					} catch (Exception e) {
						wd.code=0;
		  	            wd.map.put(f.getName(),"模板压膜异常!");
		  	            continue;
					}
	     		    AcroFields form = stamp.getAcroFields();
	     		    stamp.setFormFlattening(true);
	     		    Collection collection = map.keySet();
	     		    Object[] keyArray = collection.toArray();
	     		    boolean fff=true;
	     		       f:for (Iterator i = reader.getAcroForm().getFields().iterator(); i.hasNext();) {
	 	     		      FieldInformation field = (FieldInformation) i.next();
	 	     		      String fieldName = field.getName();
	 	     		      b:for (int j = 0; j < keyArray.length; j++) {
	 	     		        String key = (String) keyArray[j];
	 	     		        String value = map.get(key).toString();
	 	     		        if (fieldName.equals(key)) {
	 	     		        	try {
	 	     		        		if(fff&&fieldName.equals("tt")&&!value.equals("")){
		 	     		      	        int pageNo = form.getFieldPositions(fieldName).get(0).page;
		 	     		      	        Rectangle signRect = form.getFieldPositions(fieldName).get(0).position;
		 	     		      	        float x = signRect.getLeft();
		 	     		      	        float y = signRect.getBottom();
		 	     		      	        Image image = Image.getInstance(value);
		 	     		      	        // 获取操作的页面
		 	     		      	        PdfContentByte under = stamp.getOverContent(pageNo);
		 	     		      	        // 根据域的大小缩放图片
		 	     		      	        image.scaleToFit(signRect.getWidth(),signRect.getHeight());
		 	     		      	        // 添加图片
		 	     		      	        image.setAbsolutePosition(x,y);
		 	     		      	        under.addImage(image);
		 	     		      	        fff=false;
		 	     		      	        break b;
		 	     		        	}
	 	     		        		form.setFieldProperty(fieldName,"textfont",bfChinese,null);
	 								form.setField(fieldName, value);
	 								break b;
	 							} catch (Exception e) {
	 								// TODO Auto-generated catch block
	 								wd.code=0;
	 				  	            wd.map.put(f.getName(),"模板填充字段异常!字段名字为："+fieldName+",值为："+value);
	 				  	            break f;
	 							}
	 	     		        }
	 	     		      }
	 	     		    }
		     		    try {
							stamp.close();
							reader.close();
						} catch (Exception e) {
							continue;
						}
	        }
		}
		
		public static void merge(File[] filePathList,String mergeName,Map map) throws Exception{
			PdfCopyFields copyFields = null;
			copyFields = new PdfCopyFields(new FileOutputStream(mergeName));
			copyFields.open();
			for (int i = 0; i < filePathList.length; i++) {
				PdfReader reader = null;
				try {
					reader = new PdfReader(new FileInputStream(filePathList[i]));
				} catch (Exception e) {
					map.put(filePathList[i],"结果pdf文件加载异常");
				} 
				try {
					copyFields.addDocument(reader);//添加文件
				} catch (Exception e) {
					map.put(filePathList[i],"组合结果pdf文件异常");
				}
			}
			copyFields.close();
		}
		 /**选择排序算法
		 */
		public static File[] sort(File[] s){
		        //中间值
		        File temp =null;
		        //外循环:我认为最小的数,从0~长度-1
		        for(int j = 0; j<s.length-1;j++){
		            //最小值:假设第一个数就是最小的
		            String min = s[j].getName();
		            //记录最小数的下标的
		            int minIndex=j;
		            //内循环:拿我认为的最小的数和后面的数一个个进行比较
		            for(int k=j+1;k<s.length;k++){
		                //找到最小值
		                if (Integer.parseInt(min.substring(0,min.indexOf(".")))>Integer.parseInt(s[k].getName().substring(0,s[k].getName().indexOf(".")))){
		                    //修改最小
		                    min=s[k].getName();
		                    minIndex=k;
		                }
		            }
		            //当退出内层循环就找到这次的最小值
		            //交换位置
		            temp = s[j];
		            s[j]=s[minIndex];
		            s[minIndex]=temp;
		        }
		        return s;
	}
    /**拷贝
     * @param oldPath
     * @param newPath
     * @param map
     * @Description: TODO
     * @param name
     * @return 
     */
    public static void copyDir(File oldPath, File newPath,Map map){
        File[] filePath = oldPath.listFiles();
        if (!newPath.exists()) {
        	newPath.mkdir();
        }
        for (int i = 0; i < filePath.length; i++) {
        	//如果是目录
            if ((new File(oldPath+"/"+ filePath[i])).isDirectory()) {
            	copyDir(filePath[i],new File(newPath+"/"+ filePath[i]),map);
            }
            //如果是文件
            if (new File(oldPath+"/"+ filePath[i]).isFile()) {
                try {
					copyFile(filePath[i],new File(newPath+"/"+ filePath[i]));
				} catch (IOException e) {
					map.put(filePath[i], "拷贝失败");
					continue;
				}
            }
        }
    }
	public static void copyFile(File oldFile,File file) throws IOException {
        FileInputStream in = new FileInputStream(oldFile);
        FileOutputStream out = new FileOutputStream(file);;
        byte[] buffer=new byte[1024];
        while((in.read(buffer)) != -1){
            out.write(buffer);
        } 
    }

	public void addn() {
		progress += 1;
		ProgressSingleton.put(sessionid, progress);
	}
	/**
	 * 压缩
	 * @param srcDir 压缩文件夹路径 
	 * @param out    压缩文件输出流
	 * @param KeepDirStructure  是否保留原来的目录结构,true:保留目录结构; 
	 * 							false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
	 * @throws Exception 
	 */
	public static void toZip(File sourceFile, OutputStream out, boolean KeepDirStructure)
			throws Exception{
		ZipOutputStream zos = null;
		zos = new ZipOutputStream(out);
		compress(sourceFile,zos,sourceFile.getName(),KeepDirStructure);
		if(zos != null){
			try {
				zos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	private static final int  BUFFER_SIZE = 2 * 1024;
	/**
	 * 递归压缩方法
	 * @param sourceFile 源文件
	 * @param zos		 zip输出流
	 * @param name		 压缩后的名称
	 * @param KeepDirStructure  是否保留原来的目录结构,true:保留目录结构; 
	 * 							false:所有文件跑到压缩包根目录下(注意：不保留目录结构可能会出现同名文件,会压缩失败)
	 * @throws Exception
	 */
	private static void compress(File sourceFile, ZipOutputStream zos, String name,
			boolean KeepDirStructure) throws Exception{
		byte[] buf = new byte[BUFFER_SIZE];
		if(sourceFile.isFile()){
			// 向zip输出流中添加一个zip实体，构造器中name为zip实体的文件的名字
			zos.putNextEntry(new ZipEntry(name));
			// copy文件到zip输出流中
			int len;
			FileInputStream in = new FileInputStream(sourceFile);
			while ((len = in.read(buf)) != -1){
				zos.write(buf, 0, len);
			}
			// Complete the entry
			zos.closeEntry();
			in.close();
		} else {
			File[] listFiles = sourceFile.listFiles();
			if(listFiles == null || listFiles.length == 0){
				// 需要保留原来的文件结构时,需要对空文件夹进行处理
				if(KeepDirStructure){
					// 空文件夹的处理
					zos.putNextEntry(new ZipEntry(name + "/"));
					// 没有文件，不需要文件的copy
					zos.closeEntry();
				}
				
			}else {
				for (File file : listFiles) {
					// 判断是否需要保留原来的文件结构
					if (KeepDirStructure) {
						// 注意：file.getName()前面需要带上父文件夹的名字加一斜杠,
						// 不然最后压缩包中就不能保留原来的文件结构,即：所有文件都跑到压缩包根目录下了
						compress(file, zos, name + "/" + file.getName(),KeepDirStructure);
					} else {
						compress(file, zos, file.getName(),KeepDirStructure);
					}
					
				}
			}
		}
	}
	/**
	 * 打包下载 
	 * @param file
	 * @param response
	 * @return
	 */
	public static HttpServletResponse downloadZip(File file, HttpServletResponse response) {
		if (file.exists() == false) { // 不存在
			//response.getOutputStream().write("<script>alert('文件已删除，请重新打包！');</script>".getBytes("UTF-8"));
			return null;
		} else {
			try {
				// 以流的形式下载文件。
				InputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
				byte[] buffer = new byte[fis.available()];
				fis.read(buffer);
				fis.close();
				// 清空response
				response.reset();
				OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
				response.setContentType("application/octet-stream");

				// 如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
				response.setHeader("Content-Disposition",
						"attachment;filename=" + new String(file.getName().getBytes("GB2312"), "ISO8859-1"));
				toClient.write(buffer);
				toClient.flush();
				toClient.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return response;
	}
	
	/**
	 * @param dir
	 * @return
	 * @Description: TODO
	 * @param name
	 * @return 
	 */
	private static boolean deleteDir(File dir) {
		if (dir.isDirectory()) {
			String[] children = dir.list();
			for (int i = 0; i < children.length; i++) {
				boolean success = deleteDir(new File(dir, children[i]));
				if (!success) {
					return false;
				}
			}
		}
		return dir.delete();
	}
}

