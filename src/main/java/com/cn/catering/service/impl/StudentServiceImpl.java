package com.cn.catering.service.impl;

import com.cn.catering.dto.StudentBmi;
import com.cn.catering.dto.StudentDto;
import com.cn.catering.dto.StudentMeasureDto;
import com.cn.catering.model.*;
import com.cn.catering.repository.*;
import com.cn.catering.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StudentServiceImpl {

    @Autowired
    private GuardianRepository guardianRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentMeasureRepository studentMeasureRepository;

    @Autowired
    private StudentOrderRepository studentOrderRepository;

    @Autowired
    private MenuRepository menuRepository;

    public void createStudent(StudentDto studentDto) {
        Guardian guardian = guardianRepository.findById(studentDto.getGuardianId()).get();
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setIndexNumber(studentDto.getIndexNumber());
        student.setGuardian(guardian);
        studentRepository.save(student);
    }

    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId).get();
    }


    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }


    public List<Student> getStudentsByGuardianId(int guardianId) {
        return studentRepository.findByGuardianId(guardianId);
    }


    public void saveStudentMeasure(StudentMeasureDto studentMeasureDto) {
        Student student = studentRepository.findById(studentMeasureDto.getStudentId()).get();
        double heightInMeter = studentMeasureDto.getHeight() / 100;
        double bmi = studentMeasureDto.getWeight() / (heightInMeter * heightInMeter);
        StudentMeasure studentMeasure = new StudentMeasure();
        studentMeasure.setHeight(studentMeasureDto.getHeight());
        studentMeasure.setWeight(studentMeasureDto.getWeight());
        studentMeasure.setBmi(bmi);
        studentMeasure.setStudent(student);
        studentMeasure.setDate(studentMeasureDto.getDate());
        studentMeasureRepository.save(studentMeasure);
    }


    public List<StudentBmi> getStudentMeasures(int studentId) {
        List<StudentMeasure> studentMeasures = studentMeasureRepository.findByStudentId(studentId);
        List<StudentBmi> studentBmis = new ArrayList<>();
        for (StudentMeasure studentMeasure : studentMeasures) {
            String dateString = DateUtils.getFormattedDate(studentMeasure.getDate());
            StudentBmi studentBmi = new StudentBmi();
            studentBmi.setId(studentMeasure.getId());
            studentBmi.setBmi(studentMeasure.getBmi());
            studentBmi.setHeight(studentMeasure.getHeight());
            studentBmi.setWeight(studentMeasure.getWeight());
            studentBmi.setDate(studentMeasure.getDate());
            studentBmi.setDateString(dateString);
            studentBmis.add(studentBmi);
        }
        Collections.sort(studentBmis);
        return studentBmis;
    }

}
