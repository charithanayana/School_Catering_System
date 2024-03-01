package com.cn.catering.dto;

import com.cn.catering.type.UserType;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuthDto {

    private Integer userId;
    private String userName;
    private String password;
    private String token;
    private UserType userType;

}
