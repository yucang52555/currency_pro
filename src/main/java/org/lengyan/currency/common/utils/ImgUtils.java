package org.lengyan.currency.common.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

/**
 * 图片操作工具类
 * @since  2016年11月2日
 * @author ktc
 */
public class ImgUtils {
	
	/**
	 * 获取图片文件大小
	 * @param
	 * @return 
	 * @变更记录 2016年11月2日 下午3:24:08  ktc
	 */
	public static double getImgFileSize(File file) {
		if (file != null) {
			return file.length()/1024.0;
		}
		return 0;
	}
	
	/**
	 * 获取图片文件大小
	 * @param
	 * @return 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 * @变更记录 2016年11月2日 下午3:24:08  ktc
	 */
	public static double getImgStreamSize(File file) throws IllegalStateException, IOException {
		double size = 0;
		if (file != null) {
			InputStream in = new FileInputStream(file);
			size = in.available()/1024.0;
			in.close();
		}
		return size;
	}
	
	/**
	 * 获取图片文件宽度
	 * @param
	 * @return 
	 * @变更记录 2016年11月2日 下午3:26:08  ktc
	 */
	public static Integer getImgWidth(File file) throws FileNotFoundException, IOException {
		BufferedImage sourceImg =ImageIO.read(new FileInputStream(file));
		return sourceImg.getWidth();
	}
	
	/**
	 * 获取图片文件长度
	 * @param
	 * @return 
	 * @变更记录 2016年11月2日 下午3:26:08  ktc
	 */
	public static Integer getImgHeight(File file) throws FileNotFoundException, IOException {
		BufferedImage sourceImg =ImageIO.read(new FileInputStream(file));
		return sourceImg.getHeight();
	}
	
	/**
	 * 判断文件是否是图片
	 * @param
	 * @return 
	 * @变更记录 2016年11月2日 下午3:35:25  ktc
	 */
	public static boolean isImageByStream(File file) {
        boolean flag = false;
        try {
        	ImageInputStream is = ImageIO.createImageInputStream(file);
        	if(null == is) {
        		return flag;
        	}
        	is.close();
        	flag = true;
        } catch (Exception e) {
        	
        }
        return flag;
    }
	
	/**
	 * 判断文件是否是图片
	 * @param
	 * @return 
	 * @变更记录 2016年11月2日 下午3:35:25  ktc
	 */
	public static boolean isImage(File file) {
        boolean flag = false;
        try {
        	String[] imgSuffix = new String[]{".jpg", ".jpeg", ".png", ".bmp"};
        	String fileName = file.getName();
        	for (String suffix : imgSuffix) {
        		if (fileName.endsWith(suffix)) {
					flag = true;
					break;
				}
			}
        } catch (Exception e) {
        	
        }
        return flag;
    }
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
    }

}
