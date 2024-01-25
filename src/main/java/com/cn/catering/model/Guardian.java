package com.cn.catering.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "guardian")
@Getter
@Setter
public class Guardian {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "telephone_number")
    private String telephoneNumber;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "guardian")
    private List<Child> children;
}
