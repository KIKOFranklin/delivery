package com.mochasoft.deliverycore.exception;

import lombok.Data;

/**
 * @author KIKOFranklin
 * 用户登录异常.
 * @create 2021/3/3 0003 10:04
 */
@Data
public class TokenValidateException extends RuntimeException implements IException {

    private static final long serialVersionUID = 1L;

    private final Integer code;

    public TokenValidateException(String message) {
        this(403, message, null);
    }


    public TokenValidateException(Integer code, String message) {
        this(code, message, null);
    }

    public TokenValidateException(final Integer code, final String message, final Throwable cause) {
        super(message, cause);
        this.code = code;
    }
}
