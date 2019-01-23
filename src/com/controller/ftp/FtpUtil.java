package com.controller.ftp;


import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.omg.CORBA.portable.ApplicationException;

import com.model.icbc.icbc_kk;
import com.model1.icbc.icbc_dk;
import com.model1.icbc.icbc_mq;
import com.util.jsonutil;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.SocketException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;



public class FtpUtil {

    /**
     * 获取FTPClient对象
     *
     * @param ftpHost     FTP主机服务器
     * @param ftpPassword FTP 登录密码
     * @param ftpUserName FTP登录用户名
     * @param ftpPort     FTP端口 默认为21
     * @return
     */
    public static FTPClient getFTPClient(String ftpHost, String ftpUserName,
                                         String ftpPassword, int ftpPort) {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient = new FTPClient();
            ftpClient.connect(ftpHost, ftpPort);// 连接FTP服务器
            ftpClient.login(ftpUserName, ftpPassword);// 登陆FTP服务器
            if (!FTPReply.isPositiveCompletion(ftpClient.getReplyCode())) {
                System.out.println("未连接到FTP，用户名或密码错误。");
                ftpClient.disconnect();
            } else {
                System.out.println("FTP连接成功。");
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.out.println("FTP的IP地址可能错误，请正确配置。");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("FTP的端口错误,请正确配置。");
        }
        return ftpClient;
    }

    /*
     * 从FTP服务器下载文件
     *
     * @param ftpHost FTP IP地址
     * @param ftpUserName FTP 用户名
     * @param ftpPassword FTP用户名密码
     * @param ftpPort FTP端口
     * @param ftpPath FTP服务器中文件所在路径 格式： ftptest/aa
     * @param localPath 下载到本地的位置 格式：H:/download
     * @param fileName 文件名称
     */
    public static void downloadFtpFile(String ftpHost, String ftpUserName,
                                       String ftpPassword, int ftpPort, String ftpPath, String localPath,
                                       String fileName) {

        FTPClient ftpClient = null;

        try {
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);

            File localFile = new File(localPath + File.separatorChar + fileName);
            OutputStream os = new FileOutputStream(localFile);
            ftpClient.retrieveFile(fileName, os);
            os.close();
            ftpClient.logout();

        } catch (FileNotFoundException e) {
            System.out.println("没有找到" + ftpPath + "文件");
            e.printStackTrace();
        } catch (SocketException e) {
            System.out.println("连接FTP失败.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取错误。");
            e.printStackTrace();
        }

    }

    /**
     * Description: 向FTP服务器上传文件
     * @param ftpHost FTP服务器hostname
     * @param ftpUserName 账号
     * @param ftpPassword 密码
     * @param ftpPort 端口
     * @param ftpPath  FTP服务器中文件所在路径 格式： ftptest/aa
     * @param fileName ftp文件名称
     * @param input 文件流
     * @return 成功返回true，否则返回false
     */
    /** 本地字符编码 */
    private static String LOCAL_CHARSET = "GBK";
     
    // FTP协议里面，规定文件名编码为iso-8859-1
    private static String SERVER_CHARSET = "ISO-8859-1";
    
    public static boolean uploadFile(String ftpHost, String ftpUserName,
                                     String ftpPassword, int ftpPort, String ftpPath,
                                     String fileName,InputStream input) {
        boolean success = false;
        FTPClient ftpClient = null;
        try {
            int reply;
            ftpClient = getFTPClient(ftpHost, ftpUserName, ftpPassword, ftpPort);
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                return success;
            }
            ftpClient.setControlEncoding("UTF-8"); // 中文支持
            ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftpClient.enterLocalPassiveMode();
            ftpClient.changeWorkingDirectory(ftpPath);
            ftpClient.storeFile(fileName,input);
            input.close();
            ftpClient.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }
    public static List<String> zipToFile(String sourceFile,String toFolder) throws Exception {  
        String toDisk = toFolder;//接收解压后的存放路径  
        ZipFile zfile = new ZipFile(sourceFile);//连接待解压文件  
        System.out.println("要解压的文件是:" + zfile.getName());  
        Enumeration zList = zfile.entries();//得到zip包里的所有元素  
        ZipEntry ze = null;  
        byte[] buf = new byte[1024];  
        List<String> list=new ArrayList<String>();
        while (zList.hasMoreElements()) {  
            ze = (ZipEntry) zList.nextElement();  
            if(ze.isDirectory()){  
             //   System.out.println("打开zip文件里的文件夹:" + ze.getName());  
                continue;  
            }  
            //System.out.println("zip包里的文件: " + ze.getName() + "\t" + "大小为:" 
           //         + ze.getSize() + "KB");  
            //以ZipEntry为参数得到一个InputStream，并写到OutputStream中  
            OutputStream outputStream = new BufferedOutputStream(  
                    new FileOutputStream(getRealFileName(toDisk, ze.getName())));  
            InputStream inputStream = new BufferedInputStream(zfile  
                    .getInputStream(ze));  
            int readLen = 0;  
            while ((readLen = inputStream.read(buf, 0, 1024)) != -1) {  
                outputStream.write(buf, 0, readLen);  
            }  
            inputStream.close();  
            outputStream.close();  
           // System.out.println("已经解压出:" + ze.getName());
            list.add(ze.getName());
        }  
        zfile.close();
		return list;  
    }  
    private static File getRealFileName(String zippath, String absFileName){  
    	 
        String[] dirs = absFileName.split("/", absFileName.length());  
        File ret = new File(zippath);// 创建文件对象  
        if (dirs.length > 1) {  
            for (int i = 0; i < dirs.length - 1; i++) {  
                ret = new File(ret, dirs[i]);  
            }  
        }  
        if (!ret.exists()) {// 检测文件是否存在  
            ret.mkdirs();// 创建此抽象路径名指定的目录  
        }  
        ret = new File(ret, dirs[dirs.length - 1]);// 根据 ret 抽象路径名和 child 路径名字符串创建一个新 File 实例  
        return ret;  
    } 
