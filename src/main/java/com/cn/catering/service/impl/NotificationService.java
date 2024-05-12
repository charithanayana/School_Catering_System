package com.cn.catering.service.impl;

import com.cn.catering.model.NotificationUser;
import com.cn.catering.repository.NotificationRepository;
import com.cn.catering.repository.NotificationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationUserRepository notificationUserRepository;

    public List<NotificationUser> getNotifications(int userId) {
        return notificationUserRepository.findByUserId(userId);
    }
}
