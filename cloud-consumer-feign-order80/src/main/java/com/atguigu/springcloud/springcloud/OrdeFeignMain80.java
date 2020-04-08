package com.atguigu.springcloud.springcloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OrdeFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrdeFeignMain80.class, args);
    }
}
