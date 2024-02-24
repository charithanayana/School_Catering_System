package com.cn.catering.service.impl;

import com.cn.catering.dto.MenuItemDto;
import com.cn.catering.model.Menu;
import com.cn.catering.model.MenuItem;
import com.cn.catering.repository.MenuItemRepository;
import com.cn.catering.repository.MenuRepository;
import com.cn.catering.service.MenuItemService;
import com.cn.catering.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private MenuItemRepository menuItemRepository;


    @Override
    public void createMenuItem(MenuItemDto menuItemDto) {
        Menu menu = menuRepository.findById(menuItemDto.getMenuId()).get();
        MenuItem menuItem = new MenuItem();
        menuItem.setName(menuItemDto.getName());
        menuItem.setDescription(menuItemDto.getDescription());
        menuItem.setNutrition(menuItemDto.getNutrition());
        menuItem.setMenu(menu);
        menuItemRepository.save(menuItem);
    }

    @Override
    public MenuItem getMenuItem(int id) {
        return menuItemRepository.findById(id).get();
    }

}
