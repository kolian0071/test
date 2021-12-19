package com.nikfrolkov.exchange_rate_in_gif.client;

import com.nikfrolkov.exchange_rate_in_gif.client.dto.ExchangeRateDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "rates-api", url = "${rates-api.url}")
public interface ExchangeRateClient {

    @GetMapping("/historical/{date}.json")
    ExchangeRateDto getHistoricalRate(
            @PathVariable("date") String date,
            @RequestParam("app_id") String app_id,
            @RequestParam("base") String baseCurrency,
            @RequestParam("symbols") String symbols
    );
}
