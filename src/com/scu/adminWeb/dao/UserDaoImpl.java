package com.scu.adminWeb.dao;

import com.scu.adminWeb.common.utils.DbUtil;
import com.scu.adminWeb.common.domain.User;
import com.scu.adminWeb.common.utils.MyDbUtil;

import java.sql.*;
import java.util.List;

public class UserDaoImpl implements UserDao {


    @Override
    public User selectUserByName(String name) {
        String sql = " select id, userName, passWord from user where userName = ? ";
        List<User> users = MyDbUtil.executeQuery(User.class, sql, name);
//        Connection conn = DbUtil.getConnection();
////        try {
////            Class.forName("com.mysql.jdbc.Driver");
////            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8","root","root");
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//
//        User user = null;
//        ResultSet rs  = null;
//        PreparedStatement preparedStatement  = null;
//        String sql = " select id, userName, passWord from user where userName = ? ";
//        try {
//            preparedStatement = conn.prepareStatement(sql);
//            preparedStatement.setString(1,name);
//            if (preparedStatement.execute()){
//                rs = preparedStatement.getResultSet();
//                while (rs.next()){
//                    int id = rs.getInt("id");
//                    String n = rs.getString("userName");
//                    String p = rs.getString("passWord");
//                    user = new User().setId(id).setName(n).setPassWord(p);
//                    break;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            if (conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//
//                }
//            }
//
//            if (preparedStatement!=null){
//                try {
//                    preparedStatement.close();
//                } catch (SQLException e) {
//
//                }
//            }
//
//            if (rs!=null){
//                try {
//                    rs.close();
//                } catch (SQLException e) {
//
//                }
//            }
//        }
        return (users.size()>0?users.get(0):null);
    }
}
