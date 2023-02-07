package com.cykj.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class YearUtis {

    public static List<String> halfYear() {
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;// 获取当前月
        int year = calendar.get(Calendar.YEAR);// 获取当前年
        List<String> yearMonths = new ArrayList<>();// 声明一个字符串列表
        for (int i = 5; i >=0; i--){
            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH) + 1;
            if((month-i)<=0){
                year--;
                month = month-i+12;
            }
            else if((month-i)==1){
                System.out.println("当前年-月"+year+"-"+(month-1));
                month--;
            }
            String zero = "";
            if(month<10){
                zero="0";
            }
            yearMonths.add(year+"-"+zero+month);
        }
        return yearMonths;
    }
}
