package com.nikfrolkov.exchange_rate_in_gif;

import com.nikfrolkov.exchange_rate_in_gif.service.ExchangeRateServiceImpl;
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
