package com.fddxi.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/*
快捷创建Servlet.右键新建菜单选Servlet.可以在设置里修改Servlet模板
中文乱码问题解决方案(Tomcat8以后已解决)
 */
@WebServlet("/req3")
public class RequestDemo3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //解决方案:
        //POST:getReader()  设置输入流的编码

        request.setCharacterEncoding("utf-8");

        //1.获取username
        String username = request.getParameter("username");
        if("GET".equals(request.getMethod())){
            //GET: 浏览器进行URL编码,中文会变成 %二位16进制.Tomcat默认使用iso-8859-1解码.
            // 1:手动使用iso-8859-1编码,utf-8解码即可
            // 2:转二进制解码(通用解决方案,POST和GET都能解决)
            String encode = URLEncoder.encode(username, "ISO-8859-1");
            System.out.println(new String(username.getBytes("ISO-8859-1"), "utf-8"));
            username = URLDecoder.decode(encode,"utf-8");
        }
        System.out.println(username);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
