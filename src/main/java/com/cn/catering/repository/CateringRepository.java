package com.cn.catering.repository;

import com.cn.catering.model.CateringManager;
import com.cn.catering.model.Consultant;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CateringRepository extends JpaRepository<CateringManager, Integer>  {

    public CateringManager findByUserId(int userId);

}
