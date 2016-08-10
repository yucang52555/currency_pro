package org.lengyan.currency.common.enumrate;

/**
 * 文件类型
 * @author ktc
 * 2016年8月10日 上午11:51:10
 */
public enum FileType {
    Image(0),
    Sound(1),
    Excel(2);

    private int code;
    private FileType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}