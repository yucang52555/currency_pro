package org.lengyan.currency.common.enumrate;

/**
 * 婚姻状况
 * @author ktc
 * 2016年10月18日 下午5:04:55
 */
public enum MaritalStatus {
    Unmarried(0),//未婚
    Married(1),//已婚
    Unknown(3);//未知

    private int code;
    private MaritalStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}