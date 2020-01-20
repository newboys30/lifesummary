package com.biofish.lifesummary.pojo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 * 用于标记字段是否为自增主键
 * 打上此标记的字段为主键
 * @author bioFish
 */
@Target({ ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Increment {
    boolean isInrement();
}
