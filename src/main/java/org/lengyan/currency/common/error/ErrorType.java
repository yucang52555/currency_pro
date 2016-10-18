package org.lengyan.currency.common.error;

/**
 * 异常信息整理
 * @author ktc
 * 2016年10月18日 下午5:09:22
 */
public enum  ErrorType {

    DEFFAULT,
    UNKNOW_ERROR(-1L, null),
    SIGN_INVALID(72L, "签名无效！"),
    OPERATION_FAILED(73L, "操作失败！"),
    PARAM_EXCEPTION(100L, "参数错误！"),
    FIND_NULL_EXCEPTION(101L, "未查找到对象！"),
    REQUEST_EXCEPTION(102L, "请求异常！");
	
    /**
     * 错误码
     */
    private Long code;

    /**
     * 描述
     */
    private String message;

    private ResponseError responseError = new ResponseError();;

    /**
     * Creates a new instance of ExceptionType.
     *
     * @param code    code
     * @param message mms
     * @author Administrator 创建时间 2014年7月2日 下午8:00:15
     */
    private ErrorType(Long code, String message) {
        this.code = code;
        this.message = message;
        responseError.setCode(code);
        responseError.setMessage(message);
    }
    /**
     * Creates a new instance of ExceptionType.
     *
     * @author Administrator 创建时间 2014年7月2日 下午8:00:15
     */
    private ErrorType() {
    }

    /**
     * 获取code
     *
     * @return the code
     */
    public Long getCode() {
        return code;
    }

    /**
     * 获取message
     *
     * @return mms
     */
    public String getMessage() {
        return message;
    }

    /**
     * setMessage
     *
     * @param message mms
     */
    public void setMessage(String message) {
        this.message = message;
        responseError.setMessage(message);
    }

    public ResponseError getResponseError() {
        return responseError;
    }
}
