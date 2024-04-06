package com.cn.catering.service;

import com.cn.catering.model.Menu;

import java.util.List;

public interface MenuService {

    public void createMenu(Menu menu);
    public Menu getMenuById(int id);

    public List<Menu> getMenus();

}
