package org.lengyan.currency.common.utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * 数学计算工具类
 * @since  2016年9月9日
 * @author ktc
 */
public class MathUtils {
	
	/**
	 * 百分比
	 * @param
	 * @return 
	 * @变更记录 2016年9月9日 下午3:41:56  ktc
	 */
	public static String accuracy(double num, double total, int scale){  
        DecimalFormat df = (DecimalFormat)NumberFormat.getInstance();  
        //可以设置精确几位小数  
        df.setMaximumFractionDigits(scale);  
        //模式 例如四舍五入  
        df.setRoundingMode(RoundingMode.HALF_UP);  
        double accuracy_num = num / total * 100;  
        return df.format(accuracy_num)+"%";
	}
	
	public static void main(String[] args) {
//		System.out.println(accuracy(1, 49, 2));
//		System.out.println(new Date().getTime());
		Map<String, Boolean> testMap = new HashMap<String, Boolean>();
		testMap.put("1", false);
		testMap.put("2", true);
		System.out.println(testMap.get("1"));
		System.out.println(testMap.get("2"));
		System.out.println(testMap.get("3"));
	}
}
