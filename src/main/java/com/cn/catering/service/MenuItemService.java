package com.cn.catering.service;

import com.cn.catering.dto.MenuItemDto;
import com.cn.catering.model.Menu;
import com.cn.catering.model.MenuItem;

public interface MenuItemService {

    public void createMenuItem(MenuItemDto menuItemDto);
    public MenuItem getMenuItem(int id);

}
