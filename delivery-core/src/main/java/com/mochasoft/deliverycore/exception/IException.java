package com.mochasoft.deliverycore.exception;

/**
 * 异常规范
 * @author KIKOFranklin
 */
public interface IException {

    /**
     * 获取异常的状态码
     */
    Integer getCode();

    /**
     * 获取异常的提示信息
     */
    String getMessage();
}
