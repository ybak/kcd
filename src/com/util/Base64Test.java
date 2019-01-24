package com.util; 

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;  
import java.io.InputStream;  
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

import javax.imageio.ImageIO;

import Decoder.BASE64Decoder;
import Decoder.BASE64Encoder;
public class Base64Test   
{  
	//由于读取需要一定时间，所以不能单纯往字节数组里读，所以需要判断是否读完
    public static byte[] readInputStream(InputStream inStream) throws Exception{  
    	//存放读取的所有的字节数组
        ByteArrayOutputStream outStream = new ByteArrayOutputStream(); 
        byte[] buffer = new byte[1024]; 
        int len = 0; 
        while( (len=inStream.read(buffer)) != -1 ){ 
            outStream.write(buffer, 0, len); 
        } 
        inStream.close(); 
        return outStream.toByteArray(); 
    }  
	

	/**
	 * @Description: 根据图片地址转换为base64编码字符串
	 * @Author: 
	 * @CreateTime: 
	 * @return
	 */
	public static String getImageStr(String imgFile) {
	    InputStream inputStream = null;
	    byte[] data = null;
	    try {
	        inputStream = new FileInputStream(imgFile);
	        data = new byte[inputStream.available()];
	        inputStream.read(data);
	        inputStream.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    // 加密
	    BASE64Encoder encoder = new BASE64Encoder();
	    return encoder.encode(data);
	}

    //图片转化成base64字符串  
    public static String GetImageStr(String imgFile)  
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
       // String imgFile = "C:/Users/Administrator/Desktop/1/275-3-1280x800.jpg";//待处理的图片  
        InputStream in = null;  
        byte[] data = null;  
        //读取图片字节数组  
        try   
        {  
            in = new FileInputStream(imgFile);          
            data = new byte[in.available()];  
            in.read(data);  
            in.close();  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
        //对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
       
        return encoder.encode(data);//返回Base64编码过的字节数组字符串  
    }  
      
    //base64字符串转化成图片  
    public static String GenerateImage(String imgStr,String path)  
    
    
    {    	
    	//对字节数组字符串进行Base64解码并生成图片  
        if (imgStr == null){ //图像数据为空  
            return null;
        }
        BASE64Decoder decoder = new BASE64Decoder();  
        try   
        {  
            //Base64解码  
            byte[] b = decoder.decodeBuffer(imgStr);  
            for(int i=0;i<b.length;++i)  
            {  
                if(b[i]<0)  
                {//调整异常数据  
                    b[i]+=256;  
                }  
            }  
            //生成jpeg图片  
            pathutil putil=new pathutil();
            
            UUID randomUUID = UUID.randomUUID();
            String uuidName = randomUUID.toString().replaceAll("-","")+".jpg";
            String imgFilePath =uuidName;//新生成的图片 
            String imgpath=path+pathutil.getPath().toString()+"img"+pathutil.getPath().toString()+creditutil.timefile().toString();
            File file=new File(imgpath);
            if(!file.exists()){
            	file.mkdirs();
   			 }
            OutputStream out = new FileOutputStream(imgpath+pathutil.getPath()+imgFilePath);        
            out.write(b);
            System.out.println(b);
            out.flush();  
            out.close();           
            return imgFilePath;  
        }   
        catch (Exception e)   
        {  
            return e.toString();  
        }  
    }  
    /** 
     * 将网络图片进行Base64位编码 
     *  
     * @param imgUrl 
     *            图片的url路径，如http://.....xx.jpg 
     * @return 
     */  
    public static String encodeImgageToBase64(URL imageUrl) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        ByteArrayOutputStream outputStream = null;  
        try {  
            BufferedImage bufferedImage = ImageIO.read(imageUrl);  
            outputStream = new ByteArrayOutputStream();  
            ImageIO.write(bufferedImage, "jpg", outputStream);  
        } catch (MalformedURLException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        // 对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串  
    }
    /** 
     * 将本地图片进行Base64位编码 
     *  
     * @param imgUrl 
     *            图片的url路径，如http://.....xx.jpg 
     * @return 
     */  
    public static String encodeImgageToBase64(File imageFile) {// 将图片文件转化为字节数组字符串，并对其进行Base64编码处理  
        ByteArrayOutputStream outputStream = null;  
        try {  
            BufferedImage bufferedImage = ImageIO.read(imageFile);  
            outputStream = new ByteArrayOutputStream();  
            ImageIO.write(bufferedImage, "jpg", outputStream);  
        } catch (MalformedURLException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        // 对字节数组Base64编码  
        BASE64Encoder encoder = new BASE64Encoder();  
        return encoder.encode(outputStream.toByteArray());// 返回Base64编码过的字节数组字符串  
    }  
  /**
   * 
   * 
   * 
   */
    
    public static void contentToTxt(String filePath, String content) {  
        String str = new String(); //原有txt内容  
        String s1 = new String();//内容更新  
        try {  
            File f = new File(filePath);  
            if (f.exists()) {  
                System.out.print("文件存在");  
            } else {  
                System.out.print("文件不存在");  
                f.createNewFile();// 不存在则创建  
            }  
            BufferedReader input = new BufferedReader(new FileReader(f));  
  
            while ((str = input.readLine()) != null) {  
                s1 += str + "\n";  
            }  
            System.out.println(s1);  
            input.close();  
            s1 += content;  
  
            BufferedWriter output = new BufferedWriter(new FileWriter(f));  
            output.write(s1);  
            output.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
  
        }  
    }  
    /** 
     * 将Base64位编码的图片进行解码，并保存到指定目录 
     *  
     * @param base64 
     *            base64编码的图片信息 
     * @return 
     */  
    public static void decodeBase64ToImage(String base64, String path,  
            String imgName) {  
        BASE64Decoder decoder = new BASE64Decoder();  
        try {  
        	byte[] decoderBytes =decoder.decodeBuffer(base64);
        	FileOutputStream write = new FileOutputStream(new File(path+"/"+imgName));
    		//缓冲文件输入流
    		//BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
    		//缓冲文件输出流
    		//BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(write);    	
            //System.out.println(decoderBytes[1]);
            write.write(decoderBytes,0,decoderBytes.length);
            write.flush();
            //System.out.println(decoderBytes);
            write.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    
    


    public static void main(String[] args)  
    {  
        String strImg = getImageStr("C:/Users/Administrator/Desktop/1/1.jpg"); 

      // System.out.println(strImg);  
//       String[]  s = [strImg];
//       readInputStream(strImg);
       //contentToTxt("C:/Users/Administrator/Desktop/1/base2.txt",strImg);
        
//        GenerateImage(strImg,"C:/Users/Administrator/Desktop/2");
//    	MultipartFile file;
//		file = (MultipartFile) new File("C:/Users/Administrator/Desktop/1/1.jpg");
		//String strImg = encodeImgageToBase64(file);
		 //System.out.println(strImg);  
//		 GenerateImage(strImg,"C:/Users/Administrator/Desktop/2");				 		 
	//decodeBase64ToImage(strImg,"F:/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/kcd/image/upload/img/"+creditutil.timefile(),"3.jpg");
      
    }  


} 
