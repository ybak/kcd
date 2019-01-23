package com.util;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FilenameUtils;

public class imgutil {
	

public static  class ImageCut {

	private static final String JPG_HEX = "ff";
	private static final String PNG_HEX = "89";
	private static final String JPG_EXT = "jpg";
	private static final String PNG_EXT = "png";
	/**
	 * 判断并获取图片类型
	 * @param filePath
	 * @return
	 */
	public static String getFileExt(String filePath) {
	    FileInputStream fis = null;
	    String extension = FilenameUtils.getExtension(filePath);
	    try {
	        fis = new FileInputStream(new File(filePath));
	        byte[] bs = new byte[1];
	        fis.read(bs);
	        String type = Integer.toHexString(bs[0]&0xFF);
	        if(JPG_HEX.equals(type))
	            extension = JPG_EXT;
	        if(PNG_HEX.equals(type))
	            extension = PNG_EXT;
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if(fis != null)
	                fis.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    return extension;
	}
    /* 
     * 图片裁剪通用接口 
     */  
  /**
   * 图片裁剪
   * @param src 原图地址
   * @param dest 新图存储地址
   * @param x
   * @param y
   * @param w
   * @param h
   * @throws IOException
   */
    public static void cutImage1(String src,String dest,int x,int y,int w,int h) throws IOException{   
    	   String ext=ImageCut.getFileExt(src);	
    	   System.out.println(ext);
    	   Iterator iterator = ImageIO.getImageReadersByFormatName(ext);   
           ImageReader reader = (ImageReader)iterator.next();   
           InputStream in=new FileInputStream(src);  
           ImageInputStream iis = ImageIO.createImageInputStream(in);   
           reader.setInput(iis, true);   
           ImageReadParam param = reader.getDefaultReadParam();   
           Rectangle rect = new Rectangle(x,y,w,h);    
           param.setSourceRegion(rect);   
           BufferedImage bi = reader.read(0,param);                        
           ImageIO.write(bi, "jpg", new File(dest));               
    }   
    /* 
     * 图片缩放 
     */  
    public static void zoomImage(String src,String dest,int w,int h) throws Exception {  
        double wr=0,hr=0;  
        File srcFile = new File(src);  
        File destFile = new File(dest);  
        BufferedImage bufImg = ImageIO.read(srcFile);  
        Image Itemp = bufImg.getScaledInstance(w, h, Image.SCALE_SMOOTH);  
        wr=w*1.0/bufImg.getWidth();  
        hr=h*1.0 / bufImg.getHeight();  
        AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);  
        Itemp = ato.filter(bufImg, null);  
        try {  
            ImageIO.write((BufferedImage) Itemp,dest.substring(dest.lastIndexOf(".")+1), destFile);  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
          
    }
	
    /**
     * 图片切割
     * @param imagePath  原图地址
     * @param x  目标切片坐标 X轴起点
     * @param y     目标切片坐标 Y轴起点
     * @param w  目标切片 宽度
     * @param h  目标切片 高度
     * @return 
     */
    public static void cutImage(String imagePath, String x ,String y ,String w,String h){
 try {
     Image img;
     ImageFilter cropFilter;
     // 读取源图像
     BufferedImage bi = ImageIO.read(new File(imagePath));
     int srcWidth = bi.getWidth();      // 源图宽度
     int srcHeight = bi.getHeight();    // 源图高度
     System.out.println(srcWidth+"----"+srcHeight);
     //若原图大小大于切片大小，则进行切割
  Image image = bi.getScaledInstance(srcWidth, srcHeight,Image.SCALE_DEFAULT);
  cropFilter = new CropImageFilter(Integer.parseInt(x), Integer.parseInt(y), Integer.parseInt(w), Integer.parseInt(h));
  img = Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(image.getSource(), cropFilter));
  BufferedImage tag = new BufferedImage(Integer.parseInt(w), Integer.parseInt(h),BufferedImage.TYPE_INT_RGB);
  Graphics g = tag.getGraphics();
  g.drawImage(img, 0, 0, null); // 绘制缩小后的图
  g.dispose();
  // 输出为文件
  ImageIO.write(tag, "jpg", new File(imagePath+".new2.jpg"));
     }catch (IOException e) {
     e.printStackTrace();
 }
    }
}
    public static BufferedImage Rotate(Image src, int angel) {  
        int src_width = src.getWidth(null);  
        int src_height = src.getHeight(null);  
        // calculate the new image size  
        Rectangle rect_des = CalcRotatedSize(new Rectangle(new Dimension(  
                src_width, src_height)), angel);  
  
        BufferedImage res = null;  
        res = new BufferedImage(rect_des.width, rect_des.height,  
                BufferedImage.TYPE_INT_RGB);  
        Graphics2D g2 = res.createGraphics();  
        // transform  
        g2.translate((rect_des.width - src_width) / 2,  
                (rect_des.height - src_height) / 2);  
        g2.rotate(Math.toRadians(angel), src_width / 2, src_height / 2);  
  
        g2.drawImage(src, null, null);  
        return res;  
    }  
    public static Rectangle CalcRotatedSize(Rectangle src, int angel) {  
        // if angel is greater than 90 degree, we need to do some conversion  
        if (angel >= 90) {  
            if(angel / 90 % 2 == 1){  
                int temp = src.height;  
                src.height = src.width;  
                src.width = temp;  
            }  
            angel = angel % 90;  
        }  
  
        double r = Math.sqrt(src.height * src.height + src.width * src.width) / 2;  
        double len = 2 * Math.sin(Math.toRadians(angel) / 2) * r;  
        double angel_alpha = (Math.PI - Math.toRadians(angel)) / 2;  
        double angel_dalta_width = Math.atan((double) src.height / src.width);  
        double angel_dalta_height = Math.atan((double) src.width / src.height);  
  
        int len_dalta_width = (int) (len * Math.cos(Math.PI - angel_alpha  
                - angel_dalta_width));  
        int len_dalta_height = (int) (len * Math.cos(Math.PI - angel_alpha  
                - angel_dalta_height));  
        int des_width = src.width + len_dalta_width * 2;  
        int des_height = src.height + len_dalta_height * 2;  
        return new java.awt.Rectangle(new Dimension(des_width, des_height));  
    }  
	/**
     * 旋转图片为指定角度
     * 
     * @param bufferedimage
     *            目标图像
     * @param degree
     *            旋转角度
     * @return
     */
    public static BufferedImage rotateImage(final BufferedImage bufferedimage,
            final int degree) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(degree), w / 2, h / 2);
        graphics2d.drawImage(bufferedimage, 0, 0, null);
        graphics2d.dispose();
        return img;
    }

    /**
     * 变更图像为指定大小
     * 
     * @param bufferedimage
     *            目标图像
     * @param w
     *            宽
     * @param h
     *            高
     * @return
     */
    public static BufferedImage resizeImage(final BufferedImage bufferedimage,
            final int w, final int h) {
        int type = bufferedimage.getColorModel().getTransparency();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = createImage(w, h, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.drawImage(bufferedimage, 0, 0, w, h, 0, 0, bufferedimage
                .getWidth(), bufferedimage.getHeight(), null);
        graphics2d.dispose();
        return img;
    }

    /**
     * 水平翻转图像
     * 
     * @param bufferedimage 目标图像
     * @return
     */
    public static BufferedImage flipImage(final BufferedImage bufferedimage) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = createImage(w, h, bufferedimage
                .getColorModel().getTransparency())).createGraphics())
                .drawImage(bufferedimage, 0, 0, w, h, w, 0, 0, h, null);
        graphics2d.dispose();
        return img;
    } 

	private static BufferedImage createImage(int w, int h, int transparency) {
		// TODO Auto-generated method stub
		return null;
	}
	

		
	public static void main(String[] args) throws IOException {
		
	//String ext=	ImageCut.getFileExt("C:/Users/Administrator/Desktop/2/1506741812_1.jfif");	
	//System.out.println(ext);
	}

//		  try {
//			BufferedImage src = ImageIO.read(new File("C:/Users/Administrator/Desktop/2/1506741812_1.jfif"));
//			 BufferedImage des=	Rotate(src,90);
//		
//		        Assert.assertNotNull(des);  
//		        Assert.assertTrue(ImageIO.write(des, "jpg", new File("C:/Users/Administrator/Desktop/2/5.jpg")));  
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
		
		//ImageCut.cutImage("C:/Users/Administrator/Desktop/2/sago.jpg",47,30, 466,317);
		
}
