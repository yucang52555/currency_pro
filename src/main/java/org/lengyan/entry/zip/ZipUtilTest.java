package org.lengyan.entry.zip;

import java.io.IOException;

import org.lengyan.currency.common.utils.ZipUtil;

public class ZipUtilTest {
	
	/** 源文件夹路径 */
	private static String folderSrcPath = "F://logs";
	/** 压缩后的zip文件存放路劲 */
	private static String forderDesPath = "F://zip//test1.zip";
	/** 源文件路径 */
	private static String fileSrcPath = "E://工作//redis-desktop-manager-0.7.6.15.rar";
	/** 压缩后的zip文件存放路劲 */
	private static String fileDesPath = "F://zip//redis-desktop-manager-0.7.6.15.zip";
	
	/** 解压文件目标路径 */
	private static String unForderDesPath = "F://unzip";

	public static void main(String[] args) throws IOException {
		ZipUtil.zip(folderSrcPath, forderDesPath);
		ZipUtil.zip(fileSrcPath, fileDesPath);
		
		ZipUtil.unZip(forderDesPath, unForderDesPath);
		ZipUtil.unZip(fileDesPath, unForderDesPath);
	}
}