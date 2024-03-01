package com.cn.catering.controller;

import com.cn.catering.dto.GuardianDto;
import com.cn.catering.model.Guardian;
import com.cn.catering.model.User;
import com.cn.catering.service.GuardianService;
import com.cn.catering.service.UserService;
import com.cn.catering.service.impl.GuardianServiceImpl;
import com.cn.catering.type.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping(value = "/guardians")
@CrossOrigin
public class GuardianController {

    @Autowired
    private GuardianService guardianService;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping(value = "/{id}")
    public Guardian getParent(@PathVariable("id") int id) {
        return guardianService.getGuardian(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void addGuardian(@RequestBody GuardianDto guardianDto) {
        User user = new User();
        user.setUserName(guardianDto.getUserName());
        user.setPassword(passwordEncoder.encode(guardianDto.getPassword()));
        user.setCreatedAt(new Date());
        user.setUserType(UserType.GUARDIAN);
        guardianService.createGuardian(guardianDto);
        userService.saveUser(user);
    }
}
