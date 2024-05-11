package com.cn.catering.controller;

import com.cn.catering.dto.MenuItemDto;
import com.cn.catering.model.MenuItem;
import com.cn.catering.service.impl.MenuItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/menuitems")
public class MenuItemController {

    @Autowired
    private MenuItemServiceImpl menuItemService;

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MenuItem getMenu(@PathVariable("id") int id) {
        return menuItemService.getMenuItem(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addMenu(@RequestBody MenuItemDto menuItemDto) {
        menuItemService.createMenuItem(menuItemDto);
    }

}
