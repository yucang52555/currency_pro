package org.lengyan.currency.common.enumrate;

/**
 * 用户状态
 * @author ktc
 * 2016年10月18日 下午5:06:55
 */
public enum UserStatus {
    Register(0),
    Perfect(1),
    Pause(2),
    Delete(3);

    private int code;
    private UserStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
