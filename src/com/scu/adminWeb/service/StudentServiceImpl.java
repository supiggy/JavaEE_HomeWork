package com.scu.adminWeb.service;

import com.scu.adminWeb.common.domain.Student;
import com.scu.adminWeb.common.utils.CountObject;
import com.scu.adminWeb.common.utils.MyDbUtil;
import com.scu.adminWeb.common.utils.PageInfo;
import com.scu.adminWeb.dao.StudentDao;
import com.scu.adminWeb.dao.StudentDaoImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    StudentDao studentDao = new StudentDaoImpl();
    @Override
    public List<Student> findAllStudent() {
        return studentDao.selectAllStudent();
    }

    @Override
    public PageInfo<Student> findStudentByPage(int pageNo, int pageSize) {
//        PageInfo<Student> rs = null;
////                new PageInfo<>(pageNo,pageSize,?,?);
//        String sql1 = " select count(*) 'count' from student ";
//        String sql2 = " select id,name,stuNo,sex from student limit ?,? ";
//
//        List<CountObject> countObjects = MyDbUtil.executeQuery(CountObject.class, sql1);
//        int count = countObjects.get(0).getCount();
//        List<Student> students = MyDbUtil.executeQuery(Student.class, sql2, (pageNo - 1) * pageSize, pageSize);
//
//
//        rs = new PageInfo<Student>(pageNo,pageSize,count,students);
        return studentDao.selectStudentByPage(pageNo,pageSize);
    }
}
