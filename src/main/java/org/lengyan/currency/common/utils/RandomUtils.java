package org.lengyan.currency.common.utils;

import java.util.Random;

/**
 * 随机工具类
 * @author ktc
 * 2016年10月17日 上午11:04:38
 */
public class RandomUtils {

	/**
	 * 字母 数字随机数
	 * @param length
	 * @return
	 */
	public static String getCharAndNumr(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {// 字符串
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; // 取得大写字母还是小写字母
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) {// 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
}
