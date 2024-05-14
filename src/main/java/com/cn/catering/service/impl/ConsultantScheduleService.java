package com.cn.catering.service.impl;

import com.cn.catering.model.*;
import com.cn.catering.repository.*;
import com.cn.catering.type.ConsultationStatus;
import com.cn.catering.type.UserType;
import com.cn.catering.util.NotificationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConsultantScheduleService {

    @Autowired
    private ConsultantRepository consultantRepository;

    @Autowired
    private GuardianRepository guardianRepository;

    @Autowired
    private ConsultantScheduleRepository consultantScheduleRepository;

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private NotificationUserRepository notificationUserRepository;

    @Autowired
    private UserRepository userRepository;

    public void saveConsultantSchedule(Date date) {
        List<Consultant> consultants = consultantRepository.findAll();
        int consultantCount = consultants.size();
        if (consultantCount == 0) {
            return;
        }
        List<Guardian> guardians = guardianRepository.findAll();
        for (int i = 0; i < guardians.size(); i++) {
            int ind = i % consultantCount;
            Consultant consultant = consultants.get(ind);
            for (Student student : guardians.get(i).getStudents()) {
                ConsultantSchedule consultantSchedule = new ConsultantSchedule();
                consultantSchedule.setStudent(student);
                consultantSchedule.setConsultant(consultant);
                consultantSchedule.setDate(date);
                consultantSchedule.setStatus(ConsultationStatus.PENDING);
                consultantScheduleRepository.save(consultantSchedule);
            }
        }
    }

    public List<ConsultantSchedule> getSchedulesByConsultantIdAndStatus(ConsultationStatus status, Consultant consultant) {
        return consultantScheduleRepository.findByStatusAndConsultant(status, consultant);
    }

    public ConsultantSchedule getScheduleById(int scheduleId) {
        return consultantScheduleRepository.findById(scheduleId).get();
    }

    public void updateConsultantSchedule(int scheduleId, String conclusion) {
        ConsultantSchedule consultantSchedule = consultantScheduleRepository.findById(scheduleId).get();
        consultantSchedule.setConclusion(conclusion);
        consultantSchedule.setStatus(ConsultationStatus.DONE);
        consultantScheduleRepository.save(consultantSchedule);
        sendConsultantNotification(consultantSchedule.getConsultant().getUser(),
                consultantSchedule.getStudent().getGuardian().getUser(), conclusion);
    }

    private void sendConsultantNotification(User consultant, User guardian, String conclusion) {
        Notification notification = new Notification();
        notification.setTitle(NotificationUtils.CONSULTANT_FEEDBACK_NOTIFICATION_TITLE);
        notification.setSender(consultant);
        notification.setMessage(conclusion);
        notification.setDate(new Date());
        notificationRepository.save(notification);

        sendNotificationUsers(notification, UserType.CATERING_ADMIN);
        sendNotificationUsers(notification, UserType.ADMIN);
        sendGuardianNotification(notification, guardian);
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

    private void sendGuardianNotification(Notification notification, User guardian) {
        NotificationUser notificationUser = new NotificationUser();
        notificationUser.setNotification(notification);
        notificationUser.setRead(false);
        notificationUser.setUser(guardian);
        notificationUserRepository.save(notificationUser);
    }

}
