package com.cn.catering.repository;

import com.cn.catering.model.Student;
import com.cn.catering.model.StudentMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentMeasureRepository extends CrudRepository<StudentMeasure, Integer> {


}
