package com.cn.catering.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GuardianDto {

    private String firstName;
    private String lastName;
    private String mobile;
    private String email;
    private String address;
    private String userName;
    private String password;
    private String confirmPassword;

}
