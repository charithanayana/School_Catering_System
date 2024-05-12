package com.cn.catering.repository;

import com.cn.catering.model.NotificationUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationUserRepository extends JpaRepository<NotificationUser, Integer> {

    public List<NotificationUser> findByUserId(int userId);

}
