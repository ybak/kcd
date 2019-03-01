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
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PRAcroForm.FieldInformation;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopyFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.util.duoying.MD5;
/**
 * @author 
 * 套打工具 所有的初始化都在这里 子类只暴露最简单的实现 现在是把合同生成在一个文件夹中，然后再把文件夹中的合同合并
 * 如不想生成文件流(临时文件)，可用ByteArrayOutputStream代替
 */
public abstract class DocumentHandlerParent{
	private static Logger log = LogManager.getLogger(DocumentHandlerParent.class.getName());
	//二级目录 File对象
	protected File file = null;
	
	//根目录 这里的是全局的 包括图片和.pdf都在这个目录的下级
	public static String root_Directory="DIMG/assess/";
	public static String download_prefix="http://a.kcway.net/assess/";
	//public static String root_Directory="C:/Users/Administrator/Desktop/word/haha1/";
	
	//拼接中间目录
	private String savepdfpath="upload/"+new SimpleDateFormat("yyyy/MM/dd/").format(new Date());
	//一级目录 大.pdf文件 上级目录
	private String stair_file;//如:DIMG/assess/upload\2019\01\14
	//模板pdf的存放目录 如WebContent下的htpdf
	private String templateDirectory;
	//运行时模板全目录
	protected String pdftemplatepath;
	//进度key
	private String sessionid;
	//身份证md5后的作为目录的唯一标识
	private String md5p;
	private static BaseFont bfChinese;//基础字体
	//数据集
	protected Map map;
	//文件初始进度
	private int progress = 0;
	
