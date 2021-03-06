package com.http.duoying;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import javax.activation.MimetypesFileTypeMap;

public class OCRHttpHelper
{
  public static String formUpload(String urlStr, Map<String, String> textMap, Map<String, String> fileMap)
  {
    String res = "";
    HttpURLConnection conn = null;
    String BOUNDARY = "---------------------------123821742118716";
    try {
      URL url = new URL(urlStr);
      conn = (HttpURLConnection)url.openConnection();
      conn.setConnectTimeout(5000);
      conn.setReadTimeout(30000);
      conn.setDoOutput(true);
      conn.setDoInput(true);
      conn.setUseCaches(false);
      conn.setRequestMethod("POST");
      conn.setRequestProperty("Connection", "Keep-Alive");
      conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
      conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);

      OutputStream out = new DataOutputStream(conn.getOutputStream());

      if (textMap != null) {
        StringBuffer strBuf = new StringBuffer();
        Iterator iter = textMap.entrySet().iterator();
        while (iter.hasNext()) {
          Map.Entry entry = (Map.Entry)iter.next();
          String inputName = (String)entry.getKey();
          String inputValue = (String)entry.getValue();
          if (inputValue != null)
          {
            strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");

            strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"\r\n\r\n");

            strBuf.append(inputValue);
          }
        }
        out.write(strBuf.toString().getBytes());
      }

      if (fileMap != null) {
        Iterator iter = fileMap.entrySet().iterator();
        while (iter.hasNext()) {
          Map.Entry entry = (Map.Entry)iter.next();
          String inputName = (String)entry.getKey();
          String inputValue = (String)entry.getValue();
          if (inputValue != null)
          {
            File file = new File(inputValue);
            String filename = file.getName();

            String contentType = new MimetypesFileTypeMap()
              .getContentType(file);

            if (filename.endsWith(".png")) {
              contentType = "image/png";
            }
            if ((contentType == null) || (contentType.equals(""))) {
              contentType = "application/octet-stream";
            }
            StringBuffer strBuf = new StringBuffer();
            strBuf.append("\r\n").append("--").append(BOUNDARY).append("\r\n");

            strBuf.append("Content-Disposition: form-data; name=\"" + inputName + "\"; filename=\"" + filename + "\"\r\n");

            strBuf.append("Content-Type:" + contentType + "\r\n\r\n");

            out.write(strBuf.toString().getBytes());

            DataInputStream in = new DataInputStream(new FileInputStream(file));

            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
              out.write(bufferOut, 0, bytes);
            }
            in.close();
          }
        }
      }
      byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
      out.write(endData);
      out.flush();
      out.close();

      StringBuffer strBuf = new StringBuffer();

      BufferedReader reader = new BufferedReader(new InputStreamReader(conn
        .getInputStream()));
      String line = null;
      while ((line = reader.readLine()) != null) {
        strBuf.append(line).append("\n");
      }
      res = strBuf.toString();
      reader.close();
      reader = null;
    } catch (Exception e) {
      System.out.println("����POST���������" + urlStr);
      e.printStackTrace();
    } finally {
      if (conn != null) {
        conn.disconnect();
        conn = null;
      }
    }
    return res;
  }

  public static void main(String[] args)
  {
  }
}
