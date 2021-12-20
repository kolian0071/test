package com.nikfrolkov.gif.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExchangeRateInGifApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeRateInGifApplication.class, args);
    }

}
