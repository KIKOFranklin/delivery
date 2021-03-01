package com.mochasoft.deliverycore.enums;

/**
 * @author KIKOFranklin
 * @create 2021/1/31 0031 13:49
 */
public interface BaseEnum<T> {

    T getCode();

    String getDescription();
}