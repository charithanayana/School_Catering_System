package com.cn.catering.repository;

import com.cn.catering.model.Student;
import com.cn.catering.model.StudentOrder;
import com.cn.catering.type.PayType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface StudentOrderRepository extends JpaRepository<StudentOrder, Integer> {

    public StudentOrder findById(int id);

    public List<StudentOrder> findByStudentId(int studentId);

    public List<StudentOrder> findByStudentIdAndPayType(int studentId, PayType payType);

    public List<StudentOrder> findByDate(Date date);

}
