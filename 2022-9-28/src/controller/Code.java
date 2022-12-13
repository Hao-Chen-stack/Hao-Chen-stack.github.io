package controller;

import java.util.Random;
import java.util.Scanner;

public class Code {//验证码
    public static void main(String[] args) {
        String codeBox = "qwertyuipasdfghjkzxcvbnmQWERTYUPASDFGHJKLZXCVBNM" +
                "23456789";

        //要求四位验证码   并且  拿来比较
        String pcCode = "";
        for (int i = 0; i < 4; i++) {
            int ranNum = new Random().nextInt(codeBox.length());
//            System.out.print(codeBox.charAt(ranNum));
            pcCode +=codeBox.charAt(ranNum);
        }
        System.out.println("验证码是:"+pcCode);
        //大小写不区分
        System.out.println("请输入验证码:");
        String scUser = new Scanner(System.in).next();
        System.out.println(scUser.equalsIgnoreCase(pcCode));//判断验证码是否相等，equalsIgnoreCase
    }
}

