package com.ttdys108.commons.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {

    public static String encode(String str, String secret) {
        return DigestUtils.md5Hex(str + secret);
    }

    public static boolean verify(String str, String md5, String secret) {
        String encrypt = encode(str, secret);
        return encrypt.equalsIgnoreCase(md5);
    }

}
