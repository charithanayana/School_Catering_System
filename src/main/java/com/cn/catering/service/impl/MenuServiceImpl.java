package com.cn.catering.service.impl;

import com.cn.catering.model.Menu;
import com.cn.catering.repository.MenuRepository;
import com.cn.catering.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuRepository menuRepository;


    @Override
    public void createMenu(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public Menu getMenuById(int id) {
        return menuRepository.findById(id).get();
    }

    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }

}
