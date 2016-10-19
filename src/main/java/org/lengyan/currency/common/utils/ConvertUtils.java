package org.lengyan.currency.common.utils;

/**
 * 转换工具类
 * @since  2016年7月18日
 * @author ktc
 */
public class ConvertUtils {
	/**
	 * 字符串数组转整形数组
	 * @param
	 * @return 
	 * @变更记录 2016年7月18日 下午7:08:50  ktc
	 */
	public static Integer[] strArray2intArray(String...arr){
        Integer[] intArr = new Integer[arr.length];
        for (int i=0; i<arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        return intArr;
    }
}
