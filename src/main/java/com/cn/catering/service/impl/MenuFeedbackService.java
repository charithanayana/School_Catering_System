package com.cn.catering.service.impl;

import com.cn.catering.dto.MenuFeedbackDto;
import com.cn.catering.model.Guardian;
import com.cn.catering.model.Menu;
import com.cn.catering.model.MenuFeedback;
import com.cn.catering.repository.MenuFeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MenuFeedbackService {

    @Autowired
    private MenuFeedbackRepository feedbackRepository;

    public void addFeedback(MenuFeedbackDto feedbackDto) {
        MenuFeedback feedback = new MenuFeedback();
        feedback.setFeedback(feedbackDto.getFeedback());
        feedback.setMenu(new Menu(feedbackDto.getMenuId()));
        feedback.setGuardian(new Guardian(feedbackDto.getGuardianId()));
        feedback.setDate(new Date());
        feedbackRepository.save(feedback);
    }

    public List<MenuFeedback> getFeedbackByMenuId(int menuId) {
        return feedbackRepository.findByMenuId(menuId);
    }

}
