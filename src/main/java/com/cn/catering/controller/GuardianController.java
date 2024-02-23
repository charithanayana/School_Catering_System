package com.cn.catering.controller;

import com.cn.catering.dto.GuardianDto;
import com.cn.catering.model.Guardian;
import com.cn.catering.service.GuardianService;
import com.cn.catering.service.impl.GuardianServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guardians")
public class GuardianController {

    @Autowired
    private GuardianService guardianService;

    @GetMapping(value = "/{id}")
    public Guardian getParent(@PathVariable("id") int id) {
        Guardian guardian = guardianService.getGuardian(id);
        return guardian;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void addParent(@RequestBody GuardianDto parentDto) {
        guardianService.createGuardian(parentDto);
    }
}
