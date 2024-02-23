package com.cn.catering.service.impl;

import com.cn.catering.dto.GuardianDto;
import com.cn.catering.model.Guardian;

public interface GuardianServiceImpl {
    void createGuardian(GuardianDto parentDto);
    Guardian getGuardian(int id);
}
