package com.fddxi.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * 描述:Request获取请求数据
 *
 * 请求行: GET/request-demo/req1?username=zhangsan&password=123 HTTP/1.1
 *
 * 请求头
 */
@WebServlet(urlPatterns="/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //String getMethod():获取请求方式 GET
        String method = req.getMethod();
        System.out.println(method);

        //String getContextPath():获取虚拟目录(项目访问路径):/request-demo
        String contextPath = req.getContextPath();
        System.out.println(contextPath);

        //StringBuffer getRequestURL():获取URL(统一资源定位符):http://localhost:8080/request-demo/req1
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());

        //StringBuffer getRequestURI():获取URI(统一资源标识符):/request-demo/req1
        String uri = req.getRequestURI();
        System.out.println(uri);

        //String getQueryString():获取请求参数(GET方式):username=zhangsan&password=123
        String queryString = req.getQueryString();
        System.out.println(queryString);

        //-------------
        //获取请求头:user-agent:浏览器版本信息
        String agent = req.getHeader("user-agent");
        System.out.println(agent);




    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取post 请求体:请求参数

        //1.获取字符输入流
        BufferedReader reader = req.getReader();
        //2.读取数据
        String line = reader.readLine();
        System.out.println(line);
        //流会自动关闭
    }
}
