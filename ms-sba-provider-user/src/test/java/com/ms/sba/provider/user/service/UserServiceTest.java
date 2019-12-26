package com.ms.sba.provider.user.service;

import com.ms.sba.provider.user.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @Autowired
    IUserService userService;

    @Test
    void testAddUser(){
        User user = new User();
        user.setUsername("123");
        user.setEmail("root@gmail.com");

        System.out.println(userService.addUser(user));
    }

}
