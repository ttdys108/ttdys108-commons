package com.ttdys108.commons.utils;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;
import java.util.Collections;
import java.util.List;

/**
 * SHA-1加密
 */
@Slf4j
public class SHAUtil {

    public static String shaEncode(List<String> params) {
        Collections.sort(params);
        final StringBuilder joinStr = new StringBuilder();
        params.forEach( param -> joinStr.append(param));
        return shaEncode(joinStr.toString());
    }

    public static String shaEncode(String str) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            byte[] byteArray = str.getBytes("UTF-8");
            byte[] md5Bytes = sha.digest(byteArray);
            StringBuffer hexValue = new StringBuffer();
            for (int i = 0; i < md5Bytes.length; i++) {
                int val = ((int) md5Bytes[i]) & 0xff;
                if (val < 16) {
                    hexValue.append("0");
                }
                hexValue.append(Integer.toHexString(val));
            }
            return hexValue.toString();
        } catch (Exception e) {
            log.info("SHA-1 encoding error, encoding string:{}", str, e);
            throw new RuntimeException(e);
        }
    }
}
