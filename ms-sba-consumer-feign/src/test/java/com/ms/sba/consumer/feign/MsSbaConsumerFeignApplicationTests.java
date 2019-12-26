package com.ms.sba.consumer.feign;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableEurekaClient
@SpringBootTest
class MsSbaConsumerFeignApplicationTests {

    @Test
    void contextLoads() {
    }

}
