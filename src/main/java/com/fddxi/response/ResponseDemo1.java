package com.fddxi.response;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 描述:Response设置响应数据
 * 响应行: HTTP/1.1 200 OK
 * 响应头: Content-Type:text/html
 * 响应体
 *
 * 描述:Response重定向
 * 一种资源跳转方式
 * 状态码 302
 * 响应头 location:xxx
 *
 * 资源路径问题:
 * 给服务端使用,不加虚拟目录;
 * 给浏览器使用,加虚拟目录(项目访问路径)
 */
@WebServlet("/resp1")
public class ResponseDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        System.out.println("resp1...");

//        //设置响应状态码
//        response.setStatus(302);
//
//        //设置响应头键值对  location要写虚拟目录
//        response.setHeader("location","/request-demo/resp2");

        //简化方式完成重定向
//        response.sendRedirect("/request-demo/resp2");

        //动态获取虚拟目录
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/resp2");
        //响应体 输出流
//        PrintWriter writer = response.getWriter();
//        ServletOutputStream outputStream = response.getOutputStream();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
