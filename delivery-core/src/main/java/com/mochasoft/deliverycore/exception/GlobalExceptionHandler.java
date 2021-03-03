package com.mochasoft.deliverycore.exception;

import com.mochasoft.deliverycore.response.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 */
@Slf4j
@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    /**
     * 拦截业务异常，返回状态码500
     */
    @ExceptionHandler(ServiceException.class)
    public ResponseData serviceError(ServiceException e) {
        log.error("业务异常:", e);
        return ResponseData.failure(e.getCode(), e.getMessage());
    }

    /**
     * 拦截未知的运行时异常，返回状态码500
     */
    @ExceptionHandler(Throwable.class)
    public ResponseData serverError(Throwable e) {
        log.error("运行时异常:", e);
        String message = String.format("服务器运行时异常: %s", e.toString());
        return ResponseData.failure(message);
    }

    /**
     * 拦截业务异常，返回状态码500
     */
    @ExceptionHandler(TokenValidateException.class)
    public ResponseData tokenValidateError(TokenValidateException e) {
        log.error("token验证异常:", e);
        return ResponseData.failure(e.getCode(), e.getMessage());
    }

}
