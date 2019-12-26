package com.ms.sba.provider.user.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column(name = "user_type")
    private String userType;

    @Column
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column
    private boolean confirmed;

}
