package com.ms.sba.consumer.feign.pojo;

import lombok.Data;

@Data
public class User {

    private long id;
    private String username;
    private String password;
    private String userType;
    private String email;
    private String mobileNumber;
    private boolean confirmed;

}
