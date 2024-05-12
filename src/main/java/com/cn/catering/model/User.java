package com.cn.catering.model;

import com.cn.catering.type.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "passwd")
    private String password;

    @Column(name = "user_type")
    private UserType userType;

    @Column(name = "created_at")
    private Date createdAt;

    public User() {}

    public User(int id) {
        this.id = id;
    }

}
