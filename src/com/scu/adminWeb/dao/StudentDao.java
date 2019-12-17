package com.scu.adminWeb.dao;

import com.scu.adminWeb.common.domain.Student;
import com.scu.adminWeb.common.utils.PageInfo;

import java.util.List;

public interface StudentDao {
    List<Student> selectAllStudent();

    PageInfo<Student> selectStudentByPage(int pageNo, int pageSize);
}
