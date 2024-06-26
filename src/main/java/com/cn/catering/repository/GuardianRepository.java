package com.cn.catering.repository;

import com.cn.catering.model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuardianRepository extends JpaRepository<Guardian, Integer> {

    public Guardian findByUserId(int userId);

}
