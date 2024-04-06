package com.cn.catering.service;

import com.cn.catering.dto.GuardianDto;
import com.cn.catering.dto.StudentOrderDto;
import com.cn.catering.model.Guardian;
import com.cn.catering.model.StudentOrder;

import java.util.List;

public interface GuardianService {

    public void createGuardian(GuardianDto parentDto);
    public Guardian getGuardian(int id);

    public void saveStudentOrder(StudentOrderDto studentOrderDto);

    public List<StudentOrder> getStudentOrderByStudentId(int studentId);

}
