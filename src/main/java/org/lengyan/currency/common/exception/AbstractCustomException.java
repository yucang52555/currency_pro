package org.lengyan.currency.common.exception;

import org.lengyan.currency.common.error.ErrorType;

/**
 * 用户自定义异常
 * @author ktc
 * 2016年10月19日 下午5:15:52
 */
public abstract class AbstractCustomException extends Exception {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    private ErrorType errorType;

    public AbstractCustomException() {
        this.setErrorType(ErrorType.UNKNOW_ERROR);
    }

    public AbstractCustomException(ErrorType errorType) {
        super();
        this.setErrorType(errorType);
    }

    public AbstractCustomException(String msg) {
        super(msg);
        this.setErrorType(ErrorType.UNKNOW_ERROR);
    }

    public AbstractCustomException(String msg, ErrorType errorType) {
        super(msg);
        this.setErrorType(errorType);
    }

    public AbstractCustomException(String msg, Throwable cause) {
        super(msg, cause);
        this.setErrorType(ErrorType.UNKNOW_ERROR);
    }

    public AbstractCustomException(String msg, ErrorType errorType, Throwable cause) {
        super(msg, cause);
        this.setErrorType(errorType);
    }

    public AbstractCustomException(Throwable cause) {
        super(cause);
        this.setErrorType(ErrorType.UNKNOW_ERROR);
    }

    public AbstractCustomException(ErrorType errorType, Throwable cause) {
        super(cause);
        this.setErrorType(errorType);
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public void setErrorType(ErrorType errorType) {
        this.errorType = errorType;
    }
}
