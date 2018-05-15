package com.yundian.tookit.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *实体对象对应EXCEl 中的类名
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE,ElementType.FIELD})
public @interface XLSValue {

    String value() default "";

}
