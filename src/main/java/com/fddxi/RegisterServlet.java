package com.fddxi;

import com.fddxi.mapper.UserMapper;
import com.fddxi.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import utils.SQLSFUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //封装用户对象
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        //2.1获取sqlSession对象
        SqlSessionFactory sqlSessionFactory = SQLSFUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //2.2获取mapper对象
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //2.判断用户名是否存在
        User u = mapper.selectByUsername(username);
        if(u == null){
            //用户名不存在,可以注册
            mapper.add(user);

            //提交事务
            sqlSession.commit();

            //释放资源
            sqlSession.close();
        }else {
            //用户名已存在,给出提示信息
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("用户名已存在");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
