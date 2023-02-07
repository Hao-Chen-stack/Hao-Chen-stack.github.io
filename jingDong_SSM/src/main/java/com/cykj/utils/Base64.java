package com.cykj.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;


class ImgToBase64 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        System.out.println(getImgFileToBase642("C:\\Users\\86182\\Desktop\\1.png"));
//        System.out.println(getImgUrlToBase64("https://game.gtimg.cn/images/lol/act/img/rune/Electrocute.png"));
//        System.out.println(getImgBase64ToImgFile(getImgUrlToBase64("https://game.gtimg.cn/images/lol/act/img/rune/Electrocute.png"),"f://user/base2.jpg"));
    }

    /**
     * 本地图片转base64
     */
    public static String getImgFileToBase642(String imgFile) {
        //将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        byte[] buffer = null;
        //读取图片字节数组
        try(InputStream inputStream = new FileInputStream(imgFile);){
            int count = 0;
            while (count == 0) {
                count = inputStream.available();
            }
            buffer = new byte[count];
            inputStream.read(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 对字节数组Base64编码
        Encoder encode = Base64.getEncoder();
        return encode.encodeToString(buffer);
    }

    /**
     * 网络图片转base64
     */
    public static String getImgUrlToBase64(String imgUrl) {
        byte[] buffer = null;
        InputStream inputStream = null;
        try (
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();){
            // 创建URL
            URL url = new URL(imgUrl);
            // 创建链接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            inputStream = conn.getInputStream();
            // 将内容读取内存中
            buffer = new byte[1024];
            int len = -1;
            while ((len = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, len);
            }
            buffer = outputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    // 关闭inputStream流
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        // 对字节数组Base64编码
        Encoder encode = Base64.getEncoder();
        return encode.encodeToString(buffer);
    }

    /**
     * 本地或网络图片转base64
     */
    public static String getImgStrToBase64(String imgStr) {
        InputStream inputStream = null;
        byte[] buffer = null;
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream();){
            //判断网络链接图片文件/本地目录图片文件
            if (imgStr.startsWith("http://") || imgStr.startsWith("https://")) {
                // 创建URL
                URL url = new URL(imgStr);
                // 创建链接
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("GET");
                conn.setConnectTimeout(5000);
                inputStream = conn.getInputStream();
                // 将内容读取内存中
                buffer = new byte[1024];
                int len = -1;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
                buffer = outputStream.toByteArray();
            } else {
                inputStream = new FileInputStream(imgStr);
                int count = 0;
                while (count == 0) {
                    count = inputStream.available();
                }
                buffer = new byte[count];
                inputStream.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    // 关闭inputStream流
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // 对字节数组Base64编码
        Encoder encode = Base64.getEncoder();
        return encode.encodeToString(buffer);
    }

    /**
     * base64转图片存储在本地
     * @param imgBase64 图片base64
     * @param imgPath 图片本地存储地址
     */
    public static boolean getImgBase64ToImgFile(String imgBase64, String imgPath) {
        boolean flag = true;
        Decoder decode = Base64.getDecoder();
        try (OutputStream outputStream = new FileOutputStream(imgPath);){
            // 解密处理数据
            byte[] bytes = decode.decode(imgBase64);
            for (int i = 0; i < bytes.length; ++i) {
                if (bytes[i] < 0) {
                    bytes[i] += 256;
                }
            }
            outputStream.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            flag = false;
        }
        return flag;
    }
}