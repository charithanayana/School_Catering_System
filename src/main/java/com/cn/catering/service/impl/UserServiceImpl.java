package com.cn.catering.service.impl;

import com.cn.catering.dto.MenuItemDto;
import com.cn.catering.model.Menu;
import com.cn.catering.model.MenuItem;
import com.cn.catering.model.User;
import com.cn.catering.repository.MenuItemRepository;
import com.cn.catering.repository.MenuRepository;
import com.cn.catering.repository.UserRepository;
import com.cn.catering.service.MenuItemService;
import com.cn.catering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

}
