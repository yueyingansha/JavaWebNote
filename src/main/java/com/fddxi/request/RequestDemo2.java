package com.fddxi.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * 描述:doGet() 和doPost() 只有获取请求参数的代码不同
 * Request通用方式获取请求参数
 */
@WebServlet(urlPatterns="/req2")
public class RequestDemo2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //GET请求逻辑
        if("GET".equals(req.getMethod()))
        System.out.println("get...");
        //获取包含所有参数的Map集合
        Map<String, String[]> map = req.getParameterMap();
        map.keySet().forEach((o1)->{
            System.out.print(o1+":");
            String[]values;
            if((values = map.get(o1)) != null){
                for (String value : values) {
                    System.out.print(value+" ");
                }
                System.out.println();
            }
        });
        System.out.println("==========");

        //根据名称获取参数值(数组)
        String[] hobbies = req.getParameterValues("hobby");
        for (String hobby : hobbies) {
            System.out.println(hobby);
        }

        //根据名称获取参数值(单个值)
        String username = req.getParameter("username");
        System.out.println(username);
        String password = req.getParameter("password");
        System.out.println(password);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("post...");
        this.doGet(req, resp);
    }
}
