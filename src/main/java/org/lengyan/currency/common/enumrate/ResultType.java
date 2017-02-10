package org.lengyan.currency.common.enumrate;

/**
 * 返回结果
 * @author ktc
 * 2016年10月19日 下午1:34:11
 */
public enum ResultType {
    SUCCESS("0"), 
    BUSINESS_ERROR("-1"), 
    PARAM_ERROR("-2"),
    SQL_ERROR("-3");
	
    private String code;

    private ResultType(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
