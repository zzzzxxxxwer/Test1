package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBC {
    /**
     * 获取数据库连接
     * @return
     */
    public static Connection StaticMethod() {
        String driverClassName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/sys?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
        String username = "root";
        String password = "1q2w3e!@#";
        Connection connection = null; //数据库连接对象
        try {
            Class.forName(driverClassName);//1加载驱动
            connection=  DriverManager.getConnection(url,username,password);//获取连接
        } catch (ClassNotFoundException e) {
            System.out.println("驱动加载异常");
        }catch (SQLException e) {
            System.out.println("数据库连接异常");
        }
        if (connection!=null){
            return connection;//返回连接对象
        }
        return null;
    }
}
