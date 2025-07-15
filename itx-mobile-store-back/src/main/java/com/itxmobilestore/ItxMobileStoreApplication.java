package com.itxmobilestore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ItxMobileStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItxMobileStoreApplication.class, args);
    }

}