	//测试main
//	public static void main(String[] args){
//		 File file=new File(root_Directory);
//		 System.out.print(file.getPath());
//	 }
	protected abstract String fillTemplate() throws Exception;
	static{
		try {
			bfChinese= BaseFont.createFont( "STSongStd-Light" ,"UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
		} catch (DocumentException | IOException e) {
			// TODO Auto-generated catch block
			log.error("中文字体设置异常->"+e.getMessage());
		}
	}
	public DocumentHandlerParent(String templateDirectory,HttpServletRequest request,Map map) {
		this.templateDirectory=templateDirectory;
		this.sessionid=request.getSession().getId();
		this.map=map;
        //获取pdf模板目录
		this.pdftemplatepath=readPath(request,templateDirectory);
		this.stair_file=root_Directory+savepdfpath;//组合路径
		this.deleteSecondLevel();
	}
	//前置执行 删除二级目录 
	public void deleteSecondLevel(){
		//文件夹名称 身份证好-银行id
    	file = new File(new StringBuilder(stair_file).append(map.get("IDnumber")).append("—").append(map.get("bankId").toString()).toString());
    	if (file.exists()){
			DeleteFile.deleteDir(file);//删除历史的
		}
		//创建此抽象路径名指定的目录，包括所有必需但不存在的父目录
    	//当且仅当此抽象路径名表示的文件或目录存在时，返回 true；否则返回 false 
		if(file.mkdirs()){
			fileAccessAuthority(file);
		}
	} 
	//https://blog.csdn.net/u014457793/article/details/24638673
	public static void fileAccessAuthority(File file){
		try {
			//https://www.aliyun.com/jiaocheng/165962.html
			//是PHP和java混合访问一台文件共享服务器,出现的问题是当java后台创建的目录php就无法进行文件的写入。
			Runtime runtime = Runtime.getRuntime();
			Process proc = runtime.exec("chmod 777 -R" + file.getAbsolutePath());
			/*导致当前线程等待，如有必要，一直要等到由该 Process 对象表示的进程已经终止。如果已终止该子进程，此方法立即返回。如果没有终止该子进程，调用的线程将被阻塞，直到退出子进程。 =
			返回：
			进程的出口值。根据惯例，0 表示正常终止。 
			抛出： 
			InterruptedException - 如果当前线程在等待时被另一线程中断，则停止等待，抛出 InterruptedException。*/
			boolean issuccess = proc.waitFor() == 0;
			log.info("是否正常退出线程->"+issuccess);
		} catch (IOException e) {
			log.info("设置文件的读权限error->"+e+",路径:"+file.getAbsolutePath());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			log.info("退出线程error->"+e);
		} 
    	file.setExecutable(true); // true允许执行操作; false则是禁止它。 
    	file.setReadable(true); // true允许读操作; false则是禁止它。 
    	file.setWritable(true); // true允许写操作; false则是禁止它。
    	log.info("is execute allow : " + file.canExecute());
    	log.info("is read allow : " + file.canRead());
    	log.info("is write allow : " + file.canWrite());
	}
	//最后执行
	protected String endAssembly(){
		File[] arr = file.listFiles();
	    arr=sort(arr);//排序
	    //下载的文件名
	    md5p=MD5.sign(file.getName(),"UTF-8");
	    //最大pdf文件全路径 
	    StringBuilder pdfpath=new StringBuilder(stair_file).append(md5p).append(".pdf");
	   	try {
	   	  //组合结果pdf
		  merge(arr,pdfpath.toString());
		  //返回给客户端的下载路径
		  String s8=new StringBuilder(savepdfpath).append(md5p).append(".pdf").toString();
		  return s8;
	    } catch (Exception e) {
	    	DeleteFile.deleteDir(new File(pdfpath.toString()));
    		log.error("pdf容器异常->"+e);
    		throw new RuntimeException("pdf容器异常");
		}finally {
			//无论成功或者失败 删除world
	    	try {
	    		ProgressSingleton.remove(sessionid);
			} catch (NullPointerException e) {
				//键为null
			}
		}
	}
	//pdf填充 .pdf文件集 输出目录 数据集
	protected void pdfs(String[] l1){
		 for (String sss1:l1) { 
			 pdf(sss1);
		 }
	}
	protected void pdf(String sss1){
		File f=new File(pdftemplatepath+"/"+sss1);
        PdfStamper stamp = null;
		    PdfReader reader = null;
		try {
			reader = new PdfReader(new FileInputStream(f));
		} catch (IOException e){
		   log.error("出生模板加载异常->"+e);
	       throw new RuntimeException("出生模板加载异常!");
		}
		    FileOutputStream outputstream = null;
		try {
			outputstream = new FileOutputStream(new StringBuilder(getFilePath()).append("/").append(sss1).toString());
		} catch (FileNotFoundException e) { 
		   log.error("结果模板加载异常->"+e);
	       throw new RuntimeException("结果模板加载异常!");
		}
		try {
			stamp = new PdfStamper(reader,outputstream);
		} catch (Exception e) {
		  log.error("模板压膜异常!->"+e);
	          throw new RuntimeException("模板压膜异常!");
		}
		    /*try {	*/
			    AcroFields form = stamp.getAcroFields();
			    stamp.setFormFlattening(true);
			    log.info("遍历->fileName="+sss1);
			  
			     for (Iterator i = reader.getAcroForm().getFields().iterator(); i.hasNext();) {
	  		      FieldInformation field = (FieldInformation) i.next();
	  		      String fieldName = field.getName();
	  		      Object value=map.get(fieldName);
	  		      if(fieldName.indexOf("fill")==-1 && -1==fieldName.indexOf("undefined")){//对于原生合同fill_代表合同中出现的默认的文本域
	  		    	if(null !=value && !value.toString().equals("")){
		     		    	
		     		    	try {
		     		    		//如果为tt 或者名称中含有img则表示为图片 
		     		        	if(fieldName.equals("tt") || fieldName.indexOf("img")!=-1 ){
		     		        		log.info("填充照片名称:"+fieldName+",值:"+value);
		     		      	        int pageNo = form.getFieldPositions(fieldName).get(0).page;
		     		      	        Rectangle signRect = form.getFieldPositions(fieldName).get(0).position;
		     		      	        float x = signRect.getLeft();
		     		      	        float y = signRect.getBottom();
		     		      	        Image image = Image.getInstance(value.toString());
		     		      	        // 获取操作的页面
		     		      	        PdfContentByte under = stamp.getOverContent(pageNo);
		     		      	        // 根据域的大小缩放图片
		     		      	        image.scaleToFit(signRect.getWidth(),signRect.getHeight());
		     		      	        // 添加图片
		     		      	        image.setAbsolutePosition(x,y);
		     		      	        under.addImage(image);
		     		      	        continue;
		     		        	}
		     		        	log.info("填充字段名称:"+fieldName+",值:"+value);
		     		        		form.setFieldProperty(fieldName,"textfont",bfChinese,null);
									form.setField(fieldName, value.toString());
								} catch (Exception e) {
					  	            throw new RuntimeException("模板填充字段异常!字段名字为："+fieldName+",值为："+value);
								}
		     		      }
	  		    	
	  		      }
	  		    }
	 		    try {
					stamp.close();
					reader.close();
				} catch (Exception e) {
					
				}
//			} catch (Exception e) {
//				log.error("pdf填充字段异常"+e);
//				//throw new RuntimeException("pdf填充字段异常");
//			}
	}
	//进度+
	protected void addn() {
		progress += 1;
		ProgressSingleton.put(sessionid, progress);
	}
	//获得pdf大的路径
	private String getFilePath(){
		return file.getPath();
	}
	//pdf自定义拷贝
	public void copys(String[] l2){
		for(String sss0:l2){
			copy(sss0);
		}
	}
	protected void copy(String sss0){
		File copyPath=new File(pdftemplatepath+"/"+sss0);
		try {
			File newPath=new File(new StringBuilder(getFilePath()).append("/").append(sss0).toString());
			log.info("拷贝->"+copyPath.getName()+"--to--"+newPath.getName());
			CopyFile.copyFile(copyPath,newPath);
		} catch (IOException e){
		   log.error("拷贝异常->"+e.getMessage());
	       throw new RuntimeException("文件拷贝异常:"+sss0); 
		}
	}
	//pdf整合
	private static void merge(File[] filePathList,String mergeName) throws Exception{
		PdfCopyFields copyFields = null;
		File file=new File(mergeName);
		//当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。检查文件是否存在，
		//如果指定的文件不存在并成功地创建，则返回 true；如果指定的文件已经存在，则返回 false 
		if (file.createNewFile()){
			fileAccessAuthority(file);
		}
		copyFields = new PdfCopyFields(new FileOutputStream(file));
		copyFields.open();
		for (int i = 0; i < filePathList.length; i++) {
			try {
				PdfReader reader= new PdfReader(new FileInputStream(filePathList[i]));
				copyFields.addDocument(reader);//添加文件
			} catch (Exception e) {
				new RuntimeException("pdf整合异常->"+filePathList[i].getName());
			}
		}
		copyFields.close();
	}
	protected static int getLetterFirstIndex(String s){
		int index=0;
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if('A'<c&&c<'z'){//第一个英文的位置
				index=s.indexOf(c);
				break;
			}
		}
		return index;
	}
	private static String readPath(HttpServletRequest request,String s){
		/*request.getSession().getServletContext() 获取的是Servlet容器对象，相当于tomcat容器了。
		getRealPath("/") 获取实际路径，“/”指代项目根目录，所以代码返回的是项目在容器中的实际发布运行的根路径*/
		return request.getSession().getServletContext().getRealPath(s);
	}
	//选择排序算法
	private static File[] sort(File[] s){
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
}

