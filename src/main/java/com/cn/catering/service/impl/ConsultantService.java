package com.cn.catering.service.impl;

import com.cn.catering.dto.ConsultantDto;
import com.cn.catering.model.Consultant;
import com.cn.catering.repository.ConsultantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultantService {

    @Autowired
    private ConsultantRepository consultantRepository;

    public void saveConsultant(ConsultantDto consultantDto) {
        Consultant consultant = new Consultant();
        consultant.setFirstName(consultantDto.getFirstName());
        consultant.setLastName(consultantDto.getLastName());
        consultant.setMobile(consultantDto.getMobile());
        consultant.setHospital(consultantDto.getHospital());
        consultantRepository.save(consultant);
    }

    public List<Consultant> getAllConsultants() {
        return consultantRepository.findAll();
    }

}
