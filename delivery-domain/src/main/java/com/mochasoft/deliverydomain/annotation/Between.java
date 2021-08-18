package com.mochasoft.deliverydomain.annotation;

import java.lang.annotation.*;

/**
 * @author wangjiahao
 * @since 2021/8/16 11:28 下午
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Between {
    String value();
}
