package com.cn.catering.service.impl;

import com.cn.catering.model.User;
import com.cn.catering.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  {

    @Autowired
    private UserRepository userRepository;


    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    
    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
