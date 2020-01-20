package com.biofish.lifesummary.utils;

import java.security.MessageDigest;

/**
 * @ClassName MD5Util
 * @Description MD5工具
 * @Auther bioFish
 * @Date 2020/1/20 9:43
 * @Version v1.0
 **/
public class MD5Util {
    private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();

    public static String toMD5(String str) {
        try {
            return toHex(MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"))).toLowerCase();
        } catch (Exception e) {
            throw new RuntimeException("md5 加密", e);
        }
    }

    private static String toHex(byte[] bytes) {
        StringBuilder str = new StringBuilder(bytes.length * 2);
        final int fifteen = 0x0f;			//十六进制中的 15
        for (byte b : bytes) {				//byte 为 32 位
            str.append(HEX_CHARS[(b >> 4) & fifteen]);		//获取第 25 位到第 28 位的二进制数
            str.append(HEX_CHARS[b & fifteen]);				//获取第 29 位到第 32 位的二进制数
        }
        return str.toString();
    }
}
