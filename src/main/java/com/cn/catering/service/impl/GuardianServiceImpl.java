package com.cn.catering.service.impl;

import com.cn.catering.dto.GuardianDto;
import com.cn.catering.dto.StudentOrderDto;
import com.cn.catering.model.*;
import com.cn.catering.repository.GuardianRepository;
import com.cn.catering.repository.MenuRepository;
import com.cn.catering.repository.StudentOrderRepository;
import com.cn.catering.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuardianServiceImpl {


    @Autowired
    private GuardianRepository parentRepository;

    @Autowired
    private StudentOrderRepository studentOrderRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MenuRepository menuRepository;


    public void createGuardian(GuardianDto guardianDto) {
        Guardian guardian = new Guardian();
        guardian.setFirstName(guardianDto.getFirstName());
        guardian.setLastName(guardianDto.getLastName());
        guardian.setEmail(guardianDto.getEmail());
        guardian.setMobile(guardianDto.getMobile());
        guardian.setUser(new User(guardianDto.getUserId()));
        parentRepository.save(guardian);
    }


    public Guardian getGuardian(int id) {
        Optional<Guardian> parent = parentRepository.findById(id);
        return parent.get();
    }


    public void saveStudentOrder(StudentOrderDto studentOrderDto) {
        Student student = studentRepository.findById(studentOrderDto.getStudentId()).get();
        Menu menu = menuRepository.findById(studentOrderDto.getMenuId()).get();
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setStudent(student);
        studentOrder.setMenu(menu);
        studentOrder.setDate(studentOrderDto.getDate());
        studentOrderRepository.save(studentOrder);
    }


    public List<StudentOrder> getStudentOrderByStudentId(int studentId) {
        return studentOrderRepository.findByStudentId(studentId);
    }


    public List<Guardian> getAllGuardian() {
        return parentRepository.findAll();
    }

}
