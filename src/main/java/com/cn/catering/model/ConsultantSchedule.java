package com.cn.catering.model;

import com.cn.catering.type.ConsultationStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "consultantschedule")
@Getter
@Setter
public class ConsultantSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "consultant_id")
    private Consultant consultant;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @Column(name = "conclusion")
    private String conclusion;

    @Column(name = "status", columnDefinition = "tinyint(4) default 0")
    private ConsultationStatus status;

}
