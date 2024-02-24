package com.cn.catering.repository;

import com.cn.catering.model.Menu;
import com.cn.catering.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MenuRepository extends CrudRepository<Menu, Integer> {

}
