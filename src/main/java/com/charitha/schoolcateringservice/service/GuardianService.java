package com.charitha.schoolcateringservice.service;

import com.charitha.schoolcateringservice.dto.ParentDto;
import com.charitha.schoolcateringservice.model.Guardian;
import com.charitha.schoolcateringservice.repository.ParentRepository;
import com.charitha.schoolcateringservice.service.impl.GuardianServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuardianService implements GuardianServiceImpl {

    final
    ParentRepository parentRepository;

    public GuardianService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public void createGuardian(ParentDto parentDto) {
        Guardian parent = new Guardian();
        parent.setFirstName(parentDto.getFirstName());
        parent.setLastName(parentDto.getLastName());
        parent.setEmail(parentDto.getEmail());
        parent.setTelephoneNumber(parentDto.getMobileNumber());
        parentRepository.save(parent);
    }

    @Override
    public Guardian getGuardian(int id) {
        Optional<Guardian> parent = parentRepository.findById(id);
        return parent.get();
    }
}
