package com.cn.catering.controller;

import com.cn.catering.model.Consultant;
import com.cn.catering.model.ConsultantSchedule;
import com.cn.catering.service.impl.ConsultantScheduleService;
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

    @GetMapping(value = "/consultant")
    public void generateConsultantSchedule(
            @RequestParam(value = "date", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
        date = date != null ? date : new Date();
        consultantScheduleService.saveConsultantSchedule(date);
    }

    @GetMapping(value = "/consultant/{consultantId}")
    public List<ConsultantSchedule> getAllSchedules(
            @PathVariable("consultantId") int consultantId,
            @RequestParam(value = "status", required = false) ConsultationStatus status) {
        status = status != null ? status : ConsultationStatus.PENDING;
        Consultant consultant = new Consultant(consultantId);
        return consultantScheduleService.getSchedulesByConsultantIdAndStatus(status, consultant);
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
