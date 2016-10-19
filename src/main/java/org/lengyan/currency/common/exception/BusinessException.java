package org.lengyan.currency.common.exception;

import org.lengyan.currency.common.error.ErrorType;

/**
 * 业务异常
 * @author ktc
 * 2016年10月19日 下午5:16:59
 */
public class BusinessException extends AbstractCustomException {   
    /**
     * 序列号
     */
    private static final long serialVersionUID = 5519807324646450669L;

    public BusinessException() {
    }

    public BusinessException(ErrorType errorType) {
        super(errorType);
    }

    public BusinessException(String msg) {
        super(msg);
    }

    public BusinessException(String msg, ErrorType errorType) {
        super(msg, errorType);
    }

    public BusinessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public BusinessException(String msg, ErrorType errorType, Throwable cause) {
        super(msg, errorType, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(ErrorType errorType, Throwable cause) {
        super(errorType, cause);
    }
}
