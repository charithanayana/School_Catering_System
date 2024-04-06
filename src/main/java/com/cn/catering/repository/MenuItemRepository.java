package com.cn.catering.repository;

import com.cn.catering.model.Menu;
import com.cn.catering.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {

}
