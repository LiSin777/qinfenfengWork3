package UTILS;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


public class JDBCUtils {
    //创建德鲁伊数据库连接池
    private static DruidDataSource dataSource;

    static {
        try {
            Properties properties = new Properties();
            // 读取 jdbc.properties属性配置文件
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");

            //TomCat有自己的类加载器,class文件会加载到内部加载器，直接从系统类加载器无法获得流
            //InputStream is2 = ClassLoader.getSystemResourceAsStream("jdbc.properties");

            // 从流中加载数据
            properties.load(is);
            // 创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //获取连接
    public static Connection getConnection(){

        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    //关闭连接
    public static void close(Connection conn){
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
