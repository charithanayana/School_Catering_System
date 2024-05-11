package com.cn.catering.controller;

import com.cn.catering.dto.*;
import com.cn.catering.model.Student;
import com.cn.catering.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/students")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
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

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(consumes = "application/json", value = "measure")
    public void addStudentMeasure(@RequestBody StudentMeasureDto studentMeasureDto) {
        studentService.saveStudentMeasure(studentMeasureDto);
    }

    @GetMapping(value = "/report/{id}")
    @ResponseBody
    public List<StudentBmi> getBmiDetails(@PathVariable("id") int studentId) {
        return studentService.getStudentMeasures(studentId);
    }

}
