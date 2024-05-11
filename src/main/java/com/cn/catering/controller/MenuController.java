package com.cn.catering.controller;

import com.cn.catering.model.Menu;
import com.cn.catering.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/menus")
public class MenuController {

    @Autowired
    private MenuServiceImpl menuService;

    @GetMapping
    public List<Menu> getMenu() {
        return menuService.getMenus();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Menu getMenuById(@PathVariable("id") int id) {
        return menuService.getMenuById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addMenu(@RequestBody Menu menu) {
        menuService.createMenu(menu);
    }

}
