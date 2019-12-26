package com.ms.sba.consumer.feign.feign;

import com.ms.sba.consumer.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "PROVIDER-USER")
public interface UserApiFeign {

    @GetMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> signIn(@RequestBody User user);

    @PostMapping(value = "/user")
    public ResponseEntity<Map<String, Object>> signUp(@RequestBody User user);

}
