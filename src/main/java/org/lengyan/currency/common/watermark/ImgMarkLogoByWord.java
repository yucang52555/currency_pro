package org.lengyan.currency.common.watermark;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.swing.ImageIcon;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 给图片加水印(文字)
 * @author ktc
 * 2016年10月20日 上午11:37:49
 */
public class ImgMarkLogoByWord {
	/**
     * 给图片添加水印
     * @param iconPath 水印图片路径
     * @param srcImgPath 源图片路径
     * @param targerPath 目标图片路径
     */
    public static void markImageByWord(String content, String srcImgPath, String targerPath) {
    	markImageByWord(content, srcImgPath, targerPath, (float) 0.5, null);
    }
    
    /**
     * 给图片添加文字水印
     * @param filePath 需要添加水印的图片的路径
     * @param markContent 水印的文字
     * @param markContentColor 水印文字的颜色
     * @param qualNum 图片质量
     * @return
     */
    public static void markImageByWord(String markContent, String srcImgPath, String targerPath, float qualNum, Integer degree) {  
        ImageIcon imgIcon = new ImageIcon(srcImgPath);
        Image theImg = imgIcon.getImage();
        int width = theImg.getWidth(null);
        int height = theImg.getHeight(null);
        BufferedImage buffImg = new  BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = buffImg.createGraphics();
        g.setColor(Color.white);
//      g.setBackground(Color.white);
        g.drawImage(theImg, 0, 0, null );
        if (null != degree) {
            // 设置水印旋转
            g.rotate(Math.toRadians(degree),(double) buffImg.getWidth() / 2, (double) buffImg.getHeight() / 2);
        }
        g.drawString(markContent, width/5, height/5);// 添加水印的文字和设置水印文字出现的内容   
        g.dispose();
        FileOutputStream os = null;
        try {
        	os = new  FileOutputStream(targerPath);
        	JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(os);
        	JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(buffImg);
        	param.setQuality(qualNum, true);
            encoder.encode(buffImg, param);
            os.close();
            System.out.println("图片完成添加文字水印...");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != os) os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } 
    }  
}
