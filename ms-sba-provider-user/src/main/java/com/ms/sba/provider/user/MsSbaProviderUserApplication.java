package com.ms.sba.provider.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsSbaProviderUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsSbaProviderUserApplication.class, args);
    }

}
