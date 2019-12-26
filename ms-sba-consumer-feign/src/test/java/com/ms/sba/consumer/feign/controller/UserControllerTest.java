package com.ms.sba.consumer.feign.controller;

import com.ms.sba.consumer.feign.feign.UserApiFeign;
import com.ms.sba.consumer.feign.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserControllerTest {

    @Autowired
    UserApiFeign userApiFeign;

    @Test
    void testLogin() {
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");

        ResponseEntity<Map<String, Object>> responseEntity = userApiFeign.signIn(user);
        HttpStatus status = responseEntity.getStatusCode();
        Map<String, Object> body = responseEntity.getBody();

        System.out.println("...");
    }

}
