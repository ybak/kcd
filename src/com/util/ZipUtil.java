package com.util;

/**
 * 瑙ｅ帇缂╁伐鍏�
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.zip.*;

public abstract class ZipUtil {

    /**
     * 浣跨敤gzip杩涜鍘嬬缉
     *
     * @param str 鍘嬬缉鍓嶇殑鏂囨湰
     * @return 杩斿洖鍘嬬缉鍚庣殑鏂囨湰
     * @throws IOException io exception
     */
    public static final String gzip(String str) throws IOException {
        if (str == null)
            return null;

        byte[] bytes = gzip(str.getBytes(Charset.forName("UTF-8")));
        return Base64Util.getEncoder().encodeToString(bytes);
    }

    /**
     * 浣跨敤gzip杩涜鍘嬬缉
     *
     * @param bytes 鍘嬬缉鍓嶇殑鏂囨湰
     * @return 杩斿洖鍘嬬缉鍚庣殑鏂囨湰
     * @throws IOException io exception
     */
    public static final byte[] gzip(byte[] bytes) throws IOException {
        if (bytes == null)
            return null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream zout = new GZIPOutputStream(out);
        zout.write(bytes);
        zout.finish();
        byte[] compressed = out.toByteArray();
        return compressed;
    }

    /**
     * 浣跨敤zip杩涜瑙ｅ帇缂�
     *
     * @param compressedStr 鍘嬬缉鍚庣殑鏂囨湰
     * @return 瑙ｅ帇鍚庣殑瀛楃涓�
     * @throws IOException io exception
     */
    public static final String ungzip(String compressedStr) throws IOException {
        if (compressedStr == null) {
            return null;
        }
        Base64Util.getDecoder().decode(compressedStr);
        byte[] unzip = ungzip(Base64Util.getDecoder().decode(compressedStr));
        return new String(unzip, Charset.forName("UTF-8"));
    }

    /**
     * 浣跨敤zip杩涜瑙ｅ帇缂�
     *
     * @param bytes 鍘嬬缉鍚庣殑鏂囨湰
     * @return 瑙ｅ帇鍚庣殑瀛楃涓�
     * @throws IOException io exception
     */
    public static final byte[] ungzip(byte[] bytes) throws IOException {
        if (bytes == null) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        GZIPInputStream ungzip = new GZIPInputStream(in);
        byte[] buffer = new byte[1024];
        int n;
        while ((n = ungzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }
}