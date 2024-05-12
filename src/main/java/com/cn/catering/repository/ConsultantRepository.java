package com.cn.catering.repository;

import com.cn.catering.model.Consultant;
import com.cn.catering.model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ConsultantRepository extends JpaRepository<Consultant, Integer>  {

    public Consultant findByUserId(int userId);

}
