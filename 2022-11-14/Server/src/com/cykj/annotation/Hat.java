package com.cykj.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)//类上
@Retention(RetentionPolicy.RUNTIME)//渲染的策略：运行时
public @interface Hat {

    String value() default "green";
    String who() default "小林的";

}
