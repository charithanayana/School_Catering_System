package com.cn.catering.controller;

import com.cn.catering.model.Consultant;
import com.cn.catering.model.ConsultantSchedule;
import com.cn.catering.model.Guardian;
import com.cn.catering.model.Student;
import com.cn.catering.service.impl.ConsultantScheduleService;
import com.cn.catering.service.impl.ConsultantService;
import com.cn.catering.service.impl.GuardianServiceImpl;
import com.cn.catering.type.ConsultationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/schedules")
@CrossOrigin
public class ConsultantScheduleController {

    @Autowired
    private ConsultantScheduleService consultantScheduleService;

    @GetMapping(value = "consultant/{date}")
    public void generateConsultantSchedule(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        consultantScheduleService.saveConsultantSchedule(date);
    }

    @GetMapping
    public List<ConsultantSchedule> getAllSchedules(@RequestParam(value = "status", required = false) ConsultationStatus status) {
        status = status != null ? status : ConsultationStatus.PENDING;
        return consultantScheduleService.getAllConsultantSchedules(status);
    }

    @GetMapping(value = "/{scheduleId}")
    public ConsultantSchedule getScheduleById(@PathVariable("scheduleId") int scheduleId) {
        return consultantScheduleService.getScheduleById(scheduleId);
    }

    @PutMapping(value = "/{scheduleId}")
    public void updateConsultantSchedule(
            @PathVariable("scheduleId") int scheduleId,
            @RequestBody String conclusion) {
        consultantScheduleService.updateConsultantSchedule(scheduleId, conclusion);
    }

}
