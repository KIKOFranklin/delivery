package com.mochasoft.deliverycore.response;

import lombok.Data;
import org.springframework.http.HttpStatus;


/**
 * @author wangjiahao
 */
@Data
public final class ResponseData<T> {

    /**
     * 业务错误码
     */
    private final Integer code;
    /**
     * 信息描述
     */
    private final String message;
    /**
     * 返回参数
     */
    private final T data;

    private ResponseData(final Integer code, final String message, final T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> ResponseData<T> success() {
        return success(null);
    }

    public static <T> ResponseData<T> success(final T data) {
        final HttpStatus ok = HttpStatus.OK;
        return new ResponseData<>(ok.value(), ok.getReasonPhrase(), data);
    }


    public static <T> ResponseData<T> failure() {
        return failure(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase());

    }

    public static <T> ResponseData<T> failure(final String message) {
        return failure(HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
    }

    public static <T> ResponseData<T> failure(final Integer code, final String message) {

        return new ResponseData<>(code, message, null);

    }


}
