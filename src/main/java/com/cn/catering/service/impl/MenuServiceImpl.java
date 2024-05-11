package com.cn.catering.service.impl;

import com.cn.catering.model.Menu;
import com.cn.catering.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl {

    @Autowired
    private MenuRepository menuRepository;



    public void createMenu(Menu menu) {
        menuRepository.save(menu);
    }


    public Menu getMenuById(int id) {
        return menuRepository.findById(id).get();
    }

    public List<Menu> getMenus() {
        return menuRepository.findAll();
    }

}
