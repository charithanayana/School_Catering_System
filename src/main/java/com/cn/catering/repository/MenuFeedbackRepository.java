package com.cn.catering.repository;

import com.cn.catering.model.MenuFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuFeedbackRepository extends JpaRepository<MenuFeedback, Integer> {

    public List<MenuFeedback> findByMenuId(int menuId);

}
