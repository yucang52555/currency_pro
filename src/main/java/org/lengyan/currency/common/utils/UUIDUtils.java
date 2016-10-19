package org.lengyan.currency.common.utils;

/**
 * 生成UUID
 * @author ktc
 * 2016年10月19日 下午1:51:36
 */
public class UUIDUtils {
	
    /**
     * 获取没有中线的uuid
     * @return
     */
    public static String randomUUID() {
        return java.util.UUID.randomUUID().toString().replaceAll("-", "");
    }
}
