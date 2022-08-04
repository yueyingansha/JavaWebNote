package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 描述: SqlSessionFactory的创建: 代码重复且浪费资源
 * sqlSession对象代表用户和数据库的链接,不能被提取到工具类
 * (如果这么做,所有用户和所有功能都会共用一个链接,使其相互影响)
 */
public class SQLSFUtil {
    private static SqlSessionFactory s;
static{

    try {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        inputStream = Resources.getResourceAsStream(resource);
        s = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        return s;
    }
    int a = 1;

}