//    /**
//    * 把 VO 中所有属性为 null 的转为 ""
//    *
//    * @throws ApplicationException
//     * @throws IllegalAccessException 
//     * @throws IllegalArgumentException 
//    */
//    public static Object nullConverNullString(Object obj) throws ApplicationException, IllegalArgumentException, IllegalAccessException {
//    if (obj != null) {
//    Class classz = obj.getClass();
//    // 获取所有该对象的属性值
//    Field fields[] = classz.getDeclaredFields();
//    // 遍历属性值，取得所有属性为 null 值的
//    for (Field field : fields) {
//    field.setAccessible(true);  
//    try {
//    if (field.get(obj) == null) {
//    	Type t = field.getGenericType(); 
//     if(!t.toString().equals("class java.math.BigDecimal")){
//    	 Method mtd = classz.getMethod("set"
// 			    + change(field.getName()),
// 			    new Class[] { String.class });// 取得所需类的方法对象
// 			    mtd.invoke(obj, new Object[] {""});// 执行相应赋值方法
// 
//     }
//    }
//
//    } catch (Exception e) {
//    e.printStackTrace();    
//    }
//    }
//    }
//	return obj;
//    }
//
//    /**
//    * @param src
//    *            源字符串
//    * @return 字符串，将src的第一个字母转换为大写，src为空时返回null
//    */
//    public static String change(String src) {
//    if (src != null) {
//    StringBuffer sb = new StringBuffer(src);
//    sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
//    return sb.toString();
//    } else {
//    return null;
//    }
//    } 
    public static void main(String[] args) {
    //  21，FTP端口
    //  80，HTTP端口，
    //  443，HTTPS端口
    //  3306，MYSQL
    	
    	//javaftp  /   11189a82bf73182d
        String ftpHost = "125.77.23.30";
        String ftpUserName = "javaftp";
        String ftpPassword = "11189a82bf73182d";
        int ftpPort = 21;
        String ftpPath = "/KCDIMG/assess/upload/";
        String localPath = "C:/Users/Administrator/Desktop/contract(3)/contract/";
        String fileName = "kcdICBCAPI00000413.zip";
        //上传文件
        
        //获取系统默认编码    
        System.out.println(System.getProperty("file.encoding"));     
        //设置编码  
        System.getProperties().put("file.encoding", "UTF-8");  
        //获取系统默认编码    
        System.out.println(System.getProperty("file.encoding"));   
        
        String path=System.getProperty("user.dir")+"/WebContent/htpdf";
        File[] files=new File(localPath).listFiles();
        System.out.println(files.length);
        for(int i=0;i<files.length;i++){
        	System.out.println(files[i].getName());
        	String  fileName1=files[i].getName() ;
        	try{
                FileInputStream in=new FileInputStream(new File(localPath+files[i].getName()));
                boolean test = FtpUtil.uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath,fileName1,in);
                System.out.println(test);            
            } catch (FileNotFoundException e){
                e.printStackTrace();
                System.out.println(e);
            } 
        }
        
       
        //解压文件
