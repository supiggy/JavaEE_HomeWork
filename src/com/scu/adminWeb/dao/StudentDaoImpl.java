package com.scu.adminWeb.dao;

import com.scu.adminWeb.common.domain.Student;
import com.scu.adminWeb.common.utils.CountObject;
import com.scu.adminWeb.common.utils.MyDbUtil;
import com.scu.adminWeb.common.utils.PageInfo;

import java.sql.Connection;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> selectAllStudent() {
        String sql = " SELECT id,name,stuNo,sex FROM student ";
        List<Student> studentList = MyDbUtil.executeQuery(Student.class, sql);
        return studentList;
    }

    @Override
    public PageInfo<Student> selectStudentByPage(int pageNo, int pageSize) {

        Connection connection = MyDbUtil.getConnection();
        PageInfo<Student> rs = null;
//                new PageInfo<>(pageNo,pageSize,?,?);
        String sql1 = " select count(*) 'count' from student ";
        String sql2 = " select id,name,stuNo,sex from student limit ?,? ";

        List<CountObject> countObjects = MyDbUtil.executeQuery(connection,CountObject.class, sql1);
        int count = (int) countObjects.get(0).getCount();
        List<Student> students = MyDbUtil.executeQuery(connection,Student.class, sql2, (pageNo - 1) * pageSize, pageSize);


        rs = new PageInfo<Student>(pageNo,pageSize,count,students);
        MyDbUtil.closeConnection();
        return rs;
    }
}
