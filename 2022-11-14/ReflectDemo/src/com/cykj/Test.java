package com.cykj;

import com.cykj.bean.TQquser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;//反射包
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;//反射包内的方法包

public class Test {
    public static void main(String[] args) {
        //全类名：包+类
        try {
            //1、创建Class对象           clazz已经是TQquser类附体
            Class clazz = Class.forName("com.cykj.bean.TQquser");
            //2.Class的属性或方法 ：获取TQquser的属性或方法
//            Field[] fields = clazz.getFields();//只能获取公有的
            Field[] declaredFields = clazz.getDeclaredFields();//公有和私有的都能获取
            for (Field f : declaredFields) {
                //获取名字+类型
                System.out.println(f.getName()+"，"+f.getType());
            }
            System.out.println("------------------------------------------");
            //获取方法
//            Method[] methods = clazz.getDeclaredMethods();
            Method[] methods = clazz.getMethods();
            for (Method m : methods) {
                System.out.println(m.getName()+"，"+m.getReturnType());
            }
            //获取构造方法
            System.out.println("------------------------------------------");
            Constructor[] constructors = clazz.getConstructors();
            for (Constructor c : constructors) {
                System.out.println(c.getName());
            }
            System.out.println("------------------------------------------");
            Object object = clazz.newInstance();
            //                判断左边对象是否是右边的实例
            System.out.println(object instanceof TQquser);
            TQquser q = (TQquser) object;

            System.out.println(object);
            //动态给object的属性赋值
            Field field = clazz.getDeclaredField("qqid");
            field.setAccessible(true);//将private设置为可访问(public)
            field.set(object,"1001");
            System.out.println(object);
            //动态调用方法------get
            Method method = clazz.getMethod("getQqid");
            Object qqid = method.invoke(object);//调用，执行
            System.out.println(qqid);
            //动态调用方法------set
            Method setNickname = clazz.getMethod("setNickname", String.class);
            Object re = setNickname.invoke(object, "远辉");
            System.out.println(re);
            System.out.println(object);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
