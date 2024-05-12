package com.cn.catering.repository;

import com.cn.catering.model.Menu;
import com.cn.catering.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
