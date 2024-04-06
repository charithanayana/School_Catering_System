package com.cn.catering.repository;

import com.cn.catering.model.Student;
import com.cn.catering.model.StudentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentOrderRepository extends JpaRepository<StudentOrder, Integer> {

    public List<StudentOrder> findByStudentId(int studentId);

}
