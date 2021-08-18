package com.mochasoft.deliverydomain.annotation;

import java.lang.annotation.*;

/**
 * @author wangjiahao
 * @since 2021/8/11 11:05 上午
 * @apiNote 需要like查询的字段
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Likeable {
}
