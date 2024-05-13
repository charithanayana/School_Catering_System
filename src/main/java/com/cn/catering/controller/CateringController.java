package com.cn.catering.controller;

import com.cn.catering.dto.CManagerDto;
import com.cn.catering.model.CateringManager;
import com.cn.catering.model.Consultant;
import com.cn.catering.model.StudentOrder;
import com.cn.catering.model.User;
import com.cn.catering.service.impl.CateringService;
import com.cn.catering.service.impl.UserServiceImpl;
import com.cn.catering.type.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/caterings")
@CrossOrigin
public class CateringController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private CateringService cateringService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void addCateringManager(@RequestBody CManagerDto cManagerDto) {
        User user = new User();
        user.setUserName(cManagerDto.getUserName());
        user.setPassword(passwordEncoder.encode(cManagerDto.getPassword()));
        user.setCreatedAt(new Date());
        user.setUserType(UserType.CATERING_ADMIN);
        userService.saveUser(user);
        cManagerDto.setUserId(user.getId());
        cateringService.saveCateringManager(cManagerDto);
    }

    @GetMapping
    public List<CateringManager> getConsultantList() {
        return cateringService.getAllConsultants();
    }

    @GetMapping(path = "/order/{date}")
    public List<StudentOrder> getOrdersByDate(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        System.out.println("Date : " + date);
        return cateringService.getOrdersByDate(date);
    }

}
