package com.fddxi.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 描述:Request继承体系
 * ServletRequest根接口
 * HTTPServletRequest 子接口
 * RequestFacade tomcat定义的实现类
 * tomcat需要解析请求数据,封装为request对象.并且创建request对象传递到Service方法中
 * 查文档只需要查HTTPServletRequest
 */
@WebServlet(urlPatterns = "/demo2")
public class RequestIntro2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");
    }
}