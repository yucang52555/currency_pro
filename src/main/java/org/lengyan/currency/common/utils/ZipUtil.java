package org.lengyan.currency.common.utils;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

/**
 * 文件压缩工具类
 * @author ktc
 * 2016年9月29日 下午5:14:11
 */
public class ZipUtil {
	/**
	 * 提供给外部压缩调用
	 * 
	 * @param src
	 * @param des
	 * @throws IOException
	 */
	public static void zip(String src, String des) throws IOException {
		ZipOutputStream out = null;
		try {
			CheckedOutputStream cos = new CheckedOutputStream(new FileOutputStream(des), new Adler32());
			out = new ZipOutputStream(new BufferedOutputStream(cos));
			out.setEncoding("UTF-8");
			zip(new File(src), out, "");
			System.out.println("zip done!!!");
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 压缩文件
	 * 
	 * @param file
	 * @param out
	 * @param base
	 * @throws IOException
	 */
	private static void zip(File file, ZipOutputStream out, String base) throws IOException {
		if (file.isFile()) {
			if (base.length() > 0) {
				out.putNextEntry(new ZipEntry(base));
			} else {
				out.putNextEntry(new ZipEntry(file.getName()));
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
			int len;
			while ((len = br.read()) != -1) {
				out.write(len);
			}
			br.close();
		} else if (file.isDirectory()) {
			File[] subFiles = file.listFiles();
			out.putNextEntry(new ZipEntry(base + File.separator));
			base = base.length() != 0 ? base + File.separator : "";
			if (subFiles != null) {
				for (File subFile : subFiles) {
					zip(subFile, out, base + subFile.getName());
					System.out.println("zip " + subFile.getName() + "....");
				}
			}
		}
	}

	/**
	 * 解压
	 * @param zipPath
	 * @param destinationPath
	 */
	public static void unZip(String zipPath, String destinationPath) {
		File zipFile = new File(zipPath);
		if (!zipFile.exists()) {
			throw new RuntimeException("zip file " + zipPath + " does not exist.");
		}
		Project proj = new Project();
		Expand expand = new Expand();
		expand.setProject(proj);
		expand.setTaskType("unzip");
		expand.setTaskName("unzip");
		expand.setSrc(zipFile);
		expand.setDest(new File(destinationPath));
		expand.setEncoding("UTF-8");
		expand.execute();
		System.out.println("unzip done!!!");
	}
}