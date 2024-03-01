package com.cn.catering;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

    @Bean
    PasswordEncoder passwordEncoder(){ // NEEDED TO ALLOW PASSWORD ENCODER INSIDE SECURITY
        return new BCryptPasswordEncoder();
    }

}
