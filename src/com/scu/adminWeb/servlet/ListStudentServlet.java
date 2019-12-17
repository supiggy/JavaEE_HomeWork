package com.scu.adminWeb.servlet;

import com.scu.adminWeb.common.domain.Student;
import com.scu.adminWeb.common.utils.PageInfo;
import com.scu.adminWeb.service.StudentService;
import com.scu.adminWeb.service.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/listStudent")
public class ListStudentServlet extends HttpServlet {
    StudentService studentService = new StudentServiceImpl();
    protected  void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> allStudent = studentService.findAllStudent();
        String pageNoText = request.getParameter("pageNo");
        String pageSizeText = request.getParameter("pageSize");

        int pageNo = (pageNoText==null?1:Integer.parseInt(pageNoText));
        int pageSize = (pageSizeText==null?10:Integer.parseInt(pageSizeText));
        PageInfo<Student> pageInfo = studentService.findStudentByPage(pageNo, pageSize);

        //将数据交给jsp展示
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/views/list-student.jsp").forward(request,response);

    }
}
