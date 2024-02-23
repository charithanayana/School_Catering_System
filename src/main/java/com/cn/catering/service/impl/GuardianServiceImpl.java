package com.cn.catering.service.impl;

import com.cn.catering.dto.GuardianDto;
import com.cn.catering.model.Guardian;
import com.cn.catering.repository.GuardianRepository;
import com.cn.catering.service.GuardianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuardianServiceImpl implements GuardianService {


    @Autowired
    private GuardianRepository parentRepository;

    @Override
    public void createGuardian(GuardianDto parentDto) {
        Guardian parent = new Guardian();
        parent.setFirstName(parentDto.getFirstName());
        parent.setLastName(parentDto.getLastName());
        parent.setEmail(parentDto.getEmail());
        parent.setMobile(parentDto.getMobile());
        parentRepository.save(parent);
    }

    @Override
    public Guardian getGuardian(int id) {
        Optional<Guardian> parent = parentRepository.findById(id);
        return parent.get();
    }
}
