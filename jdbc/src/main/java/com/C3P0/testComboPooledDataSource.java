package com.C3P0;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
public class testComboPooledDataSource {
    @Test
    public void fun1() throws PropertyVetoException,SQLException{
       ComboPooledDataSource ds = new ComboPooledDataSource();
       ds.setJdbcUrl("jdbc:mysql://localhost:3306/sys?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE");
       ds.setUser("root");//连接数据库的参数
       ds.setPassword("1q2w3e!@#");
       ds.setDriverClass("com.jdbc.Driver");
 /*       ds.setMaxPoolSize(20);
        ds.setMaxIdleTime(10);
        ds.setInitialPoolSize(10);
        ds.setMinIdle(2);
        ds.setMaxWait(1000);//连接池参数默认值*/
        Connection con=ds.getConnection();
        System.out.println(con);
        con.close();
    }
    @Test
    public void fun2() throws PropertyVetoException,SQLException{
        ComboPooledDataSource ds=new ComboPooledDataSource();//创建对象
     Connection  con=ds.getConnection();
        System.out.println(con);
        con.close();//释放资源
    }
    @Test
    public void fun3() throws PropertyVetoException, SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource("orcale-config");//创建对象
        Connection con = ds.getConnection();
        System.out.println(con);
        con.close();//释放资源
    }
}
