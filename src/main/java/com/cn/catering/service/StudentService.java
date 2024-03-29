package com.cn.catering.service;

import com.cn.catering.dto.StudentDto;
import com.cn.catering.dto.StudentMeasureDto;
import com.cn.catering.model.Student;

import java.util.List;

public interface StudentService {

    public void createStudent(StudentDto studentDto);
    public Student getStudentById(int studentId);

    public List<Student> getAllStudents();
    public List<Student> getStudentsByGuardianId(int guardianId);

    public void saveStudentMeasure(StudentMeasureDto studentMeasureDto);

}
