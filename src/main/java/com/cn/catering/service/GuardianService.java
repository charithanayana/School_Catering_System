package com.cn.catering.service;

import com.cn.catering.dto.GuardianDto;
import com.cn.catering.model.Guardian;

public interface GuardianService {

    public void createGuardian(GuardianDto parentDto);
    public Guardian getGuardian(int id);

}
