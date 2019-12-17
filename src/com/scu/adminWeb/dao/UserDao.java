package com.scu.adminWeb.dao;

import com.scu.adminWeb.common.domain.User;

public interface UserDao {

    public User selectUserByName(String name);
}
