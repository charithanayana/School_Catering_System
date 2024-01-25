package com.cn.catering.service.impl;

import com.cn.catering.dto.ParentDto;
import com.cn.catering.model.Guardian;

public interface GuardianServiceImpl {
    void createGuardian(ParentDto parentDto);
    Guardian getGuardian(int id);
}
