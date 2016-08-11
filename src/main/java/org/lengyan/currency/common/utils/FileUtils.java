package org.lengyan.currency.common.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

/**
 * 文件操作工具类
 * @author ktc
 * 2016年8月11日 下午8:21:58
 */
public class FileUtils {
	
	/**
	 * 判断指定路径是否存在文件
	 * @param filePath
	 * @return
	 */
	public static boolean exists(String filePath) {
		if (StringUtils.isNotBlank(filePath)) {
			return new File(filePath).exists();
		}
		return false;
	}
	
	/**
	 * 创建新文件
	 * @param filePath
	 * @return
	 * @throws IOException 
	 */
	public static File createNewFile(String filePath) throws IOException {
		if (!exists(filePath)) {
			new File(filePath).createNewFile();
		}
		return new File(filePath);
	}
}
