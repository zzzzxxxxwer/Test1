package com.test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class Test {
    @org.junit.Test
        public void function() throws Exception{    //function()方法抛出异常
        Class.forName("com.mysql.cj.jdbc.Driver");//1加载驱动
        String url="jdbc:mysql://localhost:3306/sys?serverTimezone=GMT%2B8&characterEncoding=utf-8&useSSL=FALSE";
        String username="root";
        String password="1q2w3e!@#";
        Connection connection= DriverManager.getConnection(url, username,password);
        Statement stmt=connection.createStatement();
        ResultSet rs=stmt.executeQuery("select * from stu");
        while (rs.next()){
            String empno=rs.getString(1);
            String ename2=rs.getString("name");
            String ename=rs.getString("age");
            String sal=rs.getString("male");
            System.out.println(empno+","+ename2+","+ename+","+sal);
        }
    }
}
