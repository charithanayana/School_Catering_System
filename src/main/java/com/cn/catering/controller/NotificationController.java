package com.cn.catering.controller;

import com.cn.catering.model.NotificationUser;
import com.cn.catering.service.impl.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/notifications")
@CrossOrigin
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping(value = "/{userId}")
    public List<NotificationUser> getNotifications(@PathVariable("userId")  int userId) {
        return notificationService.getNotifications(userId);
    }

}
