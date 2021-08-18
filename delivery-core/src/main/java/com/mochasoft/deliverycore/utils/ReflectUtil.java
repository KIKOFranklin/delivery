package com.mochasoft.deliverycore.utils;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mochasoft.deliverycore.exception.ServiceException;
import com.mochasoft.deliverydomain.annotation.Between;
import com.mochasoft.deliverydomain.annotation.Likeable;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author wangjiahao
 * @since 2021/8/10 10:14 下午
 */
public class ReflectUtil {
    /**
     * 通过反射生成wrapper
     * @param target 目标对象
     * @param <T> 目标对象的类
     * @return queryWrapper
     * @apiNote 如该方法有问题请联系author
     *
     */
    public static <T> QueryWrapper<T> generateWrapperByReflection(final T target) {
        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        Class<?> clazz = target.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Arrays.stream(fields).forEach(t -> {
            try {
                t.setAccessible(true);
                if (t.getAnnotation(TableId.class) == null) {
                    Object fieldValue = t.get(target);
                    if (fieldValue != null && fieldValue != "") {
                        TableField tableField = t.getAnnotation(TableField.class);
                        Between betweenParam = t.getAnnotation(Between.class);
                        if(t.getAnnotation(Likeable.class) != null){
                            queryWrapper.like(tableField.value(), fieldValue);
                        } else if(t.getAnnotation(Between.class) != null){
                            if(betweenParam.value().equals("start")){
                                queryWrapper.ge(tableField.value(), fieldValue);
                            } else if(betweenParam.value().equals("end")) {
                                queryWrapper.le(tableField.value(), fieldValue);
                            }
                        } else {
                            queryWrapper.eq(tableField.value(), fieldValue);
                        }
                    }
                }
            } catch (IllegalAccessException e) {
                throw new ServiceException("服务器内部异常");
            }
        });
        queryWrapper.orderBy(true,false,"DATE");
        return queryWrapper;
    }
}
