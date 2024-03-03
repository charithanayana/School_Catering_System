package com.cn.catering.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentMeasureDto {

    private double height;
    private double weight;
    private int studentId;
    private Date date;

}
