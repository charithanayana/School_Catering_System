package com.cn.catering.controller;

import com.cn.catering.dto.ConsultantDto;
import com.cn.catering.model.Consultant;
import com.cn.catering.model.Guardian;
import com.cn.catering.model.User;
import com.cn.catering.service.impl.ConsultantService;
import com.cn.catering.service.impl.UserServiceImpl;
import com.cn.catering.type.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/consultants")
@CrossOrigin
public class ConsultantController {

    @Autowired
    private ConsultantService consultantService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserServiceImpl userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void addConsultant(@RequestBody ConsultantDto consultantDto) {
        User user = new User();
        user.setUserName(consultantDto.getUserName());
        user.setPassword(passwordEncoder.encode(consultantDto.getPassword()));
        user.setCreatedAt(new Date());
        user.setUserType(UserType.CONSULTANT);
        consultantService.saveConsultant(consultantDto);
        userService.saveUser(user);
    }

    @GetMapping
    public List<Consultant> getGuardingList() {
        return consultantService.getAllConsultants();
    }

}
