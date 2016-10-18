package org.lengyan.currency.common.enumrate;

/**
 * 文件状态
 * @author ktc
 * 2016年10月18日 下午5:04:06
 */
public enum FileStatus {
    Display(0),
    Hidden(1);

    private int code;
    private FileStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
