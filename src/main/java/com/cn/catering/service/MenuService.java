package com.cn.catering.service;

import com.cn.catering.model.Menu;

public interface MenuService {

    public void createMenu(Menu menu);
    public Menu getMenu(int id);

}
