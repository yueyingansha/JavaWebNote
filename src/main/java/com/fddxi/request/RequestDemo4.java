package com.fddxi.request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/*
请求转发(forward)

请求转发资源间共享数据:使用Request对象

void request.setAttribute(String name,Object o);存储数据到request域中
void request.getAttribute(String name);根据key,获取值
void request.removeAttribute(String name);根据key,删除该键值对

特点:url浏览器地址栏路径不发生变化
只能转发到当前服务器的内部资源
一次请求,可以在转发的资源间使用request共享数据
 */
@WebServlet("/req4")
public class RequestDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Demo4...");

        //获取数据
        request.setAttribute("msg","hello");
//        request.getAttribute("");
//        request.removeAttribute("");

        //请求转发
        request.getRequestDispatcher("/req5").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
