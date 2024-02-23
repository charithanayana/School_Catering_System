package com.cn.catering.service.impl;

import com.cn.catering.dto.StudentDto;
import com.cn.catering.model.Guardian;
import com.cn.catering.model.Student;
import com.cn.catering.repository.GuardianRepository;
import com.cn.catering.repository.StudentRepository;
import com.cn.catering.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private GuardianRepository guardianRepository;

    @Autowired
    private StudentRepository studentRepository;


    @Override
    public void createStudent(StudentDto studentDto) {
        Guardian guardian = guardianRepository.findById(studentDto.getGuardianId()).get();
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());
        student.setIndexNumber(studentDto.getIndexNumber());
        student.setGuardian(guardian);
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(int studentId) {
        return studentRepository.findById(studentId).get();
    }

    @Override
    public List<Student> getStudentsByGuardianId(int guardianId) {
        return studentRepository.findByGuardianId(guardianId);
    }

}
