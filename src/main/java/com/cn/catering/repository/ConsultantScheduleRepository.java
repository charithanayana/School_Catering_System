package com.cn.catering.repository;

import com.cn.catering.model.Consultant;
import com.cn.catering.model.ConsultantSchedule;
import com.cn.catering.type.ConsultationStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ConsultantScheduleRepository extends JpaRepository<ConsultantSchedule, Integer>  {

    public List<ConsultantSchedule> findByStatus(ConsultationStatus status);

}
