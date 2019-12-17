package com.test;

import org.junit.Test;

import java.sql.*;

public class TestJDBC {
    @Test
    public void jdbc() throws Exception {
        //通过JDBC连接数据库
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
        String userName = "root";
        String passWord = "root";
        Connection conn =null;
        PreparedStatement preparedStatement=null;
        ResultSet rs = null;
        //1.加载驱动
        try {
            Class.forName(driver);
            //2.通过DriverManager 获得数据库连接
            conn = DriverManager.getConnection(url,userName,passWord);
            //3.获得statement 执行sql语句
            String sql = "select * from user where userName = ? and passWord = ?";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1,"adimin1");
            preparedStatement.setString(2,"admin1");

            boolean is = preparedStatement.execute();//true:执行结果包含结果集 false：执行的结果包含更新行数

            if(is){
                //4.执行SQL语句
                rs = preparedStatement.getResultSet();
                //5.获得结果集
                while (rs.next()){
                    int id = rs.getInt(1);
                    String name = rs.getString(2);
                    String pwd = rs.getString(3);
                    System.out.println(id+"\t"+name+"\t"+pwd);
                }
            }else {
                int updateCount = preparedStatement.getUpdateCount();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  finally {
            if (conn!=null){
                conn.close();
            }

            if (preparedStatement!=null){
                preparedStatement.close();
            }

            if (rs!=null){
                rs.close();
            }
        }


    }


}
