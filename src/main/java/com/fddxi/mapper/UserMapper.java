package com.fddxi.mapper;

import com.fddxi.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * 描述:
 */
public interface UserMapper {
    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Select("select * from tb_user where username = #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(String username);

    /**
     * 新用户注册
     * @param user
     */
    @Insert("insert into tb_user values (null,#{username}, #{password})")
    void add(User user);
}
