package com.cn.catering.dto;

import jakarta.persistence.Column;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ParentDto {
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
}
