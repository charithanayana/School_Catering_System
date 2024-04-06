package com.cn.catering.repository;

import com.cn.catering.model.Guardian;
import com.cn.catering.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByGuardianId(int guardianId);

}
