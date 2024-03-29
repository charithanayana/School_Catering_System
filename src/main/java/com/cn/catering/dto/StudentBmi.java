package com.cn.catering.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentBmi implements Comparable<StudentBmi> {

    private Integer id;
    private int studentId;
    private double bmi;
    private Date date;
    private String dateString;
    private double height;
    private double weight;

    @Override
    public int compareTo(StudentBmi o) {
        return getDate().compareTo(o.getDate());
    }

}
