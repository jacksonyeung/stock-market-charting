package com.ms.sba.provider.user.controller;

import com.ms.sba.provider.user.dto.RequestResult;
import com.ms.sba.provider.user.entity.User;
import com.ms.sba.provider.user.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping
    public ResponseEntity<RequestResult> signUp(@RequestBody User user) {
        RequestResult requestResult = userService.addUser(user);
        return new ResponseEntity<RequestResult>(requestResult, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<RequestResult> signIn(@RequestBody User user) {
        RequestResult requestResult = userService.validateUser(user);
        return new ResponseEntity<RequestResult>(requestResult, HttpStatus.OK);
    }

}
