package com.charitha.schoolcateringservice.service;

import com.charitha.schoolcateringservice.dto.ParentDto;
import com.charitha.schoolcateringservice.model.Parent;
import com.charitha.schoolcateringservice.repository.ParentRepository;
import com.charitha.schoolcateringservice.service.impl.ParentServiceImpl;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParentService implements ParentServiceImpl {

    final
    ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Override
    public void createParent(ParentDto parentDto) {
        Parent parent = new Parent();
        parent.setFirstName(parentDto.getFirstName());
        parent.setLastName(parentDto.getLastName());
        parent.setEmail(parentDto.getEmail());
        parent.setMobileNumber(parentDto.getMobileNumber());
        parentRepository.save(parent);
    }

    @Override
    public Parent getParent(int id) {
        Optional<Parent> parent = parentRepository.findById(id);
        return parent.get();
    }
}
