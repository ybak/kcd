package com.util.duoying;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

import org.springframework.util.DigestUtils;

/**
 * 功能：MD5签名处理核心文件，不需要修改
 */

public class MD5 {
    /**
     * @param content
     * @param charset
     * @return
     * @throws SignatureException
     * @throws UnsupportedEncodingException
     */
    private static byte[] getContentBytes(Object content, String charset) {
        if (charset == null || "".equals(charset)) {
            return ((String) content).getBytes();
        }
        try {
            return ((String) content).getBytes(charset);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("MD5签名过程中出现错误,指定的编码集不对,您目前指定的编码集是:" + charset);
        }
    }

    /**
     * 签名字符串
     * 
     * @param text
     *            需要签名的字符串
     * @param key
     *            密钥
     * @param input_charset
     *            编码格式
     * @return 签名结果
     */
    public static String sign(Object text, String input_charset) {
        return DigestUtils.md5DigestAsHex(getContentBytes(text, input_charset));
    }

    /**
     * 签名字符串
     * 
     * @param text
     *            需要签名的字符串
     * @param sign
     *            签名结果
     * @param key
     *            密钥
     * @param input_charset
     *            编码格式
     * @return 签名结果
     */
    public static boolean verify(String text, String sign, String input_charset) {
        String mysign = DigestUtils.md5DigestAsHex(getContentBytes(text, input_charset));
        if (mysign.equals(sign)) {
            return true;
        } else {
            return false;
        }
    }

}