package com.cykj.test;

import com.cykj.annotation.Hat;

import java.lang.annotation.Annotation;

public class Test {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.cykj.service.impl.LoginService");
            Annotation[] annotations = clazz.getAnnotations();//返回一个数组
            for (Annotation an : annotations) {
                System.out.println(an.toString());
            }
            Hat h =  (Hat) clazz.getAnnotation(Hat.class);
            String color = h.value();
            String who = h.who();
            System.out.println(color+"，"+who);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
