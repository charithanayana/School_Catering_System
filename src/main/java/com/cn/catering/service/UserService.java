package com.cn.catering.service;

import com.cn.catering.model.User;

public interface UserService {

    public User getUserByUserName(String userName);

    public User saveUser(User user);

}
