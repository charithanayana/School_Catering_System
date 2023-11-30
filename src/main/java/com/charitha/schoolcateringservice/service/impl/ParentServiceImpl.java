package com.charitha.schoolcateringservice.service.impl;

import com.charitha.schoolcateringservice.dto.ParentDto;
import com.charitha.schoolcateringservice.model.Parent;

public interface ParentServiceImpl {
    void createParent(ParentDto parentDto);
    Parent getParent(int id);
}
