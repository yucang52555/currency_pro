package org.lengyan.currency.common.enumrate;

/**
 * 共享状态
 * @author ktc
 * 2016年10月18日 下午5:06:08
 */
public enum ShareStatus {
    Active(0),
    Pause(1),
    Delete(2);

    private int code;
    private ShareStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
