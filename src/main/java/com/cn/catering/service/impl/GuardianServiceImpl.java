package com.cn.catering.service.impl;

import com.cn.catering.dto.GuardianDto;
import com.cn.catering.dto.StudentOrderDto;
import com.cn.catering.model.Guardian;
import com.cn.catering.model.Menu;
import com.cn.catering.model.Student;
import com.cn.catering.model.StudentOrder;
import com.cn.catering.repository.GuardianRepository;
import com.cn.catering.repository.MenuRepository;
import com.cn.catering.repository.StudentOrderRepository;
import com.cn.catering.repository.StudentRepository;
import com.cn.catering.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GuardianServiceImpl implements GuardianService {


    @Autowired
    private GuardianRepository parentRepository;

    @Autowired
    private StudentOrderRepository studentOrderRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public void createGuardian(GuardianDto parentDto) {
        Guardian parent = new Guardian();
        parent.setFirstName(parentDto.getFirstName());
        parent.setLastName(parentDto.getLastName());
        parent.setEmail(parentDto.getEmail());
        parent.setMobile(parentDto.getMobile());
        parentRepository.save(parent);
    }

    @Override
    public Guardian getGuardian(int id) {
        Optional<Guardian> parent = parentRepository.findById(id);
        return parent.get();
    }

    @Override
    public void saveStudentOrder(StudentOrderDto studentOrderDto) {
        Student student = studentRepository.findById(studentOrderDto.getStudentId()).get();
        Menu menu = menuRepository.findById(studentOrderDto.getMenuId()).get();
        StudentOrder studentOrder = new StudentOrder();
        studentOrder.setStudent(student);
        studentOrder.setMenu(menu);
        studentOrder.setDate(studentOrderDto.getDate());
        studentOrderRepository.save(studentOrder);
    }

    @Override
    public List<StudentOrder> getStudentOrderByStudentId(int studentId) {
        return studentOrderRepository.findByStudentId(studentId);
    }

}
