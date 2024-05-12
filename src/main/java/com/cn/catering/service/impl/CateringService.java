package com.cn.catering.service.impl;

import com.cn.catering.dto.CManagerDto;
import com.cn.catering.model.CateringManager;
import com.cn.catering.model.Consultant;
import com.cn.catering.model.User;
import com.cn.catering.repository.CateringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CateringService {

    @Autowired
    private CateringRepository cateringRepository;

    public void saveCateringManager(CManagerDto cManagerDto) {
        CateringManager cateringManager = new CateringManager();
        cateringManager.setFirstName(cManagerDto.getFirstName());
        cateringManager.setLastName(cManagerDto.getLastName());
        cateringManager.setMobile(cManagerDto.getMobile());
        cateringManager.setUser(new User(cManagerDto.getUserId()));
        cateringRepository.save(cateringManager);
    }

    public List<CateringManager> getAllConsultants() {
        return cateringRepository.findAll();
    }

}
