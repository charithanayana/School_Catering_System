package com.cn.catering.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentOrderDto {

    private int studentId;
    private Date date;
    private int menuId;

}
