package com.charitha.schoolcateringservice.controller;

import com.charitha.schoolcateringservice.dto.ParentDto;
import com.charitha.schoolcateringservice.model.Guardian;
import com.charitha.schoolcateringservice.service.GuardianService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guardian")
public class GuardianController {
    private final GuardianService guardianService;

    public GuardianController(GuardianService parentService) {
        this.guardianService = parentService;
    }

    @GetMapping(value = "/{id}")
    public Guardian getParent(@PathVariable("id") int id) {
        Guardian guardian = guardianService.getGuardian(id);
        return guardian;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void addParent(@RequestBody ParentDto parentDto) {
        guardianService.createGuardian(parentDto);
    }
}
