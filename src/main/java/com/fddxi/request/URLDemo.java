package com.fddxi.request;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 描述:URL编码,解码工具
 */
public class URLDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "张三";

        //1.URL编码
        String encode = URLEncoder.encode(s, "utf-8");
        System.out.println(encode);

        //URL解码
        String decode = URLDecoder.decode(s, "UTF-8");
        System.out.println(decode);

    }
}
