package DAO;


import UTILS.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;


import java.sql.Connection;
import java.sql.SQLException;

//DAO底层的抽象操作类用于给数据库不同table继承获得自己的DAO
public abstract class BaseDAO {
    //DBUtils的工具类有Apache提供操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    //用于对数据库的增删改操作,返回修改的数据行数
    public int update(String sql , Object ... args){
        Connection connection = null;
        try {
            //从数据库连接池获得连接
            connection = JDBCUtils.getConnection();
            return queryRunner.update(connection , sql , args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            //关闭数据库
            JDBCUtils.close(connection);
        }
        return -1;
    }
    //查找数据库中的一行数据
    public <T> T queryOne(Class<T> type , String sql , Object ... args){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
