package com.cn.catering.service.impl;

import com.cn.catering.dto.MenuFeedbackDto;
import com.cn.catering.model.*;
import com.cn.catering.repository.*;
import com.cn.catering.type.UserType;
import com.cn.catering.util.NotificationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenuFeedbackService {

    @Autowired
    private MenuFeedbackRepository feedbackRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationUserRepository notificationUserRepository;

    @Autowired
    private GuardianRepository guardianRepository;

    public void addFeedback(MenuFeedbackDto feedbackDto) {
        Integer guardianId = feedbackDto.getGuardianId();
        Guardian guardian = guardianRepository.findById(guardianId).get();
        MenuFeedback feedback = new MenuFeedback();
        feedback.setFeedback(feedbackDto.getFeedback());
        feedback.setMenu(new Menu(feedbackDto.getMenuId()));
        feedback.setGuardian(guardian);
        feedback.setDate(new Date());
        feedbackRepository.save(feedback);
        sendNotification(feedbackDto.getFeedback(), guardian.getUser());
    }

    public List<MenuFeedback> getFeedbackByMenuId(int menuId) {
        return feedbackRepository.findByMenuId(menuId);
    }

    private void sendNotification(String message, User user) {
        Notification notification = new Notification();
        notification.setTitle(NotificationUtils.MENU_FEEDBACK_NOTIFICATION_TITLE);
        notification.setSender(user);
        notification.setMessage(message);
        notification.setDate(new Date());
        notificationRepository.save(notification);

        sendNotificationUsers(notification, UserType.CATERING_ADMIN);
        sendNotificationUsers(notification, UserType.ADMIN);
    }

    private void sendNotificationUsers(Notification notification, UserType userType) {
        List<User> users = userRepository.findByUserType(userType);
        for (User user : users) {
            NotificationUser notificationUser = new NotificationUser();
            notificationUser.setNotification(notification);
            notificationUser.setRead(false);
            notificationUser.setUser(user);
            notificationUserRepository.save(notificationUser);
        }
    }

}
