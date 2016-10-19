package org.lengyan.currency.common.utils;

import java.util.List;

/**
 * 常用公共工具类
 * @author ktc
 * 2016年8月10日 上午11:51:31
 */
public class CommonUtils {
	
	/**
	 * 获取集合的大小
	 * @param
	 * @return 
	 * @变更记录 2016年7月30日 下午6:09:07  ktc
	 */
	public static int sizeOf(List<?> elements) {
		return elements == null ? 0: elements.size();
	}
	
	/**
	 * 获取数组的大小
	 * @param
	 * @return 
	 * @变更记录 2016年10月17日 上午10:58:43  ktc
	 */
	public static int lengthOf(Object[] elements) {
		return elements == null ? 0: elements.length;
	}
	
	/**
	 * 判断集合是否为空
	 * @param list
	 * @return
	 */
	public static boolean isEmpty(List<?> list){
        return  list==null||list.size()==0;
    }

	/**
	 * 判断集合是否不为空
	 * @param list
	 * @return
	 */
    public static boolean isNotEmpty(List<?> list){
        return !isEmpty(list);
    }
}
