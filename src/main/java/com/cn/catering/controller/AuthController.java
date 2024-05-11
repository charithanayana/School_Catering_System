package com.cn.catering.controller;

import com.cn.catering.dto.AuthDto;
import com.cn.catering.exception.AuthException;
import com.cn.catering.exception.NotFoundException;
import com.cn.catering.model.User;
import com.cn.catering.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping(value = "/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    public AuthDto auth(@RequestBody AuthDto authDto) throws NotFoundException, AuthException {
        User user = userService.getUserByUserName(authDto.getUserName());
        if (user == null) {
            throw new NotFoundException("Login user not found");
        }
        if (!passwordEncoder.matches(authDto.getPassword(), user.getPassword())) {
            throw new AuthException("Authentication Failed");
        }
        String rowStr = authDto.getUserName() + ":" + authDto.getPassword();
        byte[] base64ArrByte = Base64.getEncoder().encode(rowStr.getBytes());
        String base64Str = new String(base64ArrByte);
        authDto.setUserId(user.getId());
        authDto.setToken(base64Str);
        authDto.setUserType(user.getUserType());
        authDto.setPassword(null);
        return ResponseEntity.status(HttpStatus.OK).body(authDto).getBody();
    }
}
