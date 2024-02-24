package com.cn.catering.controller;

import com.cn.catering.model.Menu;
import com.cn.catering.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/menus")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Menu getMenu(@PathVariable("id") int id) {
        return menuService.getMenu(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addMenu(@RequestBody Menu menu) {
        menuService.createMenu(menu);
    }

}
