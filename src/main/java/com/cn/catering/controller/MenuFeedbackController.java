package com.cn.catering.controller;

import com.cn.catering.dto.MenuFeedbackDto;
import com.cn.catering.model.Menu;
import com.cn.catering.model.MenuFeedback;
import com.cn.catering.service.impl.MenuFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/feedbacks")
@CrossOrigin
public class MenuFeedbackController {

    @Autowired
    private MenuFeedbackService feedbackService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void addMenuFeedback(@RequestBody MenuFeedbackDto feedbackDto) {
        feedbackService.addFeedback(feedbackDto);
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public List<MenuFeedback> getFeedbackByMenuId(@PathVariable("id") int id) {
        return feedbackService.getFeedbackByMenuId(id);
    }

}
