package com.scu.adminWeb.service;

import com.scu.adminWeb.common.domain.User;

public interface UserService {
    public User findUserByName(String name);
}
