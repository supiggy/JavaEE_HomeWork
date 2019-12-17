package com.scu.adminWeb.service;

import com.scu.adminWeb.common.domain.Student;
import com.scu.adminWeb.common.utils.PageInfo;

import java.util.List;

public interface StudentService {

    public List<Student> findAllStudent();
    public PageInfo<Student> findStudentByPage(int pageNo, int pageSize);

}
