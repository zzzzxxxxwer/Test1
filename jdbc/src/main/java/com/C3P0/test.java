package com.C3P0;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
public class test {
    @Test
    public void fun1() throws SQLException
    {   DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select * from stu where name=?";
        Map<String,Object> map = qr.query(sql, new MapHandler(), "qqq");   System.out.println(map);
        //MapHandler：单行处理器！把结果集转换成 Map<String,Object>，其中列名为键。
    }
    @Test
    public void fun2() throws SQLException {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select * from stu";
        List<Map<String,Object>> list = qr.query(sql, new MapListHandler());
        //MapListHandler：多行处理器！把结果集转换成 List<Map<String,Object>>；
        for(Map<String,Object> map : list)
        {
            System.out.println(map);
        }  }
    @Test
    public void fun3() throws SQLException
    {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select * from stu where name=?";
        Student stu = qr.query(sql, new BeanHandler<Student>(Student.class), "qqq");
        // BeanHandler：单行处理器，
        // 把结果集转换成 Bean，该处理器需要 Class 参数，即 Bean：Student类的类 型；
        System.out.println(stu);
    }
    @Test
    public void fun4() throws SQLException
    {   DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select * from stu";
        List<Student> list = qr.query(sql, new BeanListHandler<Student>(Student.class));
        //BeanListHandler：多行处理器，把结果集转换成 List<Bean>；
        for(Student stu : list)
        {    System.out.println(stu);
        }  }
    @Test
    public void fun5() throws SQLException {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select * from stu";
        Object list = qr.query(sql, new ColumnListHandler("name"));
        //ColumnListHandler：多行单列处理器,把结果集转换成 List<Object>，使用 ColumnListHandler 时需要指定某一列的名称或编号，
       /* for(Object s : list) {
            System.out.println(s);
        }*/
    }
    @Test
    public void fun6() throws SQLException {
        DataSource ds = JdbcUtils.getDataSource();
        QueryRunner qr = new QueryRunner(ds);
        String sql = "select count(*) from stu";
        Number number = (Number)qr.query(sql, new ScalarHandler());
        //ScalarHandler：单行单列处理器，把结果集转换成 Object。一般用于聚集查询，例如 select count(*) from tab_student。
        int cnt = number.intValue();
        System.out.println(cnt);
    }
}
