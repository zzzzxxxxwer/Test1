package com.C3P0;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
public class JdbcUtils {
    private static DataSource dataSource = new ComboPooledDataSource();
    public static DataSource getDataSource() {
        return dataSource;
    }
    public static Connection getConnection() {
        try {
            return dataSource.getConnection();//获取连接
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void fun1() throws SQLException {
       QueryRunner qr = new QueryRunner();//创建 QueryRunner 构造器：QueryRunner();
        String sql = "insert into stu values(?,?,?)";
        qr.update(JdbcUtils.getConnection(), sql, "u1", "zhangSan", "123");//添加一行数据
    }
    @Test
    public void fun2() throws SQLException
    {   QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());//创建 QueryRunner 构造器：QueryRunner(DataSource)
        String sql = "insert into stu values(?,?,?)";
        qr.update(sql, "u2", "zxx", "456");//添加一行数据
    }
}

