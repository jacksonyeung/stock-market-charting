package com.ms.sba.provider.user.dao;

import com.ms.sba.provider.user.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("root");
        user.setPassword("root");
        user.setUserType("Admin");
        user.setEmail("root@gmail.com");
        user.setMobileNumber("13000000000");
        user.setConfirmed(true);

        userRepository.save(user);
    }

    @Test
    public void testFindAll(){
        System.out.println(userRepository.findAll());
    }

    @Test
    public void testExists(){
        String username = "123";
        System.out.println("username : " + username + " isExisted: " + userRepository.existsByUsernameEquals(username));

        String email = "root@gmail.com";
        System.out.println("email : " + email + " isExisted: " + userRepository.existsByEmailEquals(email));
    }

}
