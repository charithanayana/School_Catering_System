package com.cn.catering.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "consultant")
@Getter
@Setter
public class Consultant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "hospital")
    private String hospital;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Consultant() {}

    public Consultant(Integer id) {
        this.id = id;
    }

}
