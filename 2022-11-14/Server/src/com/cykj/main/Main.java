package com.cykj.main;

import com.cykj.controller.Controller;
import com.cykj.view.UI;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Controller con = new Controller();
        UI myUI = new UI(con);
    }


//    public void copyFile(String inputPath,String outputPath){
//        try {
//            InputStream inputStream = new FileInputStream(inputPath);
//            OutputStream outputStream = new FileOutputStream(outputPath);
//
//            byte[] buffer = new byte[1024];
//            int len = 0;
//            while ((len = inputStream.read(buffer)) != -1){
//                outputStream.write(buffer,0,len);
//                outputStream.flush();
//                System.out.println(len);//打印长度
//                for (int i = 0; i < len; i++) {
//                    System.out.print(buffer[i]+" ");
//                }
//                System.out.println();
//            }
//            inputStream.close();
//            outputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
