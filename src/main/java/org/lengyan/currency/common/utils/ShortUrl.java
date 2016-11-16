package org.lengyan.currency.common.utils;

/**
 * 短网址算法
 * @author ktc
 * 2016年11月16日 下午4:47:21
 */
public class ShortUrl {
	//要使用生成URL的字符
	private static char[] chars = new char[]{
			'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p',
            'q','r','s','t','u','v','w','x','y','z','0','1','2','3','4','5',
            '6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L',
            'M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	private static String key = "lengyan";				//自定义生成MD5加密字符串前的混合KEY 
	
    public static void main(String[] args) { 
        String url = "http://www.lengyan.com/"; 
        for (String string : ShortText(url)) { 
            print(string); 
        } 
    } 
    
    /**
     * 短网址算法
     * @param string
     * @return
     */
    public static String[] ShortText(String string){
    	String hex = MD5SignUtils.MD5(key + string);
    	int hexLen = hex.length();
    	int subHexLen = hexLen / 8;
    	String[] ShortStr = new String[4];
    	for (int i = 0; i < subHexLen; i++) {
    		String outChars = "";
    		int j = i + 1;
    		String subHex = hex.substring(i * 8, j * 8);
    		long idx = Long.valueOf("3FFFFFFF", 16) & Long.valueOf(subHex, 16);
    		
    		for (int k = 0; k < 6; k++) {
    			int index = (int) (Long.valueOf("0000003D", 16) & idx);
    			outChars += chars[index];
    			idx = idx >> 5;
    		}
    		ShortStr[i] = outChars;
    	}
    	return ShortStr;
    }
    
	private static void print(Object messagr){
		System.out.println(messagr);
	}
}
