package com.cykj.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
    /**
     * @description:MD5加密
     * @author: chenhao
     * @date: 2022/12/12 16:50
     * @param: [str]
     * @return: java.lang.String
     **/
    public static String md5Hex(String str){
        // 无密钥加密后的字符串
        String md5str = DigestUtils.md5Hex(str);
        return md5str;
    }
}
