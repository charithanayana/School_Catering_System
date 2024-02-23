package com.cn.catering.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentDto {

    private String firstName;
    private String lastName;
    private String indexNumber;
    private int guardianId;

}
