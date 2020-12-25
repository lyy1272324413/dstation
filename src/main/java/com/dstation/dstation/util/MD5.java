package com.dstation.dstation.util;

import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;

/**
 * MD5对数据进行加密和解密的算法
 */
public class MD5 {


    /**
     * MD5加密算法，返回密文
     * @param text：需要加密的内容
     * @param key：密钥
     */
    public static String encryption(String text, String key) throws UnsupportedEncodingException {
        String md5Str = DigestUtils.md5DigestAsHex((text + key).getBytes("UTF-8"));
        return md5Str;
    }

    /**
     * 验证md5算法是否通过
     * @param text：输入内容
     * @param key：密钥
     * @param md5：数据库中的密文
     * @return
     */
    public static boolean vertify(String text, String key, String md5) throws UnsupportedEncodingException {
        String md5Str = DigestUtils.md5DigestAsHex((text + key).getBytes("UTF-8"));
        if(md5Str.equalsIgnoreCase(md5)) {
            return true;
        } else {
            return false;
        }
    }
}
