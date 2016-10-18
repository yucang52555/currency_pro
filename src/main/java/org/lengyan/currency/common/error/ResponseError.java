package org.lengyan.currency.common.error;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 
 * @author ktc
 * 2016年10月18日 下午5:10:45
 */
public class ResponseError implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6855382292704270428L;

	/**
     * message
     */
    private String message;

    /**
     * code
     */
    private Long code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
