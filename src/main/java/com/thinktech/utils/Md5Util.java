package com.thinktech.utils;

import java.security.MessageDigest;

/**
 * @author hls
 * @project springboot-scaffold
 * @date 2024/8/13 16:29:25
 */
public class Md5Util {

    private static final String[] DIGITS = { "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

    /**
     * @Auther: hls
     * @Description: 字符串加密
     */
    public static String md5Encode(String origin, String encoding) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            if (encoding == null || encoding.isEmpty()) {
                origin = byteArrayToHexString(md.digest(origin.getBytes()));
            } else {
                origin = byteArrayToHexString(md.digest(origin.getBytes(encoding)));
            }
        } catch (Exception ignore) {
        }
        return origin;
    }

    private static String byteArrayToHexString(byte[] b) {
        StringBuilder resultSb = new StringBuilder();
        for (byte value : b) {
            resultSb.append(byteToHexString(value));
        }
        return resultSb.toString();
    }

    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0) {
            n += 256;
        }
        int d1 = n / 16;
        int d2 = n % 16;
        return DIGITS[d1] + DIGITS[d2];
    }
}
