package com.controller.CBSapi;


	/**
	 * Copyright (C), 2015-2018, 瓜子二手车
	 * FileName: EncryptUtils
	 * Author: jiapengwei
	 * Date: 2018/3/1 14:53
	 * Description:
	 */
	//import sun.misc.BASE64Encoder;
	import javax.crypto.Mac;
	import javax.crypto.spec.SecretKeySpec;
	import java.io.UnsupportedEncodingException;
	import java.net.URLEncoder;
	import java.security.MessageDigest;
	import java.security.NoSuchAlgorithmException;
	import java.util.Map;
	import java.util.TreeMap;

	/**
	 * 〈〉
	 *
	 * @author jiapengwei
	 * @create 2018/3/1
	 * @since 1.0.0
	 */
	public class EncryptUtils {
	    private static final String ENC = "utf-8";

	    /**
	     * 生成签名
	     *
	     * @param params
	     * @param appSecret
	     * @return
	     */
//	    public static String generateSignature(Map params, String appSecret) {
//	        //根据map的key进行排序
//	        Map<String, Object> map = new TreeMap<>(params);
//	        //生成MD5签名，并截取生成结果的5到15位
//	        return md5(sha256HMACEncode(mapToFormatString(map), appSecret)).substring(5, 15);
//	    }

	    /**
	     * sha256加密
	     *
	     * @param params
	     * @param secret
	     * @return
	     */
//	    private static String sha256HMACEncode(String params, String secret) {
//	        String result = "";
//	        try {
//	            Mac sha256HMAC = Mac.getInstance("HmacSHA256");
//	            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
//	            sha256HMAC.init(secretKey);
//	            byte[] sha256HMACBytes = sha256HMAC.doFinal(params.getBytes());
//	            String hash =new BASE64Encoder().encode(sha256HMACBytes);
//	            return hash;
//	        } catch (Exception e) {
//
//	        }
//	        return result;
//	    }

	    /**
	     * md5加密
	     *
	     * @param value
	     * @return
	     */
	    private static String md5(String value) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("md5");
	            byte[] e = md.digest(value.getBytes());
	            return byteToHexString(e);
	        } catch (NoSuchAlgorithmException e) {
	        }
	        return null;
	    }

	    /**
	     * 字节数组转16进制字符串
	     *
	     * @param salt
	     * @return
	     */
	    private static String byteToHexString(byte[] salt) {
	        StringBuffer hexString = new StringBuffer();
	        for (int i = 0; i < salt.length; i++) {
	            String hex = Integer.toHexString(salt[i] & 0xFF);
	            if (hex.length() == 1) {
	                hex = '0' + hex;
	            }
	            hexString.append(hex.toLowerCase());
	        }
	        return hexString.toString();
	    }

	    /**
	     * 生成 URL-encode 之后的请求字符串
	     *
	     * @param map
	     * @return
	     */
	    private static String mapToFormatString(Map<String, Object> map) {
	        StringBuilder sb = new StringBuilder();
	        String result = "";
	        if (map.size() > 0) {
	            try {
	                for (Map.Entry<String, Object> entry : map.entrySet()) {
	                    sb.append(URLEncoder.encode(entry.getKey(), ENC)
	                            .replace("%3D", "=")
	                            .replace("%26", "&"));
	                    sb.append("=");
	                    sb.append(URLEncoder.encode(String.valueOf(entry.getValue()), ENC)
	                            .replace("%3D", "=")
	                            .replace("%26", "&"));
	                    sb.append("&");
	                }
	                result = sb.replace(sb.length() - 1, sb.length(), "").toString();
	            } catch (UnsupportedEncodingException e) {
	                e.printStackTrace();
	            }
	        }
	        return result;
	    }
	}

