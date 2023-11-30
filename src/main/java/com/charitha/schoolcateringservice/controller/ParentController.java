package com.charitha.schoolcateringservice.controller;

import com.charitha.schoolcateringservice.dto.ParentDto;
import com.charitha.schoolcateringservice.model.Parent;
import com.charitha.schoolcateringservice.service.ParentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/parents")
public class ParentController {
    private final ParentService parentService;

    public ParentController(ParentService parentService) {
        this.parentService = parentService;
    }

    @GetMapping(value = "/{id}")
    public Parent getParent(@PathVariable("id") int id) {
        Parent parent = parentService.getParent(id);
        return parent;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void addParent(@RequestBody ParentDto parentDto) {
        parentService.createParent(parentDto);
    }
}
