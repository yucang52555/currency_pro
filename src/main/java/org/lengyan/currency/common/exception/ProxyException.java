package org.lengyan.currency.common.exception;


import org.lengyan.currency.common.error.ResponseError;

/**
 * 代理异常
 * @author ktc
 * 2016年10月19日 下午5:17:44
 */
public class ProxyException extends AbstractCustomException {

    /**
	 * 序列化ID
	 */
	private static final long serialVersionUID = -7062131899628765074L;
	
	/**
     * responseError
     */
    private ResponseError responseError;

    /**
     * ProxyException
     */
    public ProxyException() {
    }

    /**
     * ProxyException
     *
     * @param responseError responseError
     */
    public ProxyException(ResponseError responseError) {
        this.responseError = responseError;
    }

    /**
     * ProxyException
     *
     * @param msg msg
     */
    public ProxyException(String msg) {
        super(msg);
    }

    /**
     * ProxyException
     *
     * @param msg           msg
     * @param responseError responseError
     */
    public ProxyException(String msg, ResponseError responseError) {
        super(msg);
        this.responseError = responseError;
    }

    /**
     * ProxyException
     *
     * @param msg   msg
     * @param cause cause
     */
    public ProxyException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * ProxyException
     *
     * @param msg           msg
     * @param responseError responseError
     * @param cause         cause
     */
    public ProxyException(String msg, ResponseError responseError, Throwable cause) {
        super(msg, cause);
        this.responseError = responseError;
    }

    /**
     * ProxyException
     *
     * @param cause cause
     */
    public ProxyException(Throwable cause) {
        super(cause);
    }

    /**
     * ProxyException
     *
     * @param responseError responseError
     * @param cause         cause
     */
    public ProxyException(ResponseError responseError, Throwable cause) {
        super(cause);
        this.responseError = responseError;
    }

    public ResponseError getResponseError() {
        return responseError;
    }

    public void setResponseError(ResponseError responseError) {
        this.responseError = responseError;
    }
}
