package com.charitha.schoolcateringservice.service.impl;

import com.charitha.schoolcateringservice.dto.ParentDto;
import com.charitha.schoolcateringservice.model.Guardian;

public interface GuardianServiceImpl {
    void createGuardian(ParentDto parentDto);
    Guardian getGuardian(int id);
}
