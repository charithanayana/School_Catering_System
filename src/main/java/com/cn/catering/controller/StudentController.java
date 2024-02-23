package com.cn.catering.controller;

import com.cn.catering.dto.GuardianDto;
import com.cn.catering.dto.StudentDto;
import com.cn.catering.model.Guardian;
import com.cn.catering.model.Student;
import com.cn.catering.service.StudentService;
import com.cn.catering.service.impl.GuardianServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @GetMapping(value = "/guardian/{id}")
    public List<Student> getStudentsByGuardianId(@PathVariable("id") int guardianId) {
        return studentService.getStudentsByGuardianId(guardianId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public void addStudent(@RequestBody StudentDto studentDto) {
        studentService.createStudent(studentDto);
    }

}
