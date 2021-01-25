package com.test;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class TestJDBC {
    @Test
    public void test() throws Exception{
        //3生成发送器
        //4执行
        //5释放资源
        Class.forName("com.mysql.cj.jdbc.Driver");//1加载驱动
        String url="jdbc:mysql://localhost:3306/sys?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
        String username="root";
        String password="1q2w3e!@#";
        Connection connection= DriverManager.getConnection(url,username,password);//2获取连接
        Statement statement=connection.createStatement();
        System.out.println(connection);
//        String sql="delete FROM sys_config";
//        String sql = "INSERT INTO stu(name,age,male) VALUES('zxcv','78','10')";
        String sql2 = "INSERT INTO stu(name,age,male) VALUES ('zzz','20','7')";
       String sql3 = "UPDATE stu SET name='zhaoLiu', " +
                "age=22' WHERE male='5'";
//        int row = statement.executeUpdate(sql);
        int row1 = statement.executeUpdate(sql2);
        System.out.println(row1);
    }
/*    public void function() throws Exception{    //function()方法抛出异常
        Class.forName("com.mysql.cj.jdbc.Driver");//1加载驱动
        String url="jdbc:mysql://localhost:3306/sys?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
        String username="root";
        String password="1q2w3e!@#";
        Connection connection= DriverManager.getConnection(url, username,password);
        Statement stmt=connection.createStatement();
        ResultSet rs=stmt.executeQuery("select * from sys_config");
    }*/
}
