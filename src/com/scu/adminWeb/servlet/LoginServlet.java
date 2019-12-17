package com.scu.adminWeb.servlet;


import com.scu.adminWeb.dao.UserDao;
import com.scu.adminWeb.dao.UserDaoImpl;
import com.scu.adminWeb.common.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserDao userDao = new UserDaoImpl();
    protected  void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");

        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");

        User userInDb = userDao.selectUserByName(userName);
        if(userInDb == null){
            request.setAttribute("msg","用户不存在！");
            request.getRequestDispatcher("/views/login.jsp").forward(request,response);
        }else {
            String pwdDB = userInDb.getPassWord();
            if (pwdDB.equals(passWord)){
                //Ok
                request.setAttribute("currentUserName",userName);
                request.getRequestDispatcher("/views/starter.jsp").forward(request,response);
            }else {
                request.setAttribute("msg","密码错误！");
                request.getRequestDispatcher("/views/login.jsp").forward(request,response);
            }
        }


    }
}
