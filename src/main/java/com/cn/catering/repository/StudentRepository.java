package com.cn.catering.repository;

import com.cn.catering.model.Guardian;
import com.cn.catering.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    public List<Student> findByGuardianId(int guardianId);

}