//        try {
//        	icbc_kk icbc_kk=new icbc_kk();
//        	icbc_dk icbc_dk=new icbc_dk();
//        	icbc_mq icbc_mq=new icbc_mq();
//			List<String> list=zipToFile(localPath,"C:/Users/Administrator/Desktop");
//			System.out.println(list.size());
//			String kkimg7s="";
//			String dkimg1="";
//			String dkimg2="";
//			String dkimg3="";
//			String dkimg4="";
//			String dkimg5="";
//			String dkimg6="";
//			String dkimg7="";
//			String dkimg8="";
//			for(int i=0;i<list.size();i++){
//				String name=list.get(i);
//				String filename=name.substring(name.indexOf("/")+1, name.indexOf("."));
//				String filetype=filename.substring(0, 2);
//				String fileno=filename.substring(2, 3);
//				if(filetype.equals("kk")){
//				if(Integer.parseInt(fileno)==1){
//				    icbc_kk.setImgstep3_1("upload/"+name);	
//				}else if(Integer.parseInt(fileno)==2){
//					icbc_kk.setImgstep3_2("upload/"+name);	
//				}else if(Integer.parseInt(fileno)==3){
//					icbc_kk.setImgstep3_3("upload/"+name);	
//				}else if(Integer.parseInt(fileno)==4){
//					icbc_kk.setImgstep3_4("upload/"+name);	
//				}else if(Integer.parseInt(fileno)==5){
//					icbc_kk.setImgstep3_5("upload/"+name);	
//				}else if(Integer.parseInt(fileno)==6){
//					icbc_kk.setImgstep3_6("upload/"+name);	
//				}else if(Integer.parseInt(fileno)==7){
//					icbc_kk.setImgstep3_7("upload/"+name);	
//				}else if(Integer.parseInt(fileno)==8){
//					kkimg7s=kkimg7s+""+"upload/"+name;
//				}
//				}
//				if(filetype.equals("dk")){
//					if(Integer.parseInt(fileno)==1){
//						dkimg1=dkimg1+""+"upload/"+name;
//					}else if(Integer.parseInt(fileno)==2){
//						dkimg2=dkimg2+""+"upload/"+name;	
//					}else if(Integer.parseInt(fileno)==3){
//						dkimg3=dkimg3+""+"upload/"+name;	
//					}else if(Integer.parseInt(fileno)==4){
//						dkimg4=dkimg4+""+"upload/"+name;	
//					}else if(Integer.parseInt(fileno)==5){
//						dkimg5=dkimg5+""+"upload/"+name;	
//					}else if(Integer.parseInt(fileno)==6){
//						dkimg6=dkimg6+""+"upload/"+name;	
//					}else if(Integer.parseInt(fileno)==7){
//						dkimg7=dkimg7+""+"upload/"+name;	
//					}else if(Integer.parseInt(fileno)==8){
//						dkimg8=dkimg8+""+"upload/"+name;
//					}	
//				}
//				if(filetype.equals("mq")){
//					if(Integer.parseInt(fileno)==1){
//						icbc_mq.setImgstep8_1v("upload/"+name);
//					}else if(Integer.parseInt(fileno)==2){
//						icbc_mq.setImgstep8_2v("upload/"+name);	
//					}else if(Integer.parseInt(fileno)==3){
//						icbc_mq.setImgstep8_3v("upload/"+name);	
//					}else if(Integer.parseInt(fileno)==4){
//						icbc_mq.setImgstep8_4v("upload/"+name);	
//					}
//				}
//			}
//			icbc_kk.setImgstep3_7s(kkimg7s);
//			icbc_dk.setImgstep4_1ss(dkimg1);
//			icbc_dk.setImgstep4_2ss(dkimg2);
//			icbc_dk.setImgstep4_3ss(dkimg3);
//			icbc_dk.setImgstep4_4ss(dkimg4);
//			icbc_dk.setImgstep4_5ss(dkimg5);
//			icbc_dk.setImgstep5_1ss(dkimg6);
//			icbc_dk.setImgstep6_1ss(dkimg7);
//			icbc_dk.setImgstep7_1ss(dkimg8);
//            System.out.println("開卡");
//			System.out.println(jsonutil.toJSONString(icbc_kk));
//			System.out.println("貸款");
//			System.out.println(jsonutil.toJSONString(icbc_dk));
//			System.out.println("面簽");
//			System.out.println(jsonutil.toJSONString(icbc_mq));
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        //上传一个文件
//        for(int i=0;i<100;i++){
//        	 try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//        	 System.out.println("lz"+System.currentTimeMillis());
//        }
       


        //在FTP服务器上生成一个文件，并将一个字符串写入到该文件中
//        try {
//            InputStream input = new ByteArrayInputStream("test ftp jyf".getBytes("GBK"));
//            boolean flag = FtpUtil.uploadFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, fileName,input);;
//            System.out.println(flag);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

        //下载一个文件
       // FtpUtil.downloadFtpFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, localPath, fileName);
    }
}