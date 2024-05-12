package com.cn.catering.service.impl;

import com.cn.catering.dto.MenuItemDto;
import com.cn.catering.model.Menu;
import com.cn.catering.model.MenuItem;
import com.cn.catering.repository.MenuItemRepository;
import com.cn.catering.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemServiceImpl  {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;



    public void createMenuItem(MenuItemDto menuItemDto) {
        Menu menu = menuRepository.findById(menuItemDto.getMenuId()).get();
        MenuItem menuItem = new MenuItem();
        menuItem.setName(menuItemDto.getName());
        menuItem.setDescription(menuItemDto.getDescription());
        menuItem.setNutrition(menuItemDto.getNutrition());
        menuItem.setMenu(menu);
        menuItem.setPrice(menuItemDto.getPrice());
        menuItemRepository.save(menuItem);
    }


    public MenuItem getMenuItem(int id) {
        return menuItemRepository.findById(id).get();
    }

}
