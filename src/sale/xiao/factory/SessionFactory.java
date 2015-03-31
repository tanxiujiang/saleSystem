package sale.xiao.factory;

import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @function 获取mybatis链接数据库session连接
 * @author Administrator
 * 
 */
public class SessionFactory {
    private final static String      resource          = "sale/xiao/config/mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory = null;



    /**
     * 
     * @return SqlSessionFactory
     */    public static SqlSessionFactory GetSqlSessionFactory() {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            System.err.println("加载数据配置文件失败,Error is " + e.getMessage());
        }

        if (null == sqlSessionFactory) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }

        return sqlSessionFactory;
    }
    
    
    public static SqlSessionFactory GetSqlSessionFactory(boolean isCreate) {
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            System.err.println("加载数据配置文件失败,Error is " + e.getMessage());
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        return sqlSessionFactory;
    }
}
