package com.nikfrolkov.exchange_rate_in_gif.client;

import com.nikfrolkov.exchange_rate_in_gif.model.ExchangeRate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "openexchangerates-api", url = "https://openexchangerates.org/api")
public interface ExchangeRatesClient {

    @GetMapping("/latest.json?app_id=6fac075b92df4a27b5f2fe14675baf8a&symbols=RUB")
    ResponseEntity<ExchangeRate> getLatestRate();

    @GetMapping("/historical/2021-12-15.json?app_id=6fac075b92df4a27b5f2fe14675baf8a&symbols=RUB")
    ResponseEntity<ExchangeRate> getHistoricalRate();


}
