package com.scu.adminWeb.service;

import com.scu.adminWeb.dao.UserDao;
import com.scu.adminWeb.dao.UserDaoImpl;
import com.scu.adminWeb.common.domain.User;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public User findUserByName(String name) {
        return userDao.selectUserByName(name);
    }
}
