package com.cn.catering.repository;

import com.cn.catering.model.MenuItem;
import com.cn.catering.model.Student;
import com.cn.catering.model.User;
import com.cn.catering.type.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUserName(String userName);

    public List<User> findByUserType(UserType userType);

}
