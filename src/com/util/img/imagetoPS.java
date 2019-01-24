package com.util.img;

import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class imagetoPS {

	//Í¼Ïñ¶Û»¯Ëã·¨£º
    public final static BufferedImage getDlurPicture(BufferedImage originalPic) {  
        int imageWidth = originalPic.getWidth();  
        int imageHeight = originalPic.getHeight();  
        BufferedImage newPic = new BufferedImage(imageWidth, imageHeight,  
                BufferedImage.TYPE_3BYTE_BGR);  
  
        float[] data = { 0.0625f, 0.125f, 0.0625f, 0.125f, 0.125f, 0.125f,  
                0.0625f, 0.125f, 0.0625f };  
  
        Kernel kernel = new Kernel(3, 3, data);  
        ConvolveOp co = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);  
        co.filter(originalPic, newPic);  
        return newPic;  
    } 
    //Í¼ÏñÈñ»¯Ëã·¨£º
    public final static BufferedImage getSharperPicture(BufferedImage originalPic){  
        int imageWidth = originalPic.getWidth();  
        int imageHeight = originalPic.getHeight();  
  
        BufferedImage newPic = new BufferedImage(imageWidth, imageHeight,  
                BufferedImage.TYPE_3BYTE_BGR);  
        float[] data = { 
        		-0.05f, 
        		-0.05f, 
        		-0.05f, 
        		-0.05f, 
        		1.2f, 
        		0.0f, 
        		0.1f,
        		-0.05f,
        		-0.05f }; 
  
        Kernel kernel = new Kernel(3, 3, data);  
        ConvolveOp co = new ConvolveOp(kernel, ConvolveOp.EDGE_ZERO_FILL, null);  
        co.filter(originalPic, newPic);  
        return newPic;  
    }  
    public static void saveImage(BufferedImage image, String format,  
    		String filePath) {  
    		try {  
    		ImageIO.write(image, format, new File(filePath));  
    		} catch (Exception e) {  
    		throw new RuntimeException(e);  
    		}  
    		} 
    public static void main(String[] args) {
    	try {
			BufferedImage originalPic=ImageIO.read(new File("C:/Users/Administrator/Desktop/be6966c85cf86a6ccd1e4cc0c8f13e11.jpg"));
			BufferedImage sImage=getDlurPicture(originalPic);
			BufferedImage sImage2=getSharperPicture(originalPic);
			saveImage(sImage,"jpg","C:/Users/Administrator/Desktop/2.jpg");
			saveImage(sImage,"jpg","C:/Users/Administrator/Desktop/3.jpg");
    	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
	}
}
