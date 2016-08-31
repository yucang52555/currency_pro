package org.lengyan.currency.common.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 * property文件操作工具类
 * @author ktc
 * 2016年8月12日 下午1:42:57
 */
public class PropertyUtils {
	private final static Logger LOG = Logger.getLogger(PropertyUtils.class);
	
	private static Properties properties = new Properties();
//	private static String filePath = "E:/workspace/lengyan_git/currency_pro/src/main/resources/database.properties";
	private static String filePath = "database.properties";
	
	public static void main(String[] args) {
		System.out.println(PropertyUtils.getPropertyValue("database.url"));
	}
	
	static {
        loadProperties(filePath);
    }
	
	/**
     * 根据键获取值
     * @param key 
     * @return 
     */
    public static String getPropertyValue(String key){
        String value = (String)properties.get(key);
        if(StringUtils.isNotEmpty(value)){
            try {
                value = new String(value.getBytes("ISO8859_1"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
            	LOG.info(e);
            }
        }else{
            value = "";
        }
        return value;
    }
    
    /**
     * 根据键获取值
     * @param key 
     * @return 
     */
    public static String getPropertyValue(String propertyFile, String key){
    	loadProperties(filePath);
        String value = (String)properties.get(key);
        if(StringUtils.isNotEmpty(value)){
            try {
                value = new String(value.getBytes("ISO8859_1"),"UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }else{
            value = "";
        }
        return value;
    }
    
    /**
     * 加载属性文件
     * @param filePath
     */
    private static void loadProperties(String filePath) {
    	try {
//    		InputStream in = new BufferedInputStream (new FileInputStream(filePath));
//          properties.load(in);
    		properties.load(PropertyUtils.class.getClassLoader().getResourceAsStream(filePath));
		} catch (IOException e) {
			LOG.info(e);
		}
    }

}
