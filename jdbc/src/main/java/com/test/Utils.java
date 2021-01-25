package com.test;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
//jdbc工具类
public class Utils {
    //定义四大连接参数
    private static String url;
    private static String username;
    private static String password;
    private static String driver;
    //读取配置文件
    static {
        try {
            //创建Properties集合类。
            Properties prop = new Properties();
            //加载文件
            prop.load(Utils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            //获取数据，赋值
            url = prop.getProperty("url");
            username = prop.getProperty("username");
            password = prop.getProperty("password");
            driver = prop.getProperty("driver");
            //注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("加载驱动失败");
        }
    }
    //获取Connection连接对象
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    //释放资源
    public static void close(ResultSet resultSet, Connection connection, Statement statement) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                System.out.println("连接数据库失败");
            }
        }
        close(connection, statement);
    }
    //重载
    public static void close(Connection connection, Statement statement) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

