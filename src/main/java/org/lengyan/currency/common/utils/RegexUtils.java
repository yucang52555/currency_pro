package org.lengyan.currency.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 * @author ktc
 * 2016年10月22日 下午5:24:23
 */
public class RegexUtils {
	/**
	 * 检查是否邮箱格式
	 * @return
	 */
	public static boolean checkIsMail(String mailAddress) {
		String regEx = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
		Pattern p = Pattern.compile(regEx);
		Matcher match = p.matcher(mailAddress);
		if (match.matches()) {
			return true;
		}
		return false;
	}
}
