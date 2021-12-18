package com.nikfrolkov.exchange_rate_in_gif.client;

import com.nikfrolkov.exchange_rate_in_gif.client.dto.ExchangeRatesClientDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "openexchangerates-api", url = "${openexchangerates.url}")
public interface OpenExchangeRatesClient extends OpenExchangeRates{

    @GetMapping("/latest.json")
    ExchangeRatesClientDTO getLatestRate(@RequestParam("app_id") String app_id);

    @GetMapping("/historical/{date}.json")
    ExchangeRatesClientDTO getHistoricalRate(@PathVariable("date") String date, @RequestParam("app_id") String app_id);


}
