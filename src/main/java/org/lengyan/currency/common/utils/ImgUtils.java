package org.lengyan.currency.common.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 图片操作工具类
 * @author ktc
 * 2016年11月2日 下午3:13:52
 */
public class ImgUtils {
	public static void main(String[] args) throws FileNotFoundException, IOException {  
        File picture = new File("C:/Users/Dell/Downloads/152114779941825751.jpg");  
        BufferedImage sourceImg =ImageIO.read(new FileInputStream(picture));   
        System.out.println(String.format("%.1f",picture.length()/1024.0));  
        System.out.println(sourceImg.getWidth());
        System.out.println(sourceImg.getHeight());
    }
}
