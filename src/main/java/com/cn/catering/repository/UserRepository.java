package com.cn.catering.repository;

import com.cn.catering.model.MenuItem;
import com.cn.catering.model.Student;
import com.cn.catering.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    public User findByUserName(String userName);

}
