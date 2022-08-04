package com.fddxi.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 描述:Response 响应字符数据
 * 设置字符数据的响应体
 */
@WebServlet("/resp3")
public class ResponseDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.设置 Content-Type 响应头
//        response.setHeader("Content-Type","text/html");
        response.setContentType("text/html;charset=utf-8");
        //2.获取字符输出流/这个流会随着response对象销毁,不需要手动关闭
        PrintWriter writer = response.getWriter();
        writer.write("你好");

        writer.write("<h1>aaa</h1>");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
