package com.cn.catering.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "menufeedback")
@Getter
@Setter
public class MenuFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "feedback")
    private String feedback;

    @ManyToOne
    @JoinColumn(name = "guardian_id")
    @JsonIgnoreProperties("students")
    private Guardian guardian;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    @JsonIgnoreProperties("items")
    private Menu menu;

    @Column(name = "date")
    private Date date;

}
