package com.cn.catering.service.impl;

import com.cn.catering.model.CateringManager;
import com.cn.catering.model.Consultant;
import com.cn.catering.model.Guardian;
import com.cn.catering.model.User;
import com.cn.catering.repository.CateringRepository;
import com.cn.catering.repository.ConsultantRepository;
import com.cn.catering.repository.GuardianRepository;
import com.cn.catering.repository.UserRepository;
import com.cn.catering.type.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GuardianRepository guardianRepository;

    @Autowired
    private ConsultantRepository consultantRepository;

    @Autowired
    private CateringRepository cateringRepository;


    public User getUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public int getUserIdByUserTypeAndId(UserType userType, Integer id) throws IllegalArgumentException {
        if (UserType.GUARDIAN.equals(userType)) {
            Guardian guardian = guardianRepository.findByUserId(id);
            return guardian.getId();
        } else if (UserType.CONSULTANT.equals(userType)) {
            Consultant consultant = consultantRepository.findByUserId(id);
            return consultant.getId();
        } else if (UserType.CATERING_ADMIN.equals(userType)) {
            CateringManager cateringManager = cateringRepository.findByUserId(id);
            return cateringManager.getId();
        }
        throw new IllegalArgumentException("No user type matched: " + userType.toString());
    }

}
