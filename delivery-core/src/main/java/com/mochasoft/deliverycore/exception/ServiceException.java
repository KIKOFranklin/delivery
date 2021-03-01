package com.mochasoft.deliverycore.exception;

import lombok.Data;

/**
 * 自定义异常
 */

@Data
public class ServiceException extends RuntimeException implements IException {
    private static final long serialVersionUID = 1L;

    private final Integer code;

    public ServiceException(String message) {
        this(500, message, null);
    }


    public ServiceException(Integer code, String message) {
        this(code, message, null);
    }

    public ServiceException(final Integer code, final String message, final Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